package edu.ycp.cs320.hobbyhub.server.controllers;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.IDatabase;
import edu.ycp.cs320.hobbyhub.shared.User;

public class AddAccountController {
	public void addAccount(User user) {
		IDatabase db = DatabaseProvider.getInstance();
		
		// TODO: use db to add the account
		db.addAccount(user);
	}
}

