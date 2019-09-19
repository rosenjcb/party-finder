import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import "./PositionPopup.css";

function PopupCard(props) {


    const openPositions = props.position.map((position, index) => <Card key={index} position={position}/>);

    useEffect(() => {
        console.log(props.position[0]);
    });

    return(
        <div className="position-popup">
            <ul>
                {openPositions}
            </ul>
        </div>
    );
}

function Card(props) {

    const { id, role } = props.position;
    return(
        <div className="card">
            <h1>{role}</h1>
        </div>
    )
}

export default PopupCard;