package controller;

import controller.action.CorrectionAction;
import controller.action.DeleteBoardAction;
import controller.action.JoinAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MoveCorrectionAction;
import controller.action.WriteAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join"))
			action = new JoinAction();
		else if(command.equals("login"))
			action = new LoginAction();
		else if(command.equals("logout"))
			action = new LogoutAction();
		else if(command.equals("write"))
			action = new WriteAction();
		else if(command.equals("correction"))
			action = new CorrectionAction();
			
		return action;
	}
}
