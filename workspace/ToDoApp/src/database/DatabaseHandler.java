package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

public abstract class DatabaseHandler {
	
	//write
	//protected static void signUpUser(String fName, String lName, String usrName, String pwd, String loc, String gender) {
	protected static void signUpUser(User user) {
	
		try (Connection connection = DatabaseConnection.getConnection(); ){	//get a connection to the db
			
			//prepare statement:
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
					DatabaseConst.USERS_TABLE + "(" +
						DatabaseConst.USERS_FIRST_NAME + "," +		
						DatabaseConst.USERS_LAST_NAME + ","  +
						DatabaseConst.USERS_USERNAME + ","  +
						DatabaseConst.USERS_PASSWORD + ","  +
						DatabaseConst.USERS_LOCATION + ","  +
						DatabaseConst.USERS_GENDER +
					") VALUES (?,?,?,?,?,?)" );
			
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
	

}

