package application_controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import application_model.Cuidador;
import application_model.Doctor;
import application_model.Paciente;
import application_model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//CONTROLADOR INTERFAZ REGISTRO


public class register_controller {

    @FXML
    private Button servicios;

    @FXML
    private TextField apellidos;

    @FXML
    private Button contacto;

    @FXML
    private PasswordField password;

    @FXML
    private Button inicio;

    @FXML
    private Button volver;

    @FXML
    private TextField telefono;

    @FXML
    private Button somos;

    @FXML
    private TextField nombre;

    @FXML
    private Button sigRegistro;

    @FXML
    private TextField dni;

    @FXML
    private TextField email;
    
    @FXML
    private TextField userType;
    
    @FXML
    private Label labelApellidos;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelContraseña;

    @FXML
    private Label labelTelefono;
    
    @FXML
    private Label labelNombre;
    
    @FXML
    private Label labelDni;
    
    @FXML
    private Label errorDni;
    
    @FXML
    private Label errorNombre;
    
    @FXML
    private Label errorApellidos;
    
    @FXML
    private Label errorPass;
    
    @FXML
    private Label errorEmail;
    
    @FXML
    private Label errorTelefono;
    
    
    public void setUsuarioMedico() {
    	userType.setText("Medico");
    	userType.setEditable(false);
    }
    
    public void setUsuarioCuidador() {
    	userType.setText("Cuidador");
    	userType.setEditable(false);
    }
    
    public void setUsuarioPaciente() {
    	userType.setText("Paciente");
    	userType.setEditable(false);
    }
    
    @FXML
    void volverCampoNormal(MouseEvent event) {
    	nombre.setStyle("-fx-border-color: none");
    	labelNombre.setStyle("-fx-text-fill:black");
    	errorNombre.setVisible(false);
    }
    
    @FXML
    void volverCampoDni(MouseEvent event) {
    	dni.setStyle("-fx-border-color: none");
    	labelDni.setStyle("-fx-text-fill:black");
    	errorDni.setVisible(false);
    }

    @FXML
    void volverCampoTel(MouseEvent event) {
    	telefono.setStyle("-fx-border-color: none");
    	labelTelefono.setStyle("-fx-text-fill:black");
    	errorTelefono.setVisible(false);
    }

    @FXML
    void volverCampoLastName(MouseEvent event) {
    	apellidos.setStyle("-fx-border-color: none");
    	labelApellidos.setStyle("-fx-text-fill:black");
    	errorApellidos.setVisible(false);
    }

    @FXML
    void volverCampoEmail(MouseEvent event) {
    	email.setStyle("-fx-border-color: none");
    	labelCorreo.setStyle("-fx-text-fill:black");
    	errorEmail.setVisible(false);
    }

    @FXML
    void volverCampoPass(MouseEvent event) {
    	password.setStyle("-fx-border-color: none");
    	labelContraseña.setStyle("-fx-text-fill:black");
    	errorPass.setVisible(false);
    }

