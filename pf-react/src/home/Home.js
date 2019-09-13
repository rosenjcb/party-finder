import React, { useState }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
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
                <li><HomeLink to="/createParty" label="Create"/></li>
                <li><HomeLink to="/parties" label="Join"/></li>
                <li><HomeLink to="/parties" label="Meet New People"/></li>
                <li><HomeLink to="/parties" label="Collaborate"/></li>
                <li><HomeLink to="/parties" label="Join Something"/></li>
            </ul>
        </div>
    );

    function HomeLink({ label, to, activeOnlyWhenExact }) {
        return (
          <Route
            path={to}
            exact={activeOnlyWhenExact}
            children={({ match }) => (
              <div>
                <Link className="custom-link" to={to}>{label}</Link>
              </div>
            )}
          />
        );
      }
}

export default Home;