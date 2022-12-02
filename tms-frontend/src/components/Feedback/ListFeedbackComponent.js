import React, { Component } from "react";
import FeedbackService from "../../services/FeedbackService";

class ListFeedbackComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      feedbacks: [],
    };
    this.addFeedback = this.addFeedback.bind(this);
    // this.updateFeedback = this.updateFeedback.bind(this);
    this.deleteFeedback = this.deleteFeedback.bind(this);
    this.viewFeedback = this.viewFeedback.bind(this);
  }
  componentDidMount() {
    FeedbackService.getFeedbacks().then((res) => {
      this.setState({ feedbacks: res.data });
    });
  }

  addFeedback() {
    this.props.history.push(`/add-feedback`);
  }
  // updateFeedback(){
  //     this.props.history.push('/update-feedback');
  // }<button onClick={this.updateFeedback} className="btn btn-info">Update</button>
  deleteFeedback(feedbackId) {
    FeedbackService.deleteFeedback(feedbackId).then((res) => {
      this.setState({
        feedbacks: this.state.feedbacks.filter(
          (feedback) => feedback.feedbackId !== feedbackId
        ),
      });
    });
  }
  viewFeedback(feedbackId) {
    this.props.history.push(`/view-feedback/${feedbackId}`);
  }

  render() {
    return (
      <>
        <div>
          <br></br>
          <h2 className="text-center">Feedback List</h2>
          <div>
            <button
              className="btn btn-primary btn-success"
              onClick={this.addFeedback}
            >
              Add Feedbacks
            </button>
          </div>
          <br></br>
          <div className="row">
            <table className=" table table-striped table-bordered">
              <thead>
                <tr>
                  
                  <th>Customer Id</th>
                  {/* <th>Email Id</th>
                                <th>Tour Name</th> */}
                  <th>Feedback </th>
                  <th>Rating </th>
                  <th>Submission Date</th>
                  <th>Action</th>
                </tr>
              </thead>

              <tbody>
                {this.state.feedbacks.map((feedback) => (
                  <tr key={feedback.feedbackId}>
                    
                    <td>{feedback.customerId}</td>
                    {/* <td>{feedback.emailId}</td>
                                        <td>{feedback.tourName}</td> */}
                    <td>{feedback.feedback}</td>
                    <td>{feedback.rating}</td>
                    <td>{feedback.submitDate}</td>
                    <td>
                      <button
                        style={{ marginLeft: "10px" }}
                        onClick={() => this.viewFeedback(feedback.feedbackId)}
                        className="btn btn-info"
                      >
                        View
                      </button>
                      {/* <button
                        style={{ marginLeft: "10px" }}
                        onClick={() => this.deleteFeedback(feedback.feedbackId)}
                        className="btn btn-danger"
                      >
                        Delete
                      </button> */}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </>
    );
  }
}

export default ListFeedbackComponent;
