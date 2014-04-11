package edu.ycp.cs320.hobbyhub.client;


import com.google.gwt.core.client.GWT;


public class RPC {

			public static final AccountManagementServiceAsync accountManagementService =
				(AccountManagementServiceAsync)GWT.create(AccountManagementService.class);
}
