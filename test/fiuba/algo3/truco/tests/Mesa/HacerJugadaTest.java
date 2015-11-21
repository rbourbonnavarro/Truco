package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.JugadorNoPieNoPuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.Jugada.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Jugada.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraRonda;
import fiuba.algo3.truco.modelo.Jugada.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.JuegoConFlor;

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
	
	CalculadorTanto calculadorTanto;
	
	@Before
	public void setUp(){
		
		Juan = new Jugador("Juan");
		Pedro = new Jugador("Pedro");
		Martin = new Jugador("Martin");
		Ignacio = new Jugador("Ignacio");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan, Pedro));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Martin, Ignacio));
		
		azules = new Equipo("equipo1", jugadoresEquipo1);
		rojos = new Equipo("equipo2", jugadoresEquipo2);

		calculadorTanto = new JuegoConFlor();
		
		mesa = new Mesa(rojos, azules, calculadorTanto);
	}
	
	@Test(expected = JugadorNoPieNoPuedeCantarEnvido.class)
	public void siJugadorNoEsPieNoPuedeCantarEnvido(){
		
		mesa.envido();
		
	}
	
	@Test
	public void envidoNoQueridoEsUnPuntoParaElEquipoContrario(){

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.quieroEnvido(false);
		Assert.assertEquals(mesa.puntaje(rojos), 1);
	}
	
	@Test
	public void trucoNoQueridoEsUnPuntoParaElEquipoContrario(){
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.truco();
		mesa.quieroTruco(false);
		Assert.assertEquals(mesa.puntaje(rojos), 0);
		Assert.assertEquals(mesa.puntaje(azules), 1);
	}
	
	@Test(expected = JugadorNoPuedeCantarTantoNoEsPrimeraRonda.class)
	public void noSePuedeCantarEnvidoDespuesDeLaPrimerRonda(){
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
	}
	
	@Test(expected = NoSePuedeCantarEnvido.class)
	public void noSePuedeCantarEnvidoLuegoQueSeCantoFlor () {
		mesa.flor();
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),Juan.getNombre());
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),Martin.getNombre());
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),Pedro.getNombre());
		mesa.envido();
	}
	
	@Test
	public void envidoEnvidoNoQueridoGana2PuntosElEquipoContrario(){
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.envidoEnvido();
		mesa.quieroEnvido(false);
		Assert.assertEquals(mesa.puntaje(azules), 2);
		Assert.assertEquals(mesa.puntaje(rojos), 0);
		
	}	
	
	@Test
	public void envidoRealEnvidoNoQueridoGana2PuntosElEquipoContrario(){
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.realEnvido();
		mesa.quieroEnvido(false);
		Assert.assertEquals(mesa.puntaje(azules), 2);
		Assert.assertEquals(mesa.puntaje(rojos), 0);
	}
	
	@Test
	public void envidoFaltaEnvidoNoQueridoGana2PuntosElEquipoContrario(){
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.faltaEnvido();
		mesa.quieroEnvido(false);
		Assert.assertEquals(mesa.puntaje(azules), 2);
		Assert.assertEquals(mesa.puntaje(rojos), 0);
	}
	
	@Test
	public void retrucoNoQueridoGana2PuntosElEquipoContrario(){
		mesa.truco();
		mesa.retruco();
		mesa.quieroTruco(false);
		Assert.assertTrue(mesa.puntaje(azules) == 2);
		Assert.assertTrue(mesa.puntaje(rojos) == 0);
	}
	
	@Test
	public void vale4NoQueridoGana3PuntosElEquipoContrario(){
		mesa.truco();
		mesa.retruco();
		mesa.valeCuatro();
		mesa.quieroTruco(false);
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 3);
	}

	@Test
	public void envidoVaAntesQueTruco(){
		mesa.truco();
		mesa.envido();
		mesa.quieroEnvido(false);
		Assert.assertEquals(mesa.puntaje(azules), 1);
		Assert.assertEquals(mesa.puntaje(rojos), 0);
	}
	 
	@Test
	public void faltaEnvidoQueridaTerminaElJuego(){
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.faltaEnvido();
		mesa.quieroEnvido(true);
		Assert.assertTrue(
				mesa.puntaje(rojos) == 0 && mesa.puntaje(azules) == 30
				||
				mesa.puntaje(rojos) == 30 && mesa.puntaje(azules) == 0);
	}
	
	
}
