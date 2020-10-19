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
    
    //for controller buttons to set traversable
    void setTraversable(Traversable traversable){
    	this.currController = traversable;
    }
    
    //for frame forward button to set traversable:
    void setTraversable() {
    	currController = backwardMoves.peek();
    }
    
    /** #####################################################*/
    
    //for buttons on controllers to other controllers:
    void moveForward2(Traversable target) {
    	
    	currController = target; //currController now points to target
    	
    	System.out.println("move frwrd2(Traversable)");
    	System.out.println("current controller is:" + currController);
    	
    	//to move to currController: 
    	forwardMoves.push(currController); //take cc & add it to forwards
    	System.out.println("forwardMoves:" + forwardMoves);
    	System.out.println("backwardMoves:" + backwardMoves);
    	
    	//if backwards moves isn't empty AND cc is in backwards, then remove it:
    	if((!backwardMoves.isEmpty()) && (backwardMoves.peek().equals(currController))) {
    		System.out.println("yo!");
    		backwardMoves.pop(); //remove rogue element
    		System.out.println("forwardMoves:" + forwardMoves);
        	System.out.println("backwardMoves:" + backwardMoves);
        	System.out.println("current controller is:" + currController);
    	}
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    //for frwrd button on frameController:
    void moveForward2() {
    	System.out.println("move frwrd2");
    	//currController = target; //currController now points to target
    	//this will only be turned on IF there is an option to go forward (ie a back has been added to backs)
    	
    	//we need to grab the new forwrd controller from the bakcsStack:
    	forwardMoves.push(backwardMoves.pop());
    	currController = forwardMoves.peek();//change cc to point to new top of frwrdMoves
    	
    	System.out.println("current controller is:" + currController);
    	
    	//to move to currController: 
    	//forwardMoves.push(currController); //take cc & add it to forwards
    	System.out.println("forwardMoves:" + forwardMoves);
    	System.out.println("backwardMoves:" + backwardMoves);
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    
    void moveBackward2() {
    	System.out.println("moveBackward2");
    	
    	//grab currentController & move it to the backwards pile:
    	backwardMoves.push(forwardMoves.pop());
    	currController = forwardMoves.peek(); //change cc to point to new top of frwrdMoves
    	
    	System.out.println("current controller is:" + currController);
    	System.out.println("forwardMoves:" + forwardMoves);
    	System.out.println("backwardMoves:" + backwardMoves);
    	
    	//show currController:
    	/** addRootToScene(currController.getRoot()); //add root to scene  this MIGHT still be needed later!*/
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    /** #####################################################*/
 
    void moveForward() {
    	//try add to forwardMoves:
    	
    	
    	
    	//turn on back button
    	if(btnBack.isDisabled()) { btnBack.setDisable(false); }
    	
		//FIRST: check backwardMoves isnt empty: 
		if(!backwardMoves.isEmpty()) {
			System.out.println("A");
			
			//check if it exists at top of backwardMoves:
			//if it doesn't:
			if(!backwardMoves.peek().equals(currController)) { 
				
				System.out.println("B - A");
				System.out.println("TRAVERSABLE 1:" + currController );
		    	System.out.println("BACKWARD MOVES:" + backwardMoves );
		    	System.out.println("FORWARD MOVES:" + forwardMoves );
		    	
		    	//------------------------------------------
		    	
		    	//i want to become a b!! here! 
		    	currController = backwardMoves.pop(); ///???????????
		    	//traversable = backwardMoves.peek(); ///???????????
		    	
		    	//add controller to forwardMoves:
				forwardMoves.push(currController);
				
				//clear backwardMoves & disable frwrd btn (as you're on a new fork)
				//backwardMoves.clear(); //////////////// miGHT NEED TO DO SOMETHING HERE!! 
				btnFwrd.setDisable(true); //??????????????????????????guess!
				
				//----------------------------------------
				
				System.out.println("B - B");
				System.out.println("TRAVERSABLE:" + currController );
		    	System.out.println("BACKWARD MOVES:" + backwardMoves );
		    	System.out.println("FORWARD MOVES:" + forwardMoves );
		    	
			}else { //if it does equal top of backwardMoves:
				
				//pop element onto forwardMoves
				forwardMoves.push(backwardMoves.pop());
				//btnFwrd.setDisable(true); //???????????????????????????????guess!
				System.out.println("C");
				System.out.println("TRAVERSABLE:" + currController );
		    	System.out.println("BACKWARD MOVES:" + backwardMoves );
		    	System.out.println("FORWARD MOVES:" + forwardMoves );
			}
		}else { //backwardMoves is empty:
			System.out.println("D");
			//new path, so add to forwardMoves:
			forwardMoves.push(currController);
			btnFwrd.setDisable(true); //???????????????????????????????guess!
			System.out.println("TRAVERSABLE:" + currController );
	    	System.out.println("BACKWARD MOVES:" + backwardMoves );
	    	System.out.println("FORWARD MOVES:" + forwardMoves );
		}
	
		addRootToScene(currController.getRoot()); //add root to scene
		addRootToInnerFrame(currController.getRoot()); //add root to frame
    }
    
    void moveBackward() {
    	
    	//turn on forward button
    	if(btnFwrd.isDisabled()) { btnFwrd.setDisable(false); }
    	
    	//System.out.println("MOVEBACKWARD:" );
    	//System.out.println("backStack: " + backwardMoves );
    	//System.out.println("forwardStack:" + forwardMoves);
    	
    	//remove traversable from forwardMoves, & add to backwardMoves:
    	backwardMoves.push(forwardMoves.pop());
    	
    	System.out.println("TRAVERSABLE:" + currController );
    	System.out.println("BACKWARD AFTER PUSH:" + backwardMoves );
    	System.out.println("FORWARD AFTER PUSH:" + forwardMoves );
    	
		//change traversable to be next item in forwardMoves:
    	currController = forwardMoves.peek();
    	
		//add new traversable to frame:
		addRootToInnerFrame(currController.getRoot()); 
    	
    	//if this is last element in stack:
    	if (forwardMoves.size() == 1){
    		btnBack.setDisable(true); //disable back btn
    		//setDisableFrwdBtn(true); //disable fwrd btn
		}
    }
    
   
    @FXML
    void initialize() {
    	
    	btnBack.setOnAction(event -> moveBackward2()); 
    	//btnBack.setOnAction(event -> moveBackward()); 
    	/*btnFwrd.setOnAction(event -> {
    		currController = backwardMoves.peek();
    		moveForward();
    	});*/
    	btnFwrd.setOnAction(event -> moveForward2()); 
    	//btnBack.setDisable(true); //set as initially disable
    	//btnFwrd.setDisable(true); //set as initially disable
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

