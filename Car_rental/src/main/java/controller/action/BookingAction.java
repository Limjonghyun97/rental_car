package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.BookingDto;
import booking.controller.BookingDao;
import controller.Action;

public class BookingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String date = request.getParameter("join_date");
		String location = request.getParameter("location");

		BookingDto bookingDto = new BookingDto(id, password, name);
		BookingDao bookingDao = BookingDao.getInstance();
		bookingDao.creatBooking(bookingDto);

		response.sendRedirect("reservation");
	}
}
