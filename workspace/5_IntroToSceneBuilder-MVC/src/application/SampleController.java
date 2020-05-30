package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

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
	
	@FXML
	private JFXButton MaterialButton; //material design imported button
	
	@FXML
	private JFXTextField textField;

	// from Initializable:
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//I think this must be where to pull db data for populating content during page navigation! We shall see.... ++++++++++++++ IE the 'Controller' :P
		/** NO to above. This is where we invoke getts from the stored data in the perosn class, and use that data on the elements in the view!!!  */ //++++++++++++++
		
		//add event handler to button action: 
		clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("button pressed!");
				labelId.setText(textField.getText().trim()); //change label text! 
			}
		});
		
		
		//add event handler to button action: 
		MaterialButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("MaterialButton pressed!");
				labelId.setText("Material Button pressed!"); //change label text! 
			}
		});
		
		
	}

}

