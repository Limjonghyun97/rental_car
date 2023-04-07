<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Renter Car</title>
<link rel="stylesheet" href="/resorces/grid.css">
</head>
<jsp:include page="header"/>
<body>
<%
BookingDao bookingDao = BookingDao.getInstance();
ArrayList<Booking> list = bookingDao.getBookingAll();

VehicleDao vehicleDao = VehicleDao.getInstance();
ArrayList<Vehicle> list2 = vehicleDao.getVehicleAll();

VenueDao venuDao = VenueDao.getInstance();
ArrayList<Venue> list3 = venuDao.getVenueAll();

String custname = request.getParameter("custname");
String phone = request.getParameter("phone");

%>
<section>
<h2>차량예약</h2>
<div class="search">
	<img src="<%= %>">
	<h3><%= %></h3>
	<p><%= %></p>
	<p><%= %></p>
</div>
</section>
</body>
<jsp:include page="footer"/>
</html>