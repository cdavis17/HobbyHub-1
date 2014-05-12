package edu.ycp.cs320.hobbyhub.server;

import java.util.Scanner;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.IDatabase;

public class UserQuery {
	Scanner keyboard = new Scanner(System.in);
	
		
	//System.out.println("Enter a title: ");
	String title = keyboard.nextLine();
	
	IDatabase db = DatabaseProvider.getInstance();
	
}
