package controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    
    private final ControllerA controllerA;
    private final ControllerB controllerB;
    
    private Scene scene;
    
    
    
    @FXML
    void initialize() {
    	btnA.setOnAction(event -> showA());
    	btnB.setOnAction(event -> showB());
    }
    
    
    public FrameController(){
    	
    	System.out.println("const");
    	controllerA = new ControllerA(); //initialze controller
    	controllerB = new ControllerB(); //initialze controller
    	
    	 // Create the new stage
        thisStage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/frame.fxml"));
        	//set this class as the controller:
        	loader.setController(this);
        	
        	//load the scene:
        	scene = new Scene(loader.load()); //????????????????????
        	
        	//load the scene:
        	//////thisStage.setScene(new Scene(loader.load()));
        	
        	//add scene to stage:
        	thisStage.setScene(scene); //??????????????????????
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
    	
		//create loader for a.fxml
		FXMLLoader apA = new FXMLLoader(getClass().getResource("/view/a.fxml"));
		
		apA.setController(controllerA); //set controller
		
		//------------------
	
		try {
			
			//scene2 = new Scene(apA.load()); //load a.fxml into scene2 
			apA.load(); //load fxml tree
			Parent root = apA.getRoot(); //get root element 
			((AnchorPane) scene.getRoot()).getChildren().add(root);  //add root to children of scene
			/** .setAll() clears the children and replaces them with root element and it's subsequent children. */
			frameInnerAP.getChildren().setAll(root); 
			
		} catch (IOException e1) {e1.printStackTrace();}
		
		//-----------------
		
		///((AnchorPane) scene1.getRoot()).getChildren().add(apA.getRoot()); 
		/////((AnchorPane) scene1.getRoot()).getChildren().add(scene2.getRoot()); 
		
		//get and CLEAR the children of rootAnchorPane and add formPane:
		/** .setAll() clears the children and replaces them with root element and it's subsequent children. */
		//frameInnerAP.getChildren().setAll(root); 
		
		
    }
    
    

	public void showB(){
		System.out.println("b");
		    	
		//create loader for b.fxml
		FXMLLoader apB = new FXMLLoader(getClass().getResource("/view/b.fxml"));
		
		try {
			apB.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		
		apB.setController(controllerB); //set controller
		Parent root = apB.getRoot(); //get root element 
		//get and CLEAR the children of rootAnchorPane and add formPane:
		/** .setAll() clears the children and replaces them with root element and it's subsequent children. */
		frameInnerAP.getChildren().setAll(root); 
    }
    
    
    /** ----------------------showing A or B------------- */
    
}

