import axios from 'axios';

const REPORT_API_BASE_URL = "http://localhost:8080/report";

class ReportService{

    getReports(){
        return axios.get(REPORT_API_BASE_URL+ "/view/all");
    }

    createReport(report){
        return axios.post(`${REPORT_API_BASE_URL}/add/${report.adminId}`,report);

    }

    // updateReport(report){
    //     return axios.put(REPORT_API_BASE_URL, report);

    // }
    deleteReport(id){
        return axios.delete(REPORT_API_BASE_URL+ `/delete/${id}`);

    }

    getReportById(id){
        return axios.get(REPORT_API_BASE_URL+ `/view/${id}`);
    }

}
export default new ReportService()