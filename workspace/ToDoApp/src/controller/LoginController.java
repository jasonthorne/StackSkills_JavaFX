package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import animation.Shaker;
import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends DatabaseHandler { /** +++++++++++++++++++++++++++++++should these be abstract???? */
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginLoginBtn;

    @FXML
    private JFXButton loginSignUpBtn;

    @FXML
    void initialize() {
    	
    	//-------------------user login button:-------------------------------------------------
    	
    	//add event to eventHandler of loginLoginBtn's setOnAction(EventHandler):
    	loginLoginBtn.setOnAction(event -> {
    		System.out.println("'loginLoginBtn' clicked");
    		
    		//++++++++++++++USE BUILDER PATTERN FOR THIS INSTEAD OF EMPTY OBJ then setters.
    		//create a user to hold usrName & pwd, and send to getUser to check for in db 
    		User user = new User();
    		user.setUserName(loginUsername.getText().trim());
    		user.setPassword(loginPassword.getText().trim());
    		if(!DatabaseHandler.findUser(user)) { //if user isn't found: //+++++++++++++should be reversed???
    			//shake input fields
    			Arrays.asList(loginUsername, loginPassword).forEach(s -> Shaker.shake(s));
    		}else { 
    			changeStage("/view/addItem.fxml"); //should be an enum??? +++++++++++++
    		}
    		
    	});
    	
    	//-------------------user signup button:-------------------------------------------------
    	
    	loginSignUpBtn.setOnAction(event -> {
    		System.out.println("'loginSignUpBtn' clicked");
    		
    		changeStage("/view/signup.fxml"); //should be an enum??? +++++++++++++
    	});
    	
    }
    

    private void changeStage(String fxml) {
    	
		/**hide the primary stage login window by targeting it through it's scene, 
    	 * which is itself gotten by targeting one of it's elements,
    	 * which we have access to here (the loginSignUpBtn in this case):
    	 */
		loginSignUpBtn.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++
		
		FXMLLoader loader = new FXMLLoader(); //create an fxml loader (for loading fxml - duh!)
		loader.setLocation(getClass().getResource(fxml)); //set the fxml location
		try {
			loader.load(); //load the fxml hierarchy
		} catch (IOException e) {e.printStackTrace();} 
		
		Parent root = loader.getRoot(); //create root from the loader's root (an anchorPane in this case)
		
		Stage signUpStage = new Stage(); /**make a new stage for showing signup window */
		
		//add the root to a new scene. Add that scene to the stage:
		signUpStage.setScene(new Scene(root));
		signUpStage.showAndWait(); /** show the new stage  +++++++++++++++++++++++ look further into this ++++++++++*/
    	
    }

}
