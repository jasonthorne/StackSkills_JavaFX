package model;

public class User {
	
	private String firstName; 
	private String lastName; 
	private String usertName; 
	private String password; //+++++++++++???? yikes!!
	private String location; 
	private String gender;
	
	//----------------------------constructors:------------------------
	
	public User() {} //++++++++++++++++++THIS NEEDED????
	
	public User(String firstName, String lastName, String usertName, String password, String location, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.usertName = usertName;
		this.password = password;
		this.location = location;
		this.gender = gender;
	}
	
	//----------------------------getters & setters:------------------------
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getUsertName() { return usertName; }
	public void setUsertName(String usertName) { this.usertName = usertName; }
		
	public String getPassword() { return password; 	}
	public void setPassword(String password) { 	this.password = password; }
	
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
		

}
