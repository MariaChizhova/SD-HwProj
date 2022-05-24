import React from "react";
import "./NewHomework.css"
import BackButton from "../back_btn/BackButton";
import {send_new_homework} from "../utils/Api";
import {withRouter} from "../utils/withRouter";
import {Button, Form, Row} from "react-bootstrap";
import Col from "react-bootstrap/Col";
import DateRangePicker from "react-bootstrap-daterangepicker";
import moment from 'moment';

/**
 * Presents a page for creating a new homework
 */
class NewHomework extends React.Component {

    publication = moment();
    deadline = moment();

    send = () => {
        const name = document.getElementById("name").value;
        const description = document.getElementById("description").value;
        send_new_homework(name, description, this.publication, this.deadline);
        this.props.navigate(-1);
    }

    render() {
        return (
            <div>
                <BackButton/>
                <h1 className='text'> Create new homework </h1>
                <Form className='form'>
                    <Form.Group className="mb-3" controlId="formGroupName">
                        <Form.Label>Name</Form.Label>
                        <Form.Control id="name" type="text" placeholder="Enter name"/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formGroupDescription">
                        <Form.Label>Description</Form.Label>
                        <Form.Control id="description" as="textarea" rows={8}/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formGroupTestingProgram">
                        <Form.Label>Testing program</Form.Label>
                        <Form.Control type="text" placeholder="Testing program"/>
                    </Form.Group>
                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridPublicationDate">
                            <Form.Label>Publication date</Form.Label>
                            <DateRangePicker id="publication"
                                initialSettings={{
                                    timePicker: true,
                                    singleDatePicker: true,
                                    showDropdowns: true,
                                    minYear: 1901,
                                    maxYear: parseInt(moment().format('YYYY'), 10) + 1,
                                    locale: { format: 'DD.MM.YYYY hh:mm A', },
                                }}
                                onCallback={(date) => {
                                    this.publication = date;
                                }}
                            >
                                <input type="text" className="form-control col-4"/>
                            </DateRangePicker>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridDeadline">
                            <Form.Label>Deadline</Form.Label>
                            <DateRangePicker
                                initialSettings={{
                                    timePicker: true,
                                    singleDatePicker: true,
                                    showDropdowns: true,
                                    minYear: 1901,
                                    maxYear: parseInt(moment().format('YYYY'), 10) + 1,
                                    locale: { format: 'DD.MM.YYYY hh:mm A', },
                                }}
                                onCallback={(date) => {
                                    this.deadline = date;
                                }}
                                >
                                <input type="text" className="form-control col-4"/>
                            </DateRangePicker>
                        </Form.Group>
                    </Row>
                </Form>
                <Button variant={"success"} id='create' onClick={this.send}> Create </Button>
            </div>
        );
    }
}

export default withRouter(NewHomework);