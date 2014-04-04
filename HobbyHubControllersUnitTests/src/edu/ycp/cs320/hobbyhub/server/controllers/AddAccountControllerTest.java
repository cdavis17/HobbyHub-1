package edu.ycp.cs320.hobbyhub.server.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.FakeDatabase;
import edu.ycp.cs320.hobbyhub.shared.User;

public class AddAccountControllerTest {
	public User user = new User();
	
	
	
	@Before
	public void setUp() {
		// All unit tests are run with the FakeDatabase as the implementation of IDatabase
		DatabaseProvider.setInstance(new FakeDatabase());
		user.setUserName("JohnDoe");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("abcd1234");
	}
	
	
	
	
	@Test
	public void testAddAccount() {
		AddAccountController controller = new AddAccountController();
		// User details
	;
		
		controller.addAccount(user);
		assertNotNull(user);
	}
		
	@Test
	public void testGetUserName(){
		assertEquals("JohnDoe", user.getUserName());
	}
		
		
	@Test
	public void testGetUserFirstName(){
		assertEquals("John", user.getFirstName());
	}
		
	@Test
	public void testGetUserLastName(){
		assertEquals("Doe", user.getLastName());
	}
	
	@Test
	public void testUserGetPassword(){
		assertEquals("abcd1234", user.getPassword());
	}
}

