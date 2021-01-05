package application_controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application_model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//CONTROLADOR INTERFAZ PACIENTE

public class pacient_controller {

    @FXML
    private Button contacto;

    @FXML
    private Button medicamento;

    @FXML
    private Button cita;
    
    @FXML
    private Button cerrarSesion;
    
    @FXML
    private Label nombreUsuario;
    
    
    public void setNombre(String texto) {
    	nombreUsuario.setText(texto);
		nombreUsuario.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
    }
    
    
	private static Vector<Paciente> jsonObjeto(String sJson) {
        Gson gson = new Gson();
        Vector<Paciente> Pacientes = new Vector<Paciente>();
        try(Reader reader = new FileReader(sJson)){
        	Type tipoListaPacientes = new TypeToken<Vector<Paciente>>(){}.getType();
        	Pacientes = gson.fromJson(reader, tipoListaPacientes);
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Pacientes;
	}
    
    public Paciente encontrarPaciente(String email) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> listaPacientes = jsonObjeto("pacientes.json");
    	for(Paciente p: listaPacientes) {
    		if(p.getEmail().equals(email))
    			setNombre(p.getNombre() + "," + p.getTipo());
    		paciente = p;
    	}
    	return paciente;
    }
    
    public Paciente encontrarPacienteNombre(String nombre) {
    	Paciente paciente = new Paciente();
    	Vector<Paciente> listaPacientes = jsonObjeto("pacientes.json");
    	for(Paciente p: listaPacientes) {
    		if(p.getNombre().equals(nombre))
    		paciente = p;
    	}
    	return paciente;
    }
	
    @FXML
    void cerrarSesion(ActionEvent event) {
    	try {
    		FXMLLoader vistaConfirmarCerrar = new FXMLLoader(getClass().getResource("/application_view/Confirmar_Cerrar_Sesion.fxml"));
    		confirmar_cerrar_sesion_controller controlConfirmarCerrar = new confirmar_cerrar_sesion_controller();
    		vistaConfirmarCerrar.setController(controlConfirmarCerrar);

    		Stage actual = (Stage) cerrarSesion.getScene().getWindow();
    		Parent escenaConfirmarCerrar = vistaConfirmarCerrar.load();
    		controlConfirmarCerrar.esconderNombre();
    		controlConfirmarCerrar.setNombre(nombreUsuario.getText());
    		Stage escenarioConfirmarCerrar = new Stage();
    		escenarioConfirmarCerrar.setResizable(false);
    		escenarioConfirmarCerrar.setScene(new Scene(escenaConfirmarCerrar));
    		escenarioConfirmarCerrar.show();
    		actual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    	

    @FXML
    void contactoMedico(ActionEvent event) {

    }

    @FXML
    void horarioMedicamento(ActionEvent event) {

    }

}
