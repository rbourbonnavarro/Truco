package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

public class PartidoCompletoDeACuatroTest {

	Mesa mesa;
	
	Jugador J1;
	Jugador J2;
	Jugador J3;
	Jugador J4;
	
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	
	Equipo equipoPar;
	Equipo equipoImpar;
	
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	Carta carta7;
	Carta carta8;
	Carta carta9;
	Carta carta10;
	Carta carta11;
	Carta carta12;
	
	LinkedList<Carta> cartasJ1;
	LinkedList<Carta> cartasJ2;
	LinkedList<Carta> cartasJ3;
	LinkedList<Carta> cartasJ4;
	
	@Before
	public void setUp(){
		
		J1 = new Jugador("J1");
		J2 = new Jugador("J2");
		J3 = new Jugador("J3");
		J4 = new Jugador("J4");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(J1, J3));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(J2, J4));
		
		equipoPar = new Equipo("Equipo Par", jugadoresEquipo2);
		equipoImpar = new Equipo("Equipo Impar", jugadoresEquipo1);

		boolean seJuegaConFlor = true;
		
		mesa = new Mesa(equipoImpar, equipoPar, seJuegaConFlor);


	}
	
	@Test
	public void partidaCompletaDeACuatro() {

		try {

			carta1 = new Carta(7,new Espada());
			carta2 = new Carta(7,new Basto());
			carta3 = new Carta(7,new Oro());
			carta4 = new Carta(3,new Espada());
			carta5 = new Carta(3,new Basto());
			carta6 = new Carta(3,new Oro());
			carta7 = new Carta(4,new Espada());
			carta8 = new Carta(4,new Basto());
			carta9 = new Carta(4,new Oro());
			carta10 = new Figura(12,new Espada());
			carta11 = new Figura(11,new Basto());
			carta12 = new Figura(10,new Oro());

			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));


			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertTrue(mesa.puntaje(equipoPar) == 0);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 0);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta1);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();

			Assert.assertTrue(mesa.puntaje(equipoImpar) == 2);
			Assert.assertTrue(mesa.puntaje(equipoPar) == 0);

			mesa.hacerJugada(carta7);
			mesa.hacerJugada(carta10);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.retruco();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertTrue(mesa.puntaje(equipoPar) == 2);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 2);

			Assert.assertEquals(J1.obtenerCartas().size(),3);

			carta1 = new Carta(7,new Oro());
			carta2 = new Carta(3,new Oro());
			carta3 = new Carta(4,new Oro());
			carta4 = new Carta(7,new Espada());
			carta5 = new Carta(5,new Espada());
			carta6 = new Carta(6,new Espada());
			carta7 = new Figura(12,new Espada());
			carta8 = new Figura(11,new Basto());
			carta9 = new Figura(10,new Oro());
			carta10 = new Carta(4,new Espada());
			carta11 = new Carta(4,new Basto());
			carta12 = new Carta(4,new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());

			mesa.flor();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.contraFlorAlPartido();
			mesa.quieroFlor();

		} catch (JuegoTerminadoException juegoTerminadoException) {

			Assert.assertTrue(mesa.puntaje(equipoPar) >= 30);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 2);
			Assert.assertEquals(equipoPar, mesa.getEquipoGanadorJuego());

		}
		
	}

	@Test
	public void partidaCompletaDeACuatro2() {

		try {

			carta1 = new Carta(7, new Espada());
			carta2 = new Carta(7, new Basto());
			carta3 = new Carta(7, new Oro());
			carta4 = new Carta(3, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(3, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(4, new Oro());
			carta10 = new Figura(12, new Espada());
			carta11 = new Figura(11, new Basto());
			carta12 = new Figura(10, new Oro());

			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));


			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertTrue(mesa.puntaje(equipoPar) == 0);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 0);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta1);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTanto();

			Assert.assertTrue(mesa.puntaje(equipoImpar) == 1);
			Assert.assertTrue(mesa.puntaje(equipoPar) == 0);

			mesa.hacerJugada(carta7);
			mesa.hacerJugada(carta10);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertTrue(mesa.puntaje(equipoPar) == 0);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 2);

			Assert.assertEquals(J1.obtenerCartas().size(), 3);

			carta1 = new Carta(7, new Oro());
			carta2 = new Carta(3, new Oro());
			carta3 = new Carta(4, new Oro());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(5, new Espada());
			carta6 = new Carta(6, new Espada());
			carta7 = new Figura(12, new Espada());
			carta8 = new Figura(11, new Basto());
			carta9 = new Figura(10, new Oro());
			carta10 = new Carta(4, new Espada());
			carta11 = new Carta(4, new Basto());
			carta12 = new Carta(4, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.contraFlorAlResto();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTanto();

			Assert.assertEquals(mesa.puntaje(equipoPar), 0);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 5);

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta10);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.retruco();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.valeCuatro();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoPar), 0);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 8);

			carta1 = new Carta(7, new Oro());
			carta2 = new Carta(3, new Espada());
			carta3 = new Carta(4, new Oro());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(5, new Basto());
			carta6 = new Carta(6, new Espada());
			carta7 = new Figura(12, new Espada());
			carta8 = new Figura(11, new Basto());
			carta9 = new Figura(10, new Oro());
			carta10 = new Carta(4, new Espada());
			carta11 = new Carta(4, new Basto());
			carta12 = new Carta(4, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta10);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.realEnvido();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.faltaEnvido();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTanto();

			Assert.assertEquals(mesa.puntaje(equipoPar), 7);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 8);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoPar), 7);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 9);

			carta1 = new Carta(3, new Oro());
			carta2 = new Carta(3, new Copa());
			carta3 = new Carta(4, new Oro());
			carta4 = new Carta(3, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Espada());
			carta7 = new Figura(5, new Espada());
			carta8 = new Figura(6, new Basto());
			carta9 = new Figura(6, new Oro());
			carta10 = new Carta(6, new Espada());
			carta11 = new Carta(6, new Copa());
			carta12 = new Carta(5, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta12);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta1);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();

			Assert.assertEquals(mesa.puntaje(equipoPar), 7);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 13);

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta10);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta3);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta6);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta8);
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta11);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta2);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta5);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta9);

			Assert.assertEquals(mesa.puntaje(equipoPar), 8);
			Assert.assertEquals(mesa.puntaje(equipoImpar), 13);

			carta1 = new Carta(7, new Oro());
			carta2 = new Carta(3, new Oro());
			carta3 = new Carta(4, new Oro());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(5, new Espada());
			carta6 = new Carta(6, new Espada());
			carta7 = new Figura(12, new Espada());
			carta8 = new Figura(11, new Basto());
			carta9 = new Figura(10, new Oro());
			carta10 = new Carta(4, new Espada());
			carta11 = new Carta(4, new Basto());
			carta12 = new Carta(4, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.contraFlorAlPartido();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroFlor();

		} catch (JuegoTerminadoException juegoTerminadoException) {

			Assert.assertTrue(mesa.puntaje(equipoPar) >= 30);
			Assert.assertTrue(mesa.puntaje(equipoImpar) == 13);
			Assert.assertEquals(equipoPar, mesa.getEquipoGanadorJuego());

		}

	}

	@Test
	public void partidaCompletaDeACuatro3() {

		carta1 = new Figura(12, new Espada());
		carta2 = new Figura(11, new Basto());
		carta3 = new Figura(10, new Oro());
		carta4 = new Figura(12, new Basto());
		carta5 = new Figura(11, new Espada());
		carta6 = new Figura(10, new Copa());
		carta7 = new Carta(6, new Espada());
		carta8 = new Carta(6, new Basto());
		carta9 = new Carta(6, new Oro());
		carta10 = new Carta(5, new Espada());
		carta11 = new Carta(5, new Espada());
		carta12 = new Carta(5, new Espada());

		cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
		cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
		cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
		cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));


		J1.setMano(new Mano(cartasJ1));
		J2.setMano(new Mano(cartasJ2));
		J3.setMano(new Mano(cartasJ3));
		J4.setMano(new Mano(cartasJ4));

		Assert.assertTrue(mesa.puntaje(equipoPar) == 0);
		Assert.assertTrue(mesa.puntaje(equipoImpar) == 0);

		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta1);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta4);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta7);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta10);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta2);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta5);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta8);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta11);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta3);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta6);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta9);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta12);

		Assert.assertTrue(mesa.puntaje(equipoPar) == 0);
		Assert.assertTrue(mesa.puntaje(equipoImpar) == 1);

		carta1 = new Figura(12, new Espada());
		carta2 = new Figura(11, new Basto());
		carta3 = new Carta(5, new Espada());
		carta4 = new Figura(12, new Basto());
		carta5 = new Figura(11, new Espada());
		carta6 = new Figura(10, new Copa());
		carta7 = new Carta(6, new Espada());
		carta8 = new Carta(6, new Basto());
		carta9 = new Carta(6, new Oro());
		carta10 = new Carta(5, new Espada());
		carta11 = new Carta(5, new Espada());
		carta12 = new Figura(10, new Copa());

		cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
		cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
		cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
		cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));


		J1.setMano(new Mano(cartasJ1));
		J2.setMano(new Mano(cartasJ2));
		J3.setMano(new Mano(cartasJ3));
		J4.setMano(new Mano(cartasJ4));

		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta4);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta7);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta10);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta1);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta5);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta8);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta11);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta2);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta6);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta9);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta12);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta3);

		Assert.assertTrue(mesa.puntaje(equipoPar) == 1);
		Assert.assertTrue(mesa.puntaje(equipoImpar) == 1);

		carta1 = new Figura(12, new Espada());
		carta2 = new Figura(11, new Basto());
		carta3 = new Figura(10, new Oro());
		carta4 = new Figura(12, new Basto());
		carta5 = new Figura(11, new Espada());
		carta6 = new Figura(10, new Copa());
		carta7 = new Carta(7, new Espada());
		carta8 = new Carta(6, new Basto());
		carta9 = new Carta(6, new Oro());
		carta10 = new Carta(5, new Espada());
		carta11 = new Carta(5, new Espada());
		carta12 = new Carta(5, new Espada());

		cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
		cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
		cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
		cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));

		J1.setMano(new Mano(cartasJ1));
		J2.setMano(new Mano(cartasJ2));
		J3.setMano(new Mano(cartasJ3));
		J4.setMano(new Mano(cartasJ4));

		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta7);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta10);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta1);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta4);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta8);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta11);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta2);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta5);

		Assert.assertTrue(mesa.puntaje(equipoPar) == 1);
		Assert.assertTrue(mesa.puntaje(equipoImpar) == 2);

		/*carta1 = new Figura(12, new Espada());
		carta2 = new Figura(11, new Basto());
		carta3 = new Carta(5, new Espada());
		carta4 = new Figura(12, new Basto());
		carta5 = new Figura(11, new Espada());
		carta6 = new Figura(10, new Copa());
		carta7 = new Carta(6, new Espada());
		carta8 = new Carta(6, new Basto());
		carta9 = new Carta(6, new Oro());
		carta10 = new Carta(5, new Espada());
		carta11 = new Carta(5, new Espada());
		carta12 = new Figura(10, new Copa());

		cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
		cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
		cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
		cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));


		J1.setMano(new Mano(cartasJ1));
		J2.setMano(new Mano(cartasJ2));
		J3.setMano(new Mano(cartasJ3));
		J4.setMano(new Mano(cartasJ4));

		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta1);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta4);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta7);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta10);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta2);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta5);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta8);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta11);
		Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta3);
		Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta6);
		Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta9);
		Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.hacerJugada(carta12);

		Assert.assertTrue(mesa.puntaje(equipoPar) == 1);
		Assert.assertTrue(mesa.puntaje(equipoImpar) == 1);*/

	}

	
}
