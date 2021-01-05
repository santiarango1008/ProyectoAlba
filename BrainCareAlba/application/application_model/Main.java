package application_model;
import application_controller.index_controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**------------------------------------------------|
|   @author (C) José Ignacio del Valle Bustillo    |
|   @author (C) Ricardo Delgado Fernández          |
|   @author (C) Camilo Betancur                    |
|   @author (C) Leticia Gruñeiro de Mora-Losana    |
|   @author (C) Esenia Rodionova  
|	@author (C) Santiago Arango Arce      
|   @version 16 Dec.2020                           |
|   programa: BrainCare                            |
|------------------------------------------------**/


//CLASE MAIN EXTENDS APPLICATION
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader (getClass().getResource("/application_view/index.fxml"));
			
			
			index_controller control= new index_controller ();
			loader.setController(control);
			
			Parent root= loader.load();
			
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	//MÉTODO MAIN
	public static void main(String[] args) {
		launch(args);
	}
}