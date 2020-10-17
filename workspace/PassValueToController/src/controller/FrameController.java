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

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane frameOuterAP;
    @FXML
    private AnchorPane frameInnerAP;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnFwrd;
    
    private final ControllerA controllerA;
    ///private final ControllerB controllerB;
    private FrameInterface currentController;
    
  	private final Stage stage;
    private Scene scene;
    
    private Parent backRoot;
    private Parent forwardRoot;
    private Parent currentRoot;
    
    @FXML
    void initialize() {
    	
    	btnBack.setOnAction(event -> goBack()); 
    	///btnBack.setDisable(true); //set as initially disable
    	btnFwrd.setOnAction(event -> goFwrd());
    	///btnFwrd.setDisable(true); //set as initially disable
    }
    
    
    public FrameController(){
    	
    	System.out.println("const");
    	
    	 // Create the new stage
        stage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/frame.fxml"));
        	loader.setController(this);//set this class as the controller
        	scene = new Scene(loader.load()); //load fxml into scene
        	stage.setScene(scene); //add scene to stage
        	stage.setTitle("FrameController"); //set the title:
        	/////thisStage.showAndWait();
        	
        }catch (IOException e) { e.printStackTrace(); }
        
        controllerA = new ControllerA(this); //instantiate controllerA
    	addRootToInnerFrame(controllerA.getRoot()); //add cotrollerA fxml to innerFrame
    	
    	//disable fwrd & back btn:
    	setDisableBackBtn(true);
    	setDisableFrwdBtn(true);
        
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        stage.showAndWait(); //show stage
        addRootToScene(controllerA.getRoot()); //add controllerA root to scene
    }
    
    
    
    void addRootToScene(Parent root) {
		((AnchorPane) scene.getRoot()).getChildren().add(root); //add root to children of scene
	}
	
	
	void addRootToInnerFrame(Parent root){
		frameInnerAP.getChildren().setAll(root);
	}
  
    void setBackRoot(Parent root) {
    	backRoot = root;
    }
    
    void setForwardRoot(Parent root) {
    	forwardRoot = root;
    }
    
    void setCurrentRoot(Parent root) {
    	currentRoot = root;
    }
    
    
    private void goBack() { 
    	
    	forwardRoot = currentRoot; //change forwrdRoot to point to currentRoot
    	addRootToInnerFrame(backRoot); //navigate to backRoot
    }
    
    private void goFwrd() { 
    	
    	addRootToInnerFrame(forwardRoot); 
    	
    	//-----------------have this in an interface --------------------------
    	//if(!forwardRoot) { //if haven't visited yet
    		//controllerB.setHasVisited(); //mark as visited 
    		//frameController.setDisableFrwdBtn(true);//disable forward btn (as now at farthest point
    //	}
    	
    	
    	currentRoot = forwardRoot; //currentRoot now becomes forwrdRoot
    	
    }
    
    void setDisableFrwdBtn(boolean bool){
    	btnFwrd.setDisable(bool);
    }
    
    void setDisableBackBtn(boolean bool){
    	btnBack.setDisable(bool);
    }
    	
    
    <T>void setCurrentController(FrameInterface frameInterface) {
    	this.currentController = frameInterface;
    	
    	
    	
    	//==========methods here for adding root to scene and root to inner frame 
    	
    	
    	//print();
    	
    }
    
    /*
    void print() {
    	frameInterface.printHasVisited();
    }
    */
    
    
    
    
    
    
    
    
    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++ HAVE A LOGOUT BUTTON! +++++++++++++++++++++ */
    //++++++++++++++++++++++++++++++++HAVE BOOLEANS HERE FOR DECIDING THIS ISNSTEAD. 
   // void enableNavBtns() {
    //	btnBack.setDisable(false); 
    //	btnFwrd.setDisable(false); //set as initially disable
  //  }
    
/*
	public void showB(){
		System.out.println("b");
		    
		//create loader for b.fxml
		FXMLLoader apB = new FXMLLoader(getClass().getResource("/view/b.fxml"));
		
		apB.setController(controllerB); //set controller
		
		//------------------
	
		try {
			
			//scene2 = new Scene(apA.load()); //load a.fxml into scene2 
			apB.load(); //load fxml tree
			Parent root = apB.getRoot(); //get root element 
			((AnchorPane) scene.getRoot()).getChildren().add(root);  //add root to children of scene
			//.setAll() clears the children and replaces them with root element and it's subsequent children. 
			frameInnerAP.getChildren().setAll(root); 
			
		} catch (IOException e1) {e1.printStackTrace();}
		
		//-----------------
    }*/
    
 
	
	
	
	
    
}

