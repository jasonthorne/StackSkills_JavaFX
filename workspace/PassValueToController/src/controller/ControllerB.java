package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControllerB /*implements FrameInterface*/ {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane bAP;
    
    @FXML
    private JFXButton toCBtn;
    
    
    private final ControllerC controllerC; //????????????
    private final FrameController frameController; 
    
    private Parent root;
    private boolean hasVisited = false;
    
 
   

    @FXML
    void initialize() {
    	toCBtn.setOnAction(event -> goToC());
    	
    	System.out.println("B init");

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
       	
       	//------------------------------------
       	////addToFrameController();
       	//===============================
    	
    }
    
    Parent getRoot() { return root; }
    	
    boolean getHasVisited() { return hasVisited; }
    void setHasVisited() { hasVisited = true; }
    	
   
    
    private void goToC() {
    	
    	///addToFrameController(); //++++++++++++++++++
    	
    	frameController.setCurrentRoot(controllerC.getRoot()); //set c as currentRoot
    
    	//-----------------have this in an interface --------------------------
    	if(!controllerC.getHasVisited()) { //if haven't visited yet
    		controllerC.setHasVisited(); //mark as visited 
    		frameController.setDisableFrwdBtn(true);//disable forward btn (as now at farthest point)
    	}else {
    		frameController.setDisableFrwdBtn(false); //enable forward btn
    		frameController.setForwardRoot(controllerC.getRoot()); //set forward button to go to B
    	}
    	
    	frameController.setBackRoot(root); //set back button to go back here
    	
    
    	frameController.addRootToScene(controllerC.getRoot()); /////////////////////POTENTIAL ISSUE HERE (when this is pressed a second time) ++++++++++++++++++++
    	frameController.addRootToInnerFrame(controllerC.getRoot());
    	
    	/*
    	 * when you hit the back btn: change frwrd root to point to this root (current backRoot)
    	 * 
    	 * 
    	frameController.setBackRoot(this.root); //set back button to go back here
    	frameController.setForwardRoot(controllerC.getRoot()); //set forward button to go to B
    	frameController.addRootToScene(controllerC.getRoot()); /////////////////////POTENTIAL ISSUE HERE (when this is pressed a second time) ++++++++++++++++++++
    	frameController.addRootToInnerFrame(controllerC.getRoot());
    	*/
    }



	


    
    
    
    
    
}
