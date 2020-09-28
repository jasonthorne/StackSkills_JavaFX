package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public abstract class DatabaseHandler {
	
	protected static void signUpUser(User user) {
	
		try (Connection connection = DatabaseConnection.getConnection();){	//get a connection to the db
			
			//prepare statement:
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO " + DatabaseConst.USERS_TABLE + "(" +
						DatabaseConst.USERS_FIRST_NAME + "," +		
						DatabaseConst.USERS_LAST_NAME + ","  +
						DatabaseConst.USERS_USERNAME + ","  +
						DatabaseConst.USERS_PASSWORD + ","  +
						DatabaseConst.USERS_LOCATION + ","  +
						DatabaseConst.USERS_GENDER +
					") VALUES (?,?,?,?,?,?)");
			
			//set the parameters for the statement (at the position required):
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsertName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getLocation());
			preparedStatement.setString(6, user.getGender());
			
			preparedStatement.executeUpdate(); //execute update
			
		}catch(Exception e) { e.printStackTrace(); }
		
	}
	
	
	protected static ResultSet getUser(User user) {
		ResultSet resultSet = null;
		
		//if user has a name & password: 
		if(!user.getUsertName().equals("") && !user.getPassword().equals("")) {
			
			//get a connection to the db:
			try (Connection connection = DatabaseConnection.getConnection();){
				//prepare statement:
				PreparedStatement preparedStatement = connection.prepareStatement(
						"SELECT * FROM " + DatabaseConst.USERS_TABLE + 
						"WHERE" + DatabaseConst.USERS_USERNAME + "=?" + 
						"AND" + DatabaseConst.USERS_PASSWORD + "=?");
				
				//set the parameters for the statement (at the position required):
				preparedStatement.setString(1, user.getUsertName());
				preparedStatement.setString(2, user.getPassword());
				//execute query:
				resultSet = preparedStatement.executeQuery(); 
				
			}catch(Exception e) { e.printStackTrace(); }
			
		}else { System.out.println("please enter your credentials"); }  //+++++++++++SLOPPY!! DONT USE THIS :P 
			
		return resultSet;
	}
		
	

}

