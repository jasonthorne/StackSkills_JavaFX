package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	
	//labels:
	private Label title;
	private Label response;
	private Label selected;
	
	//cherckBoxes:
	private CheckBox bananaCB;
	private CheckBox mangoCB;
	private CheckBox papayaCB;
	private CheckBox grapefruitCB;
	
	private String fruits;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			
			primaryStage.setTitle("Favourite Fruit");
			//set stage & scene:
			FlowPane root = new FlowPane(Orientation.VERTICAL, 5, 5); //orientation of ELEMENTS within the root, h gap,v gap
			root.setAlignment(Pos.CENTER); //align the ROOT withing the center of the page
			
			//-------controls:
			
			title = new Label("What fruits do you like?");
			response = new Label("");
			selected = new Label("");
			
			bananaCB = new CheckBox("banana");
			mangoCB = new CheckBox("mango");
			papayaCB = new CheckBox("papaya");
			grapefruitCB = new CheckBox("grapefruit");
			
			root.getChildren().add(title);
			root.getChildren().addAll( //ORDER MATTERS HERE ++++++++++++
					bananaCB,mangoCB,papayaCB,grapefruitCB,response,selected);
			
			Scene scene = new Scene(root,400,250); //h, w
			primaryStage.setScene(scene);
			primaryStage.show();
			
			showAll();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	void showAll() {
		fruits = "";
	}
	
}
