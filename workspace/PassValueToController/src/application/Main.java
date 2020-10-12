package application;

import controller.Controller1;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * Example of passing values beween controllers.
 * From:
 * https://stackoverflow.com/questions/14187963/passing-parameters-javafx-fxml
 *
 */


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create the first controller, which loads Layout1.fxml within its own constructor
        Controller1 controller1 = new Controller1();

        // Show the new stage
        controller1.showStage();

    }
}