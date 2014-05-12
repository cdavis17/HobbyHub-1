package edu.ycp.cs320.hobbyhub.server;

import edu.ycp.cs320.hobbyhub.*;
import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.Message;
import edu.ycp.cs320.hobbyhub.shared.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InitialData {
	public static List<User> getUsers() throws IOException {
		List<User> userList= new ArrayList<User>();
	
		try {
			while (true) {
				
				User user = new User();
				user.setuserID(1);
				user.setFirstName("Joe");
				user.setLastName("Smith");
				user.setUserName("jsmith");
				user.setLocationState("Pennsylvania");
				user.setLocationCity("York");
				userList.add(user);
			}
		} finally {
			//readUsers.close();
		}
	}
}
	
