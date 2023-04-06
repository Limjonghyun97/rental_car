<%@page import="booking.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Renter Car</title>
<link rel="stylesheet" href="/resorces/grid.css">
</head>
<jsp:include page="header" />
<body>
	<%
	Client client = (Client) session.getAttribute("client");
	BookingDao bookingDao = BookingDao.getInstance();
	ArrayList<Booking> list = bookingDao.getBookingAll();
	%>

	<section>
		<h2><%=client.getName()%>님 페이지
		</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="logout"/> 
			<input type="submit" value="로그아웃"/>
		</form>
		<table border="1">
		<thead>
		<tr>
			<th>차량 종류</th>
			<th>차량 번호</th>
			<th>지역</th>
			<th>예약날짜</th>
			<th>이용시간</th>
			<th>비용</th>
		</tr>
		</thead>
		<tbody>
		<% 
		for(Booking bookingInfo : list) {
			if(client.getId().equals(bookingInfo.getClient_id())){
		%>
		<tr>
			<td><% %></td>
			<td><%=bookingInfo.getVehicle_id() %></td>
			<td><%=bookingInfo.getVenue_id() %></td>
			<td><%=bookingInfo.getDate_time() %></td>
			<td><%=bookingInfo.getHour() %>시간</td>
			<td><%=bookingInfo.getTotal_payment() %></td>
		</tr>
		<%}
			} %>
		</tbody>
		</table>
	</section>
</body>
<jsp:include page="footer" />
</html>