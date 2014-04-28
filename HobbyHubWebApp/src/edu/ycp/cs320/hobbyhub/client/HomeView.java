package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.shared.User;

public class HomeView extends Composite {
	private LayoutPanel mainPanel;
	//public int userID;
	private PasswordTextBox passwordBox;
	private TextBox usernameBox;
		
	public HomeView(){	
		/**
		 * 
		 * 
		 * THIS WILL BE THE DEFAULT PAGE WHEN THE USER GOES TO
		 * THE APPLICATION.   SHOULD CONSIST OF A TITLE, A BRIEF DESCRIPTION
		 * , A BUTTON TO SIGN UP, AND TWO TEXT BOXES FOR THE USER TO ENTER THE PASSWORD 
		 * AND USERNAME TO LOGIN
		 * 
		 * 
		 */
	
	mainPanel = new LayoutPanel();
	initWidget(mainPanel);	
	mainPanel.setSize("780px", "543px");
		
	// Password TextBox
	this.passwordBox = new PasswordTextBox();
	mainPanel.add(passwordBox);
	mainPanel.setWidgetLeftWidth(passwordBox, 308.0, Unit.PX, 157.0, Unit.PX);
	mainPanel.setWidgetTopHeight(passwordBox, 412.0, Unit.PX, 32.0, Unit.PX);
	
	// userName TextBox
	this.usernameBox = new TextBox();
	usernameBox.setText("Enter username");
	usernameBox.setName("Username");
	mainPanel.add(usernameBox);
	mainPanel.setWidgetLeftWidth(usernameBox, 305.0, Unit.PX, 160.0, Unit.PX);
	mainPanel.setWidgetTopHeight(usernameBox, 341.0, Unit.PX, 34.0, Unit.PX);
	
	// Label for Password
	Label lblPassword = new Label("Password");
	mainPanel.add(lblPassword);
	mainPanel.setWidgetLeftWidth(lblPassword, 351.0, Unit.PX, 56.0, Unit.PX);
	mainPanel.setWidgetTopHeight(lblPassword, 388.0, Unit.PX, 18.0, Unit.PX);
	
	// New CreateAccount Button
	Button createAccountButton = new Button("New button");
	createAccountButton.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
		HobbyHubUI.setCurrentView(new HobbyHubSignUp());
		}
	});
	createAccountButton.setText("Create An Account");
	mainPanel.add(createAccountButton);
	mainPanel.setWidgetLeftWidth(createAccountButton, 578.0, Unit.PX, 190.0, Unit.PX);
	mainPanel.setWidgetTopHeight(createAccountButton, 13.0, Unit.PX, 55.0, Unit.PX);
	
	// Description Label
	Label lblNewLabel = new Label("We are here to help you connect with local users who share similar interests as you");
	mainPanel.add(lblNewLabel);
	mainPanel.setWidgetLeftWidth(lblNewLabel, 113.0, Unit.PX, 504.0, Unit.PX);
	mainPanel.setWidgetTopHeight(lblNewLabel, 174.0, Unit.PX, 32.0, Unit.PX);
	
	Button loginButton = new Button("LOGIN!");
	loginButton.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			//System.out.println("GETTING READY TO START RPC CALL");
			RPC.accountManagementService.verifyAccount(usernameBox.getText(), passwordBox.getText(), new AsyncCallback<Boolean>(){
				@Override
				public void onSuccess(Boolean result) {
					if (result) {
						// successful login						
						System.out.println("CHANGING TO NEW USERVIEW");
						RPC.accountManagementService.getUserID(usernameBox.getText(), new AsyncCallback<Integer>(){

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								GWT.log("RPC call to get User ID failed: " + caught.getMessage());
								
							}

							@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								HobbyHubUI.instance.userID = result;
								System.out.println("The userID is " + result);
							}
							
						});
						HobbyHubUI.setCurrentView(new UserView());							
					} 
					else{
						// unsuccessful login
						//Display an error message box under the login button 
						Label error = new Label("The entered username and password did not match.");
						
						mainPanel.add(error);
						mainPanel.setWidgetLeftWidth(error, 177.0, Unit.PX, 170.0, Unit.PX);
						mainPanel.setWidgetTopHeight(error, 358.0, Unit.PX, 57.0, Unit.PX);
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					GWT.log("RPC call to verify account failed: " + caught.getMessage());
				}
			});
		}
	});
	mainPanel.add(loginButton);
	mainPanel.setWidgetLeftWidth(loginButton, 351.0, Unit.PX, 81.0, Unit.PX);
	mainPanel.setWidgetTopHeight(loginButton, 463.0, Unit.PX, 30.0, Unit.PX);	
		
	}
}
