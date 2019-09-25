import React, { useState, useEffect }  from 'react';
import styled from 'styled-components';
import Close from "../assets/close.svg";



function TitleBar(props) {

    const { onExit } = props;

    return(
        <TitleBarDiv>
            <CloseButton onClick={() =>  onExit(false)}/>
        </TitleBarDiv>
    )
}

const TitleBarDiv = styled.div`
    display: flex; 
    justify-content: flex-end
`;
const CloseButton = styled.button`
    margin-left:auto; 
    margin-right: 0;
    background-image: url(${Close});
    background-color: inherit;
    border: none;
    background-repeat: no-repeat;
    min-width: 25px;
    min-height: 25px;
    background-size: contain;
    background-position: center;

    :hover {
        background-color: white;
    }
`;

export default TitleBar;