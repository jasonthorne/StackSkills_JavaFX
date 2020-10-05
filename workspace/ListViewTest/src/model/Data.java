package model;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Data {
	
	@FXML
    private HBox hBox;
    @FXML
    private Label label1;
    @FXML
    private Label label2;

    public Data(){
    	
    	//set this as the controller of cellItem.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cellItem.fxml"));
        fxmlLoader.setController(this);
        
        try{
        	hBox = fxmlLoader.load();
        }
        catch (IOException e){ throw new RuntimeException(e); }
    }

    public void setInfo(String string){
        label1.setText(string);
        label2.setText(string);
    }

    public HBox getBox(){
        return hBox;
    }

}
