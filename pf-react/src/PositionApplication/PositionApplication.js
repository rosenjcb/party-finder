import React, { useState, useEffect, createRef }  from 'react';
import styled from "styled-components";
import Body from "../Miscellaneous/Body";
import Window from "../Miscellaneous/Window";

function PositionApplication(props) {

    return(
        <Body>
            <Window>
                <PositionForm>
                    <Input value="Username" isReadOnly={true}>
                    </Input>
                </PositionForm>
            </Window>
        </Body>
    )
}


const PositionForm = styled.form`
    display: flex;
    flex-direction: flex-start;
`;

const Input = styled.input.attrs( props => ({
    value : props.value,
    readonly : props.isReadOnly
}))`
    color: ${props => { return props.isReadOnly ? "grey" : "black" } }
    border-style: none;
    user-select: ${props => { return props.isReadOnly ? "none" : "default" } }
`;
export default PositionApplication;