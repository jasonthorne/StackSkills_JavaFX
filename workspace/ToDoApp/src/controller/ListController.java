package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
    private ObservableList<Task>observableList = FXCollections.observableArrayList();
    			
   

    @FXML
    void initialize() {
    	
    	Task task = new Task();
    	task.setTask("do the thing!");
    	task.setDescription("thing");
    	task.setDateCreated(dateCreated);
    	

    }
    
  
    
}










