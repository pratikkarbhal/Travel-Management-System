package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tms.dto.ReportDetails;
import com.tms.entities.Report;

@Component
public class ReportUtil {

	public ReportDetails toDetailsReport(Report report)
	{
		ReportDetails reportDetails = new ReportDetails(report.getReportId(),report.getReportName(),report.getReportType());
		reportDetails.setAdminId(report.getAdminId());
		return reportDetails;
	}

	public List<ReportDetails> toDetailsReport(Collection<Report> report) {

        List<ReportDetails> reports = new ArrayList<>();
        for (Report rep : report) {
        	ReportDetails newRep = toDetailsReport(rep);
            reports.add(newRep);
        }

        return reports;

    }
}
