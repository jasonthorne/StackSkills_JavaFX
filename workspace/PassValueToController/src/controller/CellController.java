package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.CellItem;

public class CellController extends JFXListCell<CellItem>{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPaneCellRoot;

    @FXML
    private Label lblCellText;

    @FXML
    void initialize() {
      

    }
    
    
    @Override
    public void updateItem(CellItem cellItem, boolean isEmpty) {
        super.updateItem(cellItem,isEmpty);
   
      		if (isEmpty || cellItem == null) {
      	         setText(null);
      	         setGraphic(null);
      	     } else {
       
      	    	 
      	    /*	 
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
    		 //cellDateLbl.setText(task.getDateCreated().toString());
    		 
    		 setText(null); //??????????????=======================
	         setGraphic(cellRoot); //set this achorpane to be the graphic
        	
        	*/
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}