package controller;

import java.net.URL;
import java.util.ResourceBundle;

import animation.Shaker;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label noTasksLbl;

    @FXML
    private ImageView addBtn;
    

    @FXML
    void initialize() {
    
    	//------------------add item button:-------------------------------------------------
    	
    	/**addBtn is an image view (not a btn), so has no 'setOnAction' to take eventHandler */
    	//adding thing to use eventHandler, and eventHandler itself:
    	addBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { 
    		System.out.println("'addBtn' clicked");
    		////////Shaker.shake(addBtn); //shake button //+++++++++++++++this looks awful  :D 
    		
    		/** +++++++++++++++++this is clunky as hell. DONT DO THIS!! :P */
    		//remove button and label from screen: 
    		//addBtn.relocate(0,-1000); //(x pos, y pos)
    		//noTasksLbl.relocate(0,-10000); //(x pos, y pos)
    		//addBtn.setOpacity(0);
    		//noTasksLbl.setOpacity(0);
    		
    		/** +++++++++++++++++this transition should prob be a "buttonFade" consumer interface
    		 * nOTE THAT IT DOESNT WORK HERE AS RELOCATE KICKS IN IMMEDIATELY. */
    		//fade transition:
    		FadeTransition fadeTransition = new FadeTransition(Duration.millis(900),addBtn);
    		fadeTransition.setFromValue(1.0);
    		fadeTransition.setToValue(0.0);
    		fadeTransition.setCycleCount(1); //how many times the animation should happen (cycle)
    		fadeTransition.setAutoReverse(false); //whethert animation reverses on alternating cycles
    		fadeTransition.play();
    	
			addBtn.relocate(0,-1000); //(x pos, y pos)
    		noTasksLbl.relocate(0,-10000); //(x pos, y pos)
    		
    	}); 
    }
}
