package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

/** Java code relating to fxml elements for: fx:controller="view.LoginController"  IMPORTANT: give FULL path to controller in .fxml */

public class LoginController {
	
	@FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private JFXTextField loginUserName;
    @FXML
    private JFXPasswordField loginPassword;
    @FXML
    private JFXButton loginButton;

    //initialise variables: 
    @FXML
    void initialize() {
    	
    	//change colours of label fonts (so they're different when youy start typing):
    	loginUserName.setStyle("-fx-text-inner-color: blue"); //should use hex here obv! :P +++++++
    	loginPassword.setStyle("-fx-text-inner-color: blue");
    	
		//add event handler to button action: 
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("login button clicked");
			}
		});
		
		
    }
	
}
