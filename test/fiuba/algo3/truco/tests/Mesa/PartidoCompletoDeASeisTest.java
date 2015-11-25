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
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

public class PartidoCompletoDeASeisTest {

Mesa mesa;
	
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
		
		mesa = new Mesa(equipoImpar, equipoPar, seJuegaConFlor);

	}
	
	@Test
	public void partidaCompletaDeASeis() {

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
		carta13 = new Carta(10,new Espada());
		carta14 = new Carta(12,new Basto());
		carta15 = new Carta(11,new Oro());
		carta16 = new Figura(11,new Espada());
		carta17 = new Figura(10,new Basto());
		carta18 = new Figura(12,new Oro());
		
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
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		
		Assert.assertEquals(J5.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.envido();
		
		Assert.assertEquals(J6.getNombre(), mesa.getJugadorActual().getNombre());
		mesa.quieroEnvido();
		
	}
}
