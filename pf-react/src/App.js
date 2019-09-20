import React from 'react';
import Helmet from 'react-helmet';
import './App.css';
import Home from './Home/Home';
import PartySearch from './PartySearch/PartySearch';
import { BrowserRouter as Router, Route, Link, Switch, Redirect} from "react-router-dom";

function App() {
  return (
      <Router>
        <Helmet>
          <title>Party Finder</title> 
        </Helmet>
        <div>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path="/parties" component={PartySearch}/>
          </Switch>
        </div>
      </Router>
  );
}

export default App;
