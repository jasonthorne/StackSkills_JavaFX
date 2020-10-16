package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;


public class ControllerA {
	
	String text;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane aAP;

    @FXML
    private Label lblA;

    @FXML
    private JFXButton btnA;

    @FXML
    private JFXTextField txtA;

    @FXML
    void initialize() {
    	
    	System.out.println("yo");
    	btnA.setOnAction(event -> showText());
    	lblA.setText(text);
    }
    
    
   //ControllerA(){
	  // initialize();
   //}
    
    public void showText() {
    	
    	text = txtA.getText();
    	lblA.setText(text);
    }
    
    
    
    
    
    
    
    
    
    
}
