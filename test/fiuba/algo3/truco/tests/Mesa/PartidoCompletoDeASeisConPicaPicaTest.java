package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.MesaPicaPica;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;

public class PartidoCompletoDeASeisConPicaPicaTest {
	
	MesaPicaPica mesa;
	
	Jugador J1;
	Jugador J2;
	Jugador J3;
	Jugador J4;
	Jugador J5;
	Jugador J6;
	
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
	Carta carta13;
	Carta carta14;
	Carta carta15;
	Carta carta16;
	Carta carta17;
	Carta carta18;
	
	LinkedList<Carta> cartasJ1;
	LinkedList<Carta> cartasJ2;
	LinkedList<Carta> cartasJ3;
	LinkedList<Carta> cartasJ4;
	LinkedList<Carta> cartasJ5;
	LinkedList<Carta> cartasJ6;
	
	
	@Before
	public void setUp(){
		
		J1 = new Jugador("J1");
		J2 = new Jugador("J2");
		J3 = new Jugador("J3");
		J4 = new Jugador("J4");
		J5 = new Jugador("J5");
		J6 = new Jugador("J6");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(J1, J3, J5));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(J2, J4, J6));
		
		equipoPar = new Equipo("Equipo Par", jugadoresEquipo2);
		equipoImpar = new Equipo("Equipo Impar", jugadoresEquipo1);

		boolean seJuegaConFlor = true;
		
		mesa = new MesaPicaPica(equipoImpar, equipoPar, seJuegaConFlor);

	}
	
	@Test
	public void partidaCompletaDeASeis() {

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
			carta13 = new Carta(12, new Basto());
			carta14 = new Carta(11, new Oro());
			carta15 = new Carta(10, new Copa());
			carta16 = new Figura(12, new Oro());
			carta17 = new Figura(11, new Espada());
			carta18 = new Figura(10, new Basto());

			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

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

			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTanto();

			Assert.assertTrue(mesa.puntaje(equipoImpar) == 0);
			Assert.assertTrue(mesa.puntaje(equipoPar) == 2);

			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta13);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.reTruco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.valeCuatro();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 0);
			Assert.assertEquals(mesa.puntaje(equipoPar), 5);

			carta1 = new Figura(12, new Copa());
			carta2 = new Figura(11, new Copa());
			carta3 = new Figura(10, new Copa());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Espada());
			carta11 = new Carta(12, new Basto());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(1, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			Assert.assertEquals(mesa.puntaje(equipoImpar), 0);
			Assert.assertEquals(mesa.puntaje(equipoPar), 5);

			//la ronda pica a pica, primero J2 V J5 dsps J3 V J6 y luego J4 V J1 (los primeros son los mano)

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);

			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta13);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta5);
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta15);
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta14);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroTruco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta6);

			//termino la primera ronda, pero los puntos los sumo  al final del pica a pica, si quieren cambiarlo haganlo a gusto
			// J5 gano 2 por truco
			//turno de J3 vs J6

			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.realEnvido();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.faltaEnvido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTanto();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta18);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			//J6 gano 6 puntos
			// turno de J4 V J1
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta10);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			//J1 gano 1 punto
			Assert.assertEquals(mesa.puntaje(equipoImpar), 3);
			Assert.assertEquals(mesa.puntaje(equipoPar), 11);

			//momento de una redonda, y que deberia arrancar con J3
			carta1 = new Figura(12, new Copa());
			carta2 = new Figura(11, new Copa());
			carta3 = new Figura(10, new Copa());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Espada());
			carta11 = new Carta(12, new Basto());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(1, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta10);
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta13);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta16);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroFlor();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 6);
			Assert.assertEquals(mesa.puntaje(equipoPar), 11);

			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta1);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 6);
			Assert.assertEquals(mesa.puntaje(equipoPar), 12);

			//nuevo pica a pica esta vez la ronda va J4 v J1, J5 V J2 y J6 V J3
			carta1 = new Carta(2, new Copa());
			carta2 = new Carta(1, new Basto());
			carta3 = new Carta(6, new Copa());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Espada());
			carta11 = new Carta(12, new Basto());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(5, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			//J4 V J1
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.realEnvido();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();

			//J1 gano 7 puntos
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();
			//J1 7 J4 1

			//J5 vs J2
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();
			//J5 1

			//J6 V J3
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();
			//J6 gano 2
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta18);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();
			//J3 gano 1

			Assert.assertEquals(mesa.puntaje(equipoImpar), 15);
			Assert.assertEquals(mesa.puntaje(equipoPar), 15);

			carta1 = new Figura(12, new Copa());
			carta2 = new Figura(11, new Copa());
			carta3 = new Figura(10, new Basto());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Oro());
			carta6 = new Carta(4, new Espada());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Espada());
			carta11 = new Carta(12, new Basto());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(1, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			//momento de una redonda donde J5 es mano

			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta13);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta18);
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta1);
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta4);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 15);
			Assert.assertEquals(mesa.puntaje(equipoPar), 19);

			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.reTruco();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.valeCuatro();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 18);
			Assert.assertEquals(mesa.puntaje(equipoPar), 19);

			//pica a pica, J6 vs J3, J1 vs J4 , J2 vs J5
			carta1 = new Figura(12, new Copa());
			carta2 = new Figura(11, new Copa());
			carta3 = new Figura(10, new Copa());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Oro());
			carta11 = new Carta(7, new Oro());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(1, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			//J6 vs J3
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.envido();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroEnvido();
			//J3 gano 2
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.reTruco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.valeCuatro();
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroTruco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta17);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta7);
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta16);
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(carta8);
			//J6 gano 4 J3 2

			//J1 vs J4
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			mesa.quieroFlor();
			//J4 gano 6
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();
			//J4 6 J1 1

			//J2 vs J5
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.reTruco();
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();
			//J3 gano 1

			Assert.assertEquals(mesa.puntaje(equipoImpar), 23);
			Assert.assertEquals(mesa.puntaje(equipoPar), 29);

			//ahora deberia haber dos redondas seguidas
			Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 24);
			Assert.assertEquals(mesa.puntaje(equipoPar), 29);

			Assert.assertEquals(J2.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.truco();
			Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.noQuieroTruco();

			Assert.assertEquals(mesa.puntaje(equipoImpar), 25);
			Assert.assertEquals(mesa.puntaje(equipoPar), 29);

			carta1 = new Figura(12, new Copa());
			carta2 = new Figura(11, new Copa());
			carta3 = new Figura(10, new Copa());
			carta4 = new Carta(7, new Espada());
			carta5 = new Carta(3, new Basto());
			carta6 = new Carta(4, new Oro());
			carta7 = new Carta(4, new Espada());
			carta8 = new Carta(4, new Basto());
			carta9 = new Carta(5, new Oro());
			carta10 = new Carta(6, new Oro());
			carta11 = new Carta(7, new Oro());
			carta12 = new Carta(2, new Oro());
			carta13 = new Carta(2, new Espada());
			carta14 = new Carta(2, new Basto());
			carta15 = new Carta(7, new Oro());
			carta16 = new Carta(1, new Espada());
			carta17 = new Carta(1, new Basto());
			carta18 = new Carta(3, new Oro());


			cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
			cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));
			cartasJ3 = new LinkedList<>(Arrays.asList(carta7, carta8, carta9));
			cartasJ4 = new LinkedList<>(Arrays.asList(carta10, carta11, carta12));
			cartasJ5 = new LinkedList<>(Arrays.asList(carta13, carta14, carta15));
			cartasJ6 = new LinkedList<>(Arrays.asList(carta16, carta17, carta18));

			J1.setMano(new Mano(cartasJ1));
			J2.setMano(new Mano(cartasJ2));
			J3.setMano(new Mano(cartasJ3));
			J4.setMano(new Mano(cartasJ4));
			J5.setMano(new Mano(cartasJ5));
			J6.setMano(new Mano(cartasJ6));

			Assert.assertEquals(J3.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.hacerJugada(mesa.getCartasDelJugadorActual().get(0));
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.flor();
			Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.contraFlorAlPartido();
			Assert.assertEquals(J4.getNombre(), mesa.getJugadorActual().getNombre());
			mesa.quieroFlor();


		} catch(JuegoTerminadoException juegoTerminadoException) {

			Assert.assertEquals(mesa.puntaje(equipoImpar), 25);
			Assert.assertTrue(mesa.puntaje(equipoPar) >= 30);

		}

	}


}
