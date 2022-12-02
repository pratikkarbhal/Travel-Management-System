import React, { Component } from 'react';
import RouteService from '../../services/RouteService';

class ListRouteComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            routes: []
        }
        this.addRoute = this.addRoute.bind(this);
        // this.updateReport = this.updateReport.bind(this);
        this.deleteRoute = this.deleteRoute.bind(this);
        this.viewRoute = this.viewRoute.bind(this);
    }
    componentDidMount() {
        RouteService.getRoutes().then((res) => {
            this.setState({ routes: res.data });
        });
    }

    addRoute() {
        this.props.history.push(`/add-route`);
    }
    // updateRoute(){
    //     this.props.history.push('/update-route');
    // }<button onClick={this.updateRoute} className="btn btn-info">Update</button> 
    deleteRoute(routeId) {
        RouteService.deleteRoute(routeId).then(res => {
            this.setState({ routes: this.state.routes.filter(route => route.routeId !== routeId) });
        });
    }
    viewRoute(routeId) {
        this.props.history.push(`/view-route/${routeId}`);
    }


    render() {
        return (
            <>
                <div>
                    <br></br>
                    <h2 className="text-center">Route List</h2>
                    <div>
                        <button className="btn btn-primary btn-success" onClick={this.addRoute}>Add Route</button>
                    </div>
                    <br></br>
                    <div className="row">
                        <table className=" table table-striped table-bordered">
                            <thead>
                                <tr>
                                    
                                    <th>Route From</th>
                                    <th>Route To</th>
                                    <th>Pickup Point</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody>
                                {
                                    this.state.routes.map(
                                        route =>
                                            <tr key={route.routeId}>
                                                
                                                <td>{route.routeFrom}</td>
                                                <td>{route.routeTo}</td>
                                                <td>{route.pickupPoint}</td>
                                                <td>

                                                    <button style={{ marginLeft: "10px" }} onClick={() => this.deleteRoute(route.routeId)} className="btn btn-danger">Delete</button>
                                                    <button style={{ marginLeft: "10px" }} onClick={() => this.viewRoute(route.routeId)} className="btn btn-info">View</button>
                                                </td>
                                            </tr>
                                    )
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </>
        );
    }
}

export default ListRouteComponent;