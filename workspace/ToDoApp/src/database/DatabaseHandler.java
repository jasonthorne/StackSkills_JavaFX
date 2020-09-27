package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	
	//write
	public void signUpUser(String fName, String lName, String usrName, String pwd, String location, String gender) {
	//public void signUpUser() {
		
		/*String insert = "INSERT INTO " + 
				DatabaseConst.USERS_TABLE + "(" +
					DatabaseConst.USERS_FIRST_NAME + "," +		
					DatabaseConst.USERS_LAST_NAME + ","  +
					DatabaseConst.USERS_USERNAME + ","  +
					DatabaseConst.USERS_PASSWORD + ","  +
					DatabaseConst.USERS_LOCATION + ","  +
					DatabaseConst.USERS_GENDER +
				") + VALUES (?,?,?,?,?,?)";*/
		try (Connection connection = DatabaseConnection.getConnection(); ){	//get a connection to the db
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO " + 
							DatabaseConst.USERS_TABLE + "(" +
								DatabaseConst.USERS_FIRST_NAME + "," +		
								DatabaseConst.USERS_LAST_NAME + ","  +
								DatabaseConst.USERS_USERNAME + ","  +
								DatabaseConst.USERS_PASSWORD + ","  +
								DatabaseConst.USERS_LOCATION + ","  +
								DatabaseConst.USERS_GENDER +
							//")" + "VALUES ( " +  fName +","+ lName +","+ usrName +","+ pwd +","+ location +","+ gender +")");
							")" + "VALUES ( 'Blogs', 'Joe', 'blogs.joe@email.com', 'HR', '33000.00', 'qqq')");
								//fName +","+ lName +","+ usrName +","+ pwd +","+ location +","+ gender +")");
								
		}catch(Exception e) { e.printStackTrace(); }
		
	}
	

}

