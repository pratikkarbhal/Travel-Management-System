package com.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "REPORT")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REPORT_ID")
	private int reportId;
	
	@Column(name = "REPORT_NAME")
    private String reportName;
	
	@Column(name = "REPORT_TYPE")
    private String reportType;
	
	
	private int adminId;
	// Getters and setters
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public Report() {}

	public Report(int reportId, String reportName, String reportType) {
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportType = reportType;
	}

	public Report(String reportName, String reportType) {
		super();
		this.reportName = reportName;
		this.reportType = reportType;
	}

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

	//ToString
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportName=" + reportName + ", reportType=" + reportType + "]";
	}
	
	
}
