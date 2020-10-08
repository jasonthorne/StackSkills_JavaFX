package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;

import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Task;

public class CellController extends JFXListCell<Task>{ /** +++++IMPORTANT (type of 'Task')+++++++++++++++++++ */

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
    
    //private FXMLLoader fxmlLoader; //==================????????????
    int count = 0;
    
    @FXML
    void initialize() {
    	
    	System.out.println("userId: " + AddItemController.userId);
    	////System.out.println(++count);
    	
    }
    
    
    //override 'updateItem' from super (JFXListCell)
    @Override
    protected void updateItem(Task task, boolean isEmpty) {
       super.updateItem(task, isEmpty);
       
		//if task or cell are null:
		if (isEmpty || task == null) {
	         setText(null);
	         setGraphic(null);
	     } else { 
	    
      // if(task != null){
	    	 //if no instantiated loader:
	    	//if(fxmlLoader == null) { 
	   
	    		//load fxml tree, and set it's controller as this:
    	   		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/cell.fxml")); 
	    	 	//fxmlLoader = new FXMLLoader(getClass().getResource("/view/cell.fxml")); 
	    		 fxmlLoader.setController(this); //??????????
	    		 try {
					fxmlLoader.load(); //load fxml tree
				 } catch (IOException e) {e.printStackTrace();}
		    		 
	    		 //populate cell fields with data from task:
	    		 cellTaskNameLbl.setText(task.getTask());
	    		 cellDescriptionLbl.setText(task.getDescription());
	    		 cellDateLbl.setText(task.getDateCreated().toString());
	    		 
	    		 //------------------cellDeleteImgView:-------------------------------------------------------
	    		 //give handler to delete btn (is an image view, so needs .setOnMouseClicked ):
	    		 cellDeleteImgView.setOnMouseClicked(event -> {
    	    		System.out.println("delete btn clicked");
    	    		
    	    		/** BEFORE REMOVAL - show pop up confirming removal, on yes, THEN remove ++++++++++++++++*/
    	    		//'getListView' is from 'ListCell' which we're extending from, by extending from 'JFXListCell'
    	    		//'getItem' is from Cell, parent of 'ListCell'
    	    		getListView().getItems().remove(getItem());  //get items from listView and remove this current item. +++++++++
	    	    
    	    		//remove item from db:
    	    		DatabaseHandler.deleteTask(task);
    	    		
	    		 });
	    		 
	    		 setText(null); //set text as null
		         setGraphic(cellRoot); //set this anchorpane to be the graphic
	    	//} 
	     }
	 }
  		
    
}
