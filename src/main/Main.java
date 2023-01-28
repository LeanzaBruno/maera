package main;
	
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import core.ReportsHandler;
import core.WeatherReport;

public class Main extends Application {
	
	@FXML private TextField codesTextField;
	@FXML VBox mainPane, resultsPane;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("MAERA");
		try {
			primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml")); 
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void onMetarButton(ActionEvent event) {
		LinkedList<String> airportCodes = getAirportCodes();
		if(airportCodes == null) return;
		ReportsHandler handler = new ReportsHandler(); 
		LinkedList<WeatherReport> metars = handler.getMetar(airportCodes);
		printReports(metars);
	}
	
	public void onTafButton(ActionEvent event) {
		LinkedList<String> airportCodes = getAirportCodes();
		if(airportCodes.isEmpty()) return;
		ReportsHandler handler = new ReportsHandler(); 
		LinkedList<WeatherReport> tafs = handler.getTaf(airportCodes);
		printReports(tafs);
	}

	private LinkedList<String> getAirportCodes() {
		final String unparsedCodes = codesTextField.getText();
		if(unparsedCodes.isBlank()) return null;
		LinkedList<String> icaoCodes = new LinkedList<>(Arrays.asList(unparsedCodes.split(" ")));
		return icaoCodes;
	}
	
	private void printReports(LinkedList<WeatherReport> reports) {
		resultsPane.getChildren().clear();
		for(WeatherReport report : reports)
			createPane(report);
	}
	
	private void createPane(WeatherReport report) {
		var reportLabel = new Label(report.getReport());
		reportLabel.setFont(Font.font(14));
		reportLabel.setWrapText(true);
		
		var hBox = new HBox(reportLabel);
		
		TitledPane pane = new TitledPane(report.getAirportName() + "    " + report.getDateAndTime(), hBox);
		pane.setFont(Font.font(16));
		pane.setCollapsible(false);
		pane.setExpanded(true);
		resultsPane.getChildren().add(pane);
		resultsPane.getScene().getWindow().sizeToScene();
	}
}
