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
    private MySpecialInterface currentController;
    
  	private final Stage stage;
    private Scene scene;
    
    private Parent pastRoot;
    private Parent futureRoot;
    private Parent currentRoot; //????
    
    private boolean hasVisitedCurrent;
    		
    
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
  
    void setPastRoot(Parent root) {
    	pastRoot = root;
    }
    
    void setFutureRoot(Parent root) {
    	futureRoot = root;
    }
    
    void setCurrentRoot(Parent root) {
    	currentRoot = root;
    }
    
    void setHasVisitedCurrent(boolean bool) {
    	hasVisitedCurrent = bool;
    }
    
    private void goBack() { 
    	
    	futureRoot = currentRoot; //change forwrdRoot to point to currentRoot
    	addRootToInnerFrame(pastRoot); //navigate to backRoot
    }
    
    void goFwrd() {
    	
    	if(!currentController.getHasVisited()) { //if haven't visited yet
    		currentController.setHasVisited(); //mark as visited
    		btnFwrd.setDisable(true); //disable forward btn (as now at farthest point)
    	}else {
    		btnFwrd.setDisable(false); //enable forward button
    		//++++++this guy has to hasve a memory of what the future root is! 
    	}
    		//HERE's OUR ISSUE! :
    		////controllerB.setHasVisited(); //mark as visited 
    	
    		
    		
    		//=========================================
    		addRootToInnerFrame(futureRoot); 
    	currentRoot = futureRoot; //currentRoot now becomes forwrdRoot
    	
    }
    
    void setDisableFrwdBtn(boolean bool){ //++++++++++++CAN PROB BE PRIVATE!!
    	btnFwrd.setDisable(bool);
    }
    
    void setDisableBackBtn(boolean bool){
    	btnBack.setDisable(bool);
    }
    	
    
    <T>void setCurrentController(MySpecialInterface frameInterface) {
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

