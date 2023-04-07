<%@page import="client.controller.ClientDao"%>
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
	if (client != null) {
		response.sendRedirect("clientpage");
	}
	%>

	<section>
		<h2>마이페이지</h2>
		<div class="mypage">
			<div class="main">
				<a href="join"> <img src="/resorces/img/rent.jpg">
					<p>회원가입</p>
				</a> <a href="login"> <img src="/resorces/img/community.jpg">
					<p>로그인</p>
				</a>
			</div>
		</div>
	</section>
</body>
<jsp:include page="footer" />
</html>