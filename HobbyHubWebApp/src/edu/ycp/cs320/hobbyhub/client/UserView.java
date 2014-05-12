package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.ycp.cs320.hobbyhub.shared.User;

import edu.ycp.cs320.hobbyhub.shared.User;

public class UserView extends Composite {
	
	private AbsolutePanel absolutePanel;


	//private Hyperlink UserHobbiesLink;
	private String username;
	private User user;
	//private Button UserHobbiesLink;
	//@SuppressWarnings("deprecation")
	

	private Button UserHobbiesLink;

	public UserView(){
		
		absolutePanel = new AbsolutePanel();

		initWidget(absolutePanel);
		absolutePanel.setSize("559px", "417px");
		
		// Gets the user
		// This is failing
		System.out.println(HobbyHubUI.instance.userID);
		
		RPC.accountManagementService.getUser(HobbyHubUI.instance.userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result) {
				System.out.println("Successful");	
				user = result;	
			}			
		
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Account failed: " + caught.getMessage());
			}
		});
			
		
		//initWidget(absolutePanel);
		RootLayoutPanel rootlayoutpanel = RootLayoutPanel.get();
		rootlayoutpanel.setSize("837px", "668px");
		rootlayoutpanel.add(absolutePanel);
		rootlayoutpanel.setWidgetLeftWidth(absolutePanel, 0.0, Unit.PX, 1088.0, Unit.PX);
		rootlayoutpanel.setWidgetTopHeight(absolutePanel, 0.0, Unit.PX, 668.0, Unit.PX);
		absolutePanel.setSize("837px", "668px");
		
		Image Logo = new Image();
		Logo.setUrl("http://www.google.com/images/logo.gif");
		absolutePanel.add(Logo, 0, 20);
		Logo.setSize("115px", "84px");
		

		Button HomeLink = new Button("Home");
		HomeLink.setStyleName("dialogVPanel");
		absolutePanel.add(HomeLink, 130, 85);
		HomeLink.setSize("58", "32");
		//HomeLink.
		HomeLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to home view...");
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new UserView());
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
				HobbyHubUI.setCurrentView(new HomeView());
				
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
		Button ProfileLink = new Button("New button");
		ProfileLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("Switching to Profile View");

				HobbyHubUI.setCurrentView(new HomeView());

				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new ProfileView());

			}
		});
		ProfileLink.setStyleName("dialogVPanel");
		ProfileLink.setText("My Profile");

		absolutePanel.add(ProfileLink, 197, 52);

		absolutePanel.add(ProfileLink, 196, 85);

		
		Button HobbyLink = new Button("New button");
		HobbyLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		HobbyLink.setStyleName("dialogVPanel");
		HobbyLink.setText("Hobbies");

		absolutePanel.add(HobbyLink, 295, 52);

		absolutePanel.add(HobbyLink, 287, 85);

		
		
		Button AboutLink = new Button("New button");
		AboutLink.setStyleName("dialogVPanel");
		AboutLink.setText("About Us");

		absolutePanel.add(AboutLink, 370, 92);


		absolutePanel.add(AboutLink, 366, 85);

		
		Label WelcomeLabel = new Label("Welcome:");
		absolutePanel.add(WelcomeLabel, 10, 128);

		final Label UsernameLabel = new Label("Username");
		absolutePanel.add(UsernameLabel, 20, 152);


	
		
		
		Button MessagesLink = new Button("Messages");
		MessagesLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new MessageView());
			}
		});
		absolutePanel.add(MessagesLink, 372, 52);

		Button MessagesLink1 = new Button("New button");
		MessagesLink1.setStyleName("dialogVPanel");
		MessagesLink1.setText("Messages");
		absolutePanel.add(MessagesLink1, 10, 192);
		MessagesLink1.setSize("83px", "22px");


		Button MessagesLink = new Button("New button");
		MessagesLink.setStyleName("dialogVPanel");
		MessagesLink.setText("Messages");
		absolutePanel.add(MessagesLink, 10, 193);
		MessagesLink.setSize("83px", "22px");
		
		Button EventsLink = new Button("New button");
		EventsLink.setStyleName("dialogVPanel");
		EventsLink.setText("Events");
		absolutePanel.add(EventsLink, 10, 231);
		EventsLink.setSize("83px", "22px");
		
		Button FriendsLink = new Button("New button");
		FriendsLink.setStyleName("dialogVPanel");
		FriendsLink.setText("Friends");
		absolutePanel.add(FriendsLink, 10, 265);
		FriendsLink.setSize("83px", "22px");
		
		Button UserHobbiesLink = new Button("New button");
		UserHobbiesLink.setStyleName("dialogVPanel");
		UserHobbiesLink.setText("My Hobbies");
		absolutePanel.add(UserHobbiesLink, 10, 303);	
		
		HTML WelcomeHTML = new HTML("<div id='welcome'style='font-size: 150%;'> Welcome!</div>", true);
		absolutePanel.add(WelcomeHTML, 127, 130);
		
		HTML BodyHTML = new HTML("<div id='welcome-body'style='font-size:110%;'>This is a test to see if it works.</div>", true);
		absolutePanel.add(BodyHTML, 127, 154);
		BodyHTML.setSize("422px", "253px");
		
		Button btnLogOut = new Button("Log Out");
		btnLogOut.setStyleName("dialogVPanel");
		btnLogOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.instance.userID = 0;
			System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
			absolutePanel.clear();
			HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		absolutePanel.add(btnLogOut, 679, 85);
		
		Label label = new Label("");
		label.setStyleName("dialogVPanel");
		absolutePanel.add(label, 0, 110);
		label.setSize("825px", "0px");
		
		Label label_1 = new Label("");
		label_1.setStyleName("dialogVPanel");
		absolutePanel.add(label_1, 112, 0);
		label_1.setSize("0px", "656px");
		
		int userID = HobbyHubUI.instance.userID;
		RPC.accountManagementService.getIDUser(userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result){
				User user = result;
				GWT.log("RPC call successful.");
				GWT.log("User name is: " + user.getUserName());
				
				UsernameLabel.setText(user.getUserName());
			
			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Account failed: " + caught.getMessage());
			}
		});
		
	
	}
}
