import React, {useEffect, useState} from "react";
import styled from 'styled-components';
import Hamburger from "../assets/list-colored.svg";
import { Link } from "react-router-dom";

function NavigationBar(props) {

    const [buttonColor, setButtonColor] = useState("");
    const [isExpanded, setIsExpanded] = useState(false);

    const options =  ["Test", "test", "testing", "testz"].map(opt => <Link>{opt}</Link>);

    useEffect(() => {
        if(isExpanded) {
            setButtonColor("#18a0fb");
        } else {
            setButtonColor("inherit");
        }
    }, [isExpanded]);

    return(
        <NavBar>
            <Title>Party Finder</Title>
            <Options onClick={() => setIsExpanded(!isExpanded)} color={buttonColor}>
                {isExpanded ?
                <Links>
                    <LinkLi><StyledLink to="/" onClick={() => setIsExpanded(!isExpanded)}>Home</StyledLink></LinkLi>
                    <LinkLi><StyledLink to="/createParty" onClick={() => setIsExpanded(!isExpanded)}>Create</StyledLink></LinkLi>
                    <LinkLi><StyledLink to="/parties" onClick={() => setIsExpanded(!isExpanded)}>Join</StyledLink></LinkLi>
                </Links>
                : null}
            </Options>
        </NavBar>
    )
}

const NavBar = styled.div`
    width: 100%;
    max-height: 10vh;
    display: flex;
    background-color: #2C2F33;
    flex-direction: row;
    justify-content: space-between;
    border-bottom: 1px solid white;
    border-bottom-width: thin;
`;

const Title = styled.h1`
    align-self: flex-start;
`

const Options = styled.button`
    width: 5%;
    background-image: url("${Hamburger}");
    background-position: center;
    background-size: contain;
    background-color: ${props => props.color};
    background-repeat: no-repeat;
    position: relative;
    border: none;
`;

const Links = styled.ul`
    position: absolute;
    background-color: black;
    z-index: 100;
    right: 10px;
    top 100%;
    padding: 0;
    margin: 0 auto;
    border-radius: 4px;
    box-shadow: 0 1px 15px #808285;
`;

const LinkLi = styled.li`
    width: 100%;
    list-style-type: none;
`;

const StyledLink = styled(Link)`
    width: 100%;
    text-align: center;
    color: white;
    display: inline-block;
    text-decoration: none;
    font-size: 2rem;
    margin: 0 auto;
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;

    :hover {
        background-color: #808285;
    }
`;

export default NavigationBar