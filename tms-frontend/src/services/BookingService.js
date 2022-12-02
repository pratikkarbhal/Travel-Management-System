import axios from 'axios';

const BOOKING_API_BASE_URL = "http://localhost:8080/booking";

class BookingService {

    getBookings() {
        return axios.get(BOOKING_API_BASE_URL + "/view/all");
    }

    createBooking(booking) {
        return axios.post(`${BOOKING_API_BASE_URL}/add/${booking.bookingId}`, booking);

    }

    // updateBooking(booking){
    //     return axios.put(BOOKING_API_BASE_URL, booking);

    // }
    deleteBooking(id) {
        return axios.delete(BOOKING_API_BASE_URL + `/delete/${id}`);

    }

    getBookingById(id) {
        return axios.get(BOOKING_API_BASE_URL + `/view/${id}`);
    }

}
export default new BookingService()