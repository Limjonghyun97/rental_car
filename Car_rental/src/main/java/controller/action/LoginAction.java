package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.controller.ClientDao;
import controller.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ClientDao clientDao = ClientDao.getInstance();
		ArrayList<Client> client = clientDao.getClientAll();
		
		HttpSession session = request.getSession();
		
		for(Client clientInfo : client) {
			if(clientInfo.getId().equals(id) && clientInfo.getPassword().equals(password)) {
				session.setAttribute("client", clientInfo);
			}
		}
		
		response.sendRedirect("clientpage");
	}

}
