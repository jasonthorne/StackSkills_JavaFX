package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
    
    private final Controller1 controller1;

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
    
    //constructor grabs controller1
    public CellController(Controller1 controller1) {
    	this.controller1 = controller1;
    }
    
    
    @Override
	protected void updateItem(CellItem cellItem, boolean isEmpty) {
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
    
    void updateItem(String newText) { //item object here instead ++++++++++
    
    	////////// controller1.editObservableList(lblCellText.getText(), newText); //updateListItem
    	/*
    	controller1.getObservableList().stream()
									.filter(item -> item.getName().equals(lblCellText.getText()))
									.findFirst()
									.ifPresent(item -> item.setName(newText));
		*/
    		 
    	//Optional<CellItem> cellItem = controller1.getObservableListItem(lblCellText.getText()); /** change to id */
    	
    	
    	controller1.getCellItem(lblCellText.getText()).ifPresent(item -> {
    		item.setName(newText); //change item name
    		lblCellText.setText(newText); //change cell label.
    	});
    	
    	/*
    	if(controller1.getObservableListItem(lblCellText.getText()).isPresent()) {
    		
    	}else {
    		System.out.println("ERROR id not found");
    	}*/
    	
    	// lblCellText.setText(newText); //change cell label.
    }
    
    
    
    
    
    
    
    
    
}