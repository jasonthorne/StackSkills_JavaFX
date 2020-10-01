package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import animation.Shaker;
import database.DatabaseHandler;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label successLbl;
    @FXML
    private JFXButton tasksBtn;
    
    int taskNum=0;
    
    @FXML
    void initialize() {
    	
    	tasksBtn.setText("Tasks (" + taskNum + ")");
 
    	//-------------------save task button:-------------------------------------------------
    	
    	saveTaskBtn.setOnAction(event ->{
    		/** +++++ again use a builder pattern here, that's just passsed stright into insertTask() ++++++++++*/
    		Task task = new Task();
    		
    		//get timestamp:
    		Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
    		
    		//if username & password fields aren't empty: 
    		if(!taskField.getText().trim().equals("") && !descriptionField.getText().trim().equals("")) {
    		
        		task.setUserId(AddItemController.userId);
        		task.setTask(taskField.getText().trim());
        		task.setDateCreated(timeStamp);
        		task.setDescription(descriptionField.getText().trim());

        		DatabaseHandler.insertTask(task); //insert task to db
        		System.out.println("task added");
        		successLbl.setVisible(true); //inform user of insert
        		taskNum++;
        		
        		//clear fields:
        		taskField.clear();
        		descriptionField.clear();
        		
        		
        		
        		//tasksBtn.setText("Tasks (" + taskNum + ")");
        		//tasksBtn.setVisible(true); //show tasks button
        		
        		//send users to the list of tasks screen
        		
    		}
    		else{
    			Arrays.asList(taskField, descriptionField).forEach(s -> Shaker.shake(s));
    			System.out.println("please enter task and description");
    		}
    	});
    	
    	tasksBtn.setOnAction(event ->{
			
			System.out.println("uh oh!!");
			
		});
        
    }//initialize()
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
