import React, { Component }  from 'react';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';
import "./Home.css";    

class Home extends Component {
    constructor(props) {
        super(props);

        this.toggleNavbar = this.toggleNavbar.bind(this);
        this.state = {
          collapsed: true
        };
    }

    toggleNavbar() {
        this.setState({
          collapsed: !this.state.collapsed
        });
    }

    render() {
        return (
            <div className="homepage">
            <Navbar color="faded" dark>
                <NavbarBrand href="/" className="mr-auto">Party Finder</NavbarBrand>
                <NavbarToggler onClick={this.toggleNavbar} className="mr-2" />
                <Collapse isOpen={!this.state.collapsed} navbar>
                <Nav navbar>
                    <NavItem>
                        <NavLink href="/search">Find a Party</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/create">Create a Party</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/signup">Sign Up</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/login">Login</NavLink>
                    </NavItem>
                </Nav>
                </Collapse>
            </Navbar>
            <h1 className="left">Creating and joining startups is a difficult task. As of now, there is no single place that a person can go to find the right team or the right talent.</h1>
            <div className="collab"></div>
            <h2 className="right">Party Finder is a platform for startups. Find your party and begin your quest. What are you waiting for?</h2>
            <div className="left app"></div>
            <h1 className="right-no-clear">Find.</h1>
            </div>
        );
    }
}

export default Home;