package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CellItem;


public class Controller1 {
	
	//holds the controller's stage:
	private final Stage thisStage;
	
	//Define the nodes from the Layout1.fxml file.  This allows them to be referenced within the controller
	@FXML
    private TextField txtToSecondController;
    @FXML
    private Button btnOpenLayout2;
    @FXML
    private Label lblFromController2;
    
    /** -------------------------*/
    @FXML
    private JFXListView<CellItem> listViewCellItems;
    @FXML
    private JFXButton btnAddToList;
    @FXML
    private TextField txtToCell;
    
    /** observable list */
    private static ObservableList<CellItem>observableList; //= FXCollections.observableArrayList();
    
   //imaginary db data:
    public static List<CellItem>cellItemsDB = new ArrayList<CellItem>();
   
    
    /** -------------------------*/
    
    /** Constructor: */
    public Controller1() {
    	
    	
    	/**---------------------------------------*/
    	//populate imaginary db data:
    	cellItemsDB.add(new CellItem("item 1"));
    	cellItemsDB.add(new CellItem("item 2"));
    	cellItemsDB.add(new CellItem("item 3"));
    	/**---------------------------------------*/

        // Create the new stage
        thisStage = new Stage();
        
        //load the fxml file:
        try {
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Layout1.fxml"));
        	
        	//set this class as the controller:
        	loader.setController(this);
        	
        	//load the scene:
        	thisStage.setScene(new Scene(loader.load()));
        	
        	//set the title:
        	thisStage.setTitle("Passing copntrollersa Example - Layout1");
        	
        	/////thisStage.showAndWait();
        	
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }//constructor
    
    //---------------------
    
    /** Show the stage that was loaded in the constructor */
    public void showStage() {
        thisStage.showAndWait();
    }
    
    //--------------------
    
    /** The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc. */
    @FXML
    private void initialize() {
    	
    	System.out.println("controller1 initialize");
    	/**---------------------------------------*/
    	//add data to listView:
    	refreshList();
    	/**---------------------------------------*/

        // Add an action for the "Open Layout2" button
        btnOpenLayout2.setOnAction(event -> openLayout2());
        
        btnAddToList.setOnAction(event ->{
        	System.out.println("btnAddToList");
        	
        	//if textfield isnt empty:
        	if(!txtToCell.getText().trim().equals("")) {
        		
        		//create new CellItem with entered text, and add to db:
        		cellItemsDB.add(new CellItem(txtToCell.getText())); //===================add to db
        		
        		observableList.add(new CellItem(txtToCell.getText())); //also add to list //================add to observable list
        		//////////listViewCellItems.setItems(observableList);
        		
        		txtToCell.clear();
        		//refresh list to show new item:
        		//refreshList(); 
        	}
        	
        });
    }
    
    //----------------------
    
    /** Performs the action of loading and showing Layout2 */
    private void openLayout2() {

        // Create the second controller, which loads its own FXML file. We pass a reference to this controller
        // using the keyword [this]; that allows the second controller to access the methods contained in here.
        Controller2 controller2 = new Controller2(this);

        //btnOpenLayout2.getScene().getWindow().hide();
        
        // Show the new stage/window
        controller2.showStage();

    }

    //----------------------
    
    /** Returns the text entered into txtToSecondController. This allows other controllers/classes to view that data.*/
    public String getEnteredText() {
        return txtToSecondController.getText();
    }
    
    //----------------------

    /** Allows other controllers to set the text of this layout's Label */
    
    public void setTextFromController2(String text) {
        lblFromController2.setText(text);
    }
    
    
    /** -------------------------*/
    public void refreshList(){
    	
    	 ///////////ObservableList<CellItem>observableList; 
    	//instantiate obsList: ++++++++++sloppy!!!
    	//////ObservableList<CellItem> observableList = FXCollections.observableArrayList();
    	observableList = FXCollections.observableArrayList();
    	//add CellItems from db to observable list:
    	observableList.addAll(cellItemsDB);
    	
    	System.out.println(observableList);
    	
    	//add observable list of CellItems to JFXListView:
    	listViewCellItems.setItems(observableList);
     	//set cellFactory to create CellController CellItems:
    	listViewCellItems.setCellFactory(CellController -> new CellController());
    	
    }
    /** -------------------------*/
    
    public void addFromController2(String message) {
    	
    	/** pass the object here, and have error handling here as well. And have BOTH buttons use this method */
		//create new CellItem with entered text, and add to db:
		cellItemsDB.add(new CellItem(message)); //mimic push to db ++++++++++++++++
		
		//==================================//this might just be needed instead of refresh 
		observableList.add(new CellItem(message));
		///listViewCellItems.setItems(observableList);
		//=============================
	
		/*
		CellItem cellItem = observableList.get(0);
		cellItem.setName("timmy");
		*/
		
		/** +++++++++++++++++++++++++++++++ NOT SURE WHY DATA NEEDS PULLED AGAIN???? ++++++++++++++*/
		//refresh list to show new item:
		//refreshList(); 
		
    
    }
    
    
    static void editObservableList(String oldText, String newText) {
    	
    	
    	/*
    	//+++++do some sexy filtering here :) as there'll be losts of things to check. ++++++++
    	observableList.forEach(item -> { //this is our link with controller1. which is changing the values in listView
    		
    		//System.out.println(" observableList item name: " + item.getName());
    		
    		System.out.println("observableList item: " + item.getName());
    		
    		if (item.getName() == oldText) { //find item in mock db with name matching label
    			System.out.println("FOUND item is: " + item.getName() + "text to add: " + newText);
    			item.setName(newText);
    			System.out.println("ITEM IS NOW: " + item.getName());
    		}
    		
    	});*/
    	
    	//send anobj here, holding id of item to find, and  all the other new values to add to existing object
    	
    	observableList.stream()
    		.filter(item -> item.getName() == oldText)
    		.findFirst()
    		.ifPresent(item -> item.setName(newText));
	    	   	
    }

}
