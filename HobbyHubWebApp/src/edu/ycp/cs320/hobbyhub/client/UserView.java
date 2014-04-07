package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;

public class UserView extends Composite {
	private LayoutPanel mainPanel;
	
	public UserView(){
	
		/**
		 *
		 *
		 *
		 *
		 *	VIEW FOR THE USER WHEN THEY SIGN IN
		 *	WILL MODIFY LATER
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 */
		
		
		
	mainPanel = new LayoutPanel();
	mainPanel.setSize("800px", "800px");
	initWidget(mainPanel);
	
	// Random button
	Button btnNewButton = new Button("New button");
	mainPanel.add(btnNewButton);
	mainPanel.setWidgetLeftWidth(btnNewButton, 277.0, Unit.PX, 81.0, Unit.PX);
	mainPanel.setWidgetTopHeight(btnNewButton, 408.0, Unit.PX, 30.0, Unit.PX);
	}



}
