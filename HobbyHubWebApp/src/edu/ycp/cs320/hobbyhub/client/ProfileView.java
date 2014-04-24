package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class ProfileView extends Composite{
	private AbsolutePanel mainPanel;
	
	public ProfileView(){
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		
		Image logo = new Image((String) null);
		absolutePanel.add(logo, 10, 10);
		logo.setSize("100px", "100px");
		
		Button homeButton = new Button("New button");
		homeButton.setStyleName("dialogVPanel");
		homeButton.setText("Home");
		absolutePanel.add(homeButton, 116, 80);
		
		Button profileButton = new Button("New button");
		profileButton.setStyleName("dialogVPanel");
		profileButton.setText("My Profile");
		absolutePanel.add(profileButton, 182, 80);
		
		Button hobbyButton = new Button("New button");
		hobbyButton.setStyleName("dialogVPanel");
		hobbyButton.setText("Hobbies");
		absolutePanel.add(hobbyButton, 273, 80);
		
		Button aboutButton = new Button("New button");
		aboutButton.setStyleName("dialogVPanel");
		aboutButton.setText("About Us");
		absolutePanel.add(aboutButton, 352, 80);
		
		Label TopBorder = new Label("");
		TopBorder.setStyleName("dialogVPanel");
		absolutePanel.add(TopBorder, 0, 110);
		TopBorder.setSize("737px", "0px");
		
		Label sideBorder = new Label("");
		sideBorder.setStyleName("dialogVPanel");
		absolutePanel.add(sideBorder, 112, 0);
		sideBorder.setSize("0px", "554px");
		
		Button logOutButton = new Button("New button");
		logOutButton.setStyleName("dialogVPanel");
		logOutButton.setText("Log Out");
		absolutePanel.add(logOutButton, 662, 80);
		
		Image profilePic = new Image((String) null);
		absolutePanel.add(profilePic, 130, 128);
		profilePic.setSize("100px", "100px");
		
		Label userName = new Label("Username");
		absolutePanel.add(userName, 236, 128);
		
		Label userBorder = new Label("");
		userBorder.setStyleName("dialogVPanel");
		absolutePanel.add(userBorder, 126, 234);
		userBorder.setSize("611px", "0px");
		
		Label lblAboutMe = new Label("About Me:");
		lblAboutMe.setStyleName("gwt-DialogBox");
		absolutePanel.add(lblAboutMe, 130, 248);
		lblAboutMe.setSize("71px", "18px");
		
		Label lblCity = new Label("City:");
		absolutePanel.add(lblCity, 140, 272);
		
		Label lblState = new Label("State:");
		absolutePanel.add(lblState, 140, 296);
		
		Label lblFullName = new Label("Full Name:");
		absolutePanel.add(lblFullName, 140, 320);
		
		Label userCity = new Label("User City");
		absolutePanel.add(userCity, 211, 272);
		
		Label userState = new Label("User State");
		absolutePanel.add(userState, 211, 296);
		
		Label fullUserName = new Label("User Name");
		absolutePanel.add(fullUserName, 209, 320);
		
		Label imageBorder = new Label("");
		imageBorder.setStyleName("dialogVPanel");
		absolutePanel.add(imageBorder, 126, 357);
		imageBorder.setSize("611px", "0px");
		
		Label aboutBorder = new Label("");
		aboutBorder.setStyleName("dialogVPanel");
		absolutePanel.add(aboutBorder, 362, 242);
		aboutBorder.setSize("0px", "106px");
		
		Label lblMyHobbies = new Label("My Hobbies:");
		lblMyHobbies.setStyleName("gwt-DialogBox");
		absolutePanel.add(lblMyHobbies, 380, 248);
		lblMyHobbies.setSize("83px", "18px");
		
		Label lblHobby = new Label("Hobby1");
		absolutePanel.add(lblHobby, 390, 272);
		
		Label userImages = new Label("My Images:");
		userImages.setStyleName("gwt-DialogBox");
		absolutePanel.add(userImages, 130, 375);
		userImages.setSize("83px", "18px");
		
		Image userImage = new Image((String) null);
		absolutePanel.add(userImage, 140, 399);
		userImage.setSize("100px", "100px");
		
		Label welcome = new Label("Welcome:");
		absolutePanel.add(welcome, 10, 128);
		
		Label userWelcome = new Label("Username");
		absolutePanel.add(userWelcome, 20, 152);
		
		Button messagesButton = new Button("New button");
		messagesButton.setStyleName("dialogVPanel");
		messagesButton.setText("Messages");
		absolutePanel.add(messagesButton, 10, 176);
		messagesButton.setSize("83px", "22px");
		
		Button eventButton = new Button("New button");
		eventButton.setText("Events");
		eventButton.setStyleName("dialogVPanel");
		absolutePanel.add(eventButton, 10, 214);
		eventButton.setSize("83px", "22px");
		
		Button friendButton = new Button("New button");
		friendButton.setStyleName("dialogVPanel");
		friendButton.setText("Friends");
		absolutePanel.add(friendButton, 10, 248);
		friendButton.setSize("83px", "22px");
		
		Button myHobbiesButton = new Button("New button");
		myHobbiesButton.setStyleName("dialogVPanel");
		myHobbiesButton.setText("My Hobbies");
		absolutePanel.add(myHobbiesButton, 10, 286);
		mainPanel = new AbsolutePanel();
		
	}
}
