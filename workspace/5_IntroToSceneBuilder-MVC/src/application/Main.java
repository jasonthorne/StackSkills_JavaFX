package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		/**
		 MODEL VIEW CONTROLLER:
		 Model - what we're modeling out data to be. A person has a Person class (with name & password).
		 View - is what the user can SEE (sample.fxml in this case) 
		 Controller - connects the model & the view. (It knows everything about the model & the view). 
		 			  It takes the information from the model and displays it in the view.
		 */
		
		try {
			
			//++++Parent root is calling the FXMlLoader class. invoking its 'load' method, and passing in the resource file that we want to load into our view (sample.fxml).
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //root is now our sample.fxml
			//AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
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


