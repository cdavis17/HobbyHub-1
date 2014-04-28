package edu.ycp.cs320.hobbyhub.server.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.Message;
import edu.ycp.cs320.hobbyhub.shared.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList; // list of USERS
	private int userID = 1;  // sets index of userID
	
	public FakeDatabase() {
		userList = new ArrayList<User>();
		
		// Create initial user
		createAccount("jsmith","abc123", userID, "Joe", "Smith", "jsmith@jsmith.com");
		System.out.println("initial account is being created");
				
		//userList.add(user1);
	}
	
	@Override
	public User getUser(String username) {
		for(User user : userList){
			if(user.getUserName().equals(username)){
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
		user = getUser(username);
		if (user == null) {
			return false;
		} else if (!user.getPassword().equals(password)) {
			System.out.println("Incorrect password for " + username);
			return false;
		}
		return true;
	}

	@Override
	public int getUserID(String username){
		return getUser(username).getuserID();		
	}
	
	
	public boolean createAccount(String username, String password, int userID ,String firstname, String lastname, String email){
		User existing = getUser(username);
		
		if(existing != null){
			// FIXME
			System.out.println("Account already exists");
			return false;
		} else {
			System.out.println("Creating account for user: " + username + ", pass: " + password );
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user.setuserID(userID);
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setUserEmail(email);
			userList.add(user);
			userID++;
			return true;
		}
	}

	@Override
	public User getUser(int userID) {
		for(User user : userList) {
			if (user.getuserID() == (userID)){
				return user;
			}
		}
		return null;
	}


	


	

}
