package ar.edu.unlam.dominio;

public class ComplejoSimple extends Complejo {

	public ComplejoSimple(String nombre, Double areaTotalOcupada) {
		super(nombre, areaTotalOcupada);
		
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		return super.getEventos().add(evento);
	}

}
