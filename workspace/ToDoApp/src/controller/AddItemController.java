package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animation.Shaker;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AddItemController {
	
	static int userId; //+++++++++++++++++++++++++++++++++++++added to grab  id from correct user

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane rootAnchorPane; 

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
    	//addBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    	addBtn.setOnMouseClicked(event -> { //better way of doing above +++++++
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
    		
    		
    		/** =================ADDING NEW ANCHOR PANE ============================================ */
    		
    		//create new achorPane loaded from addItemForm.fxml 
    		try {
    			AnchorPane addItemformAnchorPane= FXMLLoader.load(getClass().getResource("/view/addItemForm.fxml"));
    			
    			//fade-in effect for new anchorPane: ++++++++++++++++++++++have the other fade out,then fade this in when it hits 0 opacity
        		FadeTransition fadeAnchorPane = new FadeTransition(Duration.millis(2000),addItemformAnchorPane);
        		fadeAnchorPane.setFromValue(0.0);
        		fadeAnchorPane.setToValue(1.0);
        		fadeAnchorPane.setCycleCount(1); //how many times the animation should happen (cycle)
        		fadeAnchorPane.setAutoReverse(false); //whether animation reverses on alternating cycles
        		fadeAnchorPane.play();
    			
    			//get and CLEAR the children of rootAnchorPane and add formPane:
    			/** .setAll() clears the children and replaces them with addItemformAnchorPane and it's subsequent children. */
    			rootAnchorPane.getChildren().setAll(addItemformAnchorPane); 
    		} catch (IOException e) { e.printStackTrace(); }
    		
    	}); 
    	
    }//initialize()
    
    
}
