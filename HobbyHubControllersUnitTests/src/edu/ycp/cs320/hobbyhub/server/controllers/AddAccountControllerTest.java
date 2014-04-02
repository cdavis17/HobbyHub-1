package edu.ycp.cs320.hobbyhub.server.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.FakeDatabase;
import edu.ycp.cs320.hobbyhub.shared.User;

public class AddAccountControllerTest {
	@Before
	public void setUp() {
		// All unit tests are run with the FakeDatabase as the implementation of IDatabase
		DatabaseProvider.setInstance(new FakeDatabase());
	}
	
	
	
	
	@Test
	public void testAddAccount() {
		AddAccountController controller = new AddAccountController();
		
		User user = new User();
		user.setUserName("JohnDoe");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("abcd1234");
		
		controller.addAccount(user);
		assertNotNull(user);
		
		
		// etc.
	}
}
