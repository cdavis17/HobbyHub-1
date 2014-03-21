package edu.ycp.cs320.hobbyhub.shared;

public class Message {
	private User sender;
	private User receiver;
	private String subject;
	private String body;
	
	// Constructor
	public Message(){
	
	}
	
	//Get/Set subject
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getSubject(){
		return this.subject;
	}
	
	
	//Get/Set body
	public void setBody(String body){
		this.body = body;
	}
	
	public String getBody(){
		return this.body;
	}

	
	//Get/Set Sender
	public void setSender(User sender){
		this.sender = sender;
	}
	
	public User getSender(){
		return this.sender;
	}
	
	//Get/Set Receiver
	public void setReciever(User reciever){
		this.receiver = reciever;
	}
	
	public User getReciever(){
		return this.receiver;
	}
	
	
	
}
