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
	
	private int userId; //+++++++++++++++++++++++++++++++++++++added to grab  id from correct user

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
    	System.out.println("initialize PPPPPPPPPPPPPPPPPPPPPPPPP': " + getUserId());
    	//-------------------save task button:-------------------------------------------------
    	
    	saveTaskBtn.setOnAction(event ->{
    		makeTask();
    		/** +++++ again use a builder pattern here, that's just passsed stright into insertTask() ++++++++++*/
    		/*
    		Task task = new Task();
    		
    		//get timestamp:
    		Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
    		
    		String task2 = taskField.getText().trim();
    		String description = descriptionField.getText().trim();
    		
    		//if username & password fields aren't empty: 
    		if(!task2.equals("") && !description.equals("")) {
    		
	    		System.out.println("BEFORE SET': " + getUserId());
	    		task.setUserId(getUserId()); //++++++++++++++++++++++++++++needed as during initialization userId is 0!
	    		task.setTask(taskField.getText().trim());
	    		task.setDateCreated(timeStamp);
	    		task.setDescription(descriptionField.getText().trim());
	
	    		DatabaseHandler.insertTask(task);
    		}
    		else{
    			System.out.println("please enter task and description");
    		}
    			*/
    		
    		
    	});
        
    }//initialize()
    
    
    private void makeTask() {
    	/** +++++ again use a builder pattern here, that's just passsed stright into insertTask() ++++++++++*/
		Task task = new Task();
		
		//get timestamp:
		Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		String task2 = taskField.getText().trim();
		String description = descriptionField.getText().trim();
		
		//if username & password fields aren't empty: 
		if(!task2.equals("") && !description.equals("")) {
		
    		System.out.println("BEFORE SET': " + getUserId());
    		task.setUserId(AddItemController.userId); //++++++++++++++++++++++++++++needed as during initialization userId is 0!
    		task.setTask(taskField.getText().trim());
    		task.setDateCreated(timeStamp);
    		task.setDescription(descriptionField.getText().trim());

    		DatabaseHandler.insertTask(task);
		}
		else{
			System.out.println("please enter task and description");
		}
			
    }
    
    /** +++++++++++++for getting userId from LoginController++++++++ */
    
    protected void setUserId(int userId) {
    	this.userId = userId;
    	System.out.println("userId from 'AddItemFormController': " + this.userId);
    }
    
  //get userId of logged in user
    protected int getUserId() { return this.userId; } //NEEDE HERE FOR saveTaskBtn.setOnAction ++++++++++++++
    
    /** +++++++++++++++++++++++++++++++++++++++++++++++++++r++++++++ */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
