package controller;



import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
    private Button loginBtn;
	
	
	 @FXML
	 void initialize() {
		 
		 loginBtn.setOnAction(event -> {
			 
			 /**hide the primary stage login window by targeting it through it's scene, 
	    	 * which is itself gotten by targeting one of it's elements,
	    	 * which we have access to here (the loginSignUpBtn in this case):
	    	 */
			loginBtn.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++
			
			FXMLLoader loader = new FXMLLoader(); //create an fxml loader (for loading fxml - duh!)
			loader.setLocation(getClass().getResource("/listView.fxml")); //set the fxml location
			try {
				loader.load(); //load the fxml hierarchy
			} catch (IOException e) {e.printStackTrace();} 
			
			Parent root = loader.getRoot(); //create root from the loader's root (an anchorPane in this case)
			Stage signUpStage = new Stage(); /**make a new stage for showing signup window */
			
			//add the root to a new scene. Add that scene to the stage:
			signUpStage.setScene(new Scene(root));
			signUpStage.showAndWait(); /** show the new stage */
			 
		 });
	 }

}
