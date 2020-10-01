package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<?> taskList;

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXButton listSaveTaskBtn;

    @FXML
    private JFXTextField descriptionTaskField;

    @FXML
    void initialize() {

    }
}
