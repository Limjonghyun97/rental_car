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
	%>

	<section>
		<h2><%=client.getName()%>님 페이지
		</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="logout"/> 
			<input type="submit" value="로그아웃"/>
		</form>
	</section>
</body>
<jsp:include page="footer" />
</html>