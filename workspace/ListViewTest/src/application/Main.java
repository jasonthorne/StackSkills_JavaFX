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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	
	/** FROM:
	 * https://stackoverflow.com/questions/19588029/customize-listview-in-javafx-with-fxml
	 */
	
	
	/*
	  Parent root = FXMLLoader.load(getClass().getResource("/fxml/CustomList.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("CustomList");
        stage.setScene(scene);
        stage.show();
	 */


	@Override
	public void start(Stage primaryStage) {
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/list.fxml"));
			Scene scene = new Scene(root);
		    primaryStage.setScene(scene);
		    primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

       
        

		   
    			
    			
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}