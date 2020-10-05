package controller;

import javafx.scene.control.ListCell;
import model.Data;

public class ListViewCellController extends ListCell<String>{
	
	@Override
    public void updateItem(String string, boolean empty){
        super.updateItem(string,empty);
        
        if(string != null){
            Data data = new Data();
            data.setInfo(string);
            setGraphic(data.getBox());
        }
    }

}
