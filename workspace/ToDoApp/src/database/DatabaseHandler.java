package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Task;
import model.User;

public abstract class DatabaseHandler {
	
	protected static void signUpUser(User user) {
	
		try (Connection connection = DatabaseConnection.getConnection();	//get a connection to the db
			
			//prepare statement:
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO " + DatabaseConst.USERS_TABLE + "(" +
						DatabaseConst.USERS_FIRST_NAME + "," +		
						DatabaseConst.USERS_LAST_NAME + ","  +
						DatabaseConst.USERS_USERNAME + ","  +
						DatabaseConst.USERS_PASSWORD + ","  +
						DatabaseConst.USERS_LOCATION + ","  +
						DatabaseConst.USERS_GENDER +
					") VALUES (?,?,?,?,?,?)");){
			
			//set the parameters for the statement (at the position required):
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getLocation());
			preparedStatement.setString(6, user.getGender());
			
			preparedStatement.executeUpdate(); //execute update
			
		}catch(Exception e) { e.printStackTrace(); }
		
	}
	
	//-----------------------------------------------------------------------------------
	/*
	protected static boolean findUser(User user) {	
		//if user has a name & password: 
		if(!user.getUserName().equals("") && !user.getPassword().equals("")) {
			
			//get a connection to the db:
			try (Connection connection = DatabaseConnection.getConnection();
				//prepare statement:
				PreparedStatement preparedStatement = connection.prepareStatement(
						" SELECT * FROM " + DatabaseConst.USERS_TABLE + 
						" WHERE " + DatabaseConst.USERS_USERNAME + "=?" + 
						" AND " + DatabaseConst.USERS_PASSWORD + "=?");){
				
				//set the parameters for the statement (at the position required):
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getPassword());
				//execute query:
				ResultSet resultSet = preparedStatement.executeQuery(); 
			
				if(resultSet.next()) { //if entry was found:
					System.out.println(resultSet.getString("username") + " " + resultSet.getString("password"));
					return true;
				}else { 
					System.out.println("invalid username or password"); 
					return false;
				}
				
			}catch(Exception e) { e.printStackTrace(); }
			
		}else { System.out.println("please enter username and password"); }
			
		return false;
	}
	*/
	
	/** ++++++++++this is AWFUL as connection isnt closed due to resultSet being returned DONT DO THIS!! */
	protected static ResultSet findUser(User user) {	

		ResultSet resultSet = null;	
	
		//get a connection to the db:
		try {
			Connection connection = DatabaseConnection.getConnection();
			//prepare statement:
			PreparedStatement preparedStatement = connection.prepareStatement(
					" SELECT * FROM " + DatabaseConst.USERS_TABLE + 
					" WHERE " + DatabaseConst.USERS_USERNAME + "=?" + 
					" AND " + DatabaseConst.USERS_PASSWORD + "=?");
			
			//set the parameters for the statement (at the position required):
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			//execute query:
			resultSet = preparedStatement.executeQuery(); 
		
		}catch(Exception e) { e.printStackTrace(); }

		return resultSet;
		
	}
	
		
	//-----------------------------------------------------------------------------------
	
	protected static void insertTask(Task task) {
		try (Connection connection = DatabaseConnection.getConnection();	//get a connection to the db
				
				//prepare statement:
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO " + DatabaseConst.TASKS_TABLE + "(" +
							DatabaseConst.USERS_USER_ID + ","  +
							DatabaseConst.TASKS_TASK + ","  +
							DatabaseConst.TASKS_DATE_CREATED + "," +		
							DatabaseConst.TASKS_DESCRIPTION + 
						") VALUES (?,?,?,?)");){
				
				//set the parameters for the statement (at the position required):
				preparedStatement.setInt(1, 1); /** +++++++++++++++++++++++++++++++*/
				preparedStatement.setString(2, task.getTask());
				preparedStatement.setTimestamp(3, task.getDateCreated());
				preparedStatement.setString(4, task.getDescription());
				
				preparedStatement.executeUpdate(); //execute update
				
		}catch(Exception e) { e.printStackTrace(); }
		
	}//insert
		
}

