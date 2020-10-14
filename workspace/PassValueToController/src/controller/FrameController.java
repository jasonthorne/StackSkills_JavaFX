package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FrameController {

	
	//holds the controller's stage:
  	private final Stage thisStage;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane frameOuterAP;
    @FXML
    private AnchorPane frameInnerAP;
    @FXML
    private JFXButton btnA;
    @FXML
    private JFXButton btnB;
    
    @FXML
    void initialize() {
    	btnA.setOnAction(event -> showA());
    	btnB.setOnAction(event -> showB());
    }
    
    
    public FrameController(){
    	
    	 // Create the new stage
        thisStage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/frame.fxml"));
        	//set this class as the controller:
        	loader.setController(this);
        	//load the scene:
        	thisStage.setScene(new Scene(loader.load()));
        	//set the title:
        	thisStage.setTitle("FrameController");
        	/////thisStage.showAndWait();
        	
        }catch (IOException e) { e.printStackTrace(); }
            
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    
    /** ----------------------showing A or B------------- */
    public void showA(){
    	System.out.println("a");
    }
    
    
    public void showB(){
    	System.out.println("b");
    }
    
    
    /** ----------------------showing A or B------------- */
    
}

