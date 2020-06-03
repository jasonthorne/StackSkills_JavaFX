package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class DetailsController {
	
	@FXML
	private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label detailsWelcomeLabel;
    @FXML
    private Label detailsName;
    @FXML
    private Label detailsAge;
    @FXML
    private Label detailsProfession;
    @FXML
    private Hyperlink detailsGithub; //removed hyperlink box: https://stackoverflow.com/questions/40591913/how-to-remove-hyperlink-border-in-javafx
    @FXML
    private Hyperlink detailsTwitter;
    
    @FXML
    void initialize() { //THis CANT be passed params as that stops it being overriden, which prevents setOnActions (eg used with link below)
    	
    	/** add click action to links: */
    	detailsGithub.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//if desktop application is supported:
				if (Desktop.isDesktopSupported()) {
					try {
						//open default desktop browser, and navigate to URI:
						Desktop.getDesktop().browse(new URI("https://www.github.com/jasonthorne"));
					} catch (IOException | URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
    	});
    	
    }
    
    //set user: 
    void setUser(String name, int age, String profession) {
    	detailsWelcomeLabel.setText("Welcome " + name);
    	detailsName.setText(name);
    	detailsAge.setText(String.valueOf(age));
    	detailsProfession.setText(profession);
    }

}
