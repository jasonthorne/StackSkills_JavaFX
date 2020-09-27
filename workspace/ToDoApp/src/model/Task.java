package model;

public class Task {
	
	private String task; 
	private long dateCreated; 
	private String description;
	
	//----------------------------constructors:------------------------
	
	public Task() {} //++++++++++++++++++THIS NEEDED????
	
	public Task(String task, long dateCreated, String description) {
		super();
		this.task = task;
		this.dateCreated = dateCreated;
		this.description = description;
	}
	
	//----------------------------getters & setters:------------------------
	
	public String getTask() { return task; }
	public void setTask(String task) { this.task = task; }
		
	public long getDateCreated() { return dateCreated; }
	public void setDateCreated(long dateCreated) { this.dateCreated = dateCreated; }
		
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; } 
}
