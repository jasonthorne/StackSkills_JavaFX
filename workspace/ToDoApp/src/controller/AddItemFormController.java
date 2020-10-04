package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import animation.Shaker;
import database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
    
    private int taskNum = 0;
    
    @FXML
    void initialize() {
    	
    	setTaskNum(); //set tasknum and add to tasksBtn
 
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
        		
        		//clear fields:
        		taskField.clear();
        		descriptionField.clear();
        		
        		//get tasknum and set tasksBtn accordingly:
        		setTaskNum();
        		
        		
        		//send users to the list of tasks screen
        		
    		}
    		else{
    			Arrays.asList(taskField, descriptionField).forEach(s -> Shaker.shake(s));
    			System.out.println("please enter task and description");
    		}
    	});
    	
    	tasksBtn.setOnAction(event ->{
			
			System.out.println("'tasksBtn' clicked");
			
			/**hide the primary stage login window by targeting it through it's scene, 
	    	 * which is itself gotten by targeting one of it's elements,
	    	 * which we have access to here (the tasksBtn in this case):
	    	 */
			/////////////tasksBtn.getScene().getWindow().hide(); //HIDES THE CURRENT WINDOW ++++++++++++
			
			/** send user to list.fxml window: */
			FXMLLoader fxmlLoader = new FXMLLoader(); //create loader to load fxml tree
			fxmlLoader.setLocation(getClass().getResource("/view/list.fxml")); //set location to load from
			try {
				fxmlLoader.load(); //load fxml tree
			} catch (IOException e) { e.printStackTrace(); }
			
			Parent root = fxmlLoader.getRoot(); //get root element from list.fxml
			Stage stage = new Stage(); //create new stage
			stage.setScene(new Scene(root)); //add new scene to stage, holding root
			///////////////stage.show(); //show stage
			stage.showAndWait(); //show stage
			
		});
        
    }//initialize()
    
    
    /** ++++++++++++++++ instead of this look into making taskNum observable */
    private void setTaskNum() {
    	//get number of tasks already saved, and display on button 
    	taskNum = DatabaseHandler.getTaskNum(AddItemController.userId);
    	tasksBtn.setText("Tasks (" + taskNum + ")");
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
