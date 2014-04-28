package edu.ycp.cs320.hobbyhub.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.shared.Message;
import edu.ycp.cs320.hobbyhub.shared.User;
import com.google.gwt.user.client.ui.ListBox;

public class MessageView extends Composite {
	private LayoutPanel mainPanel;
	private User user;
			
	public MessageView() {	
			/**
			 * 
			 * 
			 * THIS WILL BE THE DEFAULT PAGE WHEN THE USER GOES TO
			 * THEIR MESSAGES.
			 * 
			 */
		
		mainPanel = new LayoutPanel();
		initWidget(mainPanel);	
		mainPanel.setSize("780px", "543px");
		
		// Back to home button
		Button ProfileButton = new Button("Back to Home");
		ProfileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.setCurrentView(new UserView());
			}
		});
		mainPanel.add(ProfileButton);
		mainPanel.setWidgetLeftWidth(ProfileButton, 20.0, Unit.PX, 112.0, Unit.PX);
		mainPanel.setWidgetTopHeight(ProfileButton, 20.0, Unit.PX, 25.0, Unit.PX);
		ProfileButton.setSize("125px", "30px");
		
		ListBox listBox = new ListBox();
		
		mainPanel.add(listBox);
		mainPanel.setWidgetLeftWidth(listBox, 141.0, Unit.PX, 155.0, Unit.PX);
		mainPanel.setWidgetTopHeight(listBox, 191.0, Unit.PX, 219.0, Unit.PX);
		listBox.setVisibleItemCount(5);
	
		// Returns the current user signed in
		RPC.accountManagementService.getUser(HobbyHubUI.instance.userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result) {	
				user = result;
				System.out.println("The username is " + user.getFirstName());
				
			}
		
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Acount failed: " + caught.getMessage());
			}
		});
		
		/**
		 * 
		 * Need to add the list of messages to a JCombobox, add compose button, if user clicks on message in ComboBox, display it larger, be able to reply
		 * 
		 */
		// private ArrayList <Message> messages;
		//for(int i = 0; i < user.getMessages().size();i++){
			//listBox.addItem(user.getMessages().get(i).getSender().toString());
			// prints the sender of the message to the console - test
			//System.out.println(user.getMessages().get(i).getSender());
		//}
		
	
	
	}
}
