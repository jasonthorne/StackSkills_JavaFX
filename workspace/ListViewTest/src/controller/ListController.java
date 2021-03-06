package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;



import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import model.Task;

public class ListController /*extends DatabaseHandler*/ {

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
    
    /** observable list of type TASK+++++++++++++++++++++  */
    private ObservableList<Task>observableTaskList; //= FXCollections.observableArrayList();
    			
   

    @FXML
    void initialize() {
    	
    	//instantiate obsList and add task:
    	observableTaskList = FXCollections.observableArrayList();
    	
    	System.out.println("hullo! :P");
    	/*
    	//get tasks relating to userId:
    	ResultSet resultSet = DatabaseHandler.getTasks(AddItemController.userId);
   	  
    	 try {
    		 while(resultSet.next()) {
    			 
    			 //create new task & add values from db resultSet (+++++++BUILDER PATTERN HERE!!!)
    			 Task task = new Task();
    			 task.setTask(resultSet.getString("task"));
    			 task.setDateCreated(resultSet.getTimestamp("date_created"));
    			 task.setDescription(resultSet.getString("description"));
    			 
    			// observableTaskList.add(task); //add task to observable list of tasks
    			 observableTaskList.addAll(task);
    		 }
		} catch (SQLException e) {e.printStackTrace();}
		*/
    	
    	 Task task1 = new Task();
		 task1.setTask("task1");
		 task1.setDescription("description");
		 
		 Task task2 = new Task();
		 task2.setTask("task2");
		 task2.setDescription("description");
		 
		// observableTaskList.add(task); //add task to observable list of tasks
		 observableTaskList.addAll(task1, task2);
    	
    	
    	//add observable list of tasks to JFXListView:
     	taskList.setItems(observableTaskList);
     	//set cellFactory to create CellController cells:
     	taskList.setCellFactory(CellController -> new CellController());
    	
    }
    
  
    
}










