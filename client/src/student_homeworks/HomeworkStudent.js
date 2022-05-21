import React from "react";
import "./Homework.css"
import {createSearchParams, useNavigate} from "react-router-dom";

function HomeworkStudent(props) {

    const navigate = useNavigate();
    const toSubmissions = () => {
        navigate({pathname: "/student/submissions", search: createSearchParams({homeworkId: props.id}).toString()});
    }

    const toNewSubmission = () => {
        navigate({pathname: "/student/new-submission", search: createSearchParams({homeworkId: props.id}).toString()})
    }

    return (
        <div className='homework'>
            <div className='block'> {props.name} </div>
            <div className='block'>
                <p className='p'> Publication date: </p>
                <div> {props.publication} </div>
            </div>
            <div className='block'>
                <p className='p'> Deadline: </p>
                <div> {props.deadline} </div>
            </div>
            <button className='button block' onClick={toSubmissions}> Submissions </button>
            <button className='button block' onClick={toNewSubmission}> New submit </button>
        </div>
    );
}

export default HomeworkStudent;