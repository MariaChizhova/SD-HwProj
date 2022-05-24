import React from "react";
import "./BackButton.css"
import {useNavigate} from "react-router-dom";
import { Button } from 'react-bootstrap';


function BackButton() {

    const navigate = useNavigate();
    const toBack = () => {
        navigate(-1, {replace: true});
    }

    return (
        <Button variant="dark" id="back-btn" onClick={toBack}>
            Back
        </Button>
    );

}

export default BackButton;