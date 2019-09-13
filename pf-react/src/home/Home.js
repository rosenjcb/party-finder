import React, { useState }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import CustomLink from "../CustomLink/CustomLink";
import "./Home.css";    


function Home() {
    const [collapsed, setCollapsed] = useState(true);

      
    return (
        <div className="homepage">
            <h1 className="left">Creating and joining startups is a difficult task. As of now, there is no single place that a person can go to find the right team or the right talent.</h1>
            <div className="collab"></div>
            <h2 className="right">Party Finder is a platform for startups. Find your party and begin your quest. What are you waiting for?</h2>
            <div className="left app"></div>
            <ul className="right-no-clear">
                <li><CustomLink to="/createParty" label="Create" className="custom-link"/></li>
                <li><CustomLink to="/parties" label="Join" className="custom-link"/></li>
                <li><CustomLink to="/parties" label="Meet New People" className="custom-link"/></li>
                <li><CustomLink to="/parties" label="Collaborate" className="custom-link"/></li>
                <li><CustomLink to="/parties" label="Join Something" className="custom-link"/></li>
            </ul>
        </div>
    );
}

export default Home;