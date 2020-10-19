package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

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
    
	ControllerC(FrameController frameController){
		 
		this.frameController = frameController;
		
		//load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/c.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	root = loader.getRoot(); //get root element 
       	
      
    	
		
	}
	
	
	@Override
	public Parent getRoot() { return root; }
	

}
