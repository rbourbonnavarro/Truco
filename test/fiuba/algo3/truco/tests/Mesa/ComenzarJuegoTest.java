package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Envido.JuegoSinFlor;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Envido.CalculadorTanto;

public class ComenzarJuegoTest {
	
	Mesa mesa;
	Jugador jugador1;
	Jugador jugador2;
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	Equipo equipo1;
	Equipo equipo2;
	CalculadorTanto calculadorTanto;
	
	@Before
	public void setUp(){
		
		jugador1 = new Jugador("Juan");
		jugador2 = new Jugador("Pedro");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(jugador1));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(jugador2));
		
		equipo1 = new Equipo("equipo1", jugadoresEquipo1);
		equipo2 = new Equipo("equipo2", jugadoresEquipo2);

		calculadorTanto = new JuegoSinFlor();

		mesa = new Mesa(equipo1, equipo2, calculadorTanto);
	}
	
	
	@Test
	public void mesaSeInicioCorrectamente(){
			
		mesa.comenzarJuego();
		Assert.assertTrue(mesa.getJugadorActual() == jugador1);
		Assert.assertEquals(mesa.getJugadorActual().obtenerCartas().size(), 3);
		Assert.assertEquals(mesa.puntaje(equipo1),0);
	}
	
	@Test(expected = NoHayCartasParaJugar.class)
	public void hacerJugadaConCartaNulaFalla(){
	
		mesa.hacerJugada(null);
		
	}
	@Test
	public void test3JugarCartaTerminaElTurnoDelEquipo(){
		mesa.comenzarJuego();
		List<Carta> cartas = mesa.getCartasDelJugadorActual();
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Juan");
		mesa.hacerJugada(cartas.get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Pedro");
		Assert.assertEquals(2,jugador1.obtenerCartas().size());
		cartas = mesa.getCartasDelJugadorActual();
		mesa.hacerJugada(cartas.get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Juan");
	}
/*	@Test
	public void test4AlJugarCartasSeDeterminaGanadorDeVuelta(){
		Carta carta1 = new Carta(7,new Espada());
		Carta carta2 = new Carta(7,new Basto());
		Carta carta3 = new Carta(7,new Oro());
		LinkedList<Carta> cartas1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
		Carta carta4 = new Carta(3,new Espada());
		Carta carta5 = new Carta(3,new Basto());
		Carta carta6 = new Carta(3,new Oro());
		LinkedList<Carta> cartas2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));
		jugador1.setMano(new Mano(cartas1,calculadorTanto));
		jugador2.setMano(new Mano(cartas2,calculadorTanto));

		mesa.hacerJugada(carta1);
		mesa.hacerJugada(carta4);
		Assert.assertEquals(mesa.getGanadorVuelta().getEquipoGanador().getJugadorActual(),"Juan");
	}
*/
	
}
