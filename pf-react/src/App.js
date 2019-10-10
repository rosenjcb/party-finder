import React from 'react';
import Helmet from 'react-helmet';
import './App.css';
import Home from './Home/Home';
import PartySearch from './PartySearch/PartySearch';
import { BrowserRouter as Router, Route, Link, Switch, Redirect} from "react-router-dom";
import CreateParty from "./CreateParty/CreateParty";
import PartyLobby from './PartyLobby/PartyLobby';
import NavigationBar from './NavigationBar/NavigationBar';
import PositionApplication from './PositionApplication/PositionApplication';

function App() {
  return (
      <Router>
        <Helmet>
          <title>Party Finder</title> 
        </Helmet>
        <div className="font">
          <NavigationBar/>
          <Switch>
            <Route exact path="/" component={Home}/>
            <Route exact path ="/createParty" component={CreateParty}/>
            <Route exact path="/parties" component={PartySearch}/>
            <Route path ="/parties/:name/lobby" component={PartyLobby}/>
            <Route path ="/parties/:name/positions/:id/apply" component={PositionApplication}/>
          </Switch>
        </div>
      </Router>
  );
}

export default App;
