package controller;

import com.jfoenix.controls.JFXButton;




import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FrameController extends TEST{
	

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
    
  	private final Stage stage;
    private Scene scene;
    
    
    private Parent pastRoot;
    private Parent currentRoot; //????
    private Parent futureRoot;
   
    
    //2 stacks. One for forward moves, one for backward moves:
    Stack<Traversable>forwardMoves = new Stack<Traversable>();
    Stack<Traversable>backwardMoves = new Stack<Traversable>();
    Traversable traversable;
    
    
    void setTraversable(Traversable traversable){
    	this.traversable = traversable;
    }
    
    //void moveForward(Traversable controller) { //CHANGE TO: moveForward (moveBackward for other)
    void moveForward() {
    	//try add to forwardMoves:
    	
		//FIRST: check backwardMoves isnt empty: 
		if(!backwardMoves.isEmpty()) {
			
			//check if it exists at top of backwardMoves:
			//if it doesn't:
			if(!backwardMoves.peek().equals(traversable)) { 
				
				//clear backwardMoves (as you're on a new fork)
				backwardMoves.clear();
				//add controller to forwardMoves:
				forwardMoves.push(traversable);
				//addRootToInnerFrame(controller.getRoot()); //add root to frame
			}else { //if it does equal top of backwardMoves:
				
				//pop element onto forwardMoves
				forwardMoves.push(backwardMoves.pop());
				
				//if backwardMoves is now empty, disable backwards button:
				if (backwardMoves.isEmpty()){
					setDisableBackBtn(true);
				}
				//addRootToInnerFrame(controller.getRoot()); //add root to frame
			}
		}else { //backwardMoves is empty:
			
			//new path, so add to forwardMoves:
			forwardMoves.push(traversable);
		}
	
		addRootToScene(traversable.getRoot()); //add root to scene
		addRootToInnerFrame(traversable.getRoot()); //add root to frame
    }
    
    void moveBackward() {
    	
    	//remove traversable from forwardMoves, & add to backwardMoves:
    	backwardMoves.push(forwardMoves.pop());
    	
    	//change traversable to be next item in forwardMoves:
    	traversable = forwardMoves.peek();
    	
    	//add new traversable to frame:
    	addRootToInnerFrame(traversable.getRoot()); 
    	
    	//THEN check if stack is now empty:
    		//if so, disable backBtn
    	if (forwardMoves.isEmpty()){
    		setDisableFrwdBtn(true);
		}
    }
    
    
    
    /*	
    void goFwrd() {
    	
    	/*visitableIterator = visitableControllers.listIterator();
    	
    	if(visitableIterator.hasNext()) {
    	
    		Traversable currentController = visitableIterator.next();
    		System.out.println("currentController.hashCode():"  + currentController.hashCode()); 
    		
    		if(!currentController.getHasVisited()) { //if haven't visited yet
    			currentController.setHasVisited(); //mark as visited
    			btnFwrd.setDisable(true); //disable forward btn (as now at farthest point)
    			//chop offf rest of list if present!! +++++++++
    			addRootToScene(currentController.getRoot()); //add root to children of scene
    		}else {
    			btnFwrd.setDisable(false); //enable forward button
    			///anything else????????????
    		}
    		
    		addRootToInnerFrame(currentController.getRoot()); //add cotrollerA fxml to innerFrame
    		
    		
		}
		else {  
			///anything else????????????
		}
    	
    }*/
    
    
    void goBack(Traversable controller) { 
    	
    	
    	//futureRoot = currentRoot; //change forwrdRoot to point to currentRoot
    	//addRootToInnerFrame(pastRoot); //navigate to backRoot
    	backwardMoves.add(controller);
    	
    	checkTest();
    		
    	
    }
    
    
    //======================================================================
    void checkTest() {
    	if(forwardMoves.peek() == (backwardMoves).peek()) {
    		System.out.println("SAME");
    	}else {
    		System.out.println("NOT SAME");
    	}
    }
    
    @FXML
    void initialize() {
    	
    	//btnBack.setOnAction(event -> goBack()); 
    	btnBack.setDisable(true); //set as initially disable
    	/////btnFwrd.setOnAction(event -> goFwrd(Traversable nextController));
    	btnFwrd.setDisable(true); //set as initially disable
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
    	//setDisableBackBtn(true);
    	//setDisableFrwdBtn(true);
        
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
	
	
	 void setDisableBackBtn(boolean bool){ btnBack.setDisable(bool); }
	 void setDisableFrwdBtn(boolean bool){ btnFwrd.setDisable(bool); }
  
	/*
    void setPastRoot(Parent root) { pastRoot = root; }
    void setCurrentRoot(Parent root) { currentRoot = root; }
    void setFutureRoot(Parent root) { futureRoot = root; }
  
    
    void setHasVisitedCurrent(boolean bool) {
    	hasVisitedCurrent = bool;
    }
     */
	
	
    ///private void goBack() { 
    	
    	//futureRoot = currentRoot; //change forwrdRoot to point to currentRoot
    	//addRootToInnerFrame(pastRoot); //navigate to backRoot
    //}
    
	/* void goFwrd() {
    	
    
    	if(!currentController.getHasVisited()) { //if haven't visited yet
    		currentController.setHasVisited(); //mark as visited
    		btnFwrd.setDisable(true); //disable forward btn (as now at farthest point)
    	}else {
    		btnFwrd.setDisable(false); //enable forward button
    
    	}*/
    		
    		
    		
    		//=========================================
    		//addRootToInnerFrame(futureRoot); 
    		//currentRoot = futureRoot; //currentRoot now becomes forwrdRoot
    	
	/* }
    
    /*
    void setDisableFrwdBtn(boolean bool){ //++++++++++++CAN PROB BE PRIVATE!!
    	btnFwrd.setDisable(bool);
    }
    
    void setDisableBackBtn(boolean bool){
    	btnBack.setDisable(bool);
    }
    	
    
    <T>void setCurrentController(MySpecialInterface frameInterface) {
    	this.currentController = frameInterface;
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

