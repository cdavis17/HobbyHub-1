package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

<<<<<<< HEAD
import edu.ycp.cs320.hobbyhub.shared.Message;
=======
import edu.ycp.cs320.hobbyhub.shared.Hobby;
>>>>>>> refs/remotes/Mfioravan/master
import edu.ycp.cs320.hobbyhub.shared.User;

public interface AccountManagementServiceAsync {

	void verifyAccount(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void createAccount(String username, String password, int userID,
			String firstname, String lastname, String email, AsyncCallback<Boolean> callback);

	void getUserID(String username, AsyncCallback<Integer> callback);


	void getUser(int userID, AsyncCallback<User> callback);

	void addMessage(int userID, Message mes, AsyncCallback<Boolean> callback);


	void getIDUser(int userID, AsyncCallback<User> asyncCallback);
	
	void editAccount(int userID, String firstname, String lastname, String email, String city, String state, AsyncCallback<Boolean> callback);
	
	void addHobby(int userID, Hobby hobby, AsyncCallback<Boolean> callback);
	
	void removeHobby(String hobbyName, int userID, AsyncCallback<Boolean> callback);

}
