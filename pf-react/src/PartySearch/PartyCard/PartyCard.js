import React, { useState, useEffect }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import CustomLink from "../../CustomLink/CustomLink";
import "./PartyCard.css";


function PartyCard(props) {

    const partyURL = "/party/" + props.party.name;
    
    useEffect(() => {
        //console.log(props.party);
        //console.log(props.party.partyMembers.filter(partyMember => partyMember.status === "open").map(partyMember => partyMember.role));
        console.log(process.env);
        console.log(process.env.REACT_APP_HELP);
    });


    const RoleIcon = (props) => { 
        console.log(props);
        const partyRoleURL = partyURL + "/partyMembers";
        const imageVar = "REACT_APP_" + props.role.replace(" ","_").toUpperCase(); 
        const image = require("../../assets/" + process.env[imageVar]);
        /*const iconBox = {
            display: "inline-block",
            position: 'relative'
        };*/

        const iconStyle = {
            backgroundImage: `url(${image})`,
            backgroundRepeat: 'no-repeat',
            margin: '10px',
            minWidth: '50px',
            minHeight: '50px',
            backgroundSize: 'contain',
            backgroundPosition: 'center',
        };

        /*const badge = {
            position: 'absolute',
            top: '8px',
            right: '4px',
            width: '35%',
            height: '35%',
            borderRadius: '50%',
            background: 'red',
            color: 'white',
            textAlign: 'center',
            verticalAlign: 'center'
        };*/

        return(
            <div className="iconBox">
                <Link to={partyRoleURL}><div style={iconStyle}/></Link>
                <div className="badge">{props.count}</div>
            </div>
            
        )
    }

    var roleCounts = {};
    const openSlots = props.party.partyMembers.filter(partyMember => partyMember.status === "open");

    for(var slot of openSlots) {
        if(!roleCounts[slot.role] === false) roleCounts[slot.role] = roleCounts[slot.role] + 1;
        else roleCounts[slot.role] = 1;
    }

    
    const openRoles = Object.keys(roleCounts).sort((a, b) => roleCounts[b] - roleCounts[a]).map(openSlot => <RoleIcon role={openSlot} count={roleCounts[openSlot]}/>);

    return(
        <div className="partyCard">
            <div className = "shield"/>
            <Link to={partyURL} className="partyName">{props.party.name}</Link>
            <div className = "openRoles">{openRoles}</div> 
        </div>
    );
}

export default PartyCard;