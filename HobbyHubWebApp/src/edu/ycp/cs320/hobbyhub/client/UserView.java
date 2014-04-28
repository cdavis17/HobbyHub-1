package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.shared.User;

public class UserView extends Composite {
	
	private AbsolutePanel absolutePanel;
	private Hyperlink UserHobbiesLink;
	private String username;
	private User user;
	
	public UserView(){
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("559px", "417px");
		
		// Gets the user
		RPC.accountManagementService.getUser(HobbyHubUI.instance.userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result) {
				System.out.println("Successful");	
				user = result;	
				username = user.getFirstName();
				 // LABEL TO DISPLAY USERS NAME
				Label UsernameLabel = new Label(username);
				System.out.println(username);
				absolutePanel.add(UsernameLabel, 50, 50);
				UsernameLabel.setSize("200px", "30px");
			}
		
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Acount failed: " + caught.getMessage());
			}
		});
			
		
		
		
		Image Logo = new Image();
		Logo.setUrl("http://www.google.com/images/logo.gif");
		absolutePanel.add(Logo, 10, 10);
		Logo.setSize("100px", "100px");
		
		//Hyperlink HomeLink = new Hyperlink("Home", false, "newHistoryToken");
		Button HomeLink = new Button("Home");
		absolutePanel.add(HomeLink, 140, 92);
		//HomeLink.
		HomeLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to home view...");
				
			}
		});
		
		Button ProfileButton = new Button("My Profile");
		absolutePanel.add(ProfileButton, 205, 92);
		ProfileButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to profileview...");
				HobbyHubUI.setCurrentView(new ProfileView());
				
			}
		});
		Button HobbyButton = new Button("Hobbies");
		absolutePanel.add(HobbyButton, 295, 92);
		HobbyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to home view...");
				
			}
		});
		
		Label WelcomeLabel = new Label("Welcome");
		absolutePanel.add(WelcomeLabel, 20, 130);
		
		
	
		
		
		Button MessagesLink = new Button("Messages");
		MessagesLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new MessageView());
			}
		});
		absolutePanel.add(MessagesLink, 364, 92);
		
		Hyperlink EventsLink = new Hyperlink("Events", false, "newHistoryToken");
		absolutePanel.add(EventsLink, 10, 216);
		
		Hyperlink FriendsLink = new Hyperlink("Friends", false, "newHistoryToken");
		absolutePanel.add(FriendsLink, 10, 240);
		
		UserHobbiesLink = new Hyperlink("My Hobbies", false, "newHistoryToken");
		absolutePanel.add(UserHobbiesLink, 10, 264);	
		
		HTML WelcomeHTML = new HTML("<div id='welcome'style='font-size: 150%;'> Welcome!</div>", true);
		absolutePanel.add(WelcomeHTML, 110, 130);
		
		HTML BodyHTML = new HTML("<div id='welcome-body'style='font-size:110%;'>This is a test to see if it works.</div>", true);
		absolutePanel.add(BodyHTML, 110, 154);
		BodyHTML.setSize("439px", "253px");
		
		Button btnLogOut = new Button("Log Out!");
		btnLogOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.instance.userID = 0;
			System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
			HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		absolutePanel.add(btnLogOut, 412, 10);
		btnLogOut.setSize("111px", "30px");
		
	
	}
}
