package edu.ycp.cs320.hobbyhub.client;

import java.util.ArrayList;

import javax.swing.JDialog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.jjs.ast.JLabel;
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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class MessageView extends Composite {
	private LayoutPanel mainPanel;
	private User receiver;
	private User messagesender;
	private User sender;
	// to view messages


			
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
		mainPanel.setSize("1161px", "543px");
		
		// Back to home button
		Button ProfileButton = new Button("Back to Home");
		ProfileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.setCurrentView(new UserView());
			}
		});
		
		mainPanel.add(ProfileButton);
		mainPanel.setWidgetLeftWidth(ProfileButton, 20.0, Unit.PX, 125.0, Unit.PX);
		mainPanel.setWidgetTopHeight(ProfileButton, 20.0, Unit.PX, 54.0, Unit.PX);
		ProfileButton.setSize("125px", "30px");
		// labels for message viewing
		Label lblSender = new Label("From: ");
		lblSender.setStyleName("h1");
		mainPanel.add(lblSender);
		mainPanel.setWidgetLeftWidth(lblSender, 535.0, Unit.PX, 56.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblSender, 20.0, Unit.PX, 30.0, Unit.PX);
		
		final Label fromText = new Label("");
		mainPanel.add(fromText);
		mainPanel.setWidgetLeftWidth(fromText, 535.0, Unit.PX, 56.0, Unit.PX);
		mainPanel.setWidgetTopHeight(fromText, 60.0, Unit.PX, 30.0, Unit.PX);
		
		Label lblSubject = new Label("Subject");
		mainPanel.add(lblSubject);
		mainPanel.setWidgetLeftWidth(lblSubject, 535.0, Unit.PX, 56.0, Unit.PX);
		mainPanel.setWidgetTopHeight(lblSubject, 96.0, Unit.PX, 30.0, Unit.PX);
		
		final Label subjectText = new Label("");
		mainPanel.add(subjectText);
		mainPanel.setWidgetLeftWidth(subjectText, 535.0, Unit.PX, 56.0, Unit.PX);
		mainPanel.setWidgetTopHeight(subjectText, 132.0, Unit.PX, 37.0, Unit.PX);
		
		final TextArea textArea = new TextArea();
		mainPanel.add(textArea);
		mainPanel.setWidgetLeftWidth(textArea, 535.0, Unit.PX, 245.0, Unit.PX);
		mainPanel.setWidgetTopHeight(textArea, 194.0, Unit.PX, 235.0, Unit.PX);
		
		final Button ReplyButton = new Button("Reply");
		mainPanel.add(ReplyButton);
		mainPanel.setWidgetLeftWidth(ReplyButton, 648.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(ReplyButton, 455.0, Unit.PX, 30.0, Unit.PX);
		
		final TextArea replyBodyBox = new TextArea();
		mainPanel.add(replyBodyBox);
		mainPanel.setWidgetLeftWidth(replyBodyBox, 901.0, Unit.PX, 231.0, Unit.PX);
		mainPanel.setWidgetTopHeight(replyBodyBox, 194.0, Unit.PX, 188.0, Unit.PX);
		replyBodyBox.setVisible(false);
		
		final Label replyInstr = new Label("Please enter the subject of your message and text");
		mainPanel.add(replyInstr);
		mainPanel.setWidgetLeftWidth(replyInstr, 899.0, Unit.PX, 233.0, Unit.PX);
		mainPanel.setWidgetTopHeight(replyInstr, 83.0, Unit.PX, 43.0, Unit.PX);
		replyInstr.setVisible(false);
		
		final TextBox replySubjectBox = new TextBox();
		mainPanel.add(replySubjectBox);
		mainPanel.setWidgetLeftWidth(replySubjectBox, 901.0, Unit.PX, 173.0, Unit.PX);
		mainPanel.setWidgetTopHeight(replySubjectBox, 154.0, Unit.PX, 34.0, Unit.PX);
		replySubjectBox.setVisible(false);
		
		final Button replySendButton = new Button("Send");
		
		mainPanel.add(replySendButton);
		mainPanel.setWidgetLeftWidth(replySendButton, 982.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(replySendButton, 399.0, Unit.PX, 30.0, Unit.PX);
		replySendButton.setVisible(false);
		
		final ListBox listBox = new ListBox();
		listBox.addDoubleClickHandler(new DoubleClickHandler() {
			public void onDoubleClick(DoubleClickEvent event) {
			final int messageNumber = listBox.getSelectedIndex();
			// get the message and display in a dialog box
			RPC.accountManagementService.getUser(HobbyHubUI.instance.userID, new AsyncCallback<User>(){
				
				@Override
				public void onSuccess(User result) {
					receiver = result;	
					// Get Subject and Body
					final String subject = receiver.getMessages().get(messageNumber).getSubject();// + ":   " +  messagesender.getUserName();
					final String body = receiver.getMessages().get(messageNumber).getBody();
					// get Senders ID
					int senderID = receiver.getMessages().get(messageNumber).getSenderIDNumber();
					RPC.accountManagementService.getUser(senderID, new AsyncCallback<User>(){
						@Override
						public void onSuccess(User result) {
							sender = result;
							
							textArea.setText(body);
							fromText.setText(sender.getUserName());
							subjectText.setText(subject);
																
							ReplyButton.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent event) {
									replySubjectBox.setVisible(true);
									replyInstr.setVisible(true);
									replyBodyBox.setVisible(true);
									replySendButton.setVisible(true);
									
									// insert
									replySendButton.addClickHandler(new ClickHandler() {
										public void onClick(ClickEvent event) {
											// Message to be sent
											Message send = new Message(HobbyHubUI.instance.userID, messagesender.getuserID(), replySubjectBox.getText(), replyBodyBox.getText());
											// Add message to receiver of its arrayList
											RPC.accountManagementService.addMessage(messagesender.getuserID(), send, new AsyncCallback<Boolean>(){
												
												@Override
												public void onSuccess(Boolean result) {
													System.out.println("SUCCESSFUL MESSAGE SENT");
													replySubjectBox.setVisible(false);
													replyInstr.setVisible(false);
													replyBodyBox.setVisible(false);
													replySendButton.setVisible(false);
												}
												
												@Override 
												public void onFailure(Throwable caught){
													GWT.log("RPC call to send message failed: " + caught);
												}
											});
										}
									});
								}
							});
						}
					
						@Override
						public void onFailure(Throwable caught){
							GWT.log("RPC call to get sender failed: " + caught);
						}
					});
					
					System.out.println(subject + " " + body );//+ senderUserName);
					// Display subject and body
				}
	
				public void onFailure(Throwable caught){
					GWT.log("RPC call to get message details failed: " + caught);
				}
				
			});
		}
		});

		// Returns the current user signed in
		
		RPC.accountManagementService.getUser(HobbyHubUI.instance.userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result) {	
				receiver = result;
				System.out.println("The username is " + receiver.getFirstName());
				
				// gets the messages from the user
				for(int i = 0; i < receiver.getMessages().size();i++){
					final int index = i;
					RPC.accountManagementService.getUser(receiver.getMessages().get(i).getSenderIDNumber(), new AsyncCallback<User>(){
										
					@Override
					public void onSuccess(User result) {
						messagesender = result;	
						String add = receiver.getMessages().get(index).getSubject();// + ":   " +  messagesender.getUserName();
						listBox.addItem(add);
						// prints the sender of the message to the console - test
						//System.out.println(receiver.getMessages().get(index).getSubject() + " " + messagesender.getUserName());
						
						
					}

					public void onFailure(Throwable caught){
						GWT.log("RPC call to get Sender failed: " + caught);
					}
					
					});
					
				}
				mainPanel.add(listBox);
				mainPanel.setWidgetLeftWidth(listBox, 141.0, Unit.PX, 800.0, Unit.PX);
				mainPanel.setWidgetTopHeight(listBox, 191.0, Unit.PX, 219.0, Unit.PX);
				listBox.setVisibleItemCount(5);
				
			}
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Acount failed: " + caught.getMessage());
			}
			
		});
		
		
		
		
	
	
	}
}
