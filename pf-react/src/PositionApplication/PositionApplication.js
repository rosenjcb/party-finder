import React, { useState, useEffect, createRef }  from 'react';
import styled from "styled-components";
import Body from "../Miscellaneous/Body";
import Window from "../Miscellaneous/Window";
import axios from 'axios';
import RoleIcon from "../Miscellaneous/RoleIcon";
import Equity from "../assets/equity.svg";
import Compensation from "../assets/compensation.svg";

function PositionApplication(props) {

    const [position, setPosition] = useState({});

    const perks = [position.hasCompensation ? Compensation : null, position.hasEquity ? Equity : null]
            .filter(notNull => notNull !== null)
            .map((image, index) => <Perk img={image} key={index}/>);

    useEffect(() => {
        console.log(props);
        const resourceUrl = process.env.REACT_APP_BACKEND_BASE_URL + props.match.url.split("/").slice(1, -1).join("/");
        axios.get(resourceUrl)
        .then(response => {
                console.log(response.data);   
                setPosition(response.data);     
            })
            .catch(error => {
                
            });
    },[]);

    useEffect(() => {
        console.log(perks);
    },[position]);

    return(
        <Body>
            <Header size={"2.5rem"}>Position Application for {props.match.params.name}</Header>
            { position != null ? 
            <Window> 
                <RoleHeader>
                    <Header maxWidth="12%" size={"2rem"}>{position.role}</Header>
                    <Holder>
                        <RoleIcon role={position.role} size={"4rem"}/>
                        <Perks>{perks}</Perks>
                    </Holder>
                </RoleHeader>
                <PositionForm>
                    <Field>
                        <Header>Username</Header>
                        <Label>User</Label>
                    </Field>
                    <Field>
                        <Header>Test</Header>
                        <Input/>
                    </Field>
                </PositionForm>
            </Window>
            : null }
        </Body>
    )
}


const Label = styled.label`
    background-color: rgb(235, 235, 228);
    color: rgb(84, 84, 84);
    user-select: none;
    border-radius: 3px;
`;
const PositionForm = styled.form`
    display: flex;
    flex-direction: flex-start;
    justify-content: space-between;
    margin: 10px;
    background-color: #2D293D;
    border-radius: 5px;    
`;

const Input = styled.input.attrs( props => ({
    value : props.value,
    readonly : props.isReadOnly
}))`
    color: ${props => { return props.isReadOnly ? "grey" : "black" } }
    border-style: none;
    user-select: ${props => { return props.isReadOnly ? "none" : "default" } }
`;

const Field = styled.div`
    display: block;
`;

const Header = styled.h1`
    font-size: ${props => props.size ? props.size : "1.5rem"};
    color: white;
    display: block;
    margin: 0.5rem;
    margin-left: 0;
    max-width: ${props => props.maxWidth ? props.maxWidth : "default"};
`;

const RoleHeader = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-end;
`;


const Holder = styled.div`
    display: flex;
    flex-direction: column;
`;


const Perks = styled.div`
    display: inline-block;
`;

const Perk = styled.span`
    background-image: url(${props => props.img});
    background-repeat: no-repeat; 
    min-width: 35px;
    min-height: 35px;
    background-size: contain;
    background-position: center;
`;
export default PositionApplication;