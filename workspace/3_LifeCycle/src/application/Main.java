package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	

	//----------------------------------------------------
	/** APPLICATION LIFECYCLE
	//comprises of 3 methods from Application class: 
	 + init()
	 + start()
	 + stop()
	 **/
	
	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init() begins");
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			System.out.println("start() begins");
			
			primaryStage.setTitle("Life Cycle");
			
			FlowPane root = new FlowPane(Orientation.VERTICAL, 5, 5); //h,v
			root.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(root,700,400); //w,h
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//start
	
	@Override //called when application stops (duh! :P)
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop() begins");
		//get rid of db connection etc here! 
	}

	//----------------------------------------------------------

	public static void main(String[] args) {
		launch(args);
	}
}
