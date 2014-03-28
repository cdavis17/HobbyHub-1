package edu.ycp.cs320.hobbyhub.server.controllers;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.shared.User;

public class LoginController {
	public User login(String username, String password) {
		return DatabaseProvider.getInstance().login(username, password);
	}
}
