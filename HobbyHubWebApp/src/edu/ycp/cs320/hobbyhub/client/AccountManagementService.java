package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

<<<<<<< HEAD
import edu.ycp.cs320.hobbyhub.shared.Message;
=======
import edu.ycp.cs320.hobbyhub.shared.Hobby;
>>>>>>> refs/remotes/Mfioravan/master
import edu.ycp.cs320.hobbyhub.shared.User;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService{


	public boolean verifyAccount(String username, String password);

	boolean createAccount(String username, String password, int userID,
			String firstname, String lastname, String email); 
	
	public int getUserID(String username);
	

	public User getUser(int userID);
	
	public User getIDUser(int userID);
	
	boolean addMessage(int userID, Message mes);

	public boolean editAccount(int userID, String firstname, String lastname, String email, String city, String state);
	
	public boolean addHobby(int userID, Hobby hobby);
	
	public boolean removeHobby(String hobbyName, int userID);

	}

