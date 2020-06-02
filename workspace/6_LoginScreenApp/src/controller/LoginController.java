package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
				loginUser(); //close the primary stage window, and create & nav to a details window
			}
		});
    }
    
    /** ==========================CLOSING LOGIN WINDOW & CREATING AND NAVIGATING TO DETAILS WINDOW: =========== */
   
    private void loginUser() {
    	
    	/**hide the primary stage login window by targeting it through it's scene, 
    	 * which is itself gotten by targeting one of it's elements,
    	 * which we have access to here (the button in this case):
    	 */
    	loginButton.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++
    	
    	//if trimmed username & password ARENT empty:
    	if(!loginUserName.getText().toString().trim().equals("") && !loginPassword.getText().toString().trim().equals("")) {
    		
    		Stage detailsStage = new Stage(); /**make a new stage for showing details window */
    		
    		try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/details.fxml")); /**make a new root, loading in details.fxml */
				Scene scene = new Scene(root); /**make a new scene, passing it the root */
				detailsStage.setScene(scene); /** add the scene to the stage */
				detailsStage.show(); /** show the stage */
				detailsStage.setResizable(false); /** prevent user from resizing the window +++++++++++*/
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }
    
	
}
