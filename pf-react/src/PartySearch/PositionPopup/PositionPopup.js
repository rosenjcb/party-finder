import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import styled from 'styled-components';
import Equity from "../../assets/equity.svg";
import Compensation from "../../assets/compensation.svg";
import TitleBar from '../../Miscellaneous/TitleBar';
import { usePopupContext } from "../index.js";

function PopupCard(props) {

    const [isExpanded, setIsExpanded] = usePopupContext();
    const { image, partyURL } = props;
    const openPositions = props.position.map((position, index) => <Card key={index} position={position} icon={image} partyURL = {partyURL}/>);

    useEffect(() => {
        console.log(props.position[0]);
    });

    return(
        <PositionPopup>
            <TitleBar onExit={setIsExpanded}/>
            {openPositions}
        </PositionPopup>
    );
}


function Card(props) {

    const { icon, partyURL } = props;
    const { id, role, hasCompensation, hasEquity } = props.position;

    const positionURL = partyURL + "/positions/" + id + "/apply";


    useEffect(() => {
        console.log(Compensation);
        console.log(Equity);
    });

    const perks = [hasCompensation ? Compensation : null, hasEquity ? Equity : null]
            .filter(notNull => notNull !== null)
            .map((image, index) => <Perk img={image} key={index}/>);

    return(
        <CardDiv>
            <Header>
                <Holder>
                    <Icon icon={icon}/>
                    {perks}
                </Holder> 
                <Details>
                    <Title>Software Engineer</Title>   
                    <Description>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</Description>
                    <Skills>
                        <SkillPill>Javascript</SkillPill>
                        <SkillPill>React</SkillPill>
                        <SkillPill>Redux</SkillPill>
                    </Skills>
                </Details>
            </Header>     
            <Body>
                <Link to={positionURL}><ApplyButton>APPLY</ApplyButton></Link>
            </Body>
        </CardDiv>
    )
}

const PositionPopup = styled.div`
    padding: 1px;
    background-color: #663a69;
    border-radius: 5px;
    position: absolute;
    top: 50%;
    left: 50%;
    /* bring your own prefixes */
    transform: translate(-50%, -50%);

    ul {
        padding: 0;
    }
`;

const CardDiv = styled.div`
    background-color: #98799A;
    border-radius: 5px;
    padding: 1rem;
    margin: 1rem;
`;

const Header = styled.div`
    display: flex;
    border-bottom: 1px solid black;
    padding-bottom: 5px;
`

const Holder = styled.div`
    margin: 0 auto;
    width: 100%;
    text-align: center;
    display: inline;
`;

const Icon = styled.div`
    background-image: url(${props => props.icon});
    background-repeat: no-repeat;
    min-width: 75px;
    min-height: 75px;
    background-size: contain;
    background-position: center;
    display: block;
`;

const Perk = styled.span`
    background-image: url(${props => props.img});
    background-repeat: no-repeat; 
    min-width: 35px;
    min-height: 35px;
    background-size: contain;
    background-position: center;
    display: inline-block;
`;

const Details = styled.div`
    text-align: center;
`;

const Title = styled.h1`
    display: inline;    
    margin: 0 auto;
    margin-left: .5rem;
    text-align: center;
`;

const Description = styled.p`
    text-align: center;
`;

const Skills = styled.div`
`;

const SkillPill = styled.button`
    font-size: 1.5rem;
    border-radius: 16px;
    background-color: #A34C45;
    color: black; 
    border: none;
    margin: 5px;

    :hover {
        background-color: #C4736D;
    }

    :focus {
        outline: none;
    }
`;

const Body = styled.div`
    margin: 5px;
    display: flex;
    justify-content: center;
`;

const ApplyButton = styled.button`
    background-color: green;
    color: white;
    border-radius: 4px;
    border: none;
    min-width: 75px;
    min-height: 50px;

    :hover {
        background-color: #90EE90;
    }

    :focus {
        outline: none;
    }
`;

export default PopupCard;