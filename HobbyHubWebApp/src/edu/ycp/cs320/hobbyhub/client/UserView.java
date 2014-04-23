package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class UserView extends Composite{
	private LayoutPanel mainpanel;
	
	public UserView(){
		initWidget(mainpanel);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("586px", "455px");
		
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
		
		Hyperlink UserHobbiesLink = new Hyperlink("My Hobbies", false, "newHistoryToken");
		absolutePanel.add(UserHobbiesLink, 10, 264);
		
		HTML WelcomeHTML = new HTML("<div id='welcome'style='font-size: 150%;'> Welcome!</div>", true);
		absolutePanel.add(WelcomeHTML, 127, 122);
		
		HTML BodyHTML = new HTML("<div id='welcome-body'style='font-size:110%;'>This is a test to see if it works.</div>", true);
		absolutePanel.add(BodyHTML, 127, 154);
		BodyHTML.setSize("422px", "253px");
		
		Label label = new Label(" ");
		label.setStyleName("dialogVPanel");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label.setDirectionEstimator(true);
		absolutePanel.add(label, 0, 112);
		label.setSize("574px", "0px");
		
		Label label_1 = new Label(" ");
		label_1.setStyleName("dialogVPanel");
		absolutePanel.add(label_1, 116, 0);
		label_1.setSize("0px", "443px");
		
	
	}
}
