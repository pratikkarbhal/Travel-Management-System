
import React, { Component } from 'react';
import FeedbackService from '../../services/FeedbackService';

class UpdateFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            //   id:"",
            feedbackId: "",
            TourName: "",
            DepartureDate: "",
            feedback: "",
            rating: ""
        }
        //  this.changeidHandler =this.changeidHandler.bind(this);
        this.changeFeedbackIdHandler = this.changeFeedbackIdHandler.bind(this);
        this.changeTourNameHandler = this.changeTourNameHandler.bind(this);
        this.changeDepartureDateHandler = this.changeDepartureDateHandler.bind(this);
        this.changeFeedbackHandler = this.changeFeedbackHandler.bind(this);
        this.changeRatingHandler = this.changeRatingHandler.bind(this);
        this.saveFeedback = this.saveFeedback.bind(this);
    }

    saveFeedback = (e) => {
        e.preventDefault();
        let feedback = { feedbackId: this.state.feedbackId, tourName: this.state.tourName, departureDate: this.state.departureDate, feedback: this.state.feedback, rating: this.state.rating };
        console.log("feedback =>" + JSON.stringify(feedback));

        FeedbackService.updateFeedback(feedback).then(res => {
            this.props.history.push('/feedbacks');
        });
    }
    // changeidHandler =(event)=>{
    //     this.setState({id: event.target.value});
    // }
    changeFeedbackIdHandler = (event) => {
        this.setState({ feedbackId: event.target.value });
    }
    changeTourNameHandler = (event) => {
        this.setState({ TourName: event.target.value });
    }
    changeDepartureDateHandler = (event) => {
        this.setState({ DepartureDate: event.target.value });
    }
    changeFeedbackHandler = (event) => {
        this.setState({ Feedback: event.target.value });
    }
    changeRatingHandler = (event) => {
        this.setState({ Rating: event.target.value });
    }

    cancel() {
        this.props.history.push('/feedbacks');
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <br></br>
                            <h3 className="text-center">Update Feedback</h3>
                            <div className="card-body">
                                <form>
                                    {/* <div style={{marginBottom:"10px"}} className="form-group">
                                        <label>Id</label>
                                        <input placeholder="id" name="id" className="form-control"
                                        value={this.id} onChange={this.changeidHandler} />
                                    </div> */}
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Feedback Id</label>
                                        <input placeholder="Feedback Id" name="feedbackId" className="form-control"
                                            value={this.feedbackId} onChange={this.changeFeedbackIdHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Tour Name</label>
                                        <input placeholder="Tour Name" name="tourName" className="form-control"
                                            value={this.tourName} onChange={this.changeTourNameHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Departure Date</label>
                                        <input placeholder="Departure Date" name="departure Date" className="form-control"
                                            value={this.departureDate} onChange={this.changeDepartureDateHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Feedback </label>
                                        <input placeholder="Feedback " name="feedback" className="form-control"
                                            value={this.feedback} onChange={this.changeFeedbackHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Rating </label>
                                        <input placeholder="Rating " name="rating" className="form-control"
                                            value={this.rating} onChange={this.changeRatingHandler} />
                                    </div>
                                    <br></br>
                                    <button className="btn btn-success" onClick={this.saveFeedback}>Save</button>
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

export default UpdateFeedbackComponent;