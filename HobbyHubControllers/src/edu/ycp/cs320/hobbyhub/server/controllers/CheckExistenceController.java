package edu.ycp.cs320.hobbyhub.server.controllers;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.IDatabase;

public class CheckExistenceController {
	public boolean checkExistence(String username) {
		IDatabase db = DatabaseProvider.getInstance();
		
		// TODO: use compare userName to database
		return db.checkExistence(username);
		}
	}


