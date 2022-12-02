
import React, { Component } from 'react';
import ReportService from '../../services/ReportService';

class UpdateReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: "",
            reportId: "",
            reportName: "",
            reportType: ""
        }
        this.changeidHandler = this.changeidHandler.bind(this);
        this.changeReportIdHandler = this.changeReportIdHandler.bind(this);
        this.changeReportNameHandler = this.changeReportNameHandler.bind(this);
        this.changeReportTypeHandler = this.changeReportTypeHandler.bind(this);
        this.saveReport = this.saveReport.bind(this);
    }

    saveReport = (e) => {
        e.preventDefault();
        let report = { id: this.state.id, reportId: this.state.reportId, reportName: this.state.reportName, reportType: this.state.reportType };
        console.log("report =>" + JSON.stringify(report));

        ReportService.updateReport(report).then(res => {
            this.props.history.push('/reports');
        });
    }
    changeidHandler = (event) => {
        this.setState({ id: event.target.value });
    }
    changeReportIdHandler = (event) => {
        this.setState({ reportId: event.target.value });
    }
    changeReportNameHandler = (event) => {
        this.setState({ reportName: event.target.value });
    }
    changeReportTypeHandler = (event) => {
        this.setState({ reportType: event.target.value });
    }
    cancel() {
        this.props.history.push('/reports');
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <br></br>
                            <h3 className="text-center">Update Report</h3>
                            <div className="card-body">
                                <form>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Id</label>
                                        <input placeholder="id" name="id" className="form-control"
                                            value={this.id} onChange={this.changeidHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Report Id</label>
                                        <input placeholder="Report Id" name="reportId" className="form-control"
                                            value={this.reportId} onChange={this.changeReportIdHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Report Name</label>
                                        <input placeholder="Report Name" name="reportName" className="form-control"
                                            value={this.reportName} onChange={this.changeReportNameHandler} />
                                    </div>
                                    <div style={{ marginBottom: "10px" }} className="form-group">
                                        <label>Report Type</label>
                                        <input placeholder="Report Type" name="reportType" className="form-control"
                                            value={this.reportType} onChange={this.changeReportTypeHandler} />
                                    </div>
                                    <br></br>
                                    <button className="btn btn-success" onClick={this.saveReport}>Save</button>
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

export default UpdateReportComponent;