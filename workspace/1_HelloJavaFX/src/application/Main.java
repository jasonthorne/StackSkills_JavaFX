package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

public class Main extends Application {
	
	private Label myLabel;
	private TextField txtField;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			/*
			  
			//GLUON SCENEBUILDER TEST: 
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			
			primaryStage.setTitle("Sup, dawg!");
			Button btn = new Button();
			btn.setText("I is button");
			
			myLabel = new Label("I be label text");
			//myLabel.setText("I be label text");
			
			txtField = new TextField();
			txtField.setPromptText("I'm prompt text!");
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("btn pressed");
					
					//myLabel.setText("btn pressed");
					String txt = txtField.getText().trim();
					myLabel.setText(txt);
				}
			});
			
			//STACKPANE stacks all elements ONTOP of each other. - not good for this example 
			//StackPane root = new StackPane(); //create root
			
			FlowPane root = new FlowPane(10, 10); //horizontal gap, vertical gap
			root.setAlignment(Pos.CENTER); //pos root (and it's children) into middle +++++++++++++++
			
			
			root.getChildren().addAll(btn); //add btn to root
			root.getChildren().add(myLabel); //add label to root
			root.getChildren().add(txtField); //add text field to root
			Scene scene = new Scene(root,400,400); //w, h //add root to scene
			primaryStage.setScene(scene); //add scene to stage
			primaryStage.show(); //show stage
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
