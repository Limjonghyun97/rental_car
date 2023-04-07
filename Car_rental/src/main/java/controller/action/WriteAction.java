package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDto;
import board.controller.BoardDao;
import controller.Action;

public class WriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int postNo = Integer.parseInt(request.getParameter("no"));
		String clientId = request.getParameter("clientId");
		String title = request.getParameter("title");
		String info = request.getParameter("body");
		
		BoardDto boardDto = new BoardDto(postNo, clientId, title, info);
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.creatBoard(boardDto);

		response.sendRedirect("writePage");
	}
}
