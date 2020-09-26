package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseHandler{
	
	private Connection connection = null; //holds an established connection
	
	//constructor connects to DB using properties file:
	private DatabaseHandler(){ 
		
		try {
			//load properties:
			Properties properties = new Properties();	
			properties.load(new FileInputStream("DB_login.properties"));
		
			//get connection using properties:
			this.connection = DriverManager.getConnection(
					properties.getProperty("db_url"),
					properties.getProperty("db_user"), 	
					properties.getProperty("password"));
			
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	//return a newly established connection:
	public static Connection getConnection() { 
		return new DatabaseHandler().connection; 
	} 
	
}