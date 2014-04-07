package edu.ycp.cs320.hobbyhub.client;

import edu.ycp.cs320.hobbyhub.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.thirdparty.guava.common.collect.Sets.SetView;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HobbyHubWebApp {
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */

	public void onModuleLoad() {
		final Button signUpButton = new Button("Sign Up");
		final Label errorLabel = new Label();
		final Button returningUserButton = new Button("Returning Users Click Here");
		
		// We can add style names to widgets
		signUpButton.addStyleName("Sign Up");
		RootPanel.get("signUpButtonContainer").add(signUpButton, 217, 66);

		returningUserButton.addStyleName("Returning Users Click Here");
		RootPanel.get("returningUserButtonContainer").add(returningUserButton, 217, 36);
		
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		//nameField.setSize("159px", "18px");
		rootPanel.add(signUpButton);
		signUpButton.getElement().getStyle().setPosition(Position.RELATIVE);
		//("sendButtonContainer").add(s, 113, 46);
		
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
		Button btnReturnUsersClick = new Button("Return Users: Click Here");
		rootPanel.add(btnReturnUsersClick, 175, 139);
		errorLabel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				signUpButton.setEnabled(true);
				signUpButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the signUpButton.
			 */
			public void onClick(ClickEvent event) {
				// NEED TO SWITCH VIEW
				
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = signUpButton.getText();
				if (!FieldVerifier.isValidPassword(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				signUpButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		signUpButton.addClickHandler(handler);
	}
}
