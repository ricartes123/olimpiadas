package ar.edu.unlam.dominio;

public class Comisario {
	private Integer dni;
	private String nombre;
	private Integer edad;
	private TipoComisario tipoComisario;
	
	public Comisario(Integer dni, String nombre, Integer edad, TipoComisario tipoComisario) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.tipoComisario = tipoComisario;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public TipoComisario getTipoComisario() {
		return tipoComisario;
	}

	public void setTipoComisario(TipoComisario tipoComisario) {
		this.tipoComisario = tipoComisario;
	}
	
	
	
	
}
