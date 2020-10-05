package controller;

import java.io.IOException;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Data;
import controller.ListViewCellController;

public class ListViewController {
	
	@FXML
    private ListView<String> listView;
	
    private Set<String> stringSet;
    
    // observable list +++
    ObservableList<String> observableList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
    	
    	System.out.println("initialize");
    	
    	//load fxml doc tree: 
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/listView.fxml"));
    	//set controller:
        fxmlLoader.setController(this);
        
        try{
        	//create parent from fxml top element (gridPane in this case)
            Parent parent = (Parent)fxmlLoader.load(); 
            Scene scene = new Scene(parent, 400.0 ,500.0); //add to scene
        }
        catch (IOException e){ throw new RuntimeException(e);}
    	
    	
        setListView(); 
    }
    
    /** constructor ++++*/
    public ListViewController() {
    	
    	/**set this to the the controller of listView.fxml:  */
    	//load fxml doc tree: 
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/listView.fxml"));
    	//set controller:
        fxmlLoader.setController(this);
        
        try{
        	//create parent from fxml top element (gridPane in this case)
            Parent parent = (Parent)fxmlLoader.load(); 
            Scene scene = new Scene(parent, 400.0 ,500.0); //add to scene
        }
        catch (IOException e){ throw new RuntimeException(e);}
    }
    
    
    public void setListView() {
    	
    	System.out.println("setListView");
    	
    	//add some values to set:
        stringSet.add("String 1");
        stringSet.add("String 2");
        stringSet.add("String 3");
        stringSet.add("String 4");
        
        //add set to observable list:
        observableList.setAll(stringSet);
        
        //add observable list to listView fxml element:
        listView.setItems(observableList);
       
        /**
         * When the setCellFactory() method is called on the ListView, it will return the ListCell. 
         * So for sake of simplicity, I added a class which extends the ListCell, 
         * and the setGraphic() method is present for the ListCell() 
         * and will set the items of the ListCell.
         */
        
        listView.setCellFactory(new Callback<ListView<String>, javafx.scene.control.ListCell<String>>(){
            @Override
            public ListCell<String> call(ListView<String> listView){
                return new ListViewCellController(); //returns a new instance of ListViewCellController
            }
        });
    }
    
    
    
    
    

}
