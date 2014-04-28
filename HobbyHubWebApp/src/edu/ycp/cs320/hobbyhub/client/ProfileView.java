package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.dev.jjs.ast.JLabel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

public class ProfileView extends Composite{
	private LayoutPanel mainPanel;
	//public int userID;
		
	public ProfileView() {	
		/**
		 * 
		 * 
		 * THIS WILL BE THE DEFAULT PAGE WHEN THE USER GOES TO
		 * THE APPLICATION.   SHOULD CONSIST OF A TITLE, A BRIEF DESCRIPTION
		 * , A BUTTON TO SIGN UP, AND TWO TEXT BOXES FOR THE USER TO ENTER THE PASSWORD 
		 * AND USERNAME TO LOGIN
		 * 
		 * 
		 */
	
	mainPanel = new LayoutPanel();
	initWidget(mainPanel);	
	mainPanel.setSize("780px", "543px");
	
	Button ProfileButton = new Button("My Profile");
	mainPanel.add(ProfileButton);
	mainPanel.setWidgetLeftWidth(ProfileButton, 236.0, Unit.PX, 100.0, Unit.PX);
	mainPanel.setWidgetTopHeight(ProfileButton, 186.0, Unit.PX, 100.0, Unit.PX);
	ProfileButton.setSize("100px", "100px");

	
	}
}
