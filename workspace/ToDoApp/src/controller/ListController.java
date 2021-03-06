package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import database.DatabaseHandler;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;
import model.Task;

public class ListController extends DatabaseHandler {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private JFXListView<Task> taskList; /** listView of of type TASK */ 
    @FXML
    private JFXTextField listTaskField;
    @FXML
    private JFXButton listSaveTaskBtn;
    @FXML
    private JFXTextField descriptionTaskField;
    @FXML
    private ImageView testRefreshBtn; /** +++++++++++++++++TEST refresh ++++++++++++ */
    
    public void test() {
    	//initialize(); 
    	
    	System.out.println("Hi there! :P");
    }
    
    /** observable list of type TASK+++++++++++++++++++++  */
   private ObservableList<Task>observableTaskList; // = FXCollections.observableArrayList();
  
    @FXML
    void initialize() {
    	
    	refreshList();
    	/*
    	 //observable list of type TASK+++++++++++++++++++++ 
    	//instantiate obsList and add task:
    	///////////ObservableList<Task>observableTaskList = FXCollections.observableArrayList();
    	observableTaskList = FXCollections.observableArrayList();
    	
    	
    	// OBV DONT USE RESULTSET HERE!! +++++++++++++++++++
    	//get tasks relating to userId:
    	 ResultSet resultSet = DatabaseHandler.getTasks(AddItemController.userId);
   	  
    	 try {
    		 while(resultSet.next()) {
    			 
    			 //create new task & add values from db resultSet (+++++++BUILDER PATTERN HERE!!!)
    			 Task task = new Task();
    			 task.setTaskId(resultSet.getInt("taskID"));
    			 task.setUserId(AddItemController.userId);
    			 task.setTask(resultSet.getString("task"));
    			 task.setDateCreated(resultSet.getTimestamp("date_created"));
    			 task.setDescription(resultSet.getString("description"));
    			 
    			 
    			observableTaskList.add(task); //add task to observable list of tasks
    			// observableTaskList.addAll(task);
    		 }
		} catch (SQLException e) {e.printStackTrace();}
		
    	//add observable list of tasks to JFXListView:
     	taskList.setItems(observableTaskList);
     	//set cellFactory to create CellController cells:
     	taskList.setCellFactory(CellController -> new CellController());
     	*/
     	
     	/*
     	//longform cellfactory:
     	taskList.setCellFactory(new Callback<ListView<Task>, javafx.scene.control.ListCell<Task>>(){
			@Override
			public ListCell<Task> call(ListView<Task> jFXListView) {
				return new CellController();
			}
        });
     	*/
    	
     	//-----------------------------------------------------------------------
     	
     	//give eventListener to saveBtn:
    	listSaveTaskBtn.setOnAction(event ->{
    		
    		/** +++++++++++++++000000000000+++some sort of predicate interface that all of these input fields can use should be used here instead +++++++++*/
    		if(!listTaskField.getText().trim().equals("")  && !descriptionTaskField.getText().trim().equals("")) {
    			
    			Task task = new Task();
    			task.setUserId(AddItemController.userId);
        		task.setTask(listTaskField.getText().trim());
        		task.setDateCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        		task.setDescription(descriptionTaskField.getText().trim());

        		DatabaseHandler.insertTask(task); //insert task to db
        		System.out.println("task added");
        		
        		//clear fields:
        		listTaskField.clear();
        		descriptionTaskField.clear();
        		
        		/////////CHECK WHY THIS DOESNT WORK :P observableTaskList.add(task); //add task to observable list of tasks
        		
        		/** +++++++++++++ IMPORTANT ++++++++++++ */
        		/////////////initialize(); //recall initialize() as everything needs refetched from db
        		refreshList();
            
    		}
    		
    	
        });
    	
    	
    	//-------------testRefreshBtn-------------------------------------
    	testRefreshBtn.setOnMouseClicked(event -> {
    		refreshList();
    	});
    	
    	
    }//initialize
    	
    	
    	
    
    
    void refreshList(){
    	
    	System.out.println("refreshList :P");
   	 //observable list of type TASK+++++++++++++++++++++ 
    	//instantiate obsList and add task:
    	///////////ObservableList<Task>observableTaskList = FXCollections.observableArrayList();
    	observableTaskList = FXCollections.observableArrayList();
    	
    	
    	// OBV DONT USE RESULTSET HERE!! +++++++++++++++++++
    	//get tasks relating to userId:
    	 ResultSet resultSet = DatabaseHandler.getTasks(AddItemController.userId);
   	  
    	 try {
    		 while(resultSet.next()) {
    			 
    			 //create new task & add values from db resultSet (+++++++BUILDER PATTERN HERE!!!)
    			 Task task = new Task();
    			 task.setTaskId(resultSet.getInt("taskID"));
    			 task.setUserId(AddItemController.userId);
    			 task.setTask(resultSet.getString("task"));
    			 task.setDateCreated(resultSet.getTimestamp("date_created"));
    			 task.setDescription(resultSet.getString("description"));
    			 
    			 
    			observableTaskList.add(task); //add task to observable list of tasks
    			// observableTaskList.addAll(task);
    		 }
		} catch (SQLException e) {e.printStackTrace();}
		
    	//add observable list of tasks to JFXListView:
     	taskList.setItems(observableTaskList);
     	//set cellFactory to create CellController cells:
     	taskList.setCellFactory(CellController -> new CellController());
     	
    }
    
    
    
}










