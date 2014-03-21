package edu.ycp.cs320.hobbyhub.shared;

import static org.junit.Assert.*;

import org.junit.Test;

public class HobbyTest {
	
	Hobby tester = new Hobby();
	
	//Hobby Name
	@Test
	public void testHobbyName(){
		tester.setName("Stuff");
		assertEquals("Stuff", "Stuff", tester.getName());
	}
	
	//Hobby Description
	@Test
	public void testHobbyDescription(){
		tester.setDescription("Doing stuff");
		assertEquals("Doing stuff", "Doing Stuff", tester.getDescription());
	}
	
	//Long Hobby Description
	@Test
	public void testHobbyDescriptionLong(){
		String LongDescription = "This is a really long description to test if it can handle really long descriptions like this really long description. Long description.";
		tester.setDescription(LongDescription);
		assertEquals(LongDescription, LongDescription, tester.getDescription());
		
	}



}
