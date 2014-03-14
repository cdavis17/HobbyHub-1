package edu.ycp.cs320.hobbyhub.shared;

public class User {
	private String userName;
	private String locationCity;
	private String locationState;
	private String password;
	private String userEmail;
	private String firstName;
	private String lastName;
	
	public User() {
		
	}
	
	
	// Set/Get User Name
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	
	// Set/Get Users City
	public void setLocationCity(String locationCity){
		this.locationCity = locationCity;
	}
	public String getLocationCity(){
		return locationCity;
	}
	
	
	// Set/Get Users State
	public void setLocationState(String locationState){
		this.locationState = locationState;
	}
	public String getLocationState(){
		return locationState;
	}
	
	
	// Set/Get User password
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	
	
	// Set/Get User email
	public void setUserEmail(String email){
		this.userEmail = email;
	}
	public String getUserEmail(){
		return userEmail;
	}
	
	
	// Set/Get first name of user
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	
	
	// Set/Get last name of user
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}
}
