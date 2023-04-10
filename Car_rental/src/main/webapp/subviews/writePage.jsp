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
		<h2>게시글</h2>
		<form method="POST" action="correction">
			<input type="hidden" name="postNo" value="<%=postno%>">
			<table>
				<%
				for (Board boardInfo : list) {
					if (boardInfo.getPostNo() == postno) {
				%>
				<tr>
					<td>글번호</td>
					<td><%=boardInfo.getPostNo()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=boardInfo.getTitle()%></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=boardInfo.getClientId()%></td>
				</tr>
				<tr>
					<td>본문</td>
					<td><%=boardInfo.getInfo()%></td>
				</tr>
				<%
				if (client != null && boardInfo.getClientId().equals(client.getId())) {
				%>
				<tr>
					<td><input type="submit" value="수정하기"></td>
				</tr>
				<%
				}
					}
						}
				%>

			</table>
		</form>
	</section>
</body>
<jsp:include page="/footer" />
</html>