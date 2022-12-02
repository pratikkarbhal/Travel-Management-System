import React, { Component } from 'react';
import RouteService from '../../services/RouteService';

class UpdateRouteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: "",
            routeFrom: "",
            routeTo: "",
            pickupPoint: ""
        }
        this.changeidHandler = this.changeidHandler.bind(this);
        this.changeRouteFromHandler = this.changeRouteFromHandler.bind(this);
        this.changeRouteToHandler = this.changeRouteToHandler.bind(this);
        this.changePickupPointHandler = this.changePickupPointHandler.bind(this);
        this.saveRoute = this.saveRoute.bind(this);
    }

    saveRoute = (e) => {
        e.preventDefault();
        let route = { id: this.state.id, routeFrom: this.state.routeFrom, routeTo: this.state.routeTo, pickupPoint: this.state.pickupPoint };
        console.log("route =>" + JSON.stringify(route));

        RouteService.updateRoute(route).then(res => {
            this.props.history.push('/route');
        });
    }
    changeidHandler = (event) => {
        this.setState({ id: event.target.value });
    }
    changeRouteFromHandler = (event) => {
        this.setState({ routeFrom: event.target.value });
    }
    changeRouteToHandler = (event) => {
        this.setState({ routeTo: event.target.value });
    }
    changePickupPointHandler = (event) => {
        this.setState({ pickupPoint: event.target.value });
    }
    cancel() {
        this.props.history.push('/route');
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <br></br>
                            <h3 className="text-center">Update Route</h3>
                            <div className="card-body">
                                <form>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Id</label>
                                        <input placeholder="id" name="id" className="form-control"
                                            value={this.id} onChange={this.changeidHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Route From</label>
                                        <input placeholder="Route From" name="routeFrom" className="form-control"
                                            value={this.routeFrom} onChange={this.changeRouteFromHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Route To</label>
                                        <input placeholder="Route To" name="routeTo" className="form-control"
                                            value={this.routeTo} onChange={this.changeRouteToHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Pickup Point</label>
                                        <input placeholder="Pickup Point" name="pickupPoint" className="form-control"
                                            value={this.pickupPoint} onChange={this.changePickupPointHandler} />
                                    </div>
                                    <br></br>
                                    <button className="btn btn-success" onClick={this.saveRoute}>Save</button>
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

export default UpdateRouteComponent;