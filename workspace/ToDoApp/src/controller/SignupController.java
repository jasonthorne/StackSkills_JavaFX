package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import database.DatabaseHandler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class SignupController {

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
    void initialize() {
    	
    	/////////DatabaseHandler databaseHandler = new DatabaseHandler();  //instance of db handler
    	
    	//------------------sign up button:-------------------------------------------------
    	
    	signupSignUpBtn.setOnAction(event -> {
    		System.out.println("'signupSignUpBtn' clicked"); 
    		
    		new DatabaseHandler().signUpUser(
    				signupFirstName.getText(), 
    				signupLastName.getText(), 
    				signupUsername.getText(), 
    				signupPassword.getText(), 
    				signupLocation.getText(), 
    				"female"); //+++++++++++++++++++++++++test  for  gender +++++++
    		
    	});
    	
    	

    }
}
