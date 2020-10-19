package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControllerB implements Traversable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane bAP;
    @FXML
    private JFXButton toCBtn;
    
    private  ControllerC controllerC; 
    private  FrameController frameController; 
    
    private Parent root;
    private boolean hasVisited = false;
    
 
    @FXML
    void initialize() {
    	toCBtn.setOnAction(event -> goToC());
    }
    
   
    //constructor:
    ControllerB(FrameController frameController){
    	
    	controllerC = new ControllerC(frameController);
  	   	this.frameController = frameController;
    	
    	
    	//load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/b.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	root = loader.getRoot(); //get root element 
       	
       	System.out.println("ROOT: " + root);
    }
    
   
    @Override
   	public Parent getRoot() { return root; }
       
    private void goToC() {
    	
    	frameController.setTraversable(controllerC);
    	frameController.moveForward();
    
    	////////frameController.addRootToScene(controllerC.getRoot()); /////////////////////POTENTIAL ISSUE HERE (when this is pressed a second time) ++++++++++++++++++++
    	///////frameController.addRootToInnerFrame(controllerC.getRoot());
    	
    }


 


	


    
    
    
    
    
}
