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
%>
	<section>
		<h2>커뮤니티</h2>
		<%if(client != null){ %>
		<a href="write">글쓰기</a>
		<%} else {%>
		<p>글쓰기는 로그인 후 이용 가능합니다.</p>
		<p>마이페이지 > 로그인</p>
		<%} %>
		<table border="1" class="community">
		<thead>
		<tr>
			<th>게시글 No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
		</tr>
		</thead>
		<tbody>
		<!-- 공지사항 -->
		
		<!-- 이용후기 -->
		<%
		for(Board boardInfo : list){
		%>
		<tr>
			<td><%=boardInfo.getPostNo() %></td>
			<td><%=boardInfo.getTitle() %></td>
			<td><%=boardInfo.getClientId() %></td>
			<td><%=boardInfo.getJoindate() %></td>
		</tr>
		<%} %>
		</tbody>
		</table>
	</section>
</body>
<jsp:include page="footer" />
</html>