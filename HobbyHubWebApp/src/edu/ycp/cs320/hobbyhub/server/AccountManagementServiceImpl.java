package edu.ycp.cs320.hobbyhub.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
<<<<<<< HEAD
import edu.ycp.cs320.hobbyhub.shared.Message;
=======
import edu.ycp.cs320.hobbyhub.shared.Hobby;
>>>>>>> refs/remotes/Mfioravan/master
import edu.ycp.cs320.hobbyhub.shared.User;
import edu.ycp.cs320.hobbyhub.client.AccountManagementService;


public class AccountManagementServiceImpl extends RemoteServiceServlet 
			implements AccountManagementService{

	private static final long serialVersionUID = 1L;

	public boolean verifyAccount(String username, String password) {
		System.out.println("username is " + username + " and password is " + password);
		return DatabaseProvider.getInstance().verifyAccount(username, password);
	}
	
	public boolean createAccount(String username, String password, int userID ,String firstname, String lastname, String email){
		System.out.println("Account for " + firstname + lastname + " is being created.  Username is " + username + " and password is " + password);
		return DatabaseProvider.getInstance().createAccount(username, password, userID, firstname, lastname, email);
	}

	@Override
	public int getUserID(String username) {
		int ID = DatabaseProvider.getInstance().getUserID(username);
		System.out.println("User ID for " + username + "is " + ID);
		return DatabaseProvider.getInstance().getUserID(username);
	
	}


	@Override
	public User getUser(int userID) {
		return DatabaseProvider.getInstance().getUser(userID);
	}

	@Override
	public boolean addMessage(int userID, Message mes) {
		return DatabaseProvider.getInstance().addMessage(userID, mes);
		
	}
		

	public boolean addHobby(int UserID, Hobby hobby){
		return DatabaseProvider.getInstance().addHobby(UserID, hobby);
	}
	@Override
	public User getIDUser(int userID) {
		return DatabaseProvider.getInstance().getIDUser(userID);
	}
	
	public boolean editAccount(int userID, String firstname, String lastname, String email, String city, String state){
		return DatabaseProvider.getInstance().editAccount(userID, firstname, lastname, email, city, state);
	}
	
	public boolean removeHobby(String hobbyName, int userID){
		return DatabaseProvider.getInstance().removeHobby(hobbyName, userID);
	}

}

