package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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

public class ListController {

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
    private ObservableList<Task>observableList; //= FXCollections.observableArrayList();
    			
   

    @FXML
    void initialize() {
    	
    	//create a task:
    	Task task1 = new Task();
    	task1.setTask("do the thing!");
    	task1.setDescription("thing");
    	task1.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
    	
    	Task task2 = new Task();
    	task2.setTask("do the thing!");
    	task2.setDescription("thing");
    	task2.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
    	
    	//instantiate obsList and add task:
    	observableList = FXCollections.observableArrayList();
    	//observableList.add(task1); //or addAll()
    	observableList.addAll(task1, task2); //or addAll()
    	
    	//add observable list of tasks to JFXListView:
    	taskList.setItems(observableList);
    	//set cellFactory to create CellController cells:
    	taskList.setCellFactory(CellController -> new CellController());

    }
    
  
    
}










