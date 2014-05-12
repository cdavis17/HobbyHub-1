package edu.ycp.cs320.hobbyhub.client;




import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;




//import edu.ycp.cs320.hobbyhub.server.controllers.AddAccountController;


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class HobbyHubSignUp extends Composite {
	private LayoutPanel mainPanel;

	private int userID = 2;
	
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
		
		Label lblNewLabel = new Label("Username:");
		mainPanel.add(lblNewLabel);
		mainPanel.setWidgetLeftWidth(lblNewLabel, 41.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblNewLabel, 179.0, Unit.PX, 34.0, Unit.PX);
		lblNewLabel.setSize("69px", "34px");
		
		Label lblNewLabel_1 = new Label("Password:");
		mainPanel.add(lblNewLabel_1);
		mainPanel.setWidgetLeftWidth(lblNewLabel_1, 41.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblNewLabel_1, 219.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblConfirmPassword = new Label("Confirm Password:");
		mainPanel.add(lblConfirmPassword);
		mainPanel.setWidgetLeftWidth(lblConfirmPassword, 41.0, Unit.PX, 88.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblConfirmPassword, 254.0, Unit.PX, 18.0, Unit.PX);
		lblConfirmPassword.setSize("88px", "18px");
		
		Label lblCity = new Label("City:");
		mainPanel.add(lblCity);
		mainPanel.setWidgetLeftWidth(lblCity, 41.0, Unit.PX, 39.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblCity, 290.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblState = new Label("State:");
		mainPanel.add(lblState);
		mainPanel.setWidgetLeftWidth(lblState, 100.0, Unit.PX, 69.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblState, 377.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblFirstName = new Label("First Name:");
		mainPanel.add(lblFirstName);
		mainPanel.setWidgetLeftWidth(lblFirstName, 41.0, Unit.PX, 180.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblFirstName, 50.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblLastName = new Label("Last Name:");
		mainPanel.add(lblLastName);
		mainPanel.setWidgetLeftWidth(lblLastName, 51.0, Unit.PX, 125.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblLastName, 86.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblEmailAddress = new Label("Email Address:");
		mainPanel.add(lblEmailAddress);
		mainPanel.setWidgetLeftWidth(lblEmailAddress, 41.0, Unit.PX, 142.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblEmailAddress, 126.0, Unit.PX, 30.0, Unit.PX);
		
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
		
		final TextBox firstName = new TextBox();
		mainPanel.add(firstName);
		mainPanel.setWidgetLeftWidth(firstName, 166.0, Unit.PX, 173.0, Unit.PX);
		mainPanel.setWidgetTopHeight(firstName, 42.0, Unit.PX, 34.0, Unit.PX);
		
		final TextBox lastName = new TextBox();
		mainPanel.add(lastName);
		mainPanel.setWidgetLeftWidth(lastName, 166.0, Unit.PX, 173.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lastName, 82.0, Unit.PX, 34.0, Unit.PX);
		
		final TextBox email = new TextBox();
		email.setText("");
		mainPanel.add(email);
		mainPanel.setWidgetLeftWidth(email, 166.0, Unit.PX, 173.0, Unit.PX);
		mainPanel.setWidgetTopHeight(email, 122.0, Unit.PX, 34.0, Unit.PX);
		
		final TextBox username = new TextBox();
		mainPanel.add(username);
		mainPanel.setWidgetLeftWidth(username, 166.0, Unit.PX, 173.0, Unit.PX);
		mainPanel.setWidgetTopHeight(username, 179.0, Unit.PX, 34.0, Unit.PX);
		
		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		mainPanel.add(passwordTextBox);
		mainPanel.setWidgetLeftWidth(passwordTextBox, 166.0, Unit.PX, 157.0, Unit.PX);
		mainPanel.setWidgetTopHeight(passwordTextBox, 219.0, Unit.PX, 32.0, Unit.PX);
		
		PasswordTextBox confirmpasswordTextBox = new PasswordTextBox();
		mainPanel.add(confirmpasswordTextBox);
		mainPanel.setWidgetLeftWidth(confirmpasswordTextBox, 166.0, Unit.PX, 157.0, Unit.PX);
		mainPanel.setWidgetTopHeight(confirmpasswordTextBox, 254.0, Unit.PX, 32.0, Unit.PX);
		
		
		//Create Account Button
		Button CreateAccountButton = new Button("New button");
		CreateAccountButton.setText("Create Account!");
		CreateAccountButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RPC.accountManagementService.createAccount(username.getText(), passwordTextBox.getText(), userID ,firstName.getText(), lastName.getText(), email.getText(), new AsyncCallback<Boolean>(){
					@Override
					public void onSuccess(Boolean result) {
						if (result) {
							// successful login
							HobbyHubUI.setCurrentView(new HomeView());							
						} 
						else{
							// unsuccessful login
							//Display an error message box under the login button 
							Label error = new Label("Account creation was not successful!.");
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
		mainPanel.add(CreateAccountButton);
		mainPanel.setWidgetLeftWidth(CreateAccountButton, 228.0, Unit.PX, 166.0, Unit.PX);
		mainPanel.setWidgetTopHeight(CreateAccountButton, 357.0, Unit.PX, 30.0, Unit.PX);
		
		
		
		Button SignUpButton = new Button("CLICK");
		
		SignUpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GWT.log("Should be setting new USERVIEW");
				System.out.print("BUTTON CLICKED");
				HobbyHubUI.setCurrentView(new UserView());
			}
			});
		
		
		SignUpButton.setText("Sign Up");

		
				
		
		
		
		
		
		
	}
}
