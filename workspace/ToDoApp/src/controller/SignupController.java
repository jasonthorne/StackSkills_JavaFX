package controller;

import com.jfoenix.controls.JFXButton;


import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    	 
    	//------------------sign up button:-------------------------------------------------
    	/** ++++++++++++ this has no error handling - allows users with no details at all to be added :P ++++ */
    	signupSignUpBtn.setOnAction(event -> {
    		System.out.println("'signupSignUpBtn' clicked"); 
    		
    		//grab field values:
        	String firstName = signupFirstName.getText().trim(); //+++ALL OF THESE need to be checked that they're NOT empty!! 
        	String lastName = signupLastName.getText().trim(); 
        	String usertName = signupUsername.getText().trim(); 
        	String password = signupPassword.getText().trim(); 
        	String location = signupLocation.getText().trim(); 
        	String gender = "";
        	if(signupCheckBoxFemale.isSelected()) {gender="female";} ///+++++++++++++++++++AWFUL error handling!!!!++++dont use this :P
        	else {gender="male";}
        	
        	//make a user with given data, and add to db: //++++++++++++++++++++++stick fields directly in here! 
        	DatabaseHandler.signUpUser(new User(firstName, lastName, usertName, password, location, gender));
        	
        	signupSignUpBtn.getScene().getWindow().hide(); //HIDES THE SIGN UP WINDOW ++++++++++++
        	
        	//----------navigate to login page:
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("/view/login.fxml")); 
        	try {
				loader.load();
			} catch (IOException e) { e.printStackTrace(); }
			
        	Parent root = loader.getRoot();
        	Stage stage = new Stage(); /**make a new stage for showing updateTask window */
			
			//add the root to a new scene. Add that scene to the stage:
        	stage.setScene(new Scene(root));
			///////////signUpStage.showAndWait(); /** show the new stage MUST BE LAST THING */
        	stage.show(); /** show the new stage MUST BE LAST THING */
    	});
    }
    
}
