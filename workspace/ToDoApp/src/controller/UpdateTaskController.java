package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

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
    
    /*
    void test() {
    	
    	System.out.println("updateTaskController TEST");
    	//load fxml tree from updateTaskForm.fxml
	   	FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/view/list.fxml")); 
	   	try {
	   		listLoader.load(); //load fxml tree
		} catch (IOException e) { e.printStackTrace(); }
	   	
	   	//---------------show original content in fields:
		//create instance of UpdateTaskController from loader:
		ListController listController = listLoader.getController();
		
		listController.refreshList();
    }*/
    
}
