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


public class ControllerA {
	
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
    Parent root;

    @FXML
    void initialize() {
    	
    	System.out.println("ControllerA initialize");
    	btnA.setOnAction(event -> showText());
    	lblA.setText(text);
    	
    	toBBtn.setOnAction(event -> goToB());
    }
    
    
   ControllerA(FrameController frameController){
	   controllerB = new ControllerB();
	   this.frameController = frameController;
	   
	   
	    //load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/a.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	
       	root = loader.getRoot(); //get root element 
       	
       	System.out.println("ROOT: " + root);
       	
       	/////////frameController.addRootToScene(root); //add root as child element of frameController scene
       	
       	//++++++++++++++here we call a method in frameController, and pass our loader to it, to stick it in the innerAP
       	///frameController.addToWindow(loader);
	   
   }
    
    private void showText() {
    	text = txtA.getText();
    	lblA.setText(text);
    }
    
    
    private void goToB() {
    	System.out.println("goB");
    
    	frameController.addRootToScene(controllerB.getRoot());
    	frameController.addRootToInnerFrame(controllerB.getRoot());
    }
    
    //==============TRY THIS!! ======================
    //constructor adds loader to scene.
    
    //the button then just clears the inner element of its children and adds the loader's root
    
    Parent getRoot() {
    	return root;
    }
    
    
    
    
    
}
