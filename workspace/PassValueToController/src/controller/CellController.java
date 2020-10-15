package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
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
    private JFXButton btnEdit;
    
    private EditCellController editCellController;

    @FXML
    void initialize() {
    	
    	/** nicer than button? ++++++++++++++++++*/
    	anchorPaneCellRoot.setOnMouseClicked(event -> {
    		System.out.println("anchorPaneCellRoot clicked");
    	});
    	
    	
    	System.out.println("CellController initialize");
    	
    	 btnEdit.setOnAction(event -> {
			 
			 //open editCellController
			 editCellController = new EditCellController(this); //locaation?????????
		      //btnEdit.getScene().getWindow().hide();
		      
		      // Show the new stage/window
			 editCellController.showStage();
		 });
		 
    }
    
    
    @Override
    public void updateItem(CellItem cellItem, boolean isEmpty) {
        super.updateItem(cellItem, isEmpty);
   
      		if (isEmpty || cellItem == null) {
      	         setText(null);
      	         setGraphic(null);
      	     } else {
       
        	//load fxml tree, and set it's controller as this:
    	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cell.fxml")); 
    	 	
    		 loader.setController(this); //??????????
    		 try {
				loader.load(); //load fxml tree
			 } catch (IOException e) {e.printStackTrace();}
	    		 
	    		 
    		 //populate lblCellText with data from cellItem:
    		 lblCellText.setText(cellItem.getName()); 
    		 
    		
    		 setText(null); 
	         setGraphic(anchorPaneCellRoot); //set this achorpane to be the graphic	
        }
    }
    
    
   
    public String getLblText() {
    	return lblCellText.getText();
    }
    
    public void setLblText(String newText) {
    	lblCellText.setText(newText);
    }
    
    
    
    
    
    
    
    
    
    
    
}