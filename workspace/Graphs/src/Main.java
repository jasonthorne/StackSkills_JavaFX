
	
import java.util.Arrays;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Side;

public class Main extends Application {
	
	//-------------------------------BAR CHART---------------------------

	
	/*
	final static String raf = "RAF";
    final static String luftwaffe = "Luftwaffe";
    final static String russia = "Russia";
 
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        
       
        /////////https://stackoverflow.com/questions/55301550/javafx-barchart-how-to-center-align-bars ===========
        
        
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
        
        //bc.setLegendSide(Side.LEFT);
        
 
        XYChart.Series<String,Number> series1 = new XYChart.Series<String, Number>();
        series1.setName("spitfire");    
        series1.getData().add(new XYChart.Data(raf, 25601.34));
       
        bc.getData().add(series1);
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String, Number>();
        series2.setName("bf109");
        series2.getData().add(new XYChart.Data(luftwaffe, 57401.85));
       //series2.getData().add(new XYChart.Data("russia plane 2", 20148.82));
       
        
        bc.getData().add(series2);
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String, Number>();
        series3.setName("Hurricane");
        
        
        series3.getData().addAll(
        		Arrays.asList(new Data<String, Number>(raf, 45000.65), new XYChart.Data<String, Number>(russia, 45000.65)));
        
        bc.getData().add(series3);
        
        
        Scene scene  = new Scene(bc,800,600);
        
        stage.setScene(scene);
        stage.show();
        
       
        
    } */
	
	 //---------------------------------------------------------
	
	
	//Pie chart:
	
	 @Override public void start(Stage stage) {
	        Scene scene = new Scene(new Group());
	        stage.setTitle("Imported Fruits");
	        stage.setWidth(500);
	        stage.setHeight(500);
	 
	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("Grapefruit", 13),
	                new PieChart.Data("Oranges", 25),
	                new PieChart.Data("Plums", 10),
	                new PieChart.Data("Pears", 22),
	                new PieChart.Data("Apples", 30));
	                		
	        final PieChart chart = new PieChart(pieChartData);
	        
	        //chart.setLegendVisible(false);
	        
	        //=====================================CLICK EVENT
	        final Label caption = new Label("");
	        caption.setTextFill(Color.WHITE);
	        caption.setStyle("-fx-font: 24 arial;");

	        for (final PieChart.Data data : chart.getData()) {
	            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
	                new EventHandler<MouseEvent>() {
	                    @Override public void handle(MouseEvent e) {
	                        caption.setTranslateX(e.getSceneX());
	                        caption.setTranslateY(e.getSceneY());
	                        ///caption.setText(String.valueOf(data.getPieValue()) + "%");
	                        caption.setText(String.valueOf(data.getName()));
	                        
	                        System.out.println("yo");
	                     }
	                });
	        }
	        //====================================
	        
	        chart.setTitle("Imported Fruits");

	        ((Group) scene.getRoot()).getChildren().addAll(chart, caption);
	        stage.setScene(scene);
	        stage.show();
	    }
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
