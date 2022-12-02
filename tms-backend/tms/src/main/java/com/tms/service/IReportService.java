package com.tms.service;

import java.util.List;

import com.tms.entities.Report;

public interface IReportService {
	
	public Report addReport(Report report);
	public Report deleteReport(int reportId);
	public Report viewReport(int reportId);
	public List<Report> viewAllReports();
		
}
