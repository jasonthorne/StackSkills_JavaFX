package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditCellController {
	
	@FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private JFXTextField newText;
    @FXML
    private JFXButton btnEditText;
    
    @FXML
    void initialize() {
    	
    	btnEditText.setOnAction(event -> editCell());

    }
	
	// Holds this controller's Stage
    private Stage thisStage;
	
	// Will hold a reference to the cellController, allowing us to access the methods found there.
    private final CellController cellController;
    
    public EditCellController(CellController cellController) {
        // We received the cellController, now let's make it usable throughout this controller.
        this.cellController = cellController;
        
        //Create the new stage
        thisStage = new Stage();
        
	    // Load the FXML file
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/editCell.fxml"));
	        // Set this class as the controller
	        loader.setController(this);
	        // Load the scene
	        thisStage.setScene(new Scene(loader.load()));
	        // Setup the window/stage
	        thisStage.setTitle("Passing Controllers Example - Layout2");
	        
	    } catch (IOException e) {  e.printStackTrace(); }
	      
	   
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    
    /** -------------------------- */
    private void editCell(){
    	cellController.saveNewText(newText.getText());
    }
    /** -------------------------- */

}
