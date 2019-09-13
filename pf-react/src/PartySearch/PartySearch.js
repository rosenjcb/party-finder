import React, { useState, useEffect }  from 'react';
import axios from 'axios';
import "./PartySearch.css";
import PartyCard from "../PartyCard/PartyCard";

function PartySearch() {
    const [parties, setParties] = useState([]);


    parties.forEach(party => console.log(party));
    const items = parties.map(party => <PartyCard party={party}/>);


    useEffect(() => {
        const parties = axios.get('http://localhost:8080/parties/')
        parties.then((response) => {
            setParties(response.data);
        });
    }, []);

    return(
        <div className="party-search">
            <div className="list-view">
                <h1 className="party-search-header">Public Parties</h1>
                <div className="search">
                    <input type="text" placeholder="Search.."></input>
                </div>
                <ul className="list">
                    {items}
                </ul>
            </div>
        </div>
    );
}

export default PartySearch;