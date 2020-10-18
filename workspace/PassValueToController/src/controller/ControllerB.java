package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

//public class ControllerB implements Visitable {
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
    	
    	System.out.println("B init");
    	//frameController.addRootToScene(root); //+++++++++++++++
    }
    
    public ControllerB(){
    	
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
       	
       //	frameController.addRootToScene(root); //+++++++++++++++
       	
       	System.out.println("ROOT: " + root);
       	
       	//------------------------------------
       	////addToFrameController();
       	//===============================
    	
    }
    
   
    @Override
   	public Parent getRoot() { return root; }
       
     

    public boolean getHasVisited() { return hasVisited; }
    public void setHasVisited() { hasVisited = true; }
    	
   
    
    private void goToC() { 
    	
    	//frameController.addVisitableController(controllerC);
    	 
    	
    	//frameController.addVisitableController(controllerC);
    	
    	frameController.setTraversable(controllerC);
    	frameController.moveForward();
    	
    	///frameController.goBack(controllerC);
    	
    	/*
    	frameController.setPastRoot(root); //set back button to go back here
    	frameController.setCurrentController(controllerC); //set c controller as new current controller
    	frameController.goFwrd(); //call frameController's goFrwrd method (when going to c, you're going forward!)
    	
    	//==========================================================
    	
    	frameController.setCurrentRoot(controllerC.getRoot()); //set c as currentRoot
    
    	//-----------------have this in an interface --------------------------
    	if(!controllerC.getHasVisited()) { //if haven't visited yet
    		controllerC.setHasVisited(); //mark as visited 
    		frameController.setDisableFrwdBtn(true);//disable forward btn (as now at farthest point)
    	}else {
    		frameController.setDisableFrwdBtn(false); //enable forward btn
    		frameController.setFutureRoot(controllerC.getRoot()); //set forward button to go to B
    	}
    	
    	frameController.setPastRoot(root); //set back button to go back here
    	*/
    
    	////////frameController.addRootToScene(controllerC.getRoot()); /////////////////////POTENTIAL ISSUE HERE (when this is pressed a second time) ++++++++++++++++++++
    	///////frameController.addRootToInnerFrame(controllerC.getRoot());
    	
    }


    /*
	@Override
	public void addToFrameController() {
		// TODO Auto-generated method stub
		
	}*/



	


    
    
    
    
    
}
