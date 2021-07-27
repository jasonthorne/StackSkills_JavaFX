
	
import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

public class Main extends Application {
	
	//-------------------------------BAR CHART---------------------------

	final static String raf = "RAF";
    final static String luftwaffe = "Luftwaffe";
    final static String russia = "Russia";
    //final static String italy = "Italy";*/
    //final static String usa = "USA";
 
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(raf, luftwaffe, russia)));
        
        /////////https://stackoverflow.com/questions/55301550/javafx-barchart-how-to-center-align-bars ===========
        
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
 
        XYChart.Series<String,Number> series1 = new XYChart.Series<String, Number>();
        series1.setName("spitfire");    
        series1.getData().add(new XYChart.Data(raf, 25601.34));
        /*series1.getData().add(new XYChart.Data("Hurricane", 20148.82));
        series1.getData().add(new XYChart.Data("raf plane 3", 20148.82));
        series1.getData().add(new XYChart.Data("raf plane 4", 20148.82));
        /*series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));      */
        
        bc.getData().add(series1);
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();
        series2.setName("bf109");
        series2.getData().add(new XYChart.Data(luftwaffe, 57401.85));
        /*series2.getData().add(new XYChart.Data("russia plane 2", 20148.82));
        series2.getData().add(new XYChart.Data("russia plane 3", 20148.82));
        series2.getData().add(new XYChart.Data("russia plane 4", 20148.82));*/
        /*series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));  */
        
        bc.getData().add(series2);
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String, Number>();
        series3.setName("Hurricane");
        series3.getData().add(new XYChart.Data(raf, 45000.65));
       /* series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));*/
        //series3.getData().add(new XYChart.Data(usa, 92633.68));  
        
        bc.getData().add(series3);
        
        Scene scene  = new Scene(bc,800,600);
        
        stage.setScene(scene);
        stage.show();
        
        //----------------------------------------------------------
        
        
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
