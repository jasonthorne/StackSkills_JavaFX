package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import database.DatabaseHandler;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import model.Task;

public class AddItemFormController extends DatabaseHandler{
	
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
 
    	//-------------------save task button:-------------------------------------------------
    	
    	saveTaskBtn.setOnAction(event ->{
    		/** +++++ again use a builder pattern here, that's just passsed stright into insertTask() ++++++++++*/
    		Task task = new Task();
    		
    		//get timestamp:
    		Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
    		
    		String task2 = taskField.getText().trim();
    		String description = descriptionField.getText().trim();
    		
    		//if username & password fields aren't empty: 
    		if(!task2.equals("") && !description.equals("")) {
    		
        		task.setUserId(AddItemController.userId);
        		task.setTask(taskField.getText().trim());
        		task.setDateCreated(timeStamp);
        		task.setDescription(descriptionField.getText().trim());

        		DatabaseHandler.insertTask(task);
        		System.out.println("task added");
    		}
    		else{
    			System.out.println("please enter task and description");
    		}
    	});
        
    }//initialize()
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
