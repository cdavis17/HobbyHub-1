package edu.ycp.cs320.hobbyhub.shared;

public class Hobby {
	private String name;
	private String description;
	
	//Constructor
	public Hobby(){
		
	}
	
	
	//Get/Set Name
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	
	//Get/Set Description
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
}
