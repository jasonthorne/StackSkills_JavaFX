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
    	
    	System.out.println("ControllerA initialize");
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
       	
       	System.out.println("ROOT: " + root);
       	
       	/////////frameController.addRootToScene(root); //add root as child element of frameController scene
       	
       	//++++++++++++++here we call a method in frameController, and pass our loader to it, to stick it in the innerAP
       	///frameController.addToWindow(loader);
	   
   }
    
    private void showText() {
    	text = txtA.getText();
    	lblA.setText(text);
    	
    }
    
   
    
    private void goToB() { //mimicing LOGGED IN
    	
    	System.out.println("this.hashCode():"  + this.hashCode()); 
    	
    	frameController.setDisableBackBtn(false); //turn on back btn (as this is first advancement)
    	//frameController.addVisitableController(controllerB);
    	
    	frameController.moveForward(controllerB);
    	
    	////frameController.addRootToScene(controllerB.getRoot()); /////////////////////POTENTIAL ISSUE HERE (when this is pressed a second time) ++++++++++++++++++++
    	////////////frameController.addRootToInnerFrame(controllerB.getRoot());
    	
    	
    	/*
    	frameController.setDisableBackBtn(false); //turn on back btn (as this is first advancement)
    	
    	frameController.setCurrentRoot(controllerB.getRoot()); //set b as currentRoot
    	frameController.setHasVisitedCurrent(controllerB.getHasVisited()); //set whether root has been visited
    	
    	
    	//-----------------have this in an interface --------------------------
    	if(!controllerB.getHasVisited()) { //if haven't visited yet
    		controllerB.setHasVisited(); //mark as visited 
    		frameController.setDisableFrwdBtn(true);//disable forward btn (as now at farthest point)
    	}else {
    		frameController.setDisableFrwdBtn(false); //enable forward btn
    		frameController.setFutureRoot(controllerB.getRoot()); //set forward button to go to B
    	}
    	
    	frameController.setPastRoot(root); //set back button to go back here
    	*/
    	
    
    	
    	
    }
    
    //==============TRY THIS!! ======================
    //constructor adds loader to scene.
    
    //the button then just clears the inner element of its children and adds the loader's root
    
    @Override
   	public Parent getRoot() { return root; }

  
	public boolean getHasVisited() {
		return false;
	}

	
	public void setHasVisited() {
		//hasVisited = true;
	}
    
    
    
    
    
}
