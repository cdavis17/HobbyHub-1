package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;

import edu.ycp.cs320.hobbyhub.shared.Hobby;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class HobbyView extends Composite {
	private LayoutPanel mainPanel;
	private Hobby BasketBall;
	
	public HobbyView(){
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		
		BasketBall = new Hobby();
		BasketBall.setName("BasketBall");
		BasketBall.setDescription("People throw a ball into a net while getting into each others' way. This is deemed to be 'fun'.");
		
		Label lblHobbyName = new Label("Hobby Name");
		lblHobbyName.setText(BasketBall.getName());
		lblHobbyName.setStyleName("Header");
		absolutePanel.add(lblHobbyName, 165, 183);
		lblHobbyName.setSize("52px", "30px");
		
		Label lblHobbyDescription = new Label("Hobby Description");
		lblHobbyDescription.setText(BasketBall.getDescription());
	
		absolutePanel.add(lblHobbyDescription, 175, 219);
		lblHobbyDescription.setSize("304px", "100px");
		
		Image sampleImage = new Image();
		sampleImage.setUrl("http://upload.wikimedia.org/wikipedia/commons/7/7a/Basketball.png");
		absolutePanel.add(sampleImage, 485, 177);
		sampleImage.setSize("100px", "100px");
		
		Button homeButton = new Button("New button");
		homeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		homeButton.setText("Home");
		homeButton.setStyleName("dialogVPanel");
		absolutePanel.add(homeButton, 130, 67);
		homeButton.setSize("58px", "32px");
		
		Button profileButton = new Button("New button");
		profileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		profileButton.setText("My Profile");
		profileButton.setStyleName("dialogVPanel");
		absolutePanel.add(profileButton, 196, 67);
		profileButton.setSize("83px", "32px");
		
		Button hobbyButton = new Button("New button");
		hobbyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		hobbyButton.setText("Hobbies");
		hobbyButton.setStyleName("dialogVPanel");
		absolutePanel.add(hobbyButton, 287, 67);
		hobbyButton.setSize("71px", "32px");
		
		Button aboutButton = new Button("New button");
		aboutButton.setText("About Us");
		aboutButton.setStyleName("dialogVPanel");
		absolutePanel.add(aboutButton, 366, 67);
		aboutButton.setSize("78px", "32px");
		
		Button messageButton = new Button("New button");
		messageButton.setText("Messages");
		messageButton.setStyleName("dialogVPanel");
		absolutePanel.add(messageButton, 10, 193);
		messageButton.setSize("83px", "22px");
		
		Button eventButton = new Button("New button");
		eventButton.setText("Events");
		eventButton.setStyleName("dialogVPanel");
		absolutePanel.add(eventButton, 10, 231);
		eventButton.setSize("83px", "22px");
		
		Button friendButton = new Button("New button");
		friendButton.setText("Friends");
		friendButton.setStyleName("dialogVPanel");
		absolutePanel.add(friendButton, 10, 265);
		friendButton.setSize("83px", "22px");
		
		Button myHobbyButton = new Button("New button");
		myHobbyButton.setText("My Hobbies");
		myHobbyButton.setStyleName("dialogVPanel");
		absolutePanel.add(myHobbyButton, 10, 303);
		myHobbyButton.setSize("93px", "32px");
		
		Label welcomeLabel = new Label("Welcome:");
		absolutePanel.add(welcomeLabel, 10, 128);
		welcomeLabel.setSize("58px", "18px");
		
		Label usernameLabel = new Label("Username");
		absolutePanel.add(usernameLabel, 20, 152);
		usernameLabel.setSize("59px", "18px");
		
		Label sideBorder = new Label("");
		sideBorder.setStyleName("dialogVPanel");
		absolutePanel.add(sideBorder, 112, 0);
		sideBorder.setSize("0px", "554px");
		
		Label topBorder = new Label("");
		topBorder.setStyleName("dialogVPanel");
		absolutePanel.add(topBorder, 0, 110);
		topBorder.setSize("813px", "0px");
		
		Label hobbyBorder = new Label("");
		hobbyBorder.setStyleName("Border");
		absolutePanel.add(hobbyBorder, 157, 176);
		hobbyBorder.setSize("422px", "169px");
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.instance.userID = 0;
				System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
				HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		button.setText("Log Out");
		button.setStyleName("dialogVPanel");
		absolutePanel.add(button, 679, 72);
		button.setSize("70px", "32px");
		mainPanel = new LayoutPanel();
	}
}
