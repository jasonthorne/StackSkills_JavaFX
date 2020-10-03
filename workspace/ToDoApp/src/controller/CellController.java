package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Task;

public class CellController extends JFXListCell<Task>{ /** +++++IMPORTANT (not type of 'Task')+++++++++++++++++++ */

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane cellRoot;
    @FXML
    private ImageView cellIconImgView;
    @FXML
    private Label cellTaskNameLbl;
    @FXML
    private Label cellDescriptionLbl;
    @FXML
    private Label cellDateLbl;
    @FXML
    private ImageView cellDeleteImgView;
    
    private FXMLLoader fxmlLoader;

    @FXML
    void initialize() {
    	
    	cellDeleteImgView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    		System.out.println("delete btn clicked");
    	});

    }
    
    
    //override 'updateItem' from super (JFXListCell)
	@Override
	protected void updateItem(Task task, boolean isEmpty) {
		
		//if task or cell are null:
		if (isEmpty || task == null) {
	         setText(null);
	         setGraphic(null);
	     } else {
	    	// taskNamelbl.setText(taskName); //add taskName to label
			// setGraphic(hBox); // set the graphic as our Hbox ++++++++++++++++
	    	 
	    	 //if no instantiated loader:
	    	 if(fxmlLoader == null) {
	    		 
	    		 //=============IS ANY OF THIS NEEDED!! ==================
	    		 fxmlLoader = new FXMLLoader(getClass().getResource("/view/cell.fxml")); //in initialize???
	    		 fxmlLoader.setController(this); //??????????
	    		 try {
					fxmlLoader.load();
				} catch (IOException e) {e.printStackTrace();}
	    		 //========================================================
	    		 
	    		 //populate cell fields with data from task:
	    		 cellTaskNameLbl.setText(task.getTask());
	    		 cellDescriptionLbl.setText(task.getDescription());
	    		 cellDateLbl.setText(task.getDateCreated().toString());
	    		 
	    		 setText(null); //??????????????
		         setGraphic(cellRoot); //set this achorpane to be the graphic
	    	 }
	     }
	 }
  		
    
}
