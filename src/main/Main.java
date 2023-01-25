package main;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.ArrayList;
import core.ReportsHandler;

public class Main extends Application {
	
	@FXML private TextField codesTextField;
	
	@FXML private CheckBox metarCheckBox, tafCheckBox;

	@Override
	public void start(Stage primaryStage) {
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
	
	private boolean isThereAnyCode() {
		final String codes = codesTextField.getText();
		if(codes == null || codes.isEmpty()) return false;
		return true;
	}
	
	private boolean areMetarOrTafSelected(){
		if(metarCheckBox.isSelected() || tafCheckBox.isSelected())
			return true;
		return false;
	}
	private boolean isEverythingOkay() {
		if(!isThereAnyCode()) return false;
		if(!areMetarOrTafSelected()) return false;
		return true;
	}
	
	public void onDownloadButton(ActionEvent event) {
		
		if(!isEverythingOkay()) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("Hace falta ingresar los códigos oaci o bien marcar algún reporte para solicitar");
			errorAlert.showAndWait();
			return;
		}
		
		String [] codes = getCodes();
		ReportsHandler handler = ReportsHandler.getInstance();  
		if(metarCheckBox.isSelected()) {
			ArrayList<WeatherReport> metars = handler.downloadMETAR(codes);
		}
		if(tafCheckBox.isSelected()){
			handler.downloadReports(codes, ReportsHandler.REPORT_TYPE.TAF);
			handler.printPage();
		}
	}
	
	private String [] getCodes() {
		return codesTextField.getText().toLowerCase().split(" ");
	}
}
