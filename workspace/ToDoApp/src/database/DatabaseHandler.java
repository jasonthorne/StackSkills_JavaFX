package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseHandler {
	
	//write
	public void signUpUser(String fName, String lName, String usrName, String pwd, String loc, String gender) {
	
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
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			preparedStatement.setString(3, usrName);
			preparedStatement.setString(4, pwd);
			preparedStatement.setString(5, loc);
			preparedStatement.setString(6, gender);
			
			preparedStatement.executeUpdate(); //execute update
			
		}catch(Exception e) { e.printStackTrace(); }
		
	}
	

}

