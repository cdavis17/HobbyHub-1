package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;




public class ProfileView extends Composite{
	private LayoutPanel mainpanel;
	
	public ProfileView(){
		initWidget(mainpanel);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("980px", "681px");
		
		Image image = new Image((String) null);
		absolutePanel.add(image, 10, 10);
		image.setSize("100px", "100px");
		
		Hyperlink hprlnkHome = new Hyperlink("Home", false, "newHistoryToken");
		absolutePanel.add(hprlnkHome, 130, 92);
		
		Hyperlink hprlnkMyProfile = new Hyperlink("My Profile", false, "newHistoryToken");
		absolutePanel.add(hprlnkMyProfile, 190, 92);
		
		Hyperlink hprlnkNewHyperlink = new Hyperlink("Hobbies", false, "newHistoryToken");
		absolutePanel.add(hprlnkNewHyperlink, 280, 92);
		
		Hyperlink hprlnkAboutUs = new Hyperlink("About Us", false, "newHistoryToken");
		absolutePanel.add(hprlnkAboutUs, 360, 92);
		
		Label lblUsername = new Label("Username");
		absolutePanel.add(lblUsername, 246, 179);
		
		Image Avatar = new Image((String) null);
		absolutePanel.add(Avatar, 140, 175);
		Avatar.setSize("100px", "100px");
		
		Hyperlink hprlnkMessages = new Hyperlink("Messages", false, "newHistoryToken");
		absolutePanel.add(hprlnkMessages, 10, 140);
		
		Hyperlink hprlnkEvents = new Hyperlink("Events", false, "newHistoryToken");
		absolutePanel.add(hprlnkEvents, 10, 164);
		
		Hyperlink hprlnkFriends = new Hyperlink("Friends", false, "newHistoryToken");
		absolutePanel.add(hprlnkFriends, 10, 188);
		
		HTML htmlAboutMe = new HTML("<div id='UserPage'style='font-size: 150%;'>About Me: </div>", true);
		absolutePanel.add(htmlAboutMe, 141, 295);
		
		Label lblName = new Label("Name:");
		absolutePanel.add(lblName, 151, 329);
		
		Label lblNewLabel = new Label("City:");
		absolutePanel.add(lblNewLabel, 151, 360);
		
		Label lblState = new Label("State:");
		absolutePanel.add(lblState, 151, 390);
		
		Label FullName = new Label("User Full Name");
		absolutePanel.add(FullName, 195, 329);
		
		Label userCity = new Label("User City");
		absolutePanel.add(userCity, 190, 360);
		
		Label userState = new Label("User State");
		absolutePanel.add(userState, 190, 390);
		userState.setSize("74px", "18px");
		
		HTML htmlUsernamesProfile = new HTML("<div id='UserPage'style='font-size: 150%;'>Username's Profile</div>", true);
		absolutePanel.add(htmlUsernamesProfile, 140, 140);
		
		HTML htmlMyHobbies = new HTML("<div id='UserPage'style='font-size: 150%;'>My Hobbies:</div>", true);
		absolutePanel.add(htmlMyHobbies, 380, 295);
		
		Label lblHobby = new Label("Hobby 1");
		lblHobby.setVisible(false);
		absolutePanel.add(lblHobby, 380, 329);
		
		Label lblHobby_1 = new Label("Hobby 2");
		lblHobby_1.setVisible(false);
		absolutePanel.add(lblHobby_1, 380, 353);
		
		Label lblHobby_2 = new Label("Hobby 3");
		lblHobby_2.setVisible(false);
		absolutePanel.add(lblHobby_2, 380, 377);
		
		Label lblHobby_3 = new Label("Hobby 4");
		lblHobby_3.setVisible(false);
		absolutePanel.add(lblHobby_3, 380, 401);
		
		Label lblHobby_4 = new Label("Hobby 5");
		lblHobby_4.setVisible(false);
		absolutePanel.add(lblHobby_4, 480, 329);
		
		Label lblHobby_5 = new Label("Hobby 6");
		lblHobby_5.setVisible(false);
		absolutePanel.add(lblHobby_5, 480, 353);
		
		Label lblHobby_6 = new Label("Hobby 7");
		lblHobby_6.setVisible(false);
		absolutePanel.add(lblHobby_6, 480, 377);
		
		Label lblHobby_7 = new Label("Hobby 8");
		lblHobby_7.setVisible(false);
		absolutePanel.add(lblHobby_7, 480, 401);
		
		Label lblHobby_8 = new Label("Hobby 9");
		lblHobby_8.setVisible(false);
		absolutePanel.add(lblHobby_8, 570, 329);
		
		Label lblHobby_9 = new Label("Hobby 10");
		lblHobby_9.setVisible(false);
		absolutePanel.add(lblHobby_9, 570, 353);
		
		Label lblHobby_10 = new Label("Hobby 11");
		lblHobby_10.setVisible(false);
		absolutePanel.add(lblHobby_10, 570, 377);
		
		Label lblHobby_11 = new Label("Hobby 12");
		lblHobby_11.setVisible(false);
		absolutePanel.add(lblHobby_11, 570, 401);
		
		Label userBorder = new Label(" ");
		userBorder.setStyleName("dialogVPanel");
		userBorder.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		userBorder.setDirectionEstimator(true);
		absolutePanel.add(userBorder, 130, 281);
		userBorder.setSize("483px", "0px");
		
		Label aboutHobbyBorder = new Label(" ");
		aboutHobbyBorder.setStyleName("dialogVPanel");
		absolutePanel.add(aboutHobbyBorder, 336, 281);
		aboutHobbyBorder.setSize("0px", "138px");
		
		Label topBorder = new Label(" ");
		topBorder.setStyleName("dialogVPanel");
		topBorder.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		topBorder.setDirectionEstimator(true);
		absolutePanel.add(topBorder, 0, 116);
		topBorder.setSize("606px", "0px");
		
		Label sideBorder = new Label(" ");
		sideBorder.setStyleName("dialogVPanel");
		absolutePanel.add(sideBorder, 116, 0);
		sideBorder.setSize("0px", "669px");
		
		Label label = new Label(" ");
		label.setStyleName("dialogVPanel");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label.setDirectionEstimator(true);
		absolutePanel.add(label, 130, 419);
		label.setSize("483px", "0px");
		
		HTML htmlMyImages = new HTML("<div id='UserPage'style='font-size: 150%;'>My Images:</div>", true);
		absolutePanel.add(htmlMyImages, 140, 437);
		
		Image image_1 = new Image((String) null);
		absolutePanel.add(image_1, 140, 469);
		image_1.setSize("100px", "100px");
		
		Image image_2 = new Image((String) null);
		absolutePanel.add(image_2, 280, 469);
		image_2.setSize("100px", "100px");
		
		Image image_3 = new Image((String) null);
		absolutePanel.add(image_3, 428, 469);
		image_3.setSize("100px", "100px");
		
		Image image_4 = new Image((String) null);
		absolutePanel.add(image_4, 570, 469);
		image_4.setSize("100px", "100px");
		
	}
}
