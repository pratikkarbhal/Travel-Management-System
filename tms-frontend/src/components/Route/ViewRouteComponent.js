import React, { Component } from 'react';
import RouteService from '../../services/RouteService';

class ViewRouteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            route: []
        }
    }

    componentDidMount() {
        RouteService.getRouteById(this.state.id).then(res => {
            this.setState({ route: res.data });
        })

    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center">View Route Details for <b>{this.state.route.routeTo}</b></h2>
                    <hr></hr>
                    <div className="card-body">
                        <div className="row">
                            <label>Route From : {this.state.route.routeFrom} </label>

                        </div>
                        <div className="row">
                            <label>Route To : {this.state.route.routeTo} </label>

                        </div>
                        <div className="row">
                            <label>Departure Time : {this.state.route.departureTime} </label>

                        </div>

                        <div className="row">
                            <label>Arrival Time : {this.state.route.arrivalTime} </label>

                        </div>
                        <div className="row">
                            <label>Date of journey : {this.state.route.doj} </label>

                        </div>
                        <div className="row">
                            <label>Pickup Point : {this.state.route.pickupPoint} </label>

                        </div>
                        <div className="row">
                            <label>Fare : {this.state.route.fare} </label>

                        </div>
                        <div className="row">
                            <label>BusId : {this.state.route.busId} </label>

                        </div>
                    </div>
                </div>
                <br></br>
            </div>
        );
    }
}

export default ViewRouteComponent;
