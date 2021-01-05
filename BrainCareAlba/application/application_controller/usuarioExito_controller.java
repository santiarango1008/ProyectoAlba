package application_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


//CONTROLADOR INTERFAZ LOGIN SUCCESSFUL

public class usuarioExito_controller {

    @FXML
    private Button inicio;

    @FXML
    void volverInicio(ActionEvent event) {
    	try {
    		FXMLLoader vistaLogin = new FXMLLoader(getClass().getResource("/application_view/login.fxml"));
    		login_controller controlLogin = new login_controller();
    		vistaLogin.setController(controlLogin);
    		Stage actual = (Stage) inicio.getScene().getWindow();
    		Parent escenaLogin = vistaLogin.load();
    		Stage escenarioLogin = new Stage();
    		escenarioLogin.setScene(new Scene(escenaLogin));
    		escenarioLogin.show();
    		actual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
