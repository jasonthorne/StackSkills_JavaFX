package model;

import java.sql.Timestamp;

public class Task {
	
	private int userId;
	private String task; 
	//private String
	//private Timestamp dateCreated; 
	private String description;
	
	//----------------------------constructors:------------------------
	
	public Task() {} //++++++++++++++++++THIS NEEDED????
	
	//public Task(String task, Timestamp dateCreated, String description, int userId) {
	public Task(String task, String description) {
		super();
		//this.userId = userId;
		this.task = task;
		//this.dateCreated = dateCreated;
		this.description = description;
	}
	
	//----------------------------getters & setters:------------------------
	
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getTask() { return task; }
	public void setTask(String task) { this.task = task; }
		
	//public Timestamp getDateCreated() { return dateCreated; }
	//public void setDateCreated(Timestamp dateCreated) { this.dateCreated = dateCreated; }
		
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; } 

	
	
	
	
	
	
}
