<%@page import="venue.Venue"%>
<%@page import="venue.controller.VenueDao"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="booking.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.security.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Renter Car</title>
<link rel="stylesheet" href="/resorces/grid.css">
</head>
<jsp:include page="/header" />
<body>
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	//Timestamp to String
	String currentTimestampToString = sdf.format(System.currentTimeMillis());
	
	String vehicleId = request.getParameter("vehicleId");
	
	VehicleDao vehicleDao = VehicleDao.getInstance();
	ArrayList<Vehicle> list = vehicleDao.getVehicleAll();

	VenueDao venuDao = VenueDao.getInstance();
	ArrayList<Venue> list2 = venuDao.getVenueAll();
	%>

	<section>
		<h2>차량예약</h2>
		<form method="POST" action="">
		<div class="reservationInfo">
			<%for(Vehicle vehicleInfo : list) { 
				if(vehicleId.equals(vehicleInfo.getVehicleId())){
			%>
			<img class="reservationImg" src="../resorces/img/<%=vehicleInfo.getName() %>.jpg" alt="차량이미지">
			<h3><%=vehicleInfo.getName() %></h3>
			<p><%=vehicleInfo.getVehicleId() %></p>
			<p><%=vehicleInfo.getHourRate() %>원(시간당 가격)
			</p>
			<%}} %>
			<input type="submit" value="예약하기">
		</div>
		</form>
	</section>
	<script></script>
</body>
<jsp:include page="/footer" />
</html>