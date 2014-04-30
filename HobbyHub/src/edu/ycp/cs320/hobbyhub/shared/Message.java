package edu.ycp.cs320.hobbyhub.shared;

import java.io.Serializable;

public class Message implements Serializable {
    private User sender;
    private User receiver;
    private int sendID;
    private int recID;
    private String subject;
    private String body;
    
    // Constructor
    public Message(int receiverID, User receivingUser, int senderID, User sendingUser, String subjecttext, String bodytext){
   	 recID = receiverID;
   	 receiver = receivingUser;
   	 sendID = senderID;
   	 sender = sendingUser;
   	 subject = subjecttext;
   	 body = bodytext;
    }
    
    // dont need setter methods
    public int getreceiverIDNumber(){
   	 return this.recID;
    }
    public int getSenderIDNumber(){
   	 return this.sendID;
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
