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
    
    //2 stacks. One for forward moves, one for backward moves:
    Stack<Traversable>forwardMoves = new Stack<Traversable>();
    Stack<Traversable>backwardMoves = new Stack<Traversable>();
    Traversable currController; //currCtrlr
    
    /** #####################################################*/
    
    /** 
     * 
     * I think we can do both moveFrwrds in one method. Have another which stores passed controller as currentCtrlr
     * Then it just calls the moveFrwrd,  which functions the same as the no arg versiopn. (I think!) look inot this :P
     */
    
    //for buttons on controllers to other controllers:
    void moveFwrd(Traversable target) {
    	System.out.println("moveFwrd(Traversable)");
    	
    	//turn on back button:
    	if(btnBack.isDisabled()) { btnBack.setDisable(false); } /** ++++++++++++++++++++++++++++*/
    	
    	currController = target; //currController now points to target
    	
    	System.out.println("current controller is:" + currController);
    	System.out.println("forwardMoves:" + forwardMoves);
    	System.out.println("backwardMoves:" + backwardMoves);
    	
    	//to move to currController: 
    	forwardMoves.push(currController);  /** maybe pop from backwardMoves here instead!! *///take cc & add it to forwards 
    	
    	if((!backwardMoves.isEmpty())) {
    		backwardMoves.pop(); //remove rogue element
        	//turn off fwrd btn if all back options are removed
        	if(backwardMoves.isEmpty()) { btnFwrd.setDisable(true); } //++++++++++++++++++++++++++++
    	}
    	
    	/*
    	//if backwards moves isn't empty AND cc is in backwards, then remove it:
    	if((!backwardMoves.isEmpty()) && (backwardMoves.peek().equals(currController))) {
    		System.out.println("POP");
    		backwardMoves.pop(); //remove rogue element
        	//turn off fwrd btn if all back options are removed
        	if(backwardMoves.isEmpty()) { btnFwrd.setDisable(true); } //++++++++++++++++++++++++++++
    	}*/
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    //for frwrd button on frameController:
    void moveFwrd() {
    	System.out.println("moveFwrd");
    	
    	//turn on back button:
    	if(btnBack.isDisabled()) { btnBack.setDisable(false); } /** ++++++++++++++++++++++++++++*/
    	
    	//we need to grab the new forwrd controller from the backsStack:
    	forwardMoves.push(backwardMoves.pop());
    	currController = forwardMoves.peek();//change cc to point to new top of frwrdMoves
    	
    	//disable fwrd btn as you've reached end of traversed path:
    	if(backwardMoves.isEmpty()) { btnFwrd.setDisable(true); } /** ++++++++++++++++++++++++++++*/
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    
    void moveBkwrd() {
    	System.out.println("moveBkwrd");
    	
    	//turn on frwrd btn:
    	if(btnFwrd.isDisabled()) { btnFwrd.setDisable(false); } /** ++++++++++++++++++++++++++++*/
    	
    	//grab currentController & move it to the backwards pile:
    	backwardMoves.push(forwardMoves.pop());
    	currController = forwardMoves.peek(); //change cc to point to new top of frwrdMoves
    	
    	//disable back btn if currController is now last element in stack:
    	if (forwardMoves.size() == 1){ btnBack.setDisable(true); } /** ++++++++++++++++++++++++++++*/
    		
    	System.out.println("current controller is:" + currController);
    	System.out.println("forwardMoves:" + forwardMoves);
    	System.out.println("backwardMoves:" + backwardMoves);
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    /** #####################################################*/
 
    @FXML
    void initialize() {
    	
    	btnBack.setOnAction(event -> moveBkwrd()); 
    	btnFwrd.setOnAction(event -> moveFwrd()); 
    	btnBack.setDisable(true); //set as initially disable
    	btnFwrd.setDisable(true); //set as initially disable
    }
    
    
    public FrameController(){
    	
    	controllerA = new ControllerA(this); //instantiate controllerA
    	forwardMoves.push(controllerA); //add logged controller as first element
    	
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
        
        
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        //on successful login, do this (obv stick a method somewhere! :P )
        
        addRootToInnerFrame(controllerA.getRoot()); //add cotrollerA fxml to innerFrame
        System.out.println("Start of forwardMoves: " + forwardMoves);
    	//+++++++++++++++++++++++++++++++++++++++++++++++++++
        
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        stage.showAndWait(); //show stage
        ///addRootToScene(controllerA.getRoot()); //add controllerA root to scene
    }
    
    
    //add root to children of scene: ///////////THIS I THINK is needed for external windows!! 
    void addRootToScene(Parent root) {
		((AnchorPane) scene.getRoot()).getChildren().add(root); 
	}
	
	
    //add root to inner anchorPane
	void addRootToInnerFrame(Parent root){
		frameInnerAP.getChildren().setAll(root);
	}
	
	
    
    /** +++++++++++++++++++++++++++++++++++++++++++++++++++++++ HAVE A LOGOUT BUTTON! +++++++++++++++++++++ */
   
    
}

