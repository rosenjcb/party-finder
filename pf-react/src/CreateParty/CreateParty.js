import React, { useState, useEffect, createRef }  from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import styled from 'styled-components';
import PartyForm from "./PartyForm/PartyForm";

function CreateParty(props) {

    return(
        <CreatePartyDiv>
            <Header>Create A Party</Header>
            <PartyForm/>
        </CreatePartyDiv>
    )
}


const CreatePartyDiv = styled.div`
    padding: 3rem;
    background-color: #2C2F33;
    display: flex;
    flex-direction: column;
`;

const Header = styled.h1`
    color: white;
    display: block;
`;

export default CreateParty;