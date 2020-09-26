package database;

public enum Constant {
	
	//tables:
	USERS_TABLE("users"),
	TASKS_TABLE("tasks"),
	
	//users columns:
	USERS_FIRST_NAME("first_name"),
	USERS_LAST_NAME("last_name"),
	USERS_USERNAME("username"),
	USERS_PASSWORD("password"),
	USERS_LOCATION("location"),
	USERS_GENDER("gender"),
	
	//tasks columns:
	TASKS_USER_ID("userID"),
	TASKS_DATE_CREATED("date_created"),
	TASKS_DESCRIPTION("description");
	
	private final String constant; //name of constant
	private Constant(String constant) { this.constant = constant; } //constructor sets name of constant
	@Override 
	public String toString() { return constant; }  //return constant
}


