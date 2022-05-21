import React from "react";
import "./Submission.css"
import Submission from "./Submission";
import BackButton from "../back_btn/BackButton";
import {all_submissions} from "../utils/Api";
import {withRouter} from "../utils/withRouter";
import {formatDate} from "../utils/utils";



class Submissions extends React.Component {

    constructor(props) {
        super(props);
        this.state = {data: []}
    }

    componentDidMount() {
        const params = this.props.params;
        all_submissions(params.get('homeworkId'), (d) => this.setState({data: d}))
    }

    render() {
        const listItems = this.state.data.map( (d, i) =>
            <Submission key={i} id={d.id} homeworkId={d.homeworkId} number={i+1} time={formatDate(d.time)} result={d.result} back={this.props.back} />
        );

        return (
            <div>
                <BackButton/>
                <h1 className='text' > Submissions </h1>
                <div className='submissions'> {listItems} </div>
            </div>
        );
    }
}

export default withRouter(Submissions);