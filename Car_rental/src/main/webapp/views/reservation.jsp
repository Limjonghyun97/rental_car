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
<section>
<h2>차량예약</h2>
<div class="rs_part">
<form method="POST" action="../service">
	<input type="hidden" name="command" value="reservation"/>
	<input type="datetime-local"/>
	<input type="text"/>
	<input type="submit" value="검색"/>
</form>
</div>
</section>
</body>
<jsp:include page="footer"/>
</html>