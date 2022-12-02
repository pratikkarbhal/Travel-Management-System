package com.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tms.dto.ReportDetails;
import com.tms.dto.ReportRequest;
import com.tms.entities.Report;
import com.tms.service.IReportService;
import com.tms.util.ReportUtil;

@RestController
@RequestMapping("/report")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {

	@Autowired
	private IReportService rService;

	@Autowired
	private ReportUtil reportUtil;

	// Used for testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from Report";
	}

	// Used for adding report
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add/{id}")
	public ReportDetails addReport(@PathVariable("id") @Min(1) int id,@RequestBody @Valid ReportRequest requestData){
		Report repo = new Report(requestData.getReportName(), requestData.getReportType());
		repo.setAdminId(id);
		Report report = rService.addReport(repo);
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;

	}

	// Used for deleting Report
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public ReportDetails deleteReport(@PathVariable("id") @Min(1) int id){
		Report report = rService.deleteReport(id);
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;

	}
	
	// Used for viewing the report by ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public ReportDetails viewReport(@PathVariable("id") @Min(1) int id){
		Report report = rService.viewReport(id);
		ReportDetails rep = reportUtil.toDetailsReport(report);
		return rep;
	}

	// Used for viewing all the reports  
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<ReportDetails> viewAllReports() {
		List<Report> reports = rService.viewAllReports();
		List<ReportDetails> rep = reportUtil.toDetailsReport(reports);
		return rep;
	}

}
