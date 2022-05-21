import React from "react";
import {createSearchParams, useNavigate} from "react-router-dom";
import {formatDate} from "../utils/utils";

function HomeworkTeacher(props) {

    const navigate = useNavigate();
    const toSubmissions = () => {
        navigate({pathname: "/teacher/submissions", search: createSearchParams({homeworkId: props.id}).toString()});
    }

    return (
        <div className='homework'>
            <div className='block'> {props.name} </div>
            <div className='block'>
                <p className='p'> Publication date: </p>
                <div> {formatDate(props.publication)} </div>
            </div>
            <div className='block'>
                <p className='p'> Deadline: </p>
                <div> {formatDate(props.deadline)} </div>
            </div>
            <button className='button block' onClick={toSubmissions}> Submissions </button>
        </div>
    );
}

export default HomeworkTeacher;