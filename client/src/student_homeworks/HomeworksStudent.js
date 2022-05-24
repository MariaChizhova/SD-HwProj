import React from "react";
import HomeworkStudent from "./HomeworkStudent";
import "./Homeworks.css"
import { student_homework } from "../utils/Api"
import {formatDate} from "../utils/utils";

/**
 * Presents the main page for the student
 */
class HomeworksStudent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {data: []}
    }

    componentDidMount() {
        setInterval( () => student_homework((d) => this.setState({data: d})), 5000);
        student_homework((d) => this.setState({data: d}));
    }

    render() {

        const listItems = this.state.data.map( (d, i) =>
            <HomeworkStudent key={i} id={d.id} name={d.name} publication={formatDate(d.publication)} deadline={formatDate(d.deadline)}/>
        );

        return (
            <div>
                <h1 className='text' > Homeworks </h1>
                <div className='homeworks'> {listItems} </div>
            </div>
        );
    }
}

export default HomeworksStudent;