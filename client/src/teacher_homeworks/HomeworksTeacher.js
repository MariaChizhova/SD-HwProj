import React from "react";
import HomeworkTeacher from "./HomeworkTeacher";
import "./HomeworksTeacher.css"
import {withRouter} from "../utils/withRouter";
import {teacher_homework} from "../utils/Api";
import { Button } from 'react-bootstrap';

class HomeworksTeacher extends React.Component {

    constructor(props) {
        super(props);
        this.state = {data: []}
    }

    componentDidMount() {
        teacher_homework((d) => this.setState({data: d}))
    }

    render() {

        const toNewHomework = () => {
            this.props.navigate("/teacher/new-homework");
        }

        const listItems = this.state.data.map( (d, i) =>
            <HomeworkTeacher key={i} id={d.id} name={d.name} publication={d.publication} deadline={d.deadline}/>
        );

        return (
            <div>
                <div className='header-th'>
                    <h1 className='text-th'> Homeworks </h1>
                    <Button variant="secondary" className='new' onClick={toNewHomework}> New</Button>
                </div>
                <div className='homeworks'> {listItems} </div>
            </div>
        );
    }
}

export default withRouter(HomeworksTeacher);