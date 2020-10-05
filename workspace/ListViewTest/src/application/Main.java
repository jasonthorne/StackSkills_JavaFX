package application;

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
			
	
			
			Parent root = FXMLLoader.load(getClass().getResource("/view/listView.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/addItem.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/view/list.fxml"));
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