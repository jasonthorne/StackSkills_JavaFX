package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<String> taskList; /** listView of type String */

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXButton listSaveTaskBtn;

    @FXML
    private JFXTextField descriptionTaskField;
    
    /** observable list +++++++++++++++++++++  */
    ObservableList<String>observableList = FXCollections.observableArrayList("jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		,"jay","dan","jo","laura"
    		);
    			
   

    @FXML
    void initialize() {
    	
    	taskList.setItems(observableList); //add observable list to JFXListView

    }
}
