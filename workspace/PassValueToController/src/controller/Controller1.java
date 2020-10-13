package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller1 {
	
	//holds the controller's stage:
	private final Stage thisStage;
	
	//Define the nodes from the Layout1.fxml file.  This allows them to be referenced within the controller
	@FXML
    private TextField txtToSecondController;
    @FXML
    private Button btnOpenLayout2;
    @FXML
    private Label lblFromController2;
    
    /** -------------------------*/
    @FXML
    private JFXListView<?> listViewController1;
    
    @FXML
    private JFXButton btnAddToList;
    /** -------------------------*/
    
    /** Constructor: */
    public Controller1() {

        // Create the new stage
        thisStage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Layout1.fxml"));
        	
        	//set this class as the controller:
        	loader.setController(this);
        	
        	//load the scene:
        	thisStage.setScene(new Scene(loader.load()));
        	
        	//set the title:
        	thisStage.setTitle("Passing copntrollersa Example - Layout1");
        	
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }//constructor
    
    //---------------------
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    //--------------------
    
    /** The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc. */
    @FXML
    private void initialize() {

        // Add an action for the "Open Layout2" button
        btnOpenLayout2.setOnAction(event -> openLayout2());
        
        btnAddToList.setOnAction(event ->{
        	System.out.println("btnAddToList");
        });
    }
    
    //----------------------
    
    /** Performs the action of loading and showing Layout2 */
    private void openLayout2() {

        // Create the second controller, which loads its own FXML file. We pass a reference to this controller
        // using the keyword [this]; that allows the second controller to access the methods contained in here.
        Controller2 controller2 = new Controller2(this);

        //btnOpenLayout2.getScene().getWindow().hide();
        
        // Show the new stage/window
        controller2.showStage();

    }

    //----------------------
    
    /** Returns the text entered into txtToSecondController. This allows other controllers/classes to view that data.*/
    public String getEnteredText() {
        return txtToSecondController.getText();
    }
    
    //----------------------

    /** Allows other controllers to set the text of this layout's Label */
    
    public void setTextFromController2(String text) {
        lblFromController2.setText(text);
    }


}
