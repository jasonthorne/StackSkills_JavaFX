package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/** Java code relating to fxml elements for: fx:controller="application.SampleController"  IMPORTANT: give FULL path to controller in .fxml */

public class SampleController implements Initializable{ /** implement Initializable, to initialise variables */
	
	@FXML
	private Button clickMeButton; //fx:id for element in Sample.fxml 
	@FXML
	private Label labelId; //fx:id for element in Sample.fxml

	// from Initializable:
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//I think this must be where to pull db data for populating content during page navigation! We shall see.... ++++++++++++++
		
		//add event handler to button action: 
		clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("button pressed!");
				labelId.setText("button pressed!"); //change label text! 
			}
		});
	}

}

