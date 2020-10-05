package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	
	/** FROM:
	 * https://stackoverflow.com/questions/19588029/customize-listview-in-javafx-with-fxml
	 */
	
	GridPane root;


	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			System.out.println("start");
			
			Button btn = new Button();
			btn.setText("click me!");
			
			btn.setOnAction(event -> {
				 
				/*
				btn.getScene().getWindow().hide(); //HIDES THE LOGIN WINDOW ++++++++++++
				
				FXMLLoader loader = new FXMLLoader(); //create an fxml loader (for loading fxml - duh!)
				loader.setLocation(getClass().getResource("view/listView.fxml")); //set the fxml location
				try {
					loader.load(); //load the fxml hierarchy
				} catch (IOException e) {e.printStackTrace();} 
				
				Parent root = loader.getRoot(); //create root from the loader's root (an anchorPane in this case)
				Stage signUpStage = new Stage(); 
				
				//add the root to a new scene. Add that scene to the stage:
				signUpStage.setScene(new Scene(root));
				signUpStage.showAndWait(); 
				 */
				
				try {
				
					GridPane listViewGridPane = FXMLLoader.load(getClass().getResource("/view/listview.fxml"));
					
					//get and CLEAR the children of rootAnchorPane and add formPane:
	    			/** .setAll() clears the children and replaces them with addItemformAnchorPane and it's subsequent children. */
					root.getChildren().setAll(listViewGridPane); 
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			
    			
				
			 });
			
			
			
			root = new GridPane(); //horizontal gap, vertical gap
			root.setAlignment(Pos.CENTER); //pos root (and it's children) into middle +++++++++++++++
			root.getChildren().addAll(btn); //add btn to root
			Scene scene = new Scene(root,700,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}