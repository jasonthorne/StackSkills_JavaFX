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
import model.CellItem;

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
    	
    	btnEditText.setOnAction(event -> editItem());

    }
	
	// Holds this controller's Stage
    private Stage thisStage;
	
    /** ++++++++++++++++++++++++ THIS ISNT NEEDED!! :P (I think!) +++++++++++++++++++++ */
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
	        thisStage.setTitle("Passing Controllers Example - EditCellController");
	        
	    } catch (IOException e) {  e.printStackTrace(); }
	      
	   
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    
    /** -------------------------- */
    private void editItem(){
    	
    	/** ++++++++++++++ here we mimic updating observableList, +++++++++++++++++++++++++++ */
    	Controller1.editObservableList(cellController.getLblText(), newText.getText());
    	
    	/** ++++++++++++++ here we mimic pushing data to db, +++++++++++++++++++++++++++ */
    	//edit cellItem in db with new text:
    	Controller1.cellItemsDB.forEach(item -> { //this is our link with controller1. which is changing the values in listView
    		
    		//System.out.println("item name: " + item.getName());
    		//System.out.println("lblCellText: " + cellController.getLblText());
    		if (item.getName() == cellController.getLblText()) { //find item in mock db with name matching label
    		
    			//System.out.println("FOUND: item is: " + item);
    			item.setName(newText.getText()); //change name of item
    			
    			
    		}
    	});
    	
    	cellController.setLblText(newText.getText()); //change cell label.
    	
    
    	
    	/** ++++++++++++++ here we push data to db, +++++++++++++++++++++++++++
    	 * then should prob call a static method in controller 1 which repulls the data to it's list.
    	 * */
    	
    	//observable list needs changing here!! :P ++++++++++++++++++++++++++
    	//==========================
    	
    	//Controller1.editObservableList(lblCellText.getText() );
    	//===========================
    	
    	/////////////cellController.editDB(newText.getText());
    	
    }
    /** -------------------------- */

}
