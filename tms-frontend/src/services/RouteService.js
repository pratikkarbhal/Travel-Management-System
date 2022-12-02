import axios from 'axios';

const REPORT_API_BASE_URL = "http://localhost:8080/route";

class RouteService{

    getRoutes(){
        return axios.get(REPORT_API_BASE_URL+ "/view/all");
    }

    createRoute(route){
        return axios.post(`${REPORT_API_BASE_URL}/add`,route);

    }

    // updateRoute(route){
    //     return axios.put(REPORT_API_BASE_URL, route);

    // }
    deleteRoute(id){
        return axios.delete(REPORT_API_BASE_URL+ `/delete/${id}`);

    }

    getRouteById(id){
        return axios.get(REPORT_API_BASE_URL+ `/view/${id}`);
    }

}
export default new RouteService()