package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

public class LoginController {
	
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
    	
    	//add event to eventHandler of loginLoginBtn's setOnAction(EventHandler):
    	loginLoginBtn.setOnAction(event -> {
    		System.out.println("'loginLoginBtn' clicked");
    	});
    	
    	
    
    }

}
