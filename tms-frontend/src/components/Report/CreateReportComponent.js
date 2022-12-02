import React, { Component } from "react";
import ReportService from "../../services/ReportService";

class CreateReportComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      reportName: "",
      reportType: "",
      adminId: "",
    };

    this.changeReportNameHandler = this.changeReportNameHandler.bind(this);
    this.changeAdminIdHandler = this.changeAdminIdHandler.bind(this);
    this.changeReportTypeHandler = this.changeReportTypeHandler.bind(this);
    this.saveReport = this.saveReport.bind(this);
  }

  changeReportNameHandler = (event) => {
    this.setState({ reportName: event.target.value });
  };
  changeReportTypeHandler = (event) => {
    this.setState({ reportType: event.target.value });
  };
  changeAdminIdHandler = (event) => {
    this.setState({ adminId: event.target.value });
  };

  cancel() {
    this.props.history.push("/reports");
  }

  saveReport = (e) => {
    e.preventDefault();
    let report = {
      reportName: this.state.reportName,
      reportType: this.state.reportType,
      adminId: this.state.adminId,
    };
    console.log("report =>" + JSON.stringify(report));

    ReportService.createReport(report).then((res) => {
      this.props.history.push("/reports");
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
              <h3 className="text-center">Add Report</h3>
              <div className="card-body">
                <form>
                  <div style={{ marginBottom: "10px" }} className="form-group ">
                    <label>Admin Id</label>
                    <input
                      placeholder="Admin Id"
                      name="adminId"
                      className="form-control"
                      value={this.adminId}
                      onChange={this.changeAdminIdHandler}
                      type="number"
                      autoFocus
                      required
                    />
                  </div>

                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Report Name</label>
                    <input
                      placeholder="Report Name"
                      name="reportName"
                      className="form-control"
                      value={this.reportName}
                      onChange={this.changeReportNameHandler}
                      required
                    />
                  </div>
                  <div style={{ marginBottom: "10px" }} className="form-group">
                    <label>Report Description</label>
                    <input
                      placeholder="Report Description"
                      name="reportType"
                      className="form-control"
                      value={this.reportType}
                      onChange={this.changeReportTypeHandler}
                      required
                    />
                  </div>
                  <br></br>
                  <button
                    className="btn btn-success"
                    onClick={this.saveReport.bind(this)}
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

export default CreateReportComponent;
