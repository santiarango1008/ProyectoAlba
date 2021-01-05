package application_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//CONTROLADOR INTERFAZ TIPO DE REGISTRO

public class register_type_controller {

    @FXML
    private Button servicios;

    @FXML
    private Button contacto;

    @FXML
    private Button paciente;

    @FXML
    private Button medico;

    @FXML
    private Button inicio;

    @FXML
    private Button volver;

    @FXML
    private Button cuidador;

    @FXML
    private Button somos;

    @FXML
    void volverInicio(ActionEvent event) {
    	try {
    		FXMLLoader vistaInicio = new FXMLLoader(getClass().getResource("/application_view/index.fxml"));
    		index_controller controlInicio = new index_controller();
    		vistaInicio.setController(controlInicio);
    		Stage escenaActual = (Stage) volver.getScene().getWindow();
    		Parent escenaInicio = vistaInicio.load();
    		Stage escenarioInicio = new Stage();
    		escenarioInicio.setScene(new Scene(escenaInicio));
    		escenarioInicio.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void tipoUsuarioMedico(ActionEvent event) {
    	
    	try {
    		FXMLLoader vistaRegistro = new FXMLLoader(getClass().getResource("/application_view/Register.fxml"));
    		register_controller controlRegistro = new register_controller();
    		vistaRegistro.setController(controlRegistro);
    		Stage escenaActual = (Stage) medico.getScene().getWindow();
    		Parent escenaRegistro = vistaRegistro.load();
    		controlRegistro.setUsuarioMedico();
    		Stage escenarioRegistro = new Stage();
    		escenarioRegistro.setScene(new Scene(escenaRegistro));
    		escenarioRegistro.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    @FXML
    void tipoUsuarioPaciente(ActionEvent event) {
    	try {
    		FXMLLoader vistaRegistro = new FXMLLoader(getClass().getResource("/application_view/Register.fxml"));
    		register_controller controlRegistro = new register_controller();
    		vistaRegistro.setController(controlRegistro);
    		Stage escenaActual = (Stage) paciente.getScene().getWindow();
    		Parent escenaRegistro = vistaRegistro.load();
    		controlRegistro.setUsuarioPaciente();
    		Stage escenarioRegistro = new Stage();
    		escenarioRegistro.setScene(new Scene(escenaRegistro));
    		escenarioRegistro.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void tipoUsuarioCuidador(ActionEvent event) {
    	try {
    		FXMLLoader vistaRegistro = new FXMLLoader(getClass().getResource("/application_view/Register.fxml"));
    		register_controller controlRegistro = new register_controller();
    		vistaRegistro.setController(controlRegistro);
    		Stage escenaActual = (Stage) cuidador.getScene().getWindow();
    		Parent escenaRegistro = vistaRegistro.load();
    		controlRegistro.setUsuarioCuidador();
    		Stage escenarioRegistro = new Stage();
    		escenarioRegistro.setScene(new Scene(escenaRegistro));
    		escenarioRegistro.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

}
