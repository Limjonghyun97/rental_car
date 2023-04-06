package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.Booking;
import booking.BookingDto;
import booking.controller.BookingDao;
import controller.Action;

public class BookingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BookingDao bookingDao = BookingDao.getInstance();
		ArrayList<Booking> bookingInfo = bookingDao.getBookingAll();
		String date = request.getParameter("rental_date");
		String location = request.getParameter("location");

//		BookingDto bookingDto = new BookingDto();
//		bookingDao.creatBooking(bookingDto);

		response.sendRedirect("reservation");
	}
}
