package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestOlimpiadas {

	private SedeOlimpica sede;
	private Complejo complejoSimple;
	private Complejo complejoPolideportivo;

	@Before
	public void setUp() {
		this.sede = new SedeOlimpica();
		this.complejoSimple = new ComplejoSimple("Complejo Simple", 12.0);
		this.complejoPolideportivo = new ComplejoPolideportivo("Complejo Deportivo", 12.0, AreaDesignada.CENTRO);
	}

	@Test
	public void queSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpica() {
		Boolean seCreo = this.sede.crearComplejo(this.complejoSimple);
		assertTrue(seCreo);
	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaEnUnaSedeOlimpica() {
		Boolean seCreo = this.sede.crearComplejo(this.complejoPolideportivo);
		assertTrue(seCreo);
	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaYUnEventoEnUnaSedeOlimpica() {
		this.sede.crearComplejo(this.complejoPolideportivo);

		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);

		Boolean seAgrego = this.complejoPolideportivo.agregarEvento(evento1);
		assertTrue(seAgrego);
	}

	@Test(expected = IndicadorAreaException.class)
	public void queAlAgregarUnAreaAUnPolideportivoConIndicadorYaExistenteLanceUnaExcepcionIndicadorAreaException()
			throws IndicadorAreaException {
		this.sede.crearComplejo(this.complejoPolideportivo);
		((ComplejoPolideportivo) this.complejoPolideportivo).agregarAreaDesignada(AreaDesignada.CENTRO);
	}

	@Test
	public void queSePuedaAgregarUnComisarioJuezAUnEvento() {
		this.sede.crearComplejo(this.complejoSimple);
		Comisario comisarioJuez1 = new Comisario(44937298, "Pablo", 20, TipoComisario.JUEZ);

		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);

		this.complejoPolideportivo.agregarEvento(evento1);
		
		Boolean seAgrego = evento1.agregarComisario(comisarioJuez1);

		assertTrue(seAgrego);
	}
	
//	@Test(expected = ComisarioException.class)
//	public void queAlAgregarUnComisarioJuezInexistenteLanceUnaExcepcionComisarioException() throws ComisarioException{
//		this.sede.crearComplejo(this.complejoSimple);
//		Comisario comisarioJuez1 = new Comisario(44937298, "Pablo", 20, TipoComisario.JUEZ);
//		Comisario comisarioJuez2 = new Comisario(44937298, "Pablo", 20, TipoComisario.JUEZ);
//		
//		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);
//
//		this.complejoPolideportivo.agregarEvento(evento1);
//		
//		evento1.agregarComisario(comisarioJuez1);
//		evento1.agregarComisario(comisarioJuez2);
//	}
	
	@Test
	public void queSePuedaCalcularElTotalDeParticipantesDeLosEventosDeUnComplejoSimple() {
		this.sede.crearComplejo(this.complejoSimple);
		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);
		Evento evento2 = new Evento(LocalDate.of(2025, 02, 11), 2.0, 2, 2);
		
		Participante participante1 = new Participante(44939992,"Pedro",21);
		Participante participante2 = new Participante(54939892,"Juan",12);
		
		this.complejoSimple.agregarEvento(evento1);
		this.complejoSimple.agregarEvento(evento2);
		
		evento1.agregarParticipante(participante1);
		evento1.agregarParticipante(participante2);
		
		evento2.agregarParticipante(participante1);
		evento2.agregarParticipante(participante2);
		
		Integer totalEsperado = 4;
		
		Integer totalObtenido = this.complejoSimple.obtenerTotalDeParticipantesDeTodosLosEventos();
		
		assertEquals(totalEsperado, totalObtenido);
	}
	
	@Test
	public void queSePuedaCalcularElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico() {
		this.sede.crearComplejo(this.complejoSimple);
		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);
		
		Comisario comisarioJuez1 = new Comisario(41922228, "Juana", 30, TipoComisario.JUEZ);
		Comisario comisarioObservador1 = new Comisario(44917299, "Pablo", 20, TipoComisario.OBSERVADOR);
		Comisario comisarioObservador2 = new Comisario(44927298, "Pedro", 20, TipoComisario.OBSERVADOR);
	
		this.complejoSimple.agregarEvento(evento1);
		evento1.agregarComisario(comisarioJuez1);
		evento1.agregarComisario(comisarioObservador1);
		evento1.agregarComisario(comisarioObservador2);
		
		Double promedioEsperado = 10.0;
		
		Double promedioObtenido = evento1.obtenerPromedioDeEdadDeLosComisariosObservadores();
		
		assertEquals(promedioEsperado, promedioObtenido);
	}
	
	@Test
	public void queSePuedaObtenerUnaListaDeComisariosJuecesDeUnEventoEspecificoSinRepeticiones() {
		this.sede.crearComplejo(this.complejoSimple);
		Evento evento1 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);
		Evento evento2 = new Evento(LocalDate.of(2024, 06, 13), 1.5, 2, 2);
		
		Comisario comisarioJuez1 = new Comisario(41922228, "Juana", 30, TipoComisario.JUEZ);
		Comisario comisarioJuez2 = new Comisario(41922228, "Juana", 30, TipoComisario.JUEZ);
		
		this.complejoSimple.agregarEvento(evento1);
		this.complejoSimple.agregarEvento(evento2);
		
		evento1.agregarComisario(comisarioJuez1);
		evento1.agregarComisario(comisarioJuez2);
		
		Integer valorEsperado = 1;
		
		Integer valorObtenido = evento1.obtenerListaDeComisariosJueces().size();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerUnMapaDeUnComplejoPolideportivoConNombreDeComplejoYUbicacion() {
		this.sede.crearComplejo(this.complejoPolideportivo);
		
		((ComplejoPolideportivo) this.complejoPolideportivo).agregarComplejoPolideportivoAlMapa("Complejo1", AreaDesignada.CENTRO);
		
		Map<String, AreaDesignada> mapa = ((ComplejoPolideportivo) complejoPolideportivo).getMapa();
		
		assertEquals(1, mapa.size());
        assertEquals(AreaDesignada.CENTRO, mapa.get("Complejo1"));	
	}
}
