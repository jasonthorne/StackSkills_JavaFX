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
   private ObservableList<String>observableList = FXCollections.observableArrayList("jay","dan","jo","laura"
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
    	
    	/** set taskList's cell factory to create new JFXCells (instead of default cell styles) */
    	taskList.setCellFactory(param -> new JFXCell());

    }
    
    
    /** the "cell" in a list view is a row (entry) */
    private static class JFXCell extends JFXListCell<String> {
    	
    	
    	
    	
    	
    	HBox hBox = new HBox(); //horizontal box
    	Button btn = new Button("I'm a button!");
    	Label taskNamelbl = new Label();
    	
    	Pane pane = new Pane();
    	Image icon = new Image("/assets/test.png"); /** get this path from a properties file */
    	ImageView imnageIcon = new ImageView(icon);
    	
    	//constructor:
		public JFXCell() {
			super(); //why is this needed???????????????????
			
			/** add elements to hBox (Order matters!)*/
			hBox.getChildren().addAll(imnageIcon, taskNamelbl, btn);
			HBox.setHgrow(pane, Priority.ALWAYS);
		}
    	
	
		//override 'updateItem' from super (JFXListCell)
		@Override
		protected void updateItem(String taskName, boolean isEmpty) {
			
			//if name or cell are null:
			if (isEmpty || taskName == null) {
		         setText(null);
		         setGraphic(null);
		     } else {
		    	 taskNamelbl.setText(taskName); //add taskName to label
				 setGraphic(hBox); // set the graphic as our Hbox ++++++++++++++++
		     }
		 }
		
		
		
		/*
		public void updateItem(String taskName, boolean isEmpty) {
			super.updateItem(taskName, isEmpty); //call updateItem from super (JFXListCell)
			setText(null);
			setGraphic(null);
			
			//if name isn't null and cell isnt empty
			if(taskName != null && !isEmpty) {
				taskNamelbl.setText(taskName); //add taskName to label
				setGraphic(hBox); // set the graphic as our Hbox ++++++++++++++++
				
			}
		}*/
		
    }
    
}










