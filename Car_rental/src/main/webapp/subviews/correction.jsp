<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
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
<jsp:include page="/header" />
<body>
	<%
	Client client = (Client) session.getAttribute("client");
	BoardDao boardDao = BoardDao.getInstance();
	ArrayList<Board> list = boardDao.getBoardAll();
	int postno = Integer.parseInt(request.getParameter("postNo"));
	%>

	<section>
		<h2>수정하기</h2>
		<form method="POST" action="../service">
		<input type="hidden" name="command" value="correction">
			<table>
				<%
				for (Board boardInfo : list) {
					if (boardInfo.getPostNo() == postno) {
				%>
				<tr>
					<td>글번호</td>
					<td><input type="text" value="<%=boardInfo.getPostNo()%>" name="postno" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" value="<%=boardInfo.getTitle()%>" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" value="<%=boardInfo.getClientId()%>" name="clientId" readonly></td>
				</tr>
				<tr>
					<td>본문</td>
					<td><textarea name="body" rows="15" cols="40"><%=boardInfo.getInfo()%></textarea></td>
				</tr>
				<%
				}
				}
				%>
			</table>
			<input type="submit" value="수정하기">
		</form>
	</section>
</body>
<jsp:include page="/footer" />
</html>