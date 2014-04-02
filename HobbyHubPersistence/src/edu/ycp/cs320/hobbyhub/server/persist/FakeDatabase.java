package edu.ycp.cs320.hobbyhub.server.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.hobbyhub.shared.User;

public class FakeDatabase implements IDatabase {
	
	private List<User> userList;
	
	public FakeDatabase() {
		userList = new ArrayList<User>();
		
		// Create initial data
		User user1 = new User();
		user1.setUserName("jsmith");
		user1.setFirstName("Joe");
		user1.setLastName("Smith");
		user1.setPassword("abc123");
		// etc.
		
		userList.add(user1);
	}

	@Override
	public User login(String username, String password) {
		for (User user : userList) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		// No such username/password
		return null;
	}

	@Override
	public void addAccount(User user) {
		userList.add(user);
	}

	@Override
	public boolean checkExistence(String username) {
		for (User user : userList) {
			if (user.getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}

}
