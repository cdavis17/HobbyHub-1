package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.server.controllers.AddAccountController;
import edu.ycp.cs320.hobbyhub.shared.User;

public class HobbyHubSignUp implements EntryPoint, IsWidget {

	@Override
	public void onModuleLoad() {
		//stuff
		RootPanel panel = RootPanel.get("Sign Up Container");
		
		final TextBox UserNameField = new TextBox();
		panel.add(UserNameField, 104, 88);
		
		final TextBox PasswordField = new TextBox();
		panel.add(PasswordField, 104, 128);
		
		final TextBox PasswordConfirm = new TextBox();
		panel.add(PasswordConfirm, 104, 168);
		
		final TextBox CityField = new TextBox();
		panel.add(CityField, 104, 248);
		
		final TextBox StateField = new TextBox();
		panel.add(StateField, 104, 208);
		
		final TextBox FirstNameField = new TextBox();
		panel.add(FirstNameField, 104, 288);
		
		final TextBox LastNameField = new TextBox();
		panel.add(LastNameField, 104, 328);
		
		final TextBox EmailField = new TextBox();
		panel.add(EmailField, 104, 368);
		
		Label lblNewLabel = new Label("Username:");
		panel.add(lblNewLabel, 10, 88);
		lblNewLabel.setSize("69px", "34px");
		
		Label lblNewLabel_1 = new Label("Password:");
		panel.add(lblNewLabel_1, 10, 128);
		
		Label lblConfirmPassword = new Label("Confirm Password:");
		panel.add(lblConfirmPassword, 10, 168);
		lblConfirmPassword.setSize("88px", "18px");
		
		Label lblCity = new Label("City:");
		panel.add(lblCity, 10, 208);
		
		Label lblState = new Label("State:");
		panel.add(lblState, 10, 248);
		
		Label lblFirstName = new Label("First Name:");
		panel.add(lblFirstName, 10, 288);
		
		Label lblLastName = new Label("Last Name:");
		panel.add(lblLastName, 10, 328);
		
		Label lblEmailAddress = new Label("Email Address:");
		panel.add(lblEmailAddress, 10, 368);
		
		final Label UserNameError = new Label("Please enter a valid Username.");
		panel.add(UserNameError, 283, 88);
		UserNameError.setVisible(false);
		
		final Label EmptyPassError = new Label("Please enter a password");
		panel.add(EmptyPassError, 283, 157);
		EmptyPassError.setVisible(false);
		
		final Label NonMatchError = new Label("Fields must match");
		panel.add(NonMatchError, 283, 157);
		NonMatchError.setVisible(false);
		
		final Label EmailError = new Label("Please enter a valid email address.");
		panel.add(EmailError, 283, 368);
		EmailError.setVisible(false);
		
		Button SignUpButton = new Button("New button");
		SignUpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				User newAccount = new User();
				boolean error = false;
				
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
					AddAccountController controller = new AddAccountController();
					controller.addAccount(newAccount);
				}
			}
		});
		SignUpButton.setText("Sign Up");
		panel.add(SignUpButton, 151, 438);
		
		
		
		
		
		
		
		
		
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}
}
