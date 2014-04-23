package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;


public class UserView extends Composite {
	
	private AbsolutePanel absolutePanel;
	private Hyperlink UserHobbiesLink;
	@SuppressWarnings("deprecation")
	public UserView(){
		
		absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("559px", "417px");
		
		Image Logo = new Image();
		Logo.setUrl("http://www.google.com/images/logo.gif");
		absolutePanel.add(Logo, 10, 10);
		Logo.setSize("100px", "100px");
		
		Hyperlink HomeLink = new Hyperlink("Home", false, "newHistoryToken");
		absolutePanel.add(HomeLink, 140, 92);
		
		Hyperlink ProfileLink = new Hyperlink("My Profile", false, "newHistoryToken");
		absolutePanel.add(ProfileLink, 205, 92);
		
		Hyperlink HobbyLink = new Hyperlink("Hobbies", false, "newHistoryToken");
		absolutePanel.add(HobbyLink, 295, 92);
		
		
		Hyperlink AboutLink = new Hyperlink("About Us", false, "newHistoryToken");
		absolutePanel.add(AboutLink, 370, 92);
		
		Label WelcomeLabel = new Label("Welcome");
		absolutePanel.add(WelcomeLabel, 20, 130);
		
		Label UsernameLabel = new Label("Username");
		absolutePanel.add(UsernameLabel, 30, 154);
		
		Hyperlink MessagesLink = new Hyperlink("Messages", false, "newHistoryToken");
		absolutePanel.add(MessagesLink, 10, 192);
		
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
