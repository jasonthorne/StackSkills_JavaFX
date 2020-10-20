package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControllerB2 implements Traversable{
	
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private AnchorPane b2AP;

	    @FXML
	    void initialize() {
	     
	    }
	    
	    private  FrameController frameController; 
	    private Parent root;
	    
	    ControllerB2(FrameController frameController){
	    	
	    	this.frameController = frameController;
	    	
	    	//load the fxml file:
	       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/b2.fxml"));
	      
	       	//set this class as the controller:
	       	loader.setController(this);
	       	
	       	try {
				loader.load(); //load fxml tree
			} catch (IOException e) { e.printStackTrace(); }
			 
	       	root = loader.getRoot(); //get root element 
	    	
	    }

		@Override
		public Parent getRoot() {
			return root;
		}
}
