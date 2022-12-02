import React, { Component } from 'react';
import RouteService from '../../services/RouteService';

class CreateRouteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            routeFrom: "",
            routeTo: "",



            departureTime: "",
            arrivalTime: "",

            doj: "",
            pickupPoint: "",
            fare: "",
            busId: "",
        }

        this.changeRouteFromHandler = this.changeRouteFromHandler.bind(this);
        this.changeRouteToHandler = this.changeRouteToHandler.bind(this);
        this.changePickupPointHandler = this.changePickupPointHandler.bind(this);

        this.changeDepartureTimeHandler = this.changeDepartureTimeHandler.bind(this);
        this.changeArrivalTimeHandler = this.changeArrivalTimeHandler.bind(this);
        this.changeDojHandler = this.changeDojHandler.bind(this);
        this.changeFareHandler = this.changeFareHandler.bind(this);
        this.changeBusIdHandler = this.changeBusIdHandler.bind(this);

        this.saveRoute = this.saveRoute.bind(this);
    }




    changeDepartureTimeHandler = (event) => {
        this.setState({ departureTime: event.target.value });
    }
    changeArrivalTimeHandler = (event) => {
        this.setState({ arrivalTime: event.target.value });
    }
    changeDojHandler = (event) => {
        this.setState({ doj: event.target.value });
    }

    changeFareHandler = (event) => {
        this.setState({ fare: event.target.value });
    }
    changeBusIdHandler = (event) => {
        this.setState({ busId: event.target.value });
    }
    changePickupPointHandler = (event) => {
        this.setState({ pickupPoint: event.target.value });
    }
    changeRouteFromHandler = (event) => {
        this.setState({ routeFrom: event.target.value });
    }
    changeRouteToHandler = (event) => {
        this.setState({ routeTo: event.target.value });
    }


    cancel() {
        this.props.history.push('/routes');
    }


    saveRoute = (e) => {
        e.preventDefault();
        let route = { routeFrom: this.state.routeFrom, routeTo: this.state.routeTo, departureTime: this.state.departureTime, arrivalTime: this.state.arrivalTime, doj: this.state.doj, pickupPoint: this.state.pickupPoint, fare: this.state.fare, busId: this.state.busId };
        console.log("route =>" + JSON.stringify(route));

        RouteService.createRoute(route).then((res) => {
            this.props.history.push('/routes');
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
                            <h3 className="text-center">Add Route</h3>
                            <div className="card-body">
                                <form>
                                    <div style={{ marginBottom: "10px" }} className="form-group ">
                                        <label>Route From</label>
                                        <input placeholder="Route From" name="routeFrom" className="form-control"
                                            value={this.routeFrom} onChange={this.changeRouteFromHandler} autoFocus required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Route To</label>
                                        <input placeholder="Route To" name="routeTo" className="form-control"
                                            value={this.routeTo} onChange={this.changeRouteToHandler} required/>
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Departure Time</label>
                                        <input placeholder="Departure Time" name="departureTime" className="form-control"
                                            value={this.departureTime} onChange={this.changeDepartureTimeHandler} type="datetime-local" required/>
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group ">
                                        <label>Arrival Time</label>
                                        <input placeholder="Arrival Time" name="arrivalTime" className="form-control"
                                            value={this.arrivalTime} onChange={this.changeArrivalTimeHandler} type="datetime-local" required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Date of journey</label>
                                        <input placeholder="Date of journey" name="doj" className="form-control"
                                            value={this.doj} onChange={this.changeDojHandler} type="date" required/>
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Pickup Point</label>
                                        <input placeholder="Pickup Point" name="pickupPoint" className="form-control"
                                            value={this.pickupPoint} onChange={this.changePickupPointHandler} required/>
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group ">
                                        <label>Fare</label>
                                        <input placeholder="Fare" name="fare" className="form-control"
                                            value={this.fare} onChange={this.changeFareHandler} type="number" required/>
                                    </div>

                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>bus Id</label>
                                        <input placeholder="bus Id" name="busId" className="form-control"
                                            value={this.busId} onChange={this.changeBusIdHandler} type="number" required/>
                                    </div>
                                    <br></br>
                                    <button className="btn btn-success" onClick={this.saveRoute.bind(this)} type="submit">Save</button>
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

export default CreateRouteComponent;