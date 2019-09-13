import React, { useState }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";

function HomeLink({ label, to, activeOnlyWhenExact, className }) {

    return (
      <Route
        path={to}
        exact={activeOnlyWhenExact}
        children={({ match }) => (
          <div>
            <Link className={className} to={to}>{label}</Link>
          </div>
        )}
      />
    );
  }

export default HomeLink;