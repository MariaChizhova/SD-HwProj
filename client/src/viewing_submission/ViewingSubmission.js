import React from "react";
import "./ViewingSubmission.css"
import BackButton from "../back_btn/BackButton";
import {homework, submission} from "../utils/Api";
import {formatDate} from "../utils/utils";
import {withRouter} from "../utils/withRouter";
import {Form, Row, Col, Card} from "react-bootstrap";

/**
 * Represents a page where there is a detailed description of the submission
 */
class ViewingSubmission extends React.Component {

    constructor(props) {
        super(props);
        this.state = {data: {}, homework: {}}
    }

    componentDidMount() {
        const params = this.props.params;
        submission(params.get('homeworkId'), params.get('id'), (d) => this.setState({data: d}))
        homework(params.get('homeworkId'), (h) => this.setState({homework: h}))
    }

    render() {
        return (
            <div>
                <BackButton/>
                <h1 className='text' > Submission #{this.state.data.id} </h1>
                <Form className='form'>
                    <Form.Group as={Row} className="mb-3" controlId="formPlaintextTask">
                        <Form.Label column sm="2">
                            Task:
                        </Form.Label>
                        <Col sm="10">
                            <Form.Control plaintext readOnly defaultValue={this.state.homework.name} />
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3" controlId="formPlaintextTime">
                        <Form.Label column sm="2">
                            Time:
                        </Form.Label>
                        <Col sm="10">
                            <Form.Control plaintext readOnly value={formatDate(this.state.data.time)} />
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3" controlId="formPlaintextResult">
                        <Form.Label column sm="2">
                            Result:
                        </Form.Label>
                        <Col sm="10">
                            <Form.Control plaintext readOnly defaultValue={this.state.data.result} />
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3" controlId="formPlaintextLink">
                        <Form.Label column sm="2">
                            Link:
                        </Form.Label>
                        <Col sm="10">
                            <Form.Control plaintext readOnly defaultValue={this.state.data.solution} />
                        </Col>
                    </Form.Group>
                    <Card>
                        <Card.Body>{this.state.data.programOutput}</Card.Body>
                    </Card>
                </Form>
            </div>
        );
    }
}

export default withRouter(ViewingSubmission);