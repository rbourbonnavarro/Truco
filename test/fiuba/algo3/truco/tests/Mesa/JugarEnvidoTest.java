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
import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;

public class JugarEnvidoTest {

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
		
		mesa = new Mesa(azules, rojos, calculadorTanto);
		mesa.comenzarJuego();
	}
	
	@Test(expected = JugadorNoPieNoPuedeCantarEnvido.class)
	public void seJuegaEnvidoCorrectamente(){
		
		mesa.envido();
		
	}
	
	/*@Test
	public void envidoNoQueridoEsUnPuntoParaElEquipoContrario(){
		
		boolean noQuiero = false;
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(1));
		mesa.envido();
		mesa.quieroEnvido(noQuiero);
		Assert.assertTrue(mesa.puntajeActual(azules), 1);
	}
	*/
}
