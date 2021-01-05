package application_model;

import application_model.Usuario;

public class Cuidador extends Usuario {
	private int id_cuidador;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;

	public Cuidador(String email, String password, String tipo, int id_cuidador, String nombre, String apellidos,
			String dni, String telefono) {
		super(email, password, tipo);
		this.id_cuidador = id_cuidador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}

	public int getid_cuidador() {
		return id_cuidador;
	}

	public void setid_cuidador(int id_cuidador) {
		this.id_cuidador = id_cuidador;
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