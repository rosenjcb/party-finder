import React, { useState, useEffect, createRef }  from 'react';
import styled from 'styled-components';

function RoleIcon(props) {

    const { role, className, size } = props;

    const image = props.role ? require("../assets/" + process.env["REACT_APP_" + role.replace(" ","_").toUpperCase()]) : null;

    return(
        <Icon className={className} image={image} size={size} />
    );
}

const Icon = styled.div`
    background-image: url("${props  => props.image}");
    background-repeat: no-repeat;
    margin: 5px;
    height: ${props => props.size};
    width: ${props => props.size};
    background-size: contain;
    background-position: center;
    display: inline-block;
`;

export default RoleIcon;