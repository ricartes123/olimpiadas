package ar.edu.unlam.dominio;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Complejo {
	
	private String nombre;
	private Double areaTotalOcupada;
	private List <Evento> eventos;
	
	public Complejo(String nombre, Double areaTotalOcupada) {
		this.nombre = nombre;
		this.areaTotalOcupada = areaTotalOcupada;
		this.eventos = new ArrayList<>();
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public abstract Boolean agregarEvento(Evento evento);

	public Integer obtenerTotalDeParticipantesDeTodosLosEventos() {
		
		Integer total = 0;
		
		for (Evento evento : eventos) {
			total += evento.getParticipantes().size();
		}
		
		return total;
	}

}
