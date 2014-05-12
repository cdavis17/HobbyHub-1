package edu.ycp.cs320.hobbyhub.client;



import com.google.gwt.dev.asm.Label;
import com.google.gwt.dev.jjs.ast.JLabel;
=======


import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.hobbyhub.shared.User;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;


public class ProfileView extends Composite{
	private AbsolutePanel mainPanel;
	private User user;
	
	public ProfileView(){
		
		mainPanel = new AbsolutePanel();
		
		
		RootLayoutPanel rootlayoutpanel = RootLayoutPanel.get();
		rootlayoutpanel.add(mainPanel);
		rootlayoutpanel.setWidgetTopHeight(mainPanel, 0.0, Unit.PX, 668.0, Unit.PX);
		rootlayoutpanel.setWidgetLeftWidth(mainPanel, 0.0, Unit.PX, 837.0, Unit.PX);
		
		
		mainPanel.setSize("837px", "668px");

		
		Button homeButton = new Button("New button");
		homeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		homeButton.setStyleName("dialogVPanel");
		homeButton.setText("Home");
		mainPanel.add(homeButton, 130, 85);
		
		Button profileButton = new Button("New button");
		profileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		profileButton.setStyleName("dialogVPanel");
		profileButton.setText("My Profile");
		mainPanel.add(profileButton, 196, 85);
		
		Button hobbyButton = new Button("New button");
		hobbyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		hobbyButton.setStyleName("dialogVPanel");
		hobbyButton.setText("Hobbies");
		mainPanel.add(hobbyButton, 287, 85);
		
		Button aboutButton = new Button("New button");
		aboutButton.setStyleName("dialogVPanel");
		aboutButton.setText("About Us");
		mainPanel.add(aboutButton, 366, 85);
		
		Label TopBorder = new Label();
		TopBorder.setStyleName("dialogVPanel");
		mainPanel.add(TopBorder, 0, 110);
		TopBorder.setSize("826px", "0px");
		
		Label sideBorder = new Label("");
		sideBorder.setStyleName("dialogVPanel");
		mainPanel.add(sideBorder, 112, 0);
		sideBorder.setSize("0px", "656px");
		
		Button logOutButton = new Button("New button");
		logOutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.instance.userID = 0;
				System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		logOutButton.setStyleName("dialogVPanel");
		logOutButton.setText("Log Out");
		mainPanel.add(logOutButton, 679, 85);
		
		Image profilePic = new Image();
		profilePic.setUrl("http://i0.wp.com/pyd.io/wp-content/plugins/buddypress/bp-core/images/mystery-man.jpg");
		mainPanel.add(profilePic, 134, 136);
		profilePic.setSize("100px", "100px");
		

		JLabel userName = new JLabel("Username");
		mainPanel.add(userName, 236, 128);

		final Label userName = new Label("Username");
		mainPanel.add(userName, 240, 136);
		
		JLabel userBorder = new JLabel("");
		userBorder.setStyleName("dialogVPanel");
		mainPanel.add(userBorder, 126, 234);
		userBorder.setSize("699px", "0px");
		
		JLabel lblAboutMe = new JLabel("About Me:");
		lblAboutMe.setStyleName("gwt-DialogBox");
		mainPanel.add(lblAboutMe, 130, 248);
		lblAboutMe.setSize("71px", "18px");
		
		JLabel lblCity = new JLabel("City:");
		mainPanel.add(lblCity, 140, 272);
		
		JLabel lblState = new JLabel("State:");
		mainPanel.add(lblState, 140, 296);
		
		JLabel lblFullName = new JLabel("Full Name:");
		mainPanel.add(lblFullName, 140, 320);
		

		JLabel userCity = new JLabel("User City");

		final Label userCity = new Label("");

		mainPanel.add(userCity, 211, 272);

		JLabel userState = new JLabel("User State");

		final Label userState = new Label("");

		mainPanel.add(userState, 211, 296);
		

		JLabel fullUserName = new JLabel("User Name");

		final Label fullUserName = new Label("");

		mainPanel.add(fullUserName, 209, 320);
		
		JLabel imageBorder = new JLabel("");
		imageBorder.setStyleName("dialogVPanel");
		mainPanel.add(imageBorder, 126, 357);
		imageBorder.setSize("699px", "0px");
		
		JLabel aboutBorder = new JLabel("");
		aboutBorder.setStyleName("dialogVPanel");
		mainPanel.add(aboutBorder, 362, 242);
		aboutBorder.setSize("0px", "106px");
		
		JLabel lblMyHobbies = new JLabel("My Hobbies:");
		lblMyHobbies.setStyleName("gwt-DialogBox");
		mainPanel.add(lblMyHobbies, 380, 248);
		lblMyHobbies.setSize("83px", "18px");
		

		JLabel lblHobby = new JLabel("Hobby1");

		final Label lblHobby = new Label("");

		mainPanel.add(lblHobby, 390, 272);
		
		JLabel userImages = new JLabel("My Images:");
		userImages.setStyleName("gwt-DialogBox");
		mainPanel.add(userImages, 130, 375);
		userImages.setSize("83px", "18px");
		
		
		Image userImage = new Image();
		userImage.setUrl("http://cdn.maxbuttons.com/wordpress/wp-content/themes/maxbuttonsdotcom/images/placeholder-200x150.png");
		mainPanel.add(userImage, 140, 399);
		userImage.setSize("100px", "100px");
		
		JLabel welcome = new JLabel("Welcome:");
		mainPanel.add(welcome, 10, 128);
		

		JLabel userWelcome = new JLabel("Username");

		final Label userWelcome = new Label("Username");

		mainPanel.add(userWelcome, 20, 152);
		
		Button messagesButton = new Button("New button");
		messagesButton.setStyleName("dialogVPanel");
		messagesButton.setText("Messages");
		mainPanel.add(messagesButton, 10, 193);
		messagesButton.setSize("83px", "22px");
		
		Button eventButton = new Button("New button");
		eventButton.setText("Events");
		eventButton.setStyleName("dialogVPanel");
		mainPanel.add(eventButton, 10, 231);
		eventButton.setSize("83px", "22px");
		
		Button friendButton = new Button("New button");
		friendButton.setStyleName("dialogVPanel");
		friendButton.setText("Friends");
		mainPanel.add(friendButton, 10, 265);
		friendButton.setSize("83px", "22px");
		
		Button myHobbiesButton = new Button("New button");
		myHobbiesButton.setStyleName("dialogVPanel");
		myHobbiesButton.setText("My Hobbies");

		mainPanel.add(myHobbiesButton, 10, 286);
		mainPanel.add(myHobbiesButton, 10, 303);
		
		Button editProfile = new Button("New button");
		editProfile.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new EditView());
			}
		});
		editProfile.setStyleName("dialogVPanel");
		editProfile.setText("Edit Profile");
		mainPanel.add(editProfile, 234, 184);
		
		Image image = new Image();
		image.setUrl("http://www.google.com/images/logo.gif");
		mainPanel.add(image, 0, 20);
		image.setSize("115px", "84px");
		
		final Label hobby2Label = new Label("");
		mainPanel.add(hobby2Label, 390, 296);
		hobby2Label.setSize("35px", "18px");
		
		final Label hobby3Label = new Label("");
		mainPanel.add(hobby3Label, 390, 320);
		hobby3Label.setSize("27px", "18px");
		
		int userID = HobbyHubUI.instance.userID;
		RPC.accountManagementService.getIDUser(userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result){
				user = result;
				GWT.log("RPC call successful.");
				GWT.log("User name is: " + user.getUserName());
				
				
				userName.setText(user.getUserName());
				userWelcome.setText(user.getUserName());
				userCity.setText(user.getLocationCity());
				userState.setText(user.getLocationState());
				fullUserName.setText(user.getFirstName() + " " + user.getLastName());
				
				if(user.getHobbies().isEmpty() == false){
					lblHobby.setText(user.getHobbies().get(0).getName());
					if (user.getHobbies().size() >= 1){
						hobby2Label.setText(user.getHobbies().get(1).getName());
						if (user.getHobbies().size() >= 2){
							hobby3Label.setText(user.getHobbies().get(2).getName());
						}
					}
				}
				
			}
			
			public void onFailure(Throwable caught){
				GWT.log("RPC call to get Account failed: " + caught.getMessage());
				
			}
		});
		
		
	}
}

