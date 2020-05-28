package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application  implements EventHandler { //++++++++++++++++++++++++EVENTHANDLER for handling which checkbox was clicked
	
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
			root.getChildren().addAll(bananaCB, mangoCB, papayaCB, grapefruitCB, response, selected); //ORDER MATTERS HERE ++++++++++++
			
			//Attach event listeners to our checkboxes:
			/** THIDS WAS MISSED FROM TUT +++++++++++++++++++++++++++++++++ :
			 *https://stackoverflow.com/questions/47411834/checkbox-eventhandler-not-changing-text-in-label-javafx/47412025
			*/
			bananaCB.setOnAction(this);
			mangoCB.setOnAction(this);
			papayaCB.setOnAction(this);
			grapefruitCB.setOnAction(this);
			
			Scene scene = new Scene(root,400,250); //h, w
			primaryStage.setScene(scene);
			primaryStage.show();
			
			showAll(); //initially shows "fruits selected: " 
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	void showAll() {
		fruits = "";
		
		if(bananaCB.isSelected()) { fruits += " banana"; }
		if(mangoCB.isSelected()) { fruits += " mango"; }
		if(papayaCB.isSelected()) { fruits += " papaya"; }
		if(grapefruitCB.isSelected()) { fruits += " grapefruit"; }
		
		selected.setText("fruits selected: " + fruits); //append selected text with fruits string
	}
	
	
	//from eventHandler:
	@Override
	public void handle(Event event) {
		
		Object fruitChecked = event.getSource(); //get the object that's been clicked
		
		if(bananaCB.equals(fruitChecked)) {
			if(bananaCB.isSelected()) {
				response.setText("banana selected");
			}else {response.setText("banana cleared");}
			showAll();
		}
		
		if(mangoCB.equals(fruitChecked)) {
			if(mangoCB.isSelected()) {
				response.setText("mango selected");
			}else {response.setText("mango cleared");}
			showAll();
		}
		
		if(papayaCB.equals(fruitChecked)) {
			if(papayaCB.isSelected()) {
				response.setText("papaya selected");
			}else {response.setText("papaya cleared");}
			showAll();
		}
		
		if(grapefruitCB.equals(fruitChecked)) {
			if(grapefruitCB.isSelected()) {
				response.setText("grapefruit selected");
			}else {response.setText("grapefruit cleared");}
			showAll();
		}
	}
	
	
}
