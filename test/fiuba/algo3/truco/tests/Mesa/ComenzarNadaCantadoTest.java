package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComenzarNadaCantadoTest {
	
	Mesa mesa;
	Jugador jugador1;
	Jugador jugador2;
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	Equipo equipo1;
	Equipo equipo2;
	
	@Before
	public void setUp(){
		
		jugador1 = new Jugador("Juan");
		jugador2 = new Jugador("Pedro");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(jugador1));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(jugador2));
		
		equipo1 = new Equipo("equipo1", jugadoresEquipo1);
		equipo2 = new Equipo("equipo2", jugadoresEquipo2);

		boolean seJuegaConFlor = false;

		mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

	}
	
	
	@Test
	public void mesaSeInicioCorrectamente(){
			
		//mesa.comenzarJuego();
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

		//mesa.comenzarJuego();
		List<Carta> cartas = mesa.getCartasDelJugadorActual();
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Juan");
		mesa.hacerJugada(cartas.get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Pedro");
		Assert.assertEquals(2,jugador1.obtenerCartas().size());
		cartas = mesa.getCartasDelJugadorActual();
		mesa.hacerJugada(cartas.get(0));
		Assert.assertEquals(mesa.getJugadorActual().getNombre(),"Juan");

	}

	@Test
	public void test4AlJugarCartasSeDeterminaGanadorDeVueltaEnJuegoDeDos(){

		Carta carta1 = new Carta(7,new Espada());
		Carta carta2 = new Carta(7,new Basto());
		Carta carta3 = new Carta(7,new Oro());
		LinkedList<Carta> cartas1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
		Carta carta4 = new Carta(3,new Espada());
		Carta carta5 = new Carta(3,new Basto());
		Carta carta6 = new Carta(3,new Oro());
		LinkedList<Carta> cartas2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));
		jugador1.setMano(new Mano(cartas1));
		jugador2.setMano(new Mano(cartas2));

		mesa.hacerJugada(carta1);
		mesa.hacerJugada(carta4);
		Assert.assertEquals("equipo1", mesa.getGanadorVuelta().getNombre());

	}

	@Test
	public void test4AlJugarCartasSeDeterminaGanadorDeVueltaEnJuegoDeCuatro(){

		jugador1 = new Jugador("Juan");
		jugador2 = new Jugador("Pedro");
		Jugador jugador3 = new Jugador("Raul");
		Jugador jugador4 = new Jugador("Antonio");

		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(jugador1, jugador3));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(jugador2, jugador4));

		equipo1 = new Equipo("equipo1", jugadoresEquipo1);
		equipo2 = new Equipo("equipo2", jugadoresEquipo2);

		boolean seJuegaConFlor = false;

		mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

		Carta carta1 = new Carta(7,new Espada());
		Carta carta2 = new Carta(7,new Basto());
		Carta carta3 = new Carta(7,new Oro());
		LinkedList<Carta> cartas1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
		Carta carta4 = new Carta(3,new Espada());
		Carta carta5 = new Carta(3,new Basto());
		Carta carta6 = new Carta(3,new Oro());
		LinkedList<Carta> cartas2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));
		Carta carta7 = new Carta(2,new Espada());
		Carta carta8 = new Carta(2,new Basto());
		Carta carta9 = new Carta(2,new Oro());
		LinkedList<Carta> cartas3 = new LinkedList<>(Arrays.asList(carta7,carta8,carta9));
		Carta carta10 = new Carta(1,new Espada());
		Carta carta11 = new Carta(1,new Basto());
		Carta carta12 = new Carta(1,new Oro());
		LinkedList<Carta> cartas4 = new LinkedList<>(Arrays.asList(carta10,carta11,carta12));
		jugador1.setMano(new Mano(cartas1));
		jugador2.setMano(new Mano(cartas2));
		jugador3.setMano(new Mano(cartas3));
		jugador4.setMano(new Mano(cartas4));

		mesa.hacerJugada(carta1);
		mesa.hacerJugada(carta4);
		mesa.hacerJugada(carta7);
		mesa.hacerJugada(carta11);
		Assert.assertEquals("equipo2", mesa.getGanadorVuelta().getNombre());

	}

	@Test
	public void test4AlJugarCartasSeDeterminaGanadorDeVueltaEnJuegoDeSeis(){

		jugador1 = new Jugador("Juan");
		jugador2 = new Jugador("Pedro");
		Jugador jugador3 = new Jugador("Raul");
		Jugador jugador4 = new Jugador("Antonio");
		Jugador jugador5 = new Jugador("Jorge");
		Jugador jugador6 = new Jugador("Fausto");

		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(jugador1, jugador3, jugador5));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(jugador2, jugador4, jugador6));

		equipo1 = new Equipo("equipo1", jugadoresEquipo1);
		equipo2 = new Equipo("equipo2", jugadoresEquipo2);

		boolean seJuegaConFlor = false;

		mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

		Carta carta1 = new Carta(7,new Espada());
		Carta carta2 = new Carta(7,new Basto());
		Carta carta3 = new Carta(7,new Oro());
		LinkedList<Carta> cartas1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
		Carta carta4 = new Carta(3,new Espada());
		Carta carta5 = new Carta(3,new Basto());
		Carta carta6 = new Carta(3,new Oro());
		LinkedList<Carta> cartas2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));
		Carta carta7 = new Carta(2,new Espada());
		Carta carta8 = new Carta(2,new Basto());
		Carta carta9 = new Carta(2,new Oro());
		LinkedList<Carta> cartas3 = new LinkedList<>(Arrays.asList(carta7,carta8,carta9));
		Carta carta10 = new Carta(6,new Espada());
		Carta carta11 = new Carta(1,new Basto());
		Carta carta12 = new Carta(1,new Oro());
		LinkedList<Carta> cartas4 = new LinkedList<>(Arrays.asList(carta10,carta11,carta12));
		Carta carta13 = new Carta(1,new Espada());
		Carta carta14 = new Carta(6,new Basto());
		Carta carta15 = new Carta(6,new Oro());
		LinkedList<Carta> cartas5 = new LinkedList<>(Arrays.asList(carta7,carta8,carta9));
		Carta carta16 = new Carta(5,new Espada());
		Carta carta17 = new Carta(5,new Basto());
		Carta carta18 = new Carta(5,new Oro());
		LinkedList<Carta> cartas6 = new LinkedList<>(Arrays.asList(carta10,carta11,carta12));
		jugador1.setMano(new Mano(cartas1));
		jugador2.setMano(new Mano(cartas2));
		jugador3.setMano(new Mano(cartas3));
		jugador4.setMano(new Mano(cartas4));
		jugador5.setMano(new Mano(cartas5));
		jugador6.setMano(new Mano(cartas6));

		mesa.hacerJugada(carta1);
		mesa.hacerJugada(carta4);
		mesa.hacerJugada(carta7);
		mesa.hacerJugada(carta11);
		mesa.hacerJugada(carta13);
		mesa.hacerJugada(carta18);
		Assert.assertEquals("equipo1", mesa.getGanadorVuelta().getNombre());

	}

	
}
