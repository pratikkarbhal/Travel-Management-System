import React, { Component } from "react";
import BookingService from "../../services/BookingService";

class ListBookingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      bookings: [],
    };
    this.addBooking = this.addBooking.bind(this);
    // this.updateReport = this.updateReport.bind(this);
    this.deleteBooking = this.deleteBooking.bind(this);
    this.viewBooking = this.viewBooking.bind(this);
  }
  componentDidMount() {
    BookingService.getBookings().then((res) => {
      this.setState({ bookings: res.data });
    });
  }

  addBooking() {
    this.props.history.push(`/add-booking`);
  }
  // updateBooking(){
  //     this.props.history.push('/update-booking');
  // }<button onClick={this.updateBooking} className="btn btn-info">Update</button>
  deleteBooking(bookingId) {
    BookingService.deleteBooking(bookingId).then((res) => {
      this.setState({
        bookings: this.state.bookings.filter(
          (booking) => booking.bookingId !== bookingId
        ),
      });
    });
  }
  viewBooking(bookingId) {
    this.props.history.push(`/view-booking/${bookingId}`);
  }

  render() {
    return (
      <>
        <div>
          <br></br>
          <h2 className="text-center">Booking List</h2>
          <div>
            <button
              className="btn btn-primary btn-success"
              onClick={this.addBooking}
            >
              Add Booking
            </button>
          </div>
          <br></br>
          <div className="row">
            <table className=" table table-striped table-bordered">
              <thead>
                <tr>
                  <th>Booking Id</th>
                  <th>Booking Type</th>
                  <th>Booking Title</th>
                  <th>Description</th>
                  <th>Booking Date</th>
                  <th>UserId</th>
                  <th>Action</th>
                </tr>
              </thead>

              <tbody>
                {this.state.bookings.map((booking) => (
                  <tr key={booking.bookingId}>
                    <td>{booking.bookingId}</td>
                    <td>{booking.bookingType}</td>
                    <td>{booking.bookingTitle}</td>
                    <td>{booking.description}</td>
                    <td>{booking.bookingDate}</td>
                    <td>{booking.userId}</td>
                    <td>
                      <button
                        style={{ marginLeft: "10px" }}
                        onClick={() => this.deleteBooking(booking.bookingId)}
                        className="btn btn-danger"
                      >
                        Delete
                      </button>
                      <button
                        style={{ marginLeft: "10px" }}
                        onClick={() => this.viewBooking(booking.bookingId)}
                        className="btn btn-info"
                      >
                        View
                      </button>
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

export default ListBookingComponent;
