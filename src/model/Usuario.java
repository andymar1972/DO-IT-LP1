package model;

public class Usuario {
	
	private String nombresUsuario,apellidoPaterno,
	apellidoMaterno,fechaNacimiento,cargo;
	private static String codUsuario,contrase�a;

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	//Metodos Propios
	public String saludo() {
		return "Bienvenido "+nombresUsuario+" "+apellidoPaterno;
	}
}
