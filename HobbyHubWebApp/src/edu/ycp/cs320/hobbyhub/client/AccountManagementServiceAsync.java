package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.hobbyhub.shared.User;

public interface AccountManagementServiceAsync {

	void verifyAccount(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void createAccount(String username, String password, int userID,
			String firstname, String lastname, String email, AsyncCallback<Boolean> callback);

	void getUserID(String username, AsyncCallback<Integer> callback);

	void getUser(int userID, AsyncCallback<User> callback);

}
