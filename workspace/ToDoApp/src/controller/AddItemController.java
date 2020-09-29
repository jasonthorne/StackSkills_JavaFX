package controller;

import java.net.URL;
import java.util.ResourceBundle;

import animation.Shaker;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addBtn;

    @FXML
    void initialize() {
    
    	/**addBtn is an image view (not a btn), so has no 'setOnAction' to take eventHandler */
    	//adding thing to use eventHandler, and eventHandler itself:
    	addBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { 
    		System.out.println("'addBtn' clicked");
    		Shaker.shake(addBtn); //shake button //+++++++++++++++this looks awful  :D 
    	}); 
    }
}
