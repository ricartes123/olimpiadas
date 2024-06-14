package ar.edu.unlam.dominio;

import java.util.Comparator;

public class ComparadorDeComisarios implements Comparator <Comisario> {

	@Override
	public int compare(Comisario comisario1, Comisario comisario2) {
		return comisario1.getDni().compareTo(comisario2.getDni());
	}
	
}
