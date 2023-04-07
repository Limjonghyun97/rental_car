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
<jsp:include page="header" />
<body>
	<%
	Client client = (Client) session.getAttribute("client");
	BoardDao boardDao = BoardDao.getInstance();
	ArrayList<Board> list = boardDao.getBoardAll();
	
	int no = 0;
	for(Board boardInfo : list){
		no = boardInfo.getPostNo();
	}
	%>

	<section>
		<h2>글쓰기</h2>
		<form method="POST" action="../service" class="write">
			<input type="hidden" name="command" value="write">
			<table>
				<tr>
					<td>글번호(자동생성)</td>
					<td><input type="text" name="no" value="<%=no + 1 %>" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="clientId" value="<%=client.getId()%>" readonly></td>
				</tr>
				<tr>
					<td>본문</td>
					<td><textarea name="body" rows="15" cols="40"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="작성완료">
		</form>
	</section>
</body>
<jsp:include page="footer" />
</html>