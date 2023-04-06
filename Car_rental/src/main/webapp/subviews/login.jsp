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
<h2>로그인</h2>
<form method="POST" action="../service">
	<input type="hidden" name="command" value="login">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" required></td>
		</tr>
	</table>
	<input type="submit" value="로그인">
</form>
</section>
</body>
<jsp:include page="footer"/>
</html>