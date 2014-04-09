package edu.ycp.cs320.hobbyhub.server.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.hobbyhub.shared.User;

public class FakeDatabase implements IDatabase {
	private User user1; // FIRST USER
	private List<User> userList; // list of USERS
	private int userID = 1;  // sets index of userID
	public FakeDatabase() {
		userList = new ArrayList<User>();
		
		// Create initial user
		createAccount("jsmith","abc123", 1, "Joe", "Smith", "jsmith@jsmith.com");
		
		// etc.
		
		//userList.add(user1);
	}
	
	@Override
	public User getUser(String username){
		for (User user : userList) {
			if (user.getUserName().equals(username)){
				return user;
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

	public Void createAccount(String username, String password, int userID ,String firstname, String lastname, String email){
		if(userList.contains(username)){
			System.out.println("Account already exists");
		} else {
			System.out.println("Creating account for user: " + username + ", pass: " + password );
			User user = new User();
			userList.add(user);
			userID++;
		}
		return null;
	}

	

}
