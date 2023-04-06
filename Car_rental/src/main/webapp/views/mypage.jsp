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
<jsp:include page="header"/>
<body>
<%
Client client = (Client)session.getAttribute("client");

if(client != null) {
	response.sendRedirect("clientpage");
}
%>

<section>
<h2>마이페이지</h2>
<div class="mypage">
	<a href="join">회원가입</a>
	<a href="login">로그인</a>
</div>
</section>
</body>
<jsp:include page="footer"/>
</html>