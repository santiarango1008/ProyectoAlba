package application_model;

import application_model.Usuario;

public class Doctor extends Usuario {
	private int id_doctor;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;

	public Doctor(String email, String password, String tipo, int id_doctor, String nombre, String apellidos,
			String dni, String telefono) {
		super(email, password, tipo);
		this.id_doctor = id_doctor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public int getid_doctor() {
		return id_doctor;
	}

	public void setid_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
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


}
