import React from 'react';
import './App.css';
import Home from './home/Home';
import PartySearch from './PartySearch/PartySearch';
import { BrowserRouter as Router, Route, Link, Switch, Redirect} from "react-router-dom";

function App() {
  return (
      <Router>
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
