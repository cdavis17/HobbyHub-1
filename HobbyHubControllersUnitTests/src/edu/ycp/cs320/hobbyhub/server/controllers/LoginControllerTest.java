package edu.ycp.cs320.hobbyhub.server.controllers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.FakeDatabase;
import edu.ycp.cs320.hobbyhub.shared.User;

public class LoginControllerTest {
	@Before
	public void setUp() {
		// All unit tests are run with the FakeDatabase as the implementation of IDatabase
		DatabaseProvider.setInstance(new FakeDatabase());
	}
	
	@Test
	public void testSuccessfulLogin() {
		LoginController controller = new LoginController();
		
		User user = controller.login("jsmith", "abc123");
		assertNotNull(user);
		assertEquals("Joe", user.getFirstName());
		assertEquals("Smith", user.getLastName());
		assertEquals("abc123", user.getPassword());
		// etc.
	}
}
