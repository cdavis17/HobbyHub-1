package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.hobbyhub.shared.User;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService{


	public boolean verifyAccount(String username, String password);

	boolean createAccount(String username, String password, int userID,
			String firstname, String lastname, String email); 
	
	public int getUserID(String username);
	public User getUser(int userID);

	}

