package edu.ycp.cs320.hobbyhub.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessageTest {

	Message tester;
	String bodyText;
	User sender;
	User receiver;
	
	@Before
	public void setup(){
		//tester = new Message();
		bodyText = "This is the body of the message.";
		sender = new User();
		receiver = new User();
	}
	
	//
	@Test
	public void testSetSubject(){
		tester.setSubject("test");
		assertEquals("test", "test", tester.getSubject());
	}
	
	
	@Test
	public void testsetBody(){
		tester.setBody(bodyText);
		assertEquals(bodyText, tester.getBody());
	}
	
	@Test
	public void testsetSender(){
		tester.setSender(sender);
		assertEquals(sender, tester.getSender());
	}
	
	
	@Test
	public void testsetReciever(){
		tester.setReciever(receiver);
		assertEquals(receiver, tester.getReciever());
	}

}
