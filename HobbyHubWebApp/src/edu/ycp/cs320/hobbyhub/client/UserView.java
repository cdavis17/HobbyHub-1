package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.shared.User;

public class UserView extends Composite {
	
	private AbsolutePanel absolutePanel;
<<<<<<< HEAD
	private Hyperlink UserHobbiesLink;
	private String username;
	private User user;
	
=======
	private Button UserHobbiesLink;
	@SuppressWarnings("deprecation")
>>>>>>> refs/remotes/Mfioravan/master
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
		

		Button HomeLink = new Button("Home");
		HomeLink.setStyleName("dialogVPanel");
		absolutePanel.add(HomeLink, 140, 92);
		//HomeLink.
		HomeLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to home view...");
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		
<<<<<<< HEAD
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
=======
		Button ProfileLink = new Button("New button");
		ProfileLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("Switching to Profile View");
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		ProfileLink.setStyleName("dialogVPanel");
		ProfileLink.setText("My Profile");
		absolutePanel.add(ProfileLink, 205, 92);
		
		Button HobbyLink = new Button("New button");
		HobbyLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		HobbyLink.setStyleName("dialogVPanel");
		HobbyLink.setText("Hobbies");
		absolutePanel.add(HobbyLink, 295, 92);
		
		
		Button AboutLink = new Button("New button");
		AboutLink.setStyleName("dialogVPanel");
		AboutLink.setText("About Us");
		absolutePanel.add(AboutLink, 370, 92);

		
		Label WelcomeLabel = new Label("Welcome");
		absolutePanel.add(WelcomeLabel, 20, 130);
		
		

	
		
		
		Button MessagesLink = new Button("Messages");
		MessagesLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new MessageView());
			}
		});
		absolutePanel.add(MessagesLink, 364, 92);

		Button MessagesLink1 = new Button("New button");
		MessagesLink1.setStyleName("dialogVPanel");
		MessagesLink1.setText("Messages");
		absolutePanel.add(MessagesLink1, 10, 192);
		MessagesLink1.setSize("83px", "22px");

		
		Button EventsLink = new Button("New button");
		EventsLink.setStyleName("dialogVPanel");
		EventsLink.setText("Events");
		absolutePanel.add(EventsLink, 10, 226);
		EventsLink.setSize("83px", "22px");
		
		Button FriendsLink = new Button("New button");
		FriendsLink.setStyleName("dialogVPanel");
		FriendsLink.setText("My Friends");
		absolutePanel.add(FriendsLink, 10, 264);
		FriendsLink.setSize("83px", "22px");
		
		Button UserHobbiesLink = new Button("New button");
		UserHobbiesLink.setStyleName("dialogVPanel");
		UserHobbiesLink.setText("My Hobbies");
		absolutePanel.add(UserHobbiesLink, 10, 302);	
		
		HTML WelcomeHTML = new HTML("<div id='welcome'style='font-size: 150%;'> Welcome!</div>", true);
		absolutePanel.add(WelcomeHTML, 127, 130);
		
		HTML BodyHTML = new HTML("<div id='welcome-body'style='font-size:110%;'>This is a test to see if it works.</div>", true);
		absolutePanel.add(BodyHTML, 127, 154);
		BodyHTML.setSize("422px", "253px");
		
		Button btnLogOut = new Button("Log Out!");
		btnLogOut.setStyleName("dialogVPanel");
		btnLogOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.instance.userID = 0;
			System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
			HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		absolutePanel.add(btnLogOut, 466, 92);
		btnLogOut.setSize("73px", "22px");
		
		Label label = new Label("");
		label.setStyleName("dialogVPanel");
		absolutePanel.add(label, 0, 116);
		label.setSize("547px", "0px");
		
		Label label_1 = new Label("");
		label_1.setStyleName("dialogVPanel");
		absolutePanel.add(label_1, 109, 0);
		label_1.setSize("0px", "405px");
		
	
	}
}
