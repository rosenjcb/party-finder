import React, { useState, useEffect }  from 'react';
import "./PartyCard.css";

function PartyCard(props) {
    
    useEffect(() => {
        //console.log(props.party);
        //console.log(props.party.partyMembers.filter(partyMember => partyMember.status === "open").map(partyMember => partyMember.role));
        console.log(process.env);
        console.log(process.env.REACT_APP_HELP);
    });

    const RoleIcon = (props) => { 
        console.log(props);
        const imageVar = "REACT_APP_" + props.role.replace(" ","_").toUpperCase(); 
        var image = require("../assets/" + process.env[imageVar]);

        const iconBox = {
            display: "inline-block",
            position: 'relative'
        };

        const iconStyle = {
            backgroundImage: `url(${image})`,
            backgroundRepeat: 'no-repeat',
            margin: '10px',
            minWidth: '50px',
            minHeight: '50px',
            backgroundSize: 'contain',
            backgroundPosition: 'center',
        };

        const badge = {
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
        };

        return(
            <div style={iconBox}>
                <div style={iconStyle}/>
                <div style={badge}>{props.count}</div>
            </div>
            
        )
    }

    var roleCounts = {};
    const openSlots = props.party.partyMembers.filter(partyMember => partyMember.status === "open");

    for(var slot of openSlots) {
        if(!roleCounts[slot.role] === false) roleCounts[slot.role] = roleCounts[slot.role] + 1;
        else roleCounts[slot.role] = 1;
    }

    
    const openRoles = Object.keys(roleCounts).map(openSlot => <RoleIcon role={openSlot} count={roleCounts[openSlot]}/>);

    return(
        <div className="partyCard">
            <div className = "shield"/>
            <h1 className="partyName">{props.party.name}</h1>
            <div className = "openRoles">{openRoles}</div> 
        </div>
    );
}

export default PartyCard;