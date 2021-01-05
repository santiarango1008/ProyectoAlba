package application_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class confirmar_cerrar_sesion_controller {

    @FXML
    private Button salirSi;
    
    @FXML
    private Label nombreUsuario;

    @FXML
    private Button salirNo;
    
    public void setNombre(String texto) {
    	nombreUsuario.setText(texto);
    }
    
    public void esconderNombre() {
    	nombreUsuario.setVisible(false);
    }

    @FXML
    void volverInicio(ActionEvent event) {
    	try {
    		FXMLLoader vistaInicio = new FXMLLoader(getClass().getResource("/application_view/index.fxml"));
    		index_controller controlInicio = new index_controller();
    		vistaInicio.setController(controlInicio);
    		Stage escenaActual = (Stage) salirSi.getScene().getWindow();
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
    void cancelarCerrarSesion(ActionEvent event) {
    	if(nombreUsuario.getText().substring(nombreUsuario.getText().indexOf(',') + 1).equals("Paciente")) {
        	try {
        		FXMLLoader vistaPaciente = new FXMLLoader(getClass().getResource("/application_view/pacient.fxml"));
        		pacient_controller controlPaciente = new pacient_controller();
        		vistaPaciente.setController(controlPaciente);
            	Stage actual = (Stage) salirNo.getScene().getWindow();
        		Parent escenaPaciente = vistaPaciente.load();
        		controlPaciente.setNombre(nombreUsuario.getText());
        		Stage escenarioPaciente = new Stage();
        		escenarioPaciente.setScene(new Scene(escenaPaciente));
        		escenarioPaciente.show();
        		actual.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    	}else if(nombreUsuario.getText().substring(nombreUsuario.getText().indexOf(',') + 1).equals("Medico")) {
        	try {
        		FXMLLoader vistaDoctor = new FXMLLoader(getClass().getResource("/application_view/Doctor.fxml"));
        		doctor_controller controlDoctor = new doctor_controller();
        		vistaDoctor.setController(controlDoctor);
        		Stage escenaActual = (Stage) salirNo.getScene().getWindow();
        		
        		Parent escenaDoctor = vistaDoctor.load();
        		controlDoctor.setNombre(nombreUsuario.getText());
        		Stage escenarioDoctor = new Stage();
        		escenarioDoctor.setScene(new Scene(escenaDoctor));
        		escenarioDoctor.show();
        		escenaActual.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    	}else {
        	try {
        		FXMLLoader vistaCuidador = new FXMLLoader(getClass().getResource("/application_view/Carer.fxml"));
        		cuidador_controller controlCuidador = new cuidador_controller();
        		vistaCuidador.setController(controlCuidador);
        		Stage escenaActual = (Stage) salirNo.getScene().getWindow();
        		
        		Parent escenaCuidador = vistaCuidador.load();
        		Stage escenarioCuidador = new Stage();
        		escenarioCuidador.setScene(new Scene(escenaCuidador));
        		escenarioCuidador.show();
        		escenaActual.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    }

}
