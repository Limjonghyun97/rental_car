package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientDto;
import client.controller.ClientDao;
import controller.Action;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
				
		ClientDto clientDto = new ClientDto(id, password, name);
		ClientDao clientDao = ClientDao.getInstance();
		clientDao.creatClient(clientDto);

		response.sendRedirect("mypage");
	}
}
