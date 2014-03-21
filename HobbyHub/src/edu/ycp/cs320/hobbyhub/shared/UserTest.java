package edu.ycp.cs320.hobbyhub.shared;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	
	User tester = new User();

	//User Name
	@Test
	public void testGetUserName() {
		tester.setUserName("Name");
		assertEquals("Name", "Name", tester.getUserName());
	}
	
	//User Email
	@Test
	public void testGetUserEmail() {
		tester.setUserEmail("Email");
		assertEquals("Email", "Email", tester.getUserEmail());
	}
	
	//User City
	@Test
	public void testGetUserCity(){
		tester.setLocationCity("City");
		assertEquals("City", "City", tester.getLocationCity());
	}
	
	//User State
	@Test
	public void testGetUserState(){
		tester.setLocationState("State");
		assertEquals("State", "State", tester.getLocationState());
	}
	
	//User Password
	@Test
	public void testGetUserPassword(){
		tester.setPassword("Password");
		assertEquals("Password","Password", tester.getPassword());
	}
	
	
	//User First Name
	@Test
	public void testGetUserFirstName(){
		tester.setFirstName("Name");
		assertEquals("Name", "Name", tester.getFirstName());
	}
	
	//User Last Name
	@Test
	public void testGetUserLastName(){
		tester.setLastName("Name");
		assertEquals("Name", "Name", tester.getLastName());
	}
}
