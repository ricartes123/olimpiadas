package ar.edu.unlam.dominio;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ComplejoPolideportivo extends Complejo {

	private List <AreaDesignada> areasDesignadas;
	private Map <String, AreaDesignada> mapa;

	public ComplejoPolideportivo(String nombre, Double areaTotalOcupada, AreaDesignada areaDesignada) {
		super(nombre, areaTotalOcupada);
		this.areasDesignadas = new ArrayList<>();
		areasDesignadas.add(areaDesignada);
		mapa = new HashMap<>();
	}

	public Boolean agregarAreaDesignada(AreaDesignada areaDesignada) throws IndicadorAreaException {
		for (AreaDesignada areaDesignadaEncontrada : areasDesignadas) {
			if (areaDesignadaEncontrada.equals(areaDesignada)) {
				throw new IndicadorAreaException("Indicador repetido");
			}
		}
		
		return areasDesignadas.add(areaDesignada);
	}
	
	public void agregarComplejoPolideportivoAlMapa(String nombre, AreaDesignada area) {
		mapa.put(nombre, area);
	}
	
	public Map <String, AreaDesignada> getMapa(){
		return mapa;
	}
	 
	

	@Override
	public Boolean agregarEvento(Evento evento) {
		return super.getEventos().add(evento);
	}
	
	

}
