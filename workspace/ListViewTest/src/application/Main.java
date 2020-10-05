package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	/** FROM:
	 * https://stackoverflow.com/questions/19588029/customize-listview-in-javafx-with-fxml
	 */
	

	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			
			
			/** send user to list.fxml window: */
			FXMLLoader fxmlLoader = new FXMLLoader(); //create loader to load fxml tree
			fxmlLoader.setLocation(getClass().getResource("/view/listView.fxml")); //set location to load from
			try {
				fxmlLoader.load(); //load fxml tree
			} catch (IOException e) { e.printStackTrace(); }
			
			Parent root = fxmlLoader.getRoot(); //get root element from list.fxml
			Stage stage = new Stage(); //create new stage
			stage.setScene(new Scene(root)); //add new scene to stage, holding root
			///////////////stage.show(); //show stage
			stage.showAndWait(); //show stage
			
	
			/*
			System.out.println("start");
			
			Parent root = FXMLLoader.load(getClass().getResource("/view/listView.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/addItem.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/list.fxml"));
			Scene scene = new Scene(root,700,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage newStage = new Stage(); //create new stage
			newStage.setScene(scene);
			newStage.show();
			//primaryStage.setScene(scene);
			//primaryStage.show();
			*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}