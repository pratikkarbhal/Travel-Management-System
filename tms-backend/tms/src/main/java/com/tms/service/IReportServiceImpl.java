package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Report;
import com.tms.repository.IReportRepository;

@Service
@Transactional
public class IReportServiceImpl implements IReportService {

	@Autowired
	private IReportRepository reportRepository;
	// Used to add Report
	@Override
	public Report addReport(Report report){
		Report rept = reportRepository.save(report);
		return rept;
	}
	// Used to view Report using Report ID
	@Override
	public Report viewReport(int reportId){
		Optional<Report> optional = reportRepository.findById(reportId);
		Report report = optional.get();
		return report;
	} 
	// Used to delete Report
	@Override
	public Report deleteReport(int reportId) {
		Report report = viewReport(reportId);
		reportRepository.delete(report);
		return report;
	}
	// Used for viewing all Reports
	@Override
	public List<Report> viewAllReports() {
		List<Report> reports = reportRepository.findAll();
		return reports;
	}

}
