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

	
	//holds the controller's stage:
  	private final Stage thisStage;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane frameOuterAP;
    @FXML
    private AnchorPane frameInnerAP;
    @FXML
    private JFXButton btnA;
    @FXML
    private JFXButton btnB;
    
    private final ControllerA controllerA;
    //private final ControllerB controllerB;
    
    private Scene scene;
    
    
    
    @FXML
    void initialize() {
    	btnA.setOnAction(event -> showA());
    	//btnB.setOnAction(event -> showB());
    }
    
    
    public FrameController(){
    	
    	System.out.println("const");
    	controllerA = new ControllerA(this); //initialze controller
    	///controllerB = new ControllerB(); //initialze controller
    	
    	 // Create the new stage
        thisStage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/frame.fxml"));
        	//set this class as the controller:
        	loader.setController(this);
        	
        	//load the scene:
        	scene = new Scene(loader.load()); //????????????????????
        	
        	//load the scene:
        	//////thisStage.setScene(new Scene(loader.load()));
        	
        	//add scene to stage:
        	thisStage.setScene(scene); //??????????????????????
        	//set the title:
        	thisStage.setTitle("FrameController");
        	/////thisStage.showAndWait();
        	
        }catch (IOException e) { e.printStackTrace(); }
        
       
    	////controllerA = new ControllerA(this); //initialze controller
    	///addRootToScene(controllerA.getRoot());
    	
    	///controllerB = new ControllerB(); //initialze controller
            
    }
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
        addRootToScene(controllerA.getRoot()); ////??????? sloppy having this here :P
    }
    
    
    /** ----------------------showing A or B------------- */
    public void showA(){
    	System.out.println("a");
    	
    	
    	System.out.println(" FrameController. BUTTON A.");
    	
    	System.out.println(frameInnerAP.getChildren());
    	addRootToInnerFrame(controllerA.getRoot());
    	
    	
    	
    	
    	/*
    	//====================
    	
		//create loader for a.fxml
		FXMLLoader apA = new FXMLLoader(getClass().getResource("/view/a.fxml"));
		
		apA.setController(controllerA); //set controller
		//================
		//------------------
	
		try {
			
			//scene2 = new Scene(apA.load()); //load a.fxml into scene2 
			apA.load(); //load fxml tree
			Parent root = apA.getRoot(); //get root element 
			((AnchorPane) scene.getRoot()).getChildren().add(root);  //add root to children of scene
			//.setAll() clears the children and replaces them with root element and it's subsequent children.
			frameInnerAP.getChildren().setAll(root); 
			
		} catch (IOException e1) {e1.printStackTrace();}
		
		*/
		//-----------------
		
	
		
		
    }
    
    
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
    
    
    /** ----------------------showing A or B------------- */
	
	
	/** ============================show any controller ===================== */
	
	void addToWindow(FXMLLoader loader) {
		
		
			System.out.println(" controllerA. BUTTON B.");
			
			try {
				loader.load(); //load fxml tree
				
				/*
				if((((AnchorPane) scene.getRoot()).getChildren()).remove(loader.getRoot())){
					System.out.println("loader was present");
					System.out.println(((AnchorPane) scene.getRoot()).getChildren());
				}else {
				*/
					Parent root = loader.getRoot(); //get root element 
					
					((AnchorPane) scene.getRoot()).getChildren().add(root);  //add root to children of scene
					
					System.out.println("frameInner B4 add: " + frameInnerAP.getChildren());
					
					frameInnerAP.getChildren().clear(); //+++++++++++++++++ :(
					
					/** .setAll() clears the children and replaces them with root element and it's subsequent children. */
					frameInnerAP.getChildren().setAll(root);
					
					System.out.println("frameInner AFTER add: " + frameInnerAP.getChildren());
					
					
					System.out.println(((AnchorPane) scene.getRoot()).getChildren());
					System.out.println(((AnchorPane) scene.getRoot()));
				//}
			} catch (IOException e) {e.printStackTrace();}
			
		
	}
	
	
	
	void addRootToScene(Parent root) {
		((AnchorPane) scene.getRoot()).getChildren().add(root); 
	}
	
	
	void addRootToInnerFrame(Parent root){
		frameInnerAP.getChildren().setAll(root);
	}
	
	
    
}

