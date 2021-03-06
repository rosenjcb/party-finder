import React, { useState, useEffect }  from 'react';
import Helmet from 'react-helmet';
import axios from 'axios';
import "./PartySearch.css";
import PartyCard from "./PartyCard/PartyCard";
import Body from "../Miscellaneous/Body";

function PartySearch() {
    const [parties, setParties] = useState([]);


    parties.forEach(party => console.log(party));
    const items = parties.map((party, index) => <PartyCard party={party} key={index}/>);


    useEffect(() => {
        const parties = axios.get('http://localhost:8080/parties/')
        parties.then((response) => {
            setParties(response.data);
        });
    }, []);

    return(
        <Body>
            <Helmet>
                <title>Search</title> 
            </Helmet>
            <div className="party-list-view">
                <h1 className="party-search-header">Public Parties</h1>
                <div className="search">
                    <input type="text" placeholder="Search.."></input>
                </div>
                <ul className="list">
                    {items}
                </ul>
            </div>
        </Body>
    );
}

export default PartySearch;