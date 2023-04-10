package controller.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.Board;
import board.BoardDto;
import board.controller.BoardDao;
import controller.Action;


public class CorrectionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		//Timestamp to String
		String currentTimestampToString = sdf.format(System.currentTimeMillis());
		
		BoardDao boardDao = BoardDao.getInstance();
		
		int postno = Integer.parseInt(request.getParameter("postno"));
		String clientId = request.getParameter("clientId");
		String title = request.getParameter("title");
		String info = request.getParameter("body");
		String joinDate = currentTimestampToString;
		
		BoardDto boardDto = new BoardDto(postno, clientId, title, info, joinDate);
		
		boardDao.updateBoard(boardDto);
		
		response.sendRedirect("community");
	}

}
