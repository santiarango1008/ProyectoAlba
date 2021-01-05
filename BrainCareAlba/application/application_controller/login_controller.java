package application_controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application_model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//CONTROLADOR INTERFAZ LOGIN

public class login_controller {

    @FXML
    private Button volverAtras;

    @FXML
    private Button siguiente;
    
    @FXML
    private ImageView errorCorreo;
    
    @FXML
    private ImageView error;
    
    @FXML
    private TextField email;

    @FXML
    private PasswordField contraseña;
    
    public void pantallaDefecto() {
    	error.setVisible(false);
    }

    @FXML
    void volverInicio(ActionEvent event) {
    	try {
    		FXMLLoader vistaInicio = new FXMLLoader(getClass().getResource("/application_view/index.fxml"));
    		index_controller controlInicio = new index_controller();
    		vistaInicio.setController(controlInicio);
    		Stage escenaActual = (Stage) volverAtras.getScene().getWindow();
    		
    		Parent escenaInicio = vistaInicio.load();
    		Stage escenarioInicio = new Stage();
    		escenarioInicio.setScene(new Scene(escenaInicio));
    		escenarioInicio.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
	private static Vector<Usuario> jsonObjecto(String sJson) {
        Gson gson = new Gson();
        Vector<Usuario> usuarios = new Vector<Usuario>();
        try(Reader reader = new FileReader(sJson)){
        	Type tipoListaUsuarios = new TypeToken<Vector<Usuario>>(){}.getType();
        	usuarios = gson.fromJson(reader, tipoListaUsuarios);
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
	}
	
	public void mostrarVista() {
    	Vector<Usuario> usuarios = jsonObjecto("usuarios.json");
    	for(int i = 0; i < usuarios.size(); i++) {
        	if(email.getText().equals(usuarios.get(i).getEmail()) && contraseña.getText().equals(usuarios.get(i).getPassword())) {
        		if(usuarios.get(i).getTipo().equals("Paciente")) {
                	try {
                		FXMLLoader vistaPaciente = new FXMLLoader(getClass().getResource("/application_view/pacient.fxml"));
                		pacient_controller controlPaciente = new pacient_controller();
                		vistaPaciente.setController(controlPaciente);
                		Stage escenaActual = (Stage) siguiente.getScene().getWindow();
                		Parent escenaPaciente = vistaPaciente.load();
                		controlPaciente.encontrarPaciente(email.getText());
                		Stage escenarioPaciente = new Stage();
                		escenarioPaciente.setScene(new Scene(escenaPaciente));
                		escenarioPaciente.show();
                		escenaActual.close();
                	} catch(Exception e) {
                		e.printStackTrace();
                	}
        		}else if(usuarios.get(i).getTipo().equals("Cuidador")) {
                	try {
                		FXMLLoader vistaCuidador = new FXMLLoader(getClass().getResource("/application_view/Carer.fxml"));
                		cuidador_controller controlCuidador = new cuidador_controller();
                		vistaCuidador.setController(controlCuidador);
                		Stage escenaActual = (Stage) siguiente.getScene().getWindow();
                		
                		Parent escenaCuidador = vistaCuidador.load();
                		Stage escenarioCuidador = new Stage();
                		escenarioCuidador.setScene(new Scene(escenaCuidador));
                		escenarioCuidador.show();
                		escenaActual.close();
                	} catch(Exception e) {
                		e.printStackTrace();
                	}
        		}else {
                	try {
                		FXMLLoader vistaDoctor = new FXMLLoader(getClass().getResource("/application_view/Doctor.fxml"));
                		doctor_controller controlDoctor = new doctor_controller();
                		vistaDoctor.setController(controlDoctor);
                		Stage escenaActual = (Stage) siguiente.getScene().getWindow();
                		
                		Parent escenaDoctor = vistaDoctor.load();
                		controlDoctor.encontrarDoctor(email.getText());
                		Stage escenarioDoctor = new Stage();
                		escenarioDoctor.setScene(new Scene(escenaDoctor));
                		escenarioDoctor.show();
                		escenaActual.close();
                	} catch(Exception e) {
                		e.printStackTrace();
                	}
        		}

    		}else if(!email.getText().equals(usuarios.get(i).getEmail()) || !contraseña.getText().equals(usuarios.get(i).getPassword())) {
    			email.requestFocus();
    			email.setStyle("-fx-border-color: red");
    			errorCorreo.setVisible(true);
    			contraseña.requestFocus();
    			contraseña.setStyle("-fx-border-color: red");
    			error.setVisible(true);
    		}
    	}
	}

    @FXML
    void validarUsuario(ActionEvent event) {
    	mostrarVista();
    }
    
    @FXML
    void volverCampoDefecto(MouseEvent event) {
    	errorCorreo.setVisible(false);
    	email.setStyle("-fx-border-color: none");
    	error.setVisible(false);
    	contraseña.setStyle("-fx-border-color: none");
    	
    }
    
    @FXML
    void campoPassDefecto(MouseEvent event) {
    	error.setVisible(false);
    	contraseña.setStyle("-fx-border-color: none");
    	errorCorreo.setVisible(false);
    	email.setStyle("-fx-border-color: none");
    }

}

