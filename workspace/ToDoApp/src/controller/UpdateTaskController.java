package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class UpdateTaskController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField taskField;

    @FXML
    private JFXTextField descriptionField;

    @FXML
    private JFXButton saveTaskBtn;

    @FXML
    void initialize() {
    	
    	

    }
    
    //-------------------------------------------------
    //setters for cell controller
    
    void setTaskField(String task) {
    	this.taskField.setText(task); //set taskField
    }
    
    void setDescriptionField(String desc) {
    	this.descriptionField.setText(desc); //set descriptionField
    }
    
    //getters for cell controller
    String getTaskField() {
    	return this.taskField.getText(); //get taskField
    }
    
    String getDescriptionField() {
    	return this.descriptionField.getText(); //get descriptionField
    }
    
    //------------------------------------------------
    //getter for update btn (for cell controller) +++++++++++++++++++++
    JFXButton getSaveTaskBtn() {
    	return this.saveTaskBtn;
    }
    
    
}
