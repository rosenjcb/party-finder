import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import PopupCard from "../PositionPopup/PositionPopup";
import { PopupContext, usePopupContext } from "../index.js";
import "./PartyCard.css";
 
 
function PartyCard(props) {
 
    const {name, positions} = props.party;
    const partyURL = "/parties/" + name;
 
    const [isExpanded, setIsExpanded] = useState(false);
    const [selectedPosition, setSelectedPosition] = useState({});
    const [image, setImage] = useState({});

    useEffect(() => {
    }, [isExpanded]);
      
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
                <Link to={partyURL + "/lobby"} className="partyName">{name}</Link>
                <div className = "openRoles">{Object.keys(roleCounts).sort((a, b) => roleCounts[b] - roleCounts[a]).map(openSlot => {
                    const imageVar = "REACT_APP_" + openSlot.replace(" ","_").toUpperCase();
                    const image = require("../../assets/" + process.env[imageVar]);
                    return(
                        <div className="iconBox" onClick={() => { setImage(image); setIsExpanded(!isExpanded); setSelectedPosition(positions.filter(position => position.role === openSlot));}}>
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
            {isExpanded ? <PopupContext.Provider value = {[isExpanded, setIsExpanded]}><PopupCard partyURL = {partyURL} position={selectedPosition} image={image}/></PopupContext.Provider> : null}
        </div>
    );
}
 
export default PartyCard;
