package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService{


	public boolean verifyAccount(String username, String password);

	boolean createAccount(String username, String password, int userID,
			String firstname, String lastname, String email); 
	
	public int getUserID(String username);

	}

