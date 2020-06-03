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
    	
    	
    	//if trimmed username & password ARENT empty: 
    	if(!loginUserName.getText().toString().trim().equals("") && !loginPassword.getText().toString().trim().equals("")) {
    		
    		//+++++++++++ Have password & name recognition here! ++++++++++++
    		
    		/**hide the primary stage login window by targeting it through it's scene, 
        	 * which is itself gotten by targeting one of it's elements,
        	 * which we have access to here (the button in this case):
        	 */
        	loginButton.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++
    		
    		
    		
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(); //create loader
    			loader.setLocation(getClass().getResource("/view/details.fxml")); //set the fxml location
    			loader.load(); //load the fxml hierarchy
    			Parent root = loader.getRoot(); //create root from the loader's root (an anchorPane in this case)
    			
    			Stage detailsStage = new Stage(); /**make a new stage for showing details window */
    			
				//add the root to a new scene. Add that scene to the stage:
				detailsStage.setScene(new Scene(root));
				//loginButton.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++PROB BETTER PLACED HERE for optimization
				
				//-------pass info from login to details:
				
				/**create instance of controller using loader (which knows everything about our details.fxml)*/
				DetailsController detailsController = loader.getController();
				//////////detailsController.initialize(loginUserName.getText().toString().trim()); /**call detailsController's package level initialize()*/
				detailsController.setName(loginUserName.getText().toString().trim()); //call setName, passing in entered user name 
				
				detailsStage.show(); /** show the stage */
				detailsStage.setResizable(false); /** prevent user from resizing the window +++++++++++nort really needed, but nice to know! :D*/
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }
    
	
}
