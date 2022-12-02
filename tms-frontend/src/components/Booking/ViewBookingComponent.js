import React, { Component } from "react";
import BookingService from "../../services/BookingService";

class ViewBookingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.match.params.id,
      booking: [],
    };
  }

  componentDidMount() {
    BookingService.getBookingById(this.state.id).then((res) => {
      this.setState({ booking: res.data });
    });
  }

  render() {
    return (
      <div>
        <br></br>
        <div className="card col-md-6 offset-md-3">
          <h3 className="text-center">View Booking Details</h3>
          <div className="card-body">
            <div className="row">
              <label>Booking Id : {this.state.booking.bookingId} </label>
            </div>
            <div className="row">
              <label>Boking Type : {this.state.booking.bookingType} </label>
            </div>
            <div className="row">
              <label>Booking Title : {this.state.booking.bookingTitle} </label>
            </div>

            <div className="row">
              <label>Description : {this.state.booking.description} </label>
            </div>
            <div className="row">
              <label>Booking Date : {this.state.booking.bookingDate} </label>
            </div>
            <div className="row">
              <label>Pack : {this.state.booking.pack} </label>
            </div>
            <div className="row">
              <label>UserId : {this.state.booking.userId} </label>
            </div>
          </div>
        </div>
        <br></br>
      </div>
    );
  }
}

export default ViewBookingComponent;
