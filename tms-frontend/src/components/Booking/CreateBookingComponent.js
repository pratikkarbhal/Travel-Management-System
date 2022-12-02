import React, { Component } from "react";
import BookingService from "../../services/BookingService";

class CreateBookingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      bookingId: "",
      bookingType: "",
      bookingTitle: "",
      description: "",
      bookingDate: "",
      pack: "",
      userId: "",
    };

    this.changeBookingIdHandler = this.changeBookingIdHandler.bind(this);
    this.changeBookingTypeHandler = this.changeBookingTypeHandler.bind(this);
    this.changeBookingTitleHandler = this.changeBookingTitleHandler.bind(this);

    this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
    this.changeBookingDateHandler = this.changeBookingDateHandler.bind(this);
    this.changePackHandler = this.changePackHandler.bind(this);
    this.changeUserIdHandler = this.changeUserIdHandler.bind(this);

    this.saveBooking = this.saveBooking.bind(this);
  }

  changeBookingIdHandler = (event) => {
    this.setState({ bookingId: event.target.value });
  };
  changeBookingTypeHandler = (event) => {
    this.setState({ bookingType: event.target.value });
  };
  changeBookingTitleHandler = (event) => {
    this.setState({ bookingTitle: event.target.value });
  };

  changeDescriptionHandler = (event) => {
    this.setState({ description: event.target.value });
  };
  changeBookingDateHandler = (event) => {
    this.setState({ bookingDate: event.target.value });
  };
  changePackHandler = (event) => {
    this.setState({ pack: event.target.value });
  };
  changeUserIdHandler = (event) => {
    this.setState({ userId: event.target.value });
  };

  cancel() {
    this.props.history.push("/booking");
  }

  saveBooking = (e) => {
    e.preventDefault();
    let booking = {
      bookingId: this.state.bookingId,
      bookingType: this.state.bookingType,
      bookingTitle: this.state.bookingTitle,
      description: this.state.description,
      bookingDate: this.state.bookingDate,
      pack: this.state.pack,
      userId: this.state.userId,
    };
    console.log("booking =>" + JSON.stringify(booking));

    BookingService.createBooking(booking).then((res) => {
      this.props.history.push("/bookings");
      alert("Successfully Added.");
    });
  };
  render() {
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <br></br>
              <h3 className="text-center">Add Booking</h3>
              <div className="card-body">
                <form>
                  <div style={{ marginBottom: "10px" }} className="form-group ">
                    <label>Booking Id</label>
                    <input
                      placeholder="Booking Id"
                      name="bookingId"
                      className="form-control"
                      value={this.bookingId}
                      onChange={this.changeBookingIdHandler}
                      type="number"
                      autoFocus
                      required
                    />
                  </div>

                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Booking Type</label>
                    <input
                      placeholder="Booking Type"
                      name="bookingType"
                      className="form-control"
                      value={this.bookingType}
                      onChange={this.changeBookingTypeHandler}
                      type="text"
                      required
                    />
                  </div>
                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Booking Title</label>
                    <input
                      placeholder="Booking Title"
                      name="bookingTitle"
                      className="form-control"
                      value={this.bookingTitle}
                      onChange={this.changeBookingTitleHandler}
                      type="text"
                      required
                    />
                  </div>
                  <div style={{ marginBottom: "10px" }} className="form-group ">
                    <label>Description</label>
                    <input
                      placeholder="Description"
                      name="Description"
                      className="form-control"
                      value={this.description}
                      onChange={this.changeDescriptionHandler}
                      type="text"
                      required
                    />
                  </div>

                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Booking Date</label>
                    <input
                      placeholder="Booking Date"
                      name="bookingDate"
                      className="form-control"
                      value={this.bookingDate}
                      onChange={this.changeBookingDateHandler}
                      type="date"
                      required
                    />
                  </div>
                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Pack</label>
                    <input
                      placeholder="Pack"
                      name="pack"
                      className="form-control"
                      value={this.pack}
                      onChange={this.changePackHandler}
                      type="number"
                      required
                    />
                  </div>
                  <div style={{ marginBottom: "10px" }} className="form-group ">
                    <label>UserId</label>
                    <input
                      placeholder="UserId"
                      name="userId"
                      className="form-control"
                      value={this.userId}
                      onChange={this.changeUserIdHandler}
                      type="number"
                      required
                    />
                  </div>

                  <br></br>
                  <button
                    className="btn btn-success"
                    onClick={this.saveBooking.bind(this)}
                    type="submit"
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateBookingComponent;
