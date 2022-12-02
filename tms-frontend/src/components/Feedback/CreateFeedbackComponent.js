import React, { Component } from 'react';
import FeedbackService from '../../services/FeedbackService';

class CreateFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            customerName: "",
            // emailId: "",
            tourName: "",
            submitDate: "",
            feedback: "",
            rating: "",
            customerId: "",
        }

        this.changeCustomerNameHandler = this.changeCustomerNameHandler.bind(this);
        // this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
        this.changeTourNameHandler = this.changeTourNameHandler.bind(this);
        this.changeSubmitDateHandler = this.changeSubmitDateHandler.bind(this);
        this.changeCustomerIdHandler = this.changeCustomerIdHandler.bind(this);
        this.changeFeedbackHandler = this.changeFeedbackHandler.bind(this);
        this.changeRatingHandler = this.changeRatingHandler.bind(this);
        this.saveFeedback = this.saveFeedback.bind(this);
    }

    changeCustomerNameHandler = (event) => {
        this.setState({ customerName: event.target.value });
    }
    // changeEmailIdHandler = (event) => {
    //     this.setState({ emailId: event.target.value });
    // }
    changeTourNameHandler = (event) => {
        this.setState({ tourName: event.target.value });
    }
    changeSubmitDateHandler = (event) => {
        this.setState({ submitDate: event.target.value });
    }
    changeFeedbackHandler = (event) => {
        this.setState({ feedback: event.target.value });
    }
    changeRatingHandler = (event) => {
        this.setState({ rating: event.target.value });
    }
    changeCustomerIdHandler = (event) => {
        this.setState({ customerId: event.target.value });
    }

    cancel() {
        this.props.history.push('/feedbacks');
    }


    saveFeedback = (e) => {
        e.preventDefault();
        let feedback = { feedback: this.state.feedback, rating: this.state.rating, submitDate: this.state.submitDate, customerName: this.state.customerName, tourName: this.state.tourName, customerId: this.state.customerId };
        console.log("feedback =>" + JSON.stringify(feedback));

        FeedbackService.createFeedback(feedback).then((res) => {
            this.props.history.push('/feedbacks');
            alert("Successfully Added.");
        });
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <br></br>
                            <h3 className="text-center">Add Feedback</h3>
                            <div className="card-body">
                                <form>
                                    <div style={{ marginBottom: "10px" }} className="form-group ">
                                        <label>Customer Id</label>
                                        <input placeholder="Customer Id" name="customerId" className="form-control"
                                            value={this.customerId} onChange={this.changeCustomerIdHandler} type="number" autoFocus required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Customer Name</label>
                                        <input placeholder="Customer Name" name="customerName" className="form-control"
                                            value={this.customerName} onChange={this.changeCustomerNameHandler} required/>
                                    </div>

                                    {/* <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Email Id</label>
                                        <input placeholder="Email Id" name="emailId" className="form-control"
                                            value={this.emailId} onChange={this.changeEmailIdHandler} />
                                    </div> */}

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Tour Name</label>
                                        <input placeholder="Tour Name/ Destination" name="tourName" className="form-control"
                                            value={this.tourName} onChange={this.changeTourNameHandler} required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Departure Date</label>
                                        <input placeholder="yyyy-mm-dd" name="submitDate" className="form-control"
                                            value={this.submitDate} onChange={this.changeSubmitDateHandler} type="date" required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label> Feedback about your Trip</label>
                                        <input placeholder="Write your Feedback here " name="feedback" className="form-control"
                                            value={this.feedback} onChange={this.changeFeedbackHandler} required/>
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label> Rating of your Trip</label>
                                        <input placeholder="Give your Rating here " name="rating" className="form-control"
                                            value={this.rating} onChange={this.changeRatingHandler} required type="number" max={5} min={0}/>
                                    </div>

                                    <br></br>
                                    <button className="btn btn-success" onClick={this.saveFeedback.bind(this)} type="submit">Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateFeedbackComponent;