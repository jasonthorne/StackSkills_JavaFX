package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			ProgressIndicator pi = new ProgressIndicator(0.5);
	            final HBox hb = new HBox();
	            hb.getChildren().add(pi);
	            Scene scene = new Scene(hb,700,400);
			
		/*
			Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/addItem.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/list.fxml"));
			Scene scene = new Scene(root,700,400);*/
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		float downloaded = 50;
	    float total = 200;
	    float percent = (100 * downloaded) / total;
	    System.out.println(String.format("%.0f%%",percent));
		
		
		/*
		 * open any given File using the system's default application.
		 * This will also open the file in a background Thread so your application doesn't hang while waiting for the file to load.
		 */
		
		/*
		 if (Desktop.isDesktopSupported()) {
	        new Thread(() -> {
	            try {
	                Desktop.getDesktop().open(new File("C:\\Users\\jason\\Desktop\\BRS_CampaignRules.pdf"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }).start();
		  }*/
		
		launch(args);
		
		
	}

}
