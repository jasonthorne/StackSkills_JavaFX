package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControllerB {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane bAP;

    @FXML
    void initialize() {
      

    }
    
    
    Parent root;
    
    //constructor:
    ControllerB(){
    	
    	//load the fxml file:
       	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/b.fxml"));
      
       	//set this class as the controller:
       	loader.setController(this);
       	
       	try {
			loader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
		 
       	root = loader.getRoot(); //get root element 
       	
       	System.out.println("ROOT: " + root);
    	
    }
    
    Parent getRoot() {
    	return root;
    }
    
    
    
    
    
    
    
    
}
