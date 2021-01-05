package application_model;

public class Usuario {
	private String email;
	private String password;
	private String tipo;
	
	public Usuario() {
		
	}
	
	public Usuario(String email, String password, String tipo) {
		super();
		this.email = email;
		this.password = password;
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

}
