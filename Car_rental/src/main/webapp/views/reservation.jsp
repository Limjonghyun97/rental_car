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

	VehicleDao vehicleDao = VehicleDao.getInstance();
	ArrayList<Vehicle> list = vehicleDao.getVehicleAll();

	VenueDao venuDao = VenueDao.getInstance();
	ArrayList<Venue> list2 = venuDao.getVenueAll();
	%>

	<section>
		<h2>차량조회</h2>
		<div class="rs_part">
			<form method="POST" action="search">
				<input type="datetime-local" name="rental_date" value="<%=currentTimestampToString%>" /> 
					<input type="text" name="location" placeholder="장소를 입력해주세요." required /> 
					<input type="submit" value="검색" />
				<table border=1 class="reservationList">
					<thead>
						<tr>
							<th>차량 종류</th>
							<th>차량 번호*</th>
							<th>시간당 비용</th>
							<th>지역</th>
						</tr>
					</thead>
					<tbody>

						<%
							for (Vehicle vehicleInfo : list) {
							%>
						<tr>
							<td><%=vehicleInfo.getName()%></td>
							<td><a href="reservationPage?vehicleId=<%=vehicleInfo.getVehicleId() %>"><%=vehicleInfo.getVehicleId()%></a></td>
							<td><%=vehicleInfo.getHourRate()%>원</td>
							<%
							for (Venue venueInfo : list2) {
							%>
							<td><%=venueInfo.getName()%></td>
						</tr>
						<%
							}}
							%>
					</tbody>
				</table>
			</form>
		</div>
	</section>
	<script></script>
</body>
<jsp:include page="/footer" />
</html>