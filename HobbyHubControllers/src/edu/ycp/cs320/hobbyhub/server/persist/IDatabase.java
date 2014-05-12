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
	 * Attempt to add an account to database
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
	
	/**
	 * Gets ID of user
	 * 
	 * @param username of ID needed
	 * @return ID of user
	 */
	public int getUserID(String username);
	
	/**
	 * Get User from the ID 
	 * 
	 * @param userID ID of user needed
	 * @return User of ID
	 */
	public User getIDUser(int userID);
	
	/**
	 * Get Hobby from it's name
	 * 
	 * @param hobbyName Name of hobby wanted
	 * @return Hobby Hobby object with Hobby name used
	 */
	public Hobby getHobby(String hobbyName);
	
	/**
	 * Edit the user's account using parameters sent
	 * 
	 * @param userID ID used to recognized User
	 * @param firstname New first name of User
	 * @param lastname New last name of User
	 * @param email New Email of User
	 * @param city New City of User
	 * @param state New State of User
	 * @return True if no errors detected
	 */
	public boolean editAccount(int userID, String firstname, String lastname, String email, String city, String state);
	
	/**
	 * Add Hobby to the User associated with User ID
	 * 
	 * @param userID User ID of User adding the Hobby
	 * @param hobby	Hobby being added to Account
	 * @return	True if no errors detected
	 */
	public boolean addHobby(int userID, Hobby hobby);
	
	/**
	 * Remove a Hobby from an Account using the Hobby's name
	 * 
	 * @param hobbyName Name of Hobby to be removed
	 * @param userID ID number of Account
	 * @return True if successful in removing hobby
	 */
	public boolean removeHobby(String hobbyName, int userID);

	public User getUser(String username);
	
	public boolean addMessage(int userID, Message mes);

	public ArrayList<Message> getMessages(User user);

	public ArrayList<Hobby> getHobbies(User user);

	

}
