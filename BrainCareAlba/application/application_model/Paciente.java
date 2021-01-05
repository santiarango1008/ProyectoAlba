package application_model;

import application_model.Usuario;

public class Paciente extends Usuario {
	private int id_doctor;
	private int id_paciente;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	
	public Paciente(String email, String password, String tipo, int id_doctor, int id_paciente, String nombre,
			String apellidos, String dni, String telefono) {
		super(email, password, tipo);
		this.id_doctor = id_doctor;
		this.id_paciente = id_paciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}


}

