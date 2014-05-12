package edu.ycp.cs320.hobbyhub.server.persist;

import java.util.ArrayList;

import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.Message;
import edu.ycp.cs320.hobbyhub.shared.User;

/**
 * Interface that describes the persistence operations.
 * 
 * @author mfiroava
 */
public interface IDatabase {
	/**
	 * Attempt to log in a user whose username and password are given.
	 * 
	 * @param username the username
	 * @param password the password
	 * @return a {@link User} object if successful, or null if there is no
	 *         such username/password combination
	 */
	
	public User getUser(int userID);
	
	
	public User login(String username, String password);
	
	/**
	 * Attempt to add an acount to database
	 * 
	 * @param user the user
	 */
	public void addAccount(User user);
	
	/**
	 * 
	 * Checks to see if the account already exists
	 * 
	 * @param username the username
	 * @return true if account exists, false otherwise
	 */
	public boolean checkExistence(String username);
	/**
	 * 
	 * Verifies the account credentials
	 * 
	 * @param usr the username
	 * @param password password
	 * @return true if username and password exist, false otherwise
	 * 
	 */
	public boolean verifyAccount(String usr, String password);

	/**
	 * 
	 * creates a new account
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * need to add more parameters for city, state, etc....
	 */
	
	public boolean createAccount(String username, String password, int userID ,String firstname, String lastname, String email);

	public int getUserID(String username);

	public User getUser(String username);
	
	public boolean addMessage(int userID, Message mes);

	public ArrayList<Message> getMessages(User user);

	public ArrayList<Hobby> getHobbies(User user);

	

}
