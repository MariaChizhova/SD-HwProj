import React from "react";
import "./Submission.css"
import {createSearchParams, useNavigate} from "react-router-dom";

/**
 * Represents a component of one submission for the all submissions page
 * @param props
 * @returns {JSX.Element}
 */
function Submission(props) {

    const navigate = useNavigate();
    const toSubmission = () => {
        navigate({pathname: `/${props.back}/submissions/submission`, search: createSearchParams({homeworkId: props.homeworkId, id: props.id}).toString()});
    }

    return (
        <div className='submission' onClick={toSubmission}>
            <div className='block-s-first'> {props.number} </div>
            <div className='block-s'> {props.time} </div>
            <div className='block-s'> {props.result} </div>
        </div>
    );

}

export default Submission;