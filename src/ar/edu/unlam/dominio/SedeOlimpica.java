package ar.edu.unlam.dominio;

import java.util.List;
import java.util.ArrayList;

public class SedeOlimpica {
	
	private List <Complejo> complejos;
	
	public SedeOlimpica() {
		this.complejos = new ArrayList<>();
	}

	public Boolean crearComplejo(Complejo complejo) {
		return complejos.add(complejo);
	}

}
