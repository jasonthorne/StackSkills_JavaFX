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
    
    @FXML
    private JFXButton toB2Btn;
    
    //==================================
    //make these a list of Traversables?????????????????
    private  ControllerC controllerC;
    private  ControllerB2 controllerB2; 
    //=================================
    
    private  FrameController frameController; 
    private Parent root;
   
    
 
    @FXML
    void initialize() {
    	toCBtn.setOnAction(event -> goToC());
    	toB2Btn.setOnAction(event -> goToB2());
    }
    
    //constructor:
    ControllerB(FrameController frameController){
    	
    	controllerC = new ControllerC(frameController);
    	controllerB2 = new ControllerB2(frameController);
  	   	this.frameController = frameController;
    	
    	
    	//load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/b.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	root = loader.getRoot(); //get root element 
       	
       	
    }
    
   
    @Override
   	public Parent getRoot() { return root; }
       
    private void goToC() {
    	frameController.moveFwrd(controllerC);
    }

    
    private void goToB2() { 
    	frameController.moveFwrd(controllerB2);
    }


	


    
    
    
    
    
}
