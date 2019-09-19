import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import CustomLink from "../../CustomLink/CustomLink";
import PopupCard from "../PositionPopup/PositionPopup";
import "./PartyCard.css";
 
 
function PartyCard(props) {
 
    const {name, positions} = props.party;
    const partyURL = "/party/" + name;
 
    const [isExpanded, setIsExpanded] = useState(false);
    const [selectedPosition, setSelectedPosition] = useState({});
 
    const ref = createRef();

    useEffect(() => {
        //console.log(isExpanded);
        //console.log(selectedPosition);
    }, [isExpanded]);
 
    useEffect(() => {
        window.addEventListener('mousedown', (e) => {
            //if(ref.current.focus.contains(e.target)) return;
            //setIsExpanded(false);
        });
      
        // returned function will be called on component unmount 
        return () => {
          window.removeEventListener('mousedown', () => {})
        }
      }, [])
      
    var roleCounts = {};
    const openSlots = positions.filter(position => position.status === "open");
 
    for(var slot of openSlots) {
        if(!roleCounts[slot.role] === false) roleCounts[slot.role] = roleCounts[slot.role] + 1;
        else roleCounts[slot.role] = 1;
    }
 
    return(
        <div>
            <div className="partyCard">
                <div className = "shield"/>
                <Link to={partyURL} className="partyName">{name}</Link>
                <div className = "openRoles">{Object.keys(roleCounts).sort((a, b) => roleCounts[b] - roleCounts[a]).map(openSlot => {
                    const imageVar = "REACT_APP_" + openSlot.replace(" ","_").toUpperCase();
                    const image = require("../../assets/" + process.env[imageVar]);
                    return(
                        <div className="iconBox" onClick={() => { setIsExpanded(!isExpanded); setSelectedPosition(positions.filter(position => position.role === openSlot));}}>
                            <div style={{
                                backgroundImage: `url(${image})`,
                                backgroundRepeat: 'no-repeat',
                                margin: '10px',
                                minWidth: '50px',
                                minHeight: '50px',
                                backgroundSize: 'contain',
                                backgroundPosition: 'center'
                            }}/>
                            <div className="badge">{roleCounts[openSlot]}</div>
                        </div>
                    )
                })}</div>
            </div>
            {isExpanded ? <PopupCard position={selectedPosition}/> : null}
        </div>
    );
}
 
export default PartyCard;
