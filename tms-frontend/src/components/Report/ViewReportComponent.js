import React, { Component } from 'react';
import ReportService from '../../services/ReportService';

class ViewReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            report: []
        }
    }

    componentDidMount() {
        ReportService.getReportById(this.state.id).then(res => {
            this.setState({ report: res.data });
        })

    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center">View Report Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label>Report Id : {this.state.report.reportId} </label>

                        </div>
                        <div className="row">
                            <label>Report Name : {this.state.report.reportName} </label>

                        </div>
                        <div className="row">
                            <label>Report Type : {this.state.report.reportType} </label>

                        </div>
                    </div>
                </div>
                <br></br>
            </div>
        );
    }
}

export default ViewReportComponent;
