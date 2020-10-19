package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


//public class ControllerA implements Visitable { ////=======================LOGIN PAGE
public class ControllerA implements Traversable {	
	
	String text;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane aAP;

    @FXML
    private Label lblA;

    @FXML
    private JFXButton btnA;
    
    @FXML
    private JFXButton toBBtn;

    @FXML
    private JFXTextField txtA;
    
    
    private final ControllerB controllerB; //????????????
    private final FrameController frameController; 
    
    ////FXMLLoader loader;
    private Parent root;

    @FXML
    void initialize() {
    	
    	btnA.setOnAction(event -> showText());
    	lblA.setText(text);
    	toBBtn.setOnAction(event -> goToB());
    }
    
    
   ControllerA(FrameController frameController){
	   controllerB = new ControllerB(frameController);
	   this.frameController = frameController;
	   
	   
	    //load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/a.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	
       	root = loader.getRoot(); //get root element 
       	
      
       	
       	/////////frameController.addRootToScene(root); //add root as child element of frameController scene
       	
       	//++++++++++++++here we call a method in frameController, and pass our loader to it, to stick it in the innerAP
       	///frameController.addToWindow(loader);
	   
   }
    
    private void showText() {
    	text = txtA.getText();
    	lblA.setText(text);
    	
    }
    
   
    
    private void goToB() { //mimicing LOGGED IN
    
    	//frameController.setTraversable(controllerB);
    	frameController.moveForward2(controllerB);
    	
    }
    
   
    
    @Override
   	public Parent getRoot() { return root; }

  
	public boolean getHasVisited() {
		return false;
	}

	
	public void setHasVisited() {
		//hasVisited = true;
	}
    
    
    
    
    
}
