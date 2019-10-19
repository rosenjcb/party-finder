import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import styled from 'styled-components';
import axios from 'axios';
import { usePartyContext } from '..';

function PositionForm(props) {

    const [roles, setRoles] = useState([]);

    const[temp, setTemp] = useState({});

    const [position, setPosition, isPositionFormOpen, setIsPositionFormOpen] = usePartyContext();

    const handleChange = e => {
        e.preventDefault();
        const {name, value} = e.target;
        setTemp(temp  => ({...temp, [name]: value}));
    }

    const handleSubmit = e => {
        e.preventDefault();
        setPosition(temp);

        setIsPositionFormOpen(false);
    }

    useEffect(() => {
        console.log(process.env.REACT_APP_BACKEND_BASE_URL + "getRoles");
        axios.get(process.env.REACT_APP_BACKEND_BASE_URL + "getRoles")
        .then(response => {
            setRoles(response.data.map((obj, index) => <RoleOption key={index} value={obj.roleName}>{obj.roleName}</RoleOption>));
        })
        .catch(error => {
            console.log(error.response);
        });
    },[])
    
    return(
        <StyledPositionForm>
            <Field>
                <Header>Title</Header>
                <Detail>Title for the position you are creating.</Detail>
                <Input></Input>
            </Field>
            <Field>
                <Header>Role</Header>
                <Detail>What's the role for this position?</Detail>
                <RoleSelect name="role" onChange={handleChange}>
                    {roles}
                </RoleSelect>
            </Field>
            <Field>
                <Header>Compensation Package</Header>
                <Input type={"checkbox"} onChange={handleChange} name="hasCompensation" value={true} /> Compensation<br/>
                <Input type={"checkbox"} onChange={handleChange} name="hasEquity" value={true}/> Equity<br/>
            </Field>
            <Button color={"green"} hoverColor={"lightgreen"} onClick={handleSubmit}>Add</Button>
            <Button color={"red"} hoverColor={"#ff8080"} onClick={(e) => {
                e.preventDefault();
                setPosition({});
                setIsPositionFormOpen(false);
            }}>Cancel</Button>
        </StyledPositionForm>
    );
}

const StyledPositionForm = styled.div`
    background-color: #663a69;
    border-radius: 8px;
`;

const Field = styled.div`
    display: block;
    margin: 2rem;
`;

const Header = styled.h1`
    font-size: ${props => props.size ? props.size : "1.5rem"};
    color: white;
    display: block;
    margin: 0.5rem;
    margin-bottom: 0;
    margin-left: 0;
    max-width: ${props => props.maxWidth ? props.maxWidth : "default"};
`;

const Detail = styled.p`
    margin: 0;
    margin-bottom: 1rem;
    color: grey;
`;

const Input = styled.input`
`;

const RoleSelect = styled.select`
`;

const RoleOption = styled.option`
`;

const Button = styled.button`
    background-color: ${props => props.color};
    margin: 1rem;
    font-size: 1rem;
    color: white;
    border-radius: 4px;
    border: none;
    min-width: 75px;
    min-height: 50px;

    :hover {
        background-color: ${props => props.hoverColor};
    }

    :focus {
        outline: none;
    }
`;
export default PositionForm;