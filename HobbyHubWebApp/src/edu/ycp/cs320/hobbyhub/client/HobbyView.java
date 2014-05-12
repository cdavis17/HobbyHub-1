package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.User;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.dom.client.Style.Unit;

public class HobbyView extends Composite {
	private Hobby BasketBall, Football, Bowling;
	
	public HobbyView(){
		
		final AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("1900px", "839px");
		
		RootLayoutPanel rootlayoutpanel = RootLayoutPanel.get();
		rootlayoutpanel.add(absolutePanel);
		rootlayoutpanel.setWidgetLeftWidth(absolutePanel, 0.0, Unit.PX, 1900.0, Unit.PX);
		rootlayoutpanel.setWidgetTopHeight(absolutePanel, 0.0, Unit.PX, 839.0, Unit.PX);
		
		BasketBall = new Hobby();
		BasketBall.setName("BasketBall");
		BasketBall.setDescription("People throw a ball into a net while getting into each others' way. This is deemed to be 'fun'.");
		BasketBall.setImage("http://upload.wikimedia.org/wikipedia/commons/7/7a/Basketball.png");
		BasketBall.addTag("Ball");
		BasketBall.addTag("Sport");
		BasketBall.addTag("Outdoor");
		BasketBall.addTag("Basket");
		
		Football = new Hobby();
		Football.setName("Football");
		Football.setDescription("Players play an intense game of keep away as they run to the other end of the field while dodging wrestling moves.");
		Football.setImage("http://upload.wikimedia.org/wikipedia/commons/6/6e/Rugbyball2.jpg");
		Football.addTag("Ball");
		Football.addTag("Sport");
		Football.addTag("Outdoor");
		
		Bowling = new Hobby();
		Bowling.setName("Bowling");
		Bowling.setDescription("Players roll a ball down the lane to ruin some pins day.");
		Bowling.setImage("http://upload.wikimedia.org/wikipedia/en/9/98/Bowling_ball_and_pins.jpg");
		Bowling.addTag("Ball");
		Bowling.addTag("Sport");
		Bowling.addTag("Indoor");
		
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
		sampleImage.setUrl(BasketBall.getImage());
		absolutePanel.add(sampleImage, 483, 176);
		sampleImage.setSize("100px", "100px");
		
		Button homeButton = new Button("New button");
		homeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		homeButton.setText("Home");
		homeButton.setStyleName("dialogVPanel");
		absolutePanel.add(homeButton, 130, 85);
		homeButton.setSize("58", "32");
		
		Button profileButton = new Button("New button");
		profileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				HobbyHubUI.setCurrentView(new HomeView());
=======
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new ProfileView());

			}
		});
		profileButton.setText("My Profile");
		profileButton.setStyleName("dialogVPanel");
		absolutePanel.add(profileButton, 196, 85);
		profileButton.setSize("83", "32");
		
		Button hobbyButton = new Button("New button");
		hobbyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		hobbyButton.setText("Hobbies");
		hobbyButton.setStyleName("dialogVPanel");
		absolutePanel.add(hobbyButton, 287, 85);
		hobbyButton.setSize("71", "32");
		
		Button aboutButton = new Button("New button");
		aboutButton.setText("About Us");
		aboutButton.setStyleName("dialogVPanel");
		absolutePanel.add(aboutButton, 366, 85);
		
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
		myHobbyButton.setSize("93", "32");
		
		Label welcomeLabel = new Label("Welcome:");
		absolutePanel.add(welcomeLabel, 10, 128);
		welcomeLabel.setSize("58px", "18px");
		
		final Label usernameLabel = new Label("Username");
		absolutePanel.add(usernameLabel, 20, 152);
		usernameLabel.setSize("59px", "18px");
		
		// Get User Name for label
		int userID = HobbyHubUI.instance.userID;
		RPC.accountManagementService.getIDUser(userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result){
				User user = result;
				GWT.log("RPC call successful.");
				GWT.log("User name is: " + user.getUserName());
				
				usernameLabel.setText(user.getUserName());
			
			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("RPC call to get Account failed: " + caught.getMessage());
			}
		});
		
		Label sideBorder = new Label("");
		sideBorder.setStyleName("dialogVPanel");
		absolutePanel.add(sideBorder, 112, 0);
		sideBorder.setSize("0px", "755px");
		
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
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		button.setText("Log Out");
		button.setStyleName("dialogVPanel");
		absolutePanel.add(button, 679, 85);
		button.setSize("70", "32");
		
		Button addButton = new Button("New button");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RPC.accountManagementService.addHobby(HobbyHubUI.instance.userID, BasketBall, new AsyncCallback<Boolean>(){
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("An error has occured: " + caught.getMessage());
						
					}

					@Override
					public void onSuccess(Boolean result) {
						GWT.log("Addition successful.");
						
					}
				});
			}
		});
		addButton.setStyleName("dialogVPanel");
		addButton.setText("Add Hobby");
		absolutePanel.add(addButton, 485, 287);
		
		Label hobby2Name = new Label(Football.getName());
		hobby2Name.setStyleName("Header");
		absolutePanel.add(hobby2Name, 165, 381);
		hobby2Name.setSize("52px", "30px");
		
		Label hobby2Description = new Label(Football.getDescription());
		absolutePanel.add(hobby2Description, 175, 417);
		hobby2Description.setSize("304px", "100px");
		
		Image hobby2Image = new Image();
		hobby2Image.setUrl(Football.getImage());
		absolutePanel.add(hobby2Image, 483, 374);
		hobby2Image.setSize("100px", "100px");
		
		Label hobby2Border = new Label("");
		hobby2Border.setStyleName("Border");
		absolutePanel.add(hobby2Border, 157, 374);
		hobby2Border.setSize("422px", "169px");
		
		Button addHobby2 = new Button("New button");
		addHobby2.setText("Add Hobby");
		addHobby2.setStyleName("dialogVPanel");
		absolutePanel.add(addHobby2, 485, 485);
		addHobby2.setSize("88", "32");
		addHobby2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RPC.accountManagementService.addHobby(HobbyHubUI.instance.userID, Football, new AsyncCallback<Boolean>(){
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("An error has occured: " + caught.getMessage());
						
					}

					@Override
					public void onSuccess(Boolean result) {
						GWT.log("Addition successful.");
						
					}
				});
			}
		});
		
		Label hobby1Tag1 = new Label("New label");
		hobby1Tag1.setText(BasketBall.getTags().get(0));
		absolutePanel.add(hobby1Tag1, 169, 325);
		
		Label hobby1Tag2 = new Label("New label");
		hobby1Tag2.setText(BasketBall.getTags().get(1));
		absolutePanel.add(hobby1Tag2, 258, 325);
		
		Label hobby1Tag3 = new Label("New label");
		hobby1Tag3.setText(BasketBall.getTags().get(2));
		absolutePanel.add(hobby1Tag3, 347, 325);
		
		Label hobby1Tag4 = new Label("New label");
		hobby1Tag4.setText(BasketBall.getTags().get(3));
		absolutePanel.add(hobby1Tag4, 436, 325);
		
		Label hobby2Tag1 = new Label("New label");
		hobby2Tag1.setText(Football.getTags().get(0));
		absolutePanel.add(hobby2Tag1, 169, 525);
		hobby2Tag1.setSize("56px", "18px");
		
		Label hobby2Tag2 = new Label("New label");
		hobby2Tag2.setText(Football.getTags().get(1));
		absolutePanel.add(hobby2Tag2, 258, 525);
		hobby2Tag2.setSize("56px", "18px");
		
		Label hobby2Tag3 = new Label("New label");
		hobby2Tag3.setText(Football.getTags().get(2));
		absolutePanel.add(hobby2Tag3, 347, 525);
		hobby2Tag3.setSize("56px", "18px");
		
		Label hobby3Name = new Label(Bowling.getName());
		hobby3Name.setStyleName("Header");
		absolutePanel.add(hobby3Name, 165, 571);
		hobby3Name.setSize("52px", "30px");
		
		Label hobby3Description = new Label(Bowling.getDescription());
		absolutePanel.add(hobby3Description, 175, 607);
		hobby3Description.setSize("304px", "100px");
		
		Image hobby3Image = new Image();
		hobby3Image.setUrl(Bowling.getImage());
		absolutePanel.add(hobby3Image, 483, 565);
		hobby3Image.setSize("100px", "100px");
		
		Label hobby3Border = new Label("");
		hobby3Border.setStyleName("Border");
		absolutePanel.add(hobby3Border, 157, 564);
		hobby3Border.setSize("422px", "169px");
		
		Button addHobby3 = new Button("New button");
		addHobby3.setText("Add Hobby");
		addHobby3.setStyleName("dialogVPanel");
		absolutePanel.add(addHobby3, 485, 675);
		addHobby3.setSize("88", "32");
		addHobby3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RPC.accountManagementService.addHobby(HobbyHubUI.instance.userID, Bowling, new AsyncCallback<Boolean>(){
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("An error has occured: " + caught.getMessage());
						
					}

					@Override
					public void onSuccess(Boolean result) {
						GWT.log("Addition successful.");
						
					}
				});
			}
		});
		
		Label hobby3Tag1 = new Label(Bowling.getTags().get(0));
		absolutePanel.add(hobby3Tag1, 169, 715);
		hobby3Tag1.setSize("56px", "18px");
		
		Label hobby3Tag2 = new Label(Bowling.getTags().get(1));
		absolutePanel.add(hobby3Tag2, 258, 715);
		hobby3Tag2.setSize("56px", "18px");
		
		Label hobby3Tag3 = new Label(Bowling.getTags().get(2));
		absolutePanel.add(hobby3Tag3, 347, 715);
		hobby3Tag3.setSize("56px", "18px");
		
		Image logo = new Image();
		logo.setUrl("http://www.google.com/images/logo.gif");
		absolutePanel.add(logo, 0, 20);
		logo.setSize("115px", "84px");
		setWidth("1900");
		
	
	}
}
