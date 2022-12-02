import axios from 'axios';

const REPORT_API_BASE_URL = "http://localhost:8080/feedback";

class FeedbackService{

    getFeedbacks(){
        return axios.get(REPORT_API_BASE_URL+ "/view/all");
    }

    createFeedback(feedback){
        return axios.post(`${REPORT_API_BASE_URL}/add`,feedback);

    }

    // updateFeedback(feedback){
    //     return axios.put(REPORT_API_BASE_URL, feedback);

    // }
    deleteFeedback(id){
        return axios.delete(REPORT_API_BASE_URL+ `/delete/${id}`);

    }

    getFeedbackById(id){
        return axios.get(REPORT_API_BASE_URL+ `/view/${id}`);
    }

}
export default new FeedbackService()