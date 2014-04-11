package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AccountManagementServiceAsync {

	void verifyAccount(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void createAccount(String username, String password, int userID,
			String firstname, String lastname, String email, AsyncCallback<Boolean> callback);

}
