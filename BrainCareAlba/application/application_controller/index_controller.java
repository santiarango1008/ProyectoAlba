package application_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//CONTROLADOR INTERFAZ INDEX

public class index_controller {

    @FXML
    private Button btnServicios;

    @FXML
    private Button quienesSomos;

    @FXML
    private Button contacto;

    @FXML
    private Button btnInicio;

    @FXML
    private Button iniciarSesion;

    @FXML
    private Button btnRegistro;

    @FXML
    void login(ActionEvent event) {
    	try {
    		FXMLLoader vistaLogin = new FXMLLoader(getClass().getResource("/application_view/login.fxml"));
    		login_controller controlLogin = new login_controller();
    		vistaLogin.setController(controlLogin);
    		Stage escenaActual = (Stage) iniciarSesion.getScene().getWindow();
    		Parent escenaLogin = vistaLogin.load();
    		Stage escenarioLogin = new Stage();
    		escenarioLogin.setScene(new Scene(escenaLogin));
    		escenarioLogin.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void Registrarse(ActionEvent event) {
    	try {
    		FXMLLoader vistaRegistro = new FXMLLoader(getClass().getResource("/application_view/register_type.fxml"));
    		register_type_controller controlRegistro = new register_type_controller();
    		vistaRegistro.setController(controlRegistro);
    		Stage escenaActual = (Stage) btnRegistro.getScene().getWindow();
    		Parent escenaRegistro = vistaRegistro.load();
    		Stage escenarioRegistro = new Stage();
    		escenarioRegistro.setScene(new Scene(escenaRegistro));
    		escenarioRegistro.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void quienes(ActionEvent event) {
    	
    }
    @FXML
    void Contacto(ActionEvent event) {
    	
    
}
    @FXML
    void Servicio(ActionEvent event) {
    	
}
	
}
