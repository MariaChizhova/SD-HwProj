import React from "react";
import "./NewSubmission.css"
import BackButton from "../back_btn/BackButton";
import {homework, send_new_submission} from "../utils/Api";
import {withRouter} from "../utils/withRouter";
import {formatDate} from "../utils/utils";
import { InputGroup, FormControl, Button, Card } from 'react-bootstrap';


class NewSubmission extends React.Component {

    constructor(props) {
        super(props);
        this.state = {data: {}}
    }

    componentDidMount() {
        const params = this.props.params;
        homework(params.get('homeworkId'), (d) => this.setState({data: d}))
    }

    send = () => {
        const time = new Date();
        const solution = document.getElementById("link").value;
        send_new_submission(time, solution);
        this.props.navigate(-1);
    }

    render() {
        return (
            <div>
                <BackButton/>
                <h1 className='text' > {this.state.data.name} </h1>
                <Card className='description'>
                    <Card.Body>{this.state.data.description}</Card.Body>
                </Card>
                <div className='dates'>
                    <div className='block-ns'>
                        <p className='p-ns'> Publication date: </p>
                        <div className='dates-numbers'> {formatDate(this.state.data.publication)} </div>
                    </div>
                    <div className='block-ns'>
                        <p className='p-ns'> Deadline: </p>
                        <div className='dates-numbers'> {formatDate(this.state.data.deadline)} </div>
                    </div>
                </div>
                <InputGroup id="linkGroup">
                    <InputGroup.Text id="inputGroup-sizing-default">Link to the solution</InputGroup.Text>
                    <FormControl id="link" type={"text"}
                        aria-label="Default"
                        aria-describedby="inputGroup-sizing-default"
                    />
                </InputGroup>
                <Button variant={"success"} id='submit' onClick={this.send}> Submit </Button>
            </div>
        );
    }
}

export default withRouter(NewSubmission);