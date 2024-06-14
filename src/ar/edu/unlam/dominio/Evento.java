package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Evento {
	
	private LocalDate fecha;
	private Double duracion;
	private Integer nroParticipantes;
	private Integer nroComisarios;
	private Set <Comisario> comisarios;
	private Set <Participante> participantes;
	
	public Evento(LocalDate fecha, Double duracion, Integer nroParticipantes, Integer nroComisarios) {
		super();
		this.fecha = fecha;
		this.duracion = duracion;
		this.nroParticipantes = nroParticipantes;
		this.nroComisarios = nroComisarios;
		this.comisarios = new TreeSet<>(new ComparadorDeComisarios());
		this.participantes = new HashSet<>();
		
	}
	
	public Integer getNroParticipantes() {
		return nroParticipantes;
	}

	public void setNroParticipantes(Integer nroParticipantes) {
		this.nroParticipantes = nroParticipantes;
	}

	public Integer getNroComisarios() {
		return nroComisarios;
	}

	public void setNroComisarios(Integer nroComisarios) {
		this.nroComisarios = nroComisarios;
	}

	public Boolean agregarComisario(Comisario comisario) {
		
		if(comisarios.size()>=getNroComisarios()) {
			return false;
		}
		
		return comisarios.add(comisario);
	}

	public Boolean agregarParticipante(Participante participante) {
		return participantes.add(participante);
	}
	

	public Set<Comisario> getComisarios() {
		return comisarios;
	}

	public void setComisarios(Set<Comisario> comisarios) {
		this.comisarios = comisarios;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public Double obtenerPromedioDeEdadDeLosComisariosObservadores() {
		
		Double totalEdades = 0.0;
		Double promedio = 0.0;
		
		for (Comisario comisario : comisarios) {
			if(comisario.getTipoComisario().equals(TipoComisario.OBSERVADOR)) {
				totalEdades += comisario.getEdad();
				promedio = totalEdades / getComisarios().size();
			}
		}

		return promedio;
	}

	public Set<Comisario> obtenerListaDeComisariosJueces() {
		
		Set<Comisario> comisariosJueces = new TreeSet<>(new ComparadorDeComisarios());
		
		for (Comisario comisario : comisarios) {
			if(comisario.getTipoComisario().equals(TipoComisario.JUEZ)){
				comisariosJueces.add(comisario);
			}
		}
		
		return comisariosJueces;
	}
	
	
	
	
}
