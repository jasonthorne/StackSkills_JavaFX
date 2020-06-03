package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
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
    private Label detailsGithub;
    @FXML
    private Label detailsTwitter;

    @FXML
    void initialize(String name) {
    	
    	//not sure if better setting here, or using seperate setter, like below! ??????????
    	/*
    	detailsWelcomeLabel.setText("Welcome " + name);
    	detailsName.setText(name);
    	*/
    }
    
    //set name //++++++++++++++++This should prob be in the initialize method!! 
    void setName(String name) {
    	detailsWelcomeLabel.setText("Welcome " + name);
    	detailsName.setText(name);
    }

}
