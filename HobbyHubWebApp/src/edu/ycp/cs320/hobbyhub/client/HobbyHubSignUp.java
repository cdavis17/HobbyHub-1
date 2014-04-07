package edu.ycp.cs320.hobbyhub.client;




import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;



//import edu.ycp.cs320.hobbyhub.server.controllers.AddAccountController;
import edu.ycp.cs320.hobbyhub.shared.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;

public class HobbyHubSignUp extends Composite {
	private LayoutPanel mainPanel;
	private LayoutPanel infomationPanel;
	
	/**
	 * 
	 *
	 *
	 * SIGN UP VIEW CONTAINS BOXES AND LABELS FOR
	 * USER TO FILL OUT, WHEN THEY CLICK THE SIGN UP
	 * BUTTON THEY SHOULD BE REVERTED BACK TO THE HOMEPAGE
	 * WILL NEED RPC CALL TO ADD ACCOUNT TO DATABASE
	 * 
	 * 
	 * 
	 * 
	 *
	 *
	 *
	 */
	
	public HobbyHubSignUp() {
		mainPanel = new LayoutPanel();
		mainPanel.setSize("800px", "800px");
		initWidget(mainPanel);
		
		// Random button
		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.setCurrentView(new UserView());
			}
		});
		mainPanel.add(btnNewButton);
		mainPanel.setWidgetLeftWidth(btnNewButton, 445.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnNewButton, 337.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblNewLabel = new Label("Username:");
		mainPanel.add(lblNewLabel);
		mainPanel.setWidgetLeftWidth(lblNewLabel, 0.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblNewLabel, 0.0, Unit.PX, 34.0, Unit.PX);
		lblNewLabel.setSize("69px", "34px");
		
		Label lblNewLabel_1 = new Label("Password:");
		mainPanel.add(lblNewLabel_1);
		mainPanel.setWidgetLeftWidth(lblNewLabel_1, 109.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblNewLabel_1, 194.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblConfirmPassword = new Label("Confirm Password:");
		mainPanel.add(lblConfirmPassword);
		mainPanel.setWidgetLeftWidth(lblConfirmPassword, 109.0, Unit.PX, 88.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblConfirmPassword, 230.0, Unit.PX, 18.0, Unit.PX);
		lblConfirmPassword.setSize("88px", "18px");
		
		Label lblCity = new Label("City:");
		mainPanel.add(lblCity);
		mainPanel.setWidgetLeftWidth(lblCity, 109.0, Unit.PX, 39.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblCity, 313.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblState = new Label("State:");
		mainPanel.add(lblState);
		mainPanel.setWidgetLeftWidth(lblState, 109.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblState, 277.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblFirstName = new Label("First Name:");
		mainPanel.add(lblFirstName);
		mainPanel.setWidgetLeftWidth(lblFirstName, 86.0, Unit.PX, 180.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblFirstName, 46.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblLastName = new Label("Last Name:");
		mainPanel.add(lblLastName);
		mainPanel.setWidgetLeftWidth(lblLastName, 109.0, Unit.PX, 125.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblLastName, 82.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblEmailAddress = new Label("Email Address:");
		mainPanel.add(lblEmailAddress);
		mainPanel.setWidgetLeftWidth(lblEmailAddress, 104.0, Unit.PX, 142.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblEmailAddress, 118.0, Unit.PX, 30.0, Unit.PX);
		
		final Label UserNameError = new Label("Please enter a valid Username.");
		mainPanel.add(UserNameError);
		mainPanel.setWidgetLeftWidth(UserNameError, 429.0, Unit.PX, 188.0, Unit.PX);
		mainPanel.setWidgetTopHeight(UserNameError, 118.0, Unit.PX, 30.0, Unit.PX);
		UserNameError.setVisible(false);
		
		final Label EmptyPassError = new Label("Please enter a password");
		mainPanel.add(EmptyPassError);
		mainPanel.setWidgetLeftWidth(EmptyPassError, 472.0, Unit.PX, 200.0, Unit.PX);
		mainPanel.setWidgetTopHeight(EmptyPassError, 154.0, Unit.PX, 30.0, Unit.PX);
		EmptyPassError.setVisible(false);
		
		final Label NonMatchError = new Label("Fields must match");
		mainPanel.add(NonMatchError);
		mainPanel.setWidgetLeftWidth(NonMatchError, 472.0, Unit.PX, 125.0, Unit.PX);
		mainPanel.setWidgetTopHeight(NonMatchError, 218.0, Unit.PX, 30.0, Unit.PX);
		NonMatchError.setVisible(false);
		
		final Label EmailError = new Label("Please enter a valid email address.");
		mainPanel.add(EmailError);
		mainPanel.setWidgetLeftWidth(EmailError, 404.0, Unit.PX, 234.0, Unit.PX);
		mainPanel.setWidgetTopHeight(EmailError, 179.0, Unit.PX, 34.0, Unit.PX);
		EmailError.setVisible(false);
		
		Button SignUpButton = new Button("CLICK");
		
		SignUpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GWT.log("Should be setting new USERVIEW");
				System.out.print("BUTTON CLICKED");
				HobbyHubUI.setCurrentView(new UserView());
			}
			});
				//User newAccount = new User();
				//boolean error = false;
				
				/*
				//Add User Name
				if (UserNameField.getText() != null){
					newAccount.setUserName(UserNameField.getText());
					UserNameError.setVisible(false);
				} else {
					UserNameError.setVisible(true);
					error = true;
				}
				
				//Add Password
				if (PasswordField.getText() != null && PasswordConfirm.getText() != null){
					EmptyPassError.setVisible(false);
					if(PasswordField.getText().equals(PasswordConfirm.getText())){
						newAccount.setPassword(PasswordField.getText());
					} else {
						NonMatchError.setVisible(true);
						error = true;
					}
				} else {
					EmptyPassError.setVisible(true);
					error = true;
				}
				
				//City
				if (CityField.getText() != null){
					newAccount.setLocationCity(CityField.getText());
				}
				
				//State
				if (StateField.getText() != null){
					newAccount.setLocationState(StateField.getText());
				}
				
				//First Name
				if (FirstNameField.getText() != null){
					newAccount.setFirstName(FirstNameField.getText());
				}
				
				//Last Name
				if (LastNameField.getText() != null){
					newAccount.setLastName(LastNameField.getText());
				}
				
				//Email
				if (EmailField.getText() != null){
					newAccount.setUserEmail(EmailField.getText());
					EmailError.setVisible(false);
				} else {
					EmailError.setVisible(true);
					error = true;
				}
				
				//Add Account to db
				if (error == false){
					//AddAccountController controller = new AddAccountController();
					//controller.addAccount(newAccount);
				}
				*/

			
		
		SignUpButton.setText("Sign Up");
		//mainPanel.add(SignUpButton);
		
				
		
		
		
		
		
		
	}
}
