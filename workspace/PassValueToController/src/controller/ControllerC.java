package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

//public class ControllerC implements Visitable {
public class ControllerC implements Traversable {
	
	@FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane cAP;
    
    @FXML
    void initialize() {
    	//frameController.addRootToScene(root); //+++++++++++++++

    }
	
    private final FrameController frameController; 
    
    private Parent root;
    private boolean hasVisited = false;

   
	ControllerC(FrameController frameController){
		 
		this.frameController = frameController;
		System.out.println("this.hashCode():"  + this.hashCode()); 
		
		//load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/c.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	root = loader.getRoot(); //get root element 
       	
       	System.out.println("ROOT: " + root);
    	
		
	}
	
	
	@Override
	public Parent getRoot() { return root; }
	
    public boolean getHasVisited() { return hasVisited; }
    public void setHasVisited() { hasVisited = true; }

   

}
