package edu.ycp.cs320.hobbyhub.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;

//import com.google.gwt.core.client.EntryPoint;

public class HobbyHubUI implements EntryPoint {

	public static HobbyHubUI instance;
	public int userID;
	private static IsWidget currentView;
	
	@Override
	public void onModuleLoad() {
		GWT.log("Reached entry point!");
		
		instance = this;
		
		GWT.log("SETTING THE CURRENT VIEW");
		setCurrentView(new HomeView());
		userID = 0;
	}
		
	public static void setCurrentView(IsWidget cv) {
		// removes current view
		GWT.log("setCurrentView");
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		// sets new current view
		GWT.log("SetCurrentView");
		currentView = cv;
		RootLayoutPanel.get().add(cv);
		RootLayoutPanel.get().setWidgetTopBottom(cv, 350.0, Unit.PX, 100.0, Unit.PX);
		RootLayoutPanel.get().setWidgetLeftRight(cv, 350.0, Unit.PX, 100.0, Unit.PX);
		GWT.log("Current View is Changed");
	}

	
}
