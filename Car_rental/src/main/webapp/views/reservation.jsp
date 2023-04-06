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
<jsp:include page="header"/>
<body>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

//Timestamp to String
String currentTimestampToString = sdf.format(System.currentTimeMillis());
%>

<section>
<h2>차량예약</h2>
<div class="rs_part">
<form method="POST" action="search">
	<input type="datetime-local" name="rental_date" value="<%=currentTimestampToString %>"/>
	<input type="text" name="location" placeholder="장소를 입력해주세요." required/>
	<input type="submit" value="검색"/>
</form>
</div>
</section>
<script></script>
</body>
<jsp:include page="footer"/>
</html>