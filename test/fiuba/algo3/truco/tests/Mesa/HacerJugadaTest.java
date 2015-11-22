package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Palo.Espada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Jugadas.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraVuelta;

public class HacerJugadaTest {

	Mesa mesa;
	
	Jugador Juan;
	Jugador Pedro;
	Jugador Martin;
	Jugador Ignacio;
	
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	
	Equipo azules;
	Equipo rojos;
	
	@Before
	public void setUp() {
		
		Juan = new Jugador("Juan");
		Pedro = new Jugador("Pedro");
		Martin = new Jugador("Martin");
		Ignacio = new Jugador("Ignacio");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan, Pedro));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Martin, Ignacio));
		
		azules = new Equipo("equipo1", jugadoresEquipo1);
		rojos = new Equipo("equipo2", jugadoresEquipo2);

		boolean seJuegaConFlor = false;
		
		mesa = new Mesa(azules, rojos, seJuegaConFlor);

	}
	
	@Test(expected = JugadorNoPieNoPuedeCantarEnvido.class)
	public void siJugadorNoEsPieNoPuedeCantarEnvido() {
		
		mesa.envido();
		
	}
	
	@Test
	public void envidoNoQueridoEsUnPuntoParaElEquipoContrario() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.noQuieroEnvido();
		Assert.assertEquals(mesa.puntaje(azules), 1);

	}
	
	@Test
	public void trucoNoQueridoEsUnPuntoParaElEquipoContrario() {
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.truco();
		mesa.noQuieroTruco();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 1);

	}
	
	@Test(expected = JugadorNoPuedeCantarTantoNoEsPrimeraVuelta.class)
	public void noSePuedeCantarEnvidoDespuesDeLaPrimerRonda() {
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();

	}

	@Test(expected = JuegoSinFlorException.class)
	public void noSePuedeCantarFlorCuandoSeJuegaSinFlor() {

		List<Carta> lista = new ArrayList<>(Arrays.asList(new Carta(7,new Espada()),new Carta(3,new Espada()),new Carta(2,new Espada())));
		Juan.setMano(new Mano(lista));
		Assert.assertEquals(Juan.getNombre(),mesa.getJugadorActual().getNombre());
		mesa.flor();

	}

	@Test
	public void envidoEnvidoNoQueridoFuncionaCorrectamente() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.envidoEnvido();
		mesa.noQuieroEnvido();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 2);

	}

	@Test
	public void retrucoNoQueridoFuncionaCorrectamente() {

		mesa.truco();
		mesa.retruco();
		mesa.noQuieroTruco();
		Assert.assertTrue(mesa.puntaje(azules) == 0);
		Assert.assertTrue(mesa.puntaje(rojos) == 2);

	}

	@Test
	public void vale4NoQueridoFuncionaCorrectamente() {

		mesa.truco();
		mesa.retruco();
		mesa.valeCuatro();
		mesa.noQuieroTruco();
		Assert.assertEquals(mesa.puntaje(azules), 3);
		Assert.assertEquals(mesa.puntaje(rojos), 0);

	}

	@Test
	public void envidoVaAntesQueTruco() {

		mesa.truco();
		mesa.envido();
		mesa.noQuieroEnvido();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 1);

	}

	@Test
	public void faltaEnvidoQueridaTerminaElJuego() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.faltaEnvido();
		mesa.quieroEnvido();
		Assert.assertTrue(
				mesa.puntaje(rojos) == 0 && mesa.puntaje(azules) == 30
						||
						mesa.puntaje(rojos) == 30 && mesa.puntaje(azules) == 0);

	}
	

}
