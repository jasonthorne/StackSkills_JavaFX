package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;

import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    @FXML
    private ImageView cellRefreshImgView;
    
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
			 
			 //---------------REFRESH BUTTON---cellRefreshImgView:-------------------------------------------------------
			 cellRefreshImgView.setOnMouseClicked(event -> {
				 
				//load fxml tree from updateTaskForm.fxml
			   	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/updateTaskForm.fxml")); 
			   	try {
					loader.load(); //load fxml tree
				} catch (IOException e) { e.printStackTrace(); }
			   	
			   	//---------------show original content in fields:
				//create instance of UpdateTaskController from loader:
				/** remember you only have package level access to what it contains here */
				UpdateTaskController updateTaskController = loader.getController();
				
				//send taskNameLbl & cellDescriptionLbl values to updateTaskForm: //++++++++++
				updateTaskController.setTaskField(task.getTask());
				updateTaskController.setDescriptionField(task.getDescription());
				//-----------------
				
				//-------------SAVE BUTTON - update task in db:
				//get save btn from updateTaskController, and set its action event to update task in db
				updateTaskController.getSaveTaskBtn().setOnAction(event2 ->{
					
					//++++++++++++++++++HAVE ERROR HANDLING HERE for fields below (if enter no values into new form) ++++++++++++
					
					//update task with new values:
					task.setTask(updateTaskController.getTaskField());	//get value of field  from controller
					task.setDateCreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
					task.setDescription(updateTaskController.getDescriptionField()); //get value of field  from controller
					
					DatabaseHandler.updateTask(task); //update task in db
					
					/** ++++++++++++++++++++++++++++++++++++++++++++++++++++ */
					
					/////////////updateTaskController.test();
					/*
					//load fxml tree from updateTaskForm.fxml
				   	FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/view/list.fxml")); 
				   	try {
				   		listLoader.load(); //load fxml tree
					} catch (IOException e) { e.printStackTrace(); }
				   	
				   	//---------------show original content in fields:
					//create instance of UpdateTaskController from loader:
					ListController listController = listLoader.getController();
					
					//listController.refreshList();
					
					//new ListController().refreshList();
					*/
					/** ++++++++++++++++++++++++++++++++++++++++++++++++++++ */
					
				});
				//-------------
				
				Parent root = loader.getRoot(); //create root from the loader's root (an anchorPane in this case)
				Stage signUpStage = new Stage(); /**make a new stage for showing updateTask window */
				
				//add the root to a new scene. Add that scene to the stage:
				signUpStage.setScene(new Scene(root));
				///////////signUpStage.showAndWait(); /** show the new stage MUST BE LAST THING */
				signUpStage.show(); /** show the new stage MUST BE LAST THING */
			   	
			 });
			 
			 
			 //--------------------------------------------------------------------------------------------
			 
			 setText(null); //set text as null
	         setGraphic(cellRoot); //set this anchorpane to be the graphic
	    	//} 
	     }
	 }
  		
    
}
