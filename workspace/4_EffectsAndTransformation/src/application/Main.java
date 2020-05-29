package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;


public class Main extends Application implements EventHandler {
	
	private Button rotateButton;
	private Button blurButton;
	private Button scaleButton;
	
	private Rotate rotate; //javafx rotate obj
	private double angle;
	
	private BoxBlur boxBlur;
	private double blurVal; 
	
	private double scaleFactor;
	private Scale scale;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Effects & Transformation");
			
			angle = 0.0; //angle for rotating rotate button
			blurVal = 1.0; //value of blur effect
			scaleFactor = 1.0; //scale factor
			
			rotateButton = new Button("Rotate");
			blurButton = new Button("Blur off");
			scaleButton = new Button("Scale");
			
			rotateButton.setOnAction(this); /** when button is clicked this is passed to it's event handler ++++++++++++++++++*/
			blurButton.setOnAction(this);
			scaleButton.setOnAction(this);
			
			Label reflect = new Label("Reflection adds visual sparkle");
			
			FlowPane root = new FlowPane(15, 15); //h,v
			root.setAlignment(Pos.CENTER);
			root.getChildren().addAll(rotateButton, blurButton, scaleButton, reflect);
			
			Scene scene = new Scene(root,300,150); //w,h
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//-----------------------------------
			//set up transformations:
			
			//rotate:
			rotate = new Rotate();
			rotateButton.getTransforms().add(rotate); //add rotate obj to button
			//blur:
			boxBlur = new BoxBlur(1.0, 1.0, 1);//w,h,iteration //boxBlur obj
			//scale:
			scale = new Scale(scaleFactor, scaleFactor);
			scaleButton.getTransforms().add(scale); //add scale obj to button
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(Event event) {
		
		if(event.getSource().equals(rotateButton)) {
			System.out.println("rotate");
			angle+=15.0; //increase angle
			rotate.setAngle(angle); //set angle value of rotation
			rotate.setPivotX(rotateButton.getWidth()/2); //set x value pivot point (pivot from h center of button)
			rotate.setPivotY(rotateButton.getHeight()/2); //set y value pivot point (pivot from v center of button)
		}
		
		if(event.getSource().equals(blurButton)) {
			System.out.println("blur");
			//each time button is pressed, it's blur is changed:
			if(blurVal == 10.0) { //if blur val is at 10
				blurVal=1.0; //reduce to 1
				blurButton.setEffect(null); //remove effect
				blurButton.setText("Blur Off");
			}else {
				blurVal++; //increment blur val
				blurButton.setEffect(boxBlur); //set effect with our BoxBlur obj
				blurButton.setText("Blur On");
			}
			
			//set w & h of blur box:
			boxBlur.setWidth(blurVal);
			boxBlur.setHeight(blurVal);
		}
		if(event.getSource().equals(scaleButton)) {
			System.out.println("scale");
			scaleFactor+=0.1; //increase scale factor by 0.1
			if(scaleFactor > 2.0) { //if scale factor hits 2.0, reset it to 1.0:
				scaleFactor = 1.0;
			}
			
			//increment x and y scales by scaleFactor val:
			scale.setX(scaleFactor); 
			scale.setY(scaleFactor);
		}
	}
}
