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
	public User getUser(String username){
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUserName().compareTo(username) == 0){
				return userList.get(i);
			}
		}
		return null;
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

	@Override
	public boolean verifyAccount(String username, String password) {
		User user = null;
		if(userList.contains(username)){	//Account exists in the database
			// set user equal to account
			user = getUser(username);
			if(user.getPassword().equals(password)){
				return true;				
			} else {
				System.out.println("Password does not match");
				return false;
			}
		} else { 	
		System.out.println("No such account: " + username);
		return false;		
		}
	}

	

}
