package application_controller;


//import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application_model.Doctor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class doctor_controller {

    @FXML
    private Button cerrar;
    
    @FXML
    private Button enfermedades;
    
    @FXML
    private Button informes;
    
    @FXML
    private Button pacientes;
    
    @FXML
    private Label nombreUsuario;

    
    public void setNombre(String texto) {
    	nombreUsuario.setText(texto);
		nombreUsuario.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
    }
    
	private static Vector<Doctor> jsonObjeto(String sJson) {
        Gson gson = new Gson();
        Vector<Doctor> Doctores = new Vector<Doctor>();
        try(Reader reader = new FileReader(sJson)){
        	Type tipoListaDoctores = new TypeToken<Vector<Doctor>>(){}.getType();
        	Doctores = gson.fromJson(reader, tipoListaDoctores);
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Doctores;
	}
    
    public Doctor encontrarDoctor(String email) {
    	Doctor doctor = new Doctor();
    	Vector<Doctor> listaDoctores = jsonObjeto("doctores.json");
    	for(Doctor d: listaDoctores) {
    		if(d.getEmail().equals(email))
    			setNombre(d.getNombre() + "," + d.getTipo());
    			doctor = d;
    	}
    	return doctor;
    }
    
    public Doctor encontrarDoctorNombre(String name) {
    	Doctor doctor = new Doctor();
    	Vector<Doctor> listaDoctores = jsonObjeto("doctores.json");
    	for(Doctor d: listaDoctores) {
    		if(d.getNombre().equals(name))
    			doctor = d;
    	}
    	return doctor;
    }

   
    @FXML
    void cerrarSesion(ActionEvent event) {
    	try {
    		FXMLLoader vistaConfirmarCerrar = new FXMLLoader(getClass().getResource("/application_view/Confirmar_Cerrar_Sesion.fxml"));
    		confirmar_cerrar_sesion_controller controlConfirmarCerrar = new confirmar_cerrar_sesion_controller();
    		vistaConfirmarCerrar.setController(controlConfirmarCerrar);

    		Stage actual = (Stage) cerrar.getScene().getWindow();
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

}