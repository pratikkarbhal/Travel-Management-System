import React, { Component } from 'react';
import ReportService from '../../services/ReportService';

class ListReportComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            reports: []
        }
        this.addReport = this.addReport.bind(this);
        // this.updateReport = this.updateReport.bind(this);
        this.deleteReport = this.deleteReport.bind(this);
        this.viewReport = this.viewReport.bind(this);
    }
    componentDidMount() {
        ReportService.getReports().then((res) => {
            this.setState({ reports: res.data });
        });
    }

    addReport() {
        this.props.history.push(`/add-report`);
    }
    // updateReport(){
    //     this.props.history.push('/update-report');
    // }<button onClick={this.updateReport} className="btn btn-info">Update</button> 
    deleteReport(reportId) {
        ReportService.deleteReport(reportId).then(res => {
            this.setState({ reports: this.state.reports.filter(report => report.reportId !== reportId) });
        });
    }
    viewReport(reportId) {
        this.props.history.push(`/view-report/${reportId}`);
    }


    render() {
        return (
            <>
                <div>
                    <br></br>
                    <h2 className="text-center">Report List</h2>
                    <div>
                        <button className="btn btn-primary btn-success" onClick={this.addReport}>Add Reports</button>
                    </div>
                    <br></br>
                    <div className="row">
                        <table className=" table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Report Id</th>
                                    <th>Report Name</th>
                                    <th>Report Description</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody>
                                {
                                    this.state.reports.map(
                                        report =>
                                            <tr key={report.reportId}>
                                                <td>{report.reportId}</td>
                                                <td>{report.reportName}</td>
                                                <td>{report.reportType}</td>
                                                <td>

                                                    <button style={{ marginLeft: "10px" }} onClick={() => this.deleteReport(report.reportId)} className="btn btn-danger">Delete</button>
                                                    <button style={{ marginLeft: "10px" }} onClick={() => this.viewReport(report.reportId)} className="btn btn-info">View</button>
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

export default ListReportComponent;