import React, { useState, useEffect, createRef }  from 'react';
import Helmet from 'react-helmet';
import { withRouter } from 'react-router-dom';
import styled from 'styled-components';
import axios from 'axios';
import Body from "../Miscellaneous/Body";
import Window  from "../Miscellaneous/Window";
import RoleIcon from "../Miscellaneous/RoleIcon";
import Apply from "../assets/apply.svg";
import Shield from "../assets/shield.svg";

function PartyLobby(props) {
    
    const { name } = props.match.params;

    const [party, setParty] = useState(null);

    const members = party != null ? party.positions.map(position => <ClickableRoleIcon role={position.role} size={"4rem"}/>) : null;

    useEffect(() => {
        axios.get("http://localhost:8080/parties/" + name)
        .then(response => {
            setParty(response.data); 
            console.log(response.data);  
        })
        .catch(error => {
            console.log(error);
        });
    },[])

    return(
        <Body>
            <Helmet>
                <title>{name}</title> 
            </Helmet>
            {party != null ? 
            <GridWindow>
                <Avatar gridArea={"avatar"}/>
                <InfoBox align={"right"} gridArea={"name"}>
                    <Title>{party.name}</Title>
                    <IconList>
                        {members}
                    </IconList>
                </InfoBox>
                <InfoBox align={"right"} gridArea={"mission"}>
                    <Title>Mission Statement</Title>
                    <Para>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</Para>
                </InfoBox>
                <InfoBox align={"left"} gridArea={"description"}>
                    <Title>Description</Title>
                    <Para>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?</Para>
                </InfoBox>
                <InfoBox align={"left"} gridArea={"communication"}>
                    <Title>Communication Channels</Title>
                    <IconList>
                        {members}
                    </IconList>
                </InfoBox>
            </GridWindow>
            :  null }
        </Body>
    )
}

const GridWindow = styled(Window)`
    margin: 0 auto;
    display: inline-grid;
    width: 100%;
    grid-template-rows: auto;
    grid-template-areas: 
        "avatar avatar name name"
        "avatar avatar mission mission"
        "description description description description"
        "communication communication communication communication";

    @media only screen 
        and (min-device-width: 320px) 
        and (max-device-width: 480px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: portrait) {
            grid-template-areas: 
                "avatar"
                "name"
                "mission"
                "description"
                "communication";
    }

`;

const Avatar = styled.div`
    background-image: url("${Shield}");
    background-repeat: no-repeat;
    margin: 0;
    min-width: 10rem;
    min-height: 10rem;
    background-size: contain;
    background-position: center;
    margin: 1.5rem;
    grid-area: ${props => props.gridArea};

    @media only screen 
    and (min-device-width: 320px) 
    and (max-device-width: 480px)
    and (-webkit-min-device-pixel-ratio: 2)
    and (orientation: portrait) {
        text-align: center;
        margin: 0 auto;
    }
`;


const ClickableRoleIcon = styled(RoleIcon)`
    :hover {
        background-color: green;
        background-image: none;
    }
`;

const InfoBox = styled.div`
    grid-area: ${props => props.gridArea};
    text-align: ${props => props.align};

    @media only screen 
    and (min-device-width: 320px) 
    and (max-device-width: 480px)
    and (-webkit-min-device-pixel-ratio: 2)
    and (orientation: portrait) {
        text-align: center;
    }
`;

const Title = styled.h1`
    margin: 10px;
    font-size: 3rem;
    color: 
`;

const IconList = styled.ul`
    list-style: none;
    margin: 10px;
    margin-bottom: 3rem;    
    padding: 0;

    li {
        display: inline;
    }
`;

const Para = styled.p`  
    font-size: 1.2rem;
    margin: 10px;
`;

export default PartyLobby;