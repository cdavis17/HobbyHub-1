package edu.ycp.cs320.hobbyhub.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Hobby implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private ArrayList <String> tag = new ArrayList<String>();
	private String image;
	
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
	
	//Get/Add Tags
	public ArrayList<String> getTags(){
		return tag;
	}
	
	public void addTag(String newTag){
		tag.add(newTag);
	}
	
	//Get/Set Image url
	public String getImage(){
		return image;
	}
	
	public void setImage(String url){
		this.image = url;
	}
}