    @FXML
    void volverTipoUsuario(ActionEvent event) {
    	try {
    		FXMLLoader vistaTipoUsuario = new FXMLLoader(getClass().getResource("/application_view/register_type.fxml"));
    		register_type_controller controlTipoUsuraio = new register_type_controller();
    		vistaTipoUsuario.setController(controlTipoUsuraio);
    		Stage escenaActual = (Stage) volver.getScene().getWindow();
    		Parent escenaTipoUsuraio = vistaTipoUsuario.load();
    		Stage escenarioTipoUsuraio = new Stage();
    		escenarioTipoUsuraio.setScene(new Scene(escenaTipoUsuraio));
    		escenarioTipoUsuraio.show();
    		escenaActual.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public boolean validarUsuario() {
    	if(nombre.getText().isEmpty()) {
    		nombre.requestFocus();
    		labelNombre.setStyle("-fx-text-fill: red");
    		errorNombre.setVisible(true);
    		errorNombre.setText("Nombre no puede estar vacio");
    		nombre.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(nombre.getText().matches(".*\\d+.*")) {
    		nombre.requestFocus();
    		labelNombre.setStyle("-fx-text-fill: red");
    		errorNombre.setVisible(true);
    		errorNombre.setText("Nombre no puede contener numeros");
    		nombre.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(apellidos.getText().matches(".*\\d+.*")) {
    		apellidos.requestFocus();
    		labelApellidos.setStyle("-fx-text-fill: red");
    		errorApellidos.setVisible(true);
    		errorApellidos.setText("Apellidos no puede contener numeros");
    		apellidos.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(apellidos.getText().isEmpty()) {
    		apellidos.requestFocus();
    		labelApellidos.setStyle("-fx-text-fill: red");
    		errorApellidos.setVisible(true);
    		errorApellidos.setText("Apellidos no puede estar vacio");
    		apellidos.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(dni.getText().isEmpty()) {
    		dni.requestFocus();
    		labelDni.setStyle("-fx-text-fill: red");
    		errorDni.setVisible(true);
    		errorDni.setText("DNI no puede estar vacio");
    		dni.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!dni.getText().matches(".*[a-zA-Z].*")) {
    		dni.requestFocus();
    		labelDni.setStyle("-fx-text-fill: red");
    		errorDni.setVisible(true);
    		errorDni.setText("DNI debe contener una letra");
    		dni.setStyle("-fx-text-fill: red");
    		return false;
    	}
    	else if(dni.getText().length() < 9) {
    		dni.requestFocus();
    		labelDni.setStyle("-fx-text-fill: red");
    		errorDni.setVisible(true);
    		errorDni.setText("DNI debe ser al menos de 9 caracteres, incluyendo la letra");
    		dni.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(email.getText().isEmpty()) {
    		email.requestFocus();
    		labelCorreo.setStyle("-fx-text-fill: red");
    		errorEmail.setVisible(true);
    		errorEmail.setText("Direccion de correo no puede estar vacio");
    		email.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!email.getText().contains("@")) {
    		email.requestFocus();
    		labelCorreo.setStyle("-fx-text-fill: red");
    		errorEmail.setVisible(true);
    		errorEmail.setText("Direccion de correo no contiene @");
    		email.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!email.getText().contains(".")) {
    		email.requestFocus();
    		labelCorreo.setStyle("-fx-text-fill: red");
    		errorEmail.setVisible(true);
    		errorEmail.setText("Direccion de correo no contiene .");
    		email.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(telefono.getText().isEmpty()) {
    		telefono.requestFocus();
    		labelTelefono.setStyle("-fx-text-fill: red");
    		errorTelefono.setVisible(true);
    		errorTelefono.setText("Telefono no puede estar vacio");
    		telefono.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(telefono.getText().matches(".*[a-zA-Z]+.*")) {
    		telefono.requestFocus();
    		labelTelefono.setStyle("-fx-text-fill: red");
    		errorTelefono.setVisible(true);
    		errorTelefono.setText("Telefono no puede contener letras");
    		telefono.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(telefono.getText().length() < 9) {
    		telefono.requestFocus();
    		labelTelefono.setStyle("-fx-text-fill: red");
    		errorTelefono.setVisible(true);
    		errorTelefono.setText("Telefono debe contener 9 digitos como minimo");
    		telefono.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(password.getText().isEmpty()) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña no puede estar vacia");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!password.getText().matches(".*[a-z].*")) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña debe contener al menos una letra Minuscula");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!password.getText().matches(".*[A-Z].*")) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña debe contener al menos una letra Mayuscula");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!password.getText().matches(".*\\d.*")) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña debe contener al menos un Numero");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(!password.getText().matches(".*\\W.*")) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña debe contener al menos un Caracter Especial");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}else if(password.getText().length() < 8) {
    		password.requestFocus();
    		labelContraseña.setStyle("-fx-text-fill: red");
    		errorPass.setVisible(true);
    		errorPass.setText("Contraseña debe ser al menos de 8 caracteres");
    		password.setStyle("-fx-text-fill: red");
    		return false;
    	}
    return true;
    	
    }
    
    public void crearUsuario(Usuario usuario) {
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	Vector<Usuario> listaUsuarios = jsonObjeto("usuarios.json");
		File archivoAntiguo = new File("usuarios.json");
		archivoAntiguo.delete();
		Usuario nuevoUsuario = new Usuario(usuario.getEmail(), usuario.getPassword(), usuario.getTipo());
		listaUsuarios.add(nuevoUsuario);
    	try(FileWriter usuarios = new FileWriter("usuarios.json", true)) {
    		gson.toJson(listaUsuarios,usuarios);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
		
    }
    
	private static <T> Vector<T> jsonObjeto(String sJson) {
        Gson gson = new Gson();
        Vector<T> usuarios = new Vector<T>();
        try(Reader reader = new FileReader(sJson)){
        	Type tipoListaUsuarios = new TypeToken<Vector<T>>(){}.getType();
        	usuarios = gson.fromJson(reader, tipoListaUsuarios);
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
	}
    
    @FXML
    void guardarUsuario(ActionEvent event) {
    	if(validarUsuario() == true) {
    		if(userType.getText().equals("Paciente")) {
    	    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    			Vector<Paciente> listaPacientes = jsonObjeto("pacientes.json");
    			File archivoAntiguo = new File("pacientes.json");
    			archivoAntiguo.delete();
    			Paciente usuarioPaciente = new Paciente(email.getText(), password.getText(), userType.getText(), 1, new Random().nextInt(10000),nombre.getText(), 
    			    	apellidos.getText(), dni.getText(), telefono.getText());
    	    	listaPacientes.add(usuarioPaciente);
    	    	crearUsuario(usuarioPaciente);
    	    	try(FileWriter usuarios = new FileWriter("pacientes.json", true)) {
    	    		gson.toJson(listaPacientes,usuarios);
    	    		
    	    	} catch(IOException e) {
    	    		e.printStackTrace();
    	    	}
    		} else if(userType.getText().equals("Cuidador")) {
    	    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    			Vector<Cuidador> listaCuidadores = jsonObjeto("cuidadores.json");
    			File archivoAntiguo = new File("cuidadores.json");
    			archivoAntiguo.delete();
    			Cuidador usuarioCuidador = new Cuidador(email.getText(), password.getText(), userType.getText(), new Random().nextInt(10000), nombre.getText(), 
    			    	apellidos.getText(), dni.getText(), telefono.getText());
    	    	listaCuidadores.add(usuarioCuidador);
    	    	crearUsuario(usuarioCuidador);
    	    	try(FileWriter usuarios = new FileWriter("cuidadores.json", true)) {
    	    		gson.toJson(listaCuidadores,usuarios);
    	    		
    	    	} catch(IOException e) {
    	    		e.printStackTrace();
    	    	}
    		}else {
    	    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    			Vector<Doctor> listaDoctores = jsonObjeto("doctores.json");
    			File archivoAntiguo = new File("doctores.json");
    			archivoAntiguo.delete();
    			Doctor usuarioDoctor = new Doctor(email.getText(), password.getText(), userType.getText(), 1, nombre.getText(), 
    			    	apellidos.getText(), dni.getText(), telefono.getText());
    	    	listaDoctores.add(usuarioDoctor);
    	    	crearUsuario(usuarioDoctor);
    	    	try(FileWriter usuarios = new FileWriter("doctores.json", true)) {
    	    		gson.toJson(listaDoctores,usuarios);
    	    		
    	    	} catch(IOException e) {
    	    		e.printStackTrace();
    	    	}
    		}
	    	
	    	try {
	    		FXMLLoader vistaRegistroCorrecto = new FXMLLoader(getClass().getResource("/application_view/Registro_Correcto.fxml"));
	    		usuarioExito_controller controlInicio = new usuarioExito_controller();
	    		vistaRegistroCorrecto.setController(controlInicio);
	    		Stage actual = (Stage) volver.getScene().getWindow();
	    		Parent escenaRegistroCorrecto = vistaRegistroCorrecto.load();
	    		Stage escenarioRegistroCorrecto = new Stage();
	    		escenarioRegistroCorrecto.setScene(new Scene(escenaRegistroCorrecto));
	    		escenarioRegistroCorrecto.setResizable(false);
	    		escenarioRegistroCorrecto.show();
	    		actual.close();
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
    	}
    }

}
