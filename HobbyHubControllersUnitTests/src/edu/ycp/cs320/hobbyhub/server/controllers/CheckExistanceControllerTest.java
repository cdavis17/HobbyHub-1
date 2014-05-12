package edu.ycp.cs320.hobbyhub.server.controllers;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.server.persist.FakeDatabase;


public class CheckExistanceControllerTest {
	CheckExistenceController controller = new CheckExistenceController();
	
	
	@Before
	public void setUp() {
		// All unit tests are run with the FakeDatabase as the implementation of IDatabase
		DatabaseProvider.setInstance(new FakeDatabase());
		
	}
	
	/**
	 * 
	 * Tests for the first account we created
	 * Username should already be in existence
	 * 
	 */
	@Test
	public void testAlreadyCreatedAccount() {
		assertTrue(controller.checkExistence("jsmith"));
		
	}
	
	/**
	 * 
	 * Tests for a non-existent account
	 * Account will not be in existence
	 * 
	 */
	@Test
	public void testNotCreatedAccount(){
		assertFalse(controller.checkExistence("accountdoesnotexist"));
		
	}
}
