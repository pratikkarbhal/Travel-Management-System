package com.tms.dto;

public class ReportDetails {

	private int reportId;
	private String reportName;
	private String reportType;
	private int adminId;

	// Constructor
	public ReportDetails(int reportId, String reportName, String reportType) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
	}

	// Getters and Setters
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	

}
