package controller;

import com.jfoenix.controls.JFXButton;


import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import database.DatabaseHandler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import model.User;

public class SignupController extends DatabaseHandler{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signupFirstName;

    @FXML
    private JFXTextField signupLastName;

    @FXML
    private JFXTextField signupUsername;

    @FXML
    private JFXTextField signupLocation;

    @FXML
    private JFXCheckBox signupCheckBoxMale;

    @FXML
    private JFXCheckBox signupCheckBoxFemale;

    @FXML
    private JFXPasswordField signupPassword;

    @FXML
    private JFXButton signupSignUpBtn;

    @FXML
    void initialize() {  //+++++++++++++++++++++ should be private????
    	 
    	/////////DatabaseHandler databaseHandler = new DatabaseHandler();  //instance of db handler
    	
    	//------------------sign up button:-------------------------------------------------
    	
    	signupSignUpBtn.setOnAction(event -> {
    		System.out.println("'signupSignUpBtn' clicked"); 
    		createUser();
    		
    	});
    }
    
    private void createUser() {
    	
    	//grab field values:
    	String firstName = signupFirstName.getText(); 
    	String lastName = signupLastName.getText(); 
    	String usertName = signupUsername.getText(); 
    	String password = signupPassword.getText(); 
    	String location = signupLocation.getText(); 
    	String gender = "";
    	if(signupCheckBoxFemale.isSelected()) {gender="female";} ///+++++++++++++++++++AWFUL error handling!!!!++++dont use this :P
    	else {gender="male";}
    	
    	//make a user with given data, and add to db:
    	DatabaseHandler.signUpUser(new User(firstName, lastName, usertName, password, location, gender));
    	
    }
}
