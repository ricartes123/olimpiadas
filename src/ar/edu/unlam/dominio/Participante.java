package ar.edu.unlam.dominio;

import java.util.Objects;

public class Participante {
	private Integer dni;
	private String nombre;
	private Integer edad;
	
	public Participante(Integer dni, String nombre, Integer edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
}
