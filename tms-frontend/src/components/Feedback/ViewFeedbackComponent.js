import React, { Component } from 'react';
import FeedbackService from '../../services/FeedbackService';

class ViewFeedbackComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            feedback: []
        }
    }

    componentDidMount() {
        FeedbackService.getFeedbackById(this.state.id).then(res => {
            this.setState({ feedback: res.data });
        })

    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center">View Feedback Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label>Feedback Id : {this.state.feedback.feedbackId} </label>

                        </div>
                        <div className="row">
                            <label>Customer Name : {this.state.feedback.customerName} </label>

                        </div>
                        <div className="row">
                            <label>Feedback  : {this.state.feedback.feedback} </label>

                        </div>
                        <div className="row">
                            <label>Rating : {this.state.feedback.rating} </label>

                        </div>
                    </div>
                </div>
                <br></br>
            </div>
        );
    }
}

export default ViewFeedbackComponent;
