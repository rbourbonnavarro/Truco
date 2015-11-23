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
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

public class PartidoCompletoDeACuatroTest {

	Mesa mesa;
	
	Jugador Juan;
	Jugador Pedro;
	Jugador Roberto;
	Jugador Ignacio;
	
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	
	Equipo equipoJuanRoberto;
	Equipo equipoPedroIgnacio;
	
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
	
	LinkedList<Carta> cartasJuan;
	LinkedList<Carta> cartasPedro; 
	LinkedList<Carta> cartasRoberto;
	LinkedList<Carta> cartasIgnacio; 
	
	@Before
	public void setUp(){
		
		Juan = new Jugador("Juan");
		Pedro = new Jugador("Pedro");
		Roberto = new Jugador("Roberto");
		Ignacio = new Jugador("Ignacio");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan, Roberto));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Pedro, Ignacio));
		
		equipoJuanRoberto = new Equipo("JuanRoberto", jugadoresEquipo1);
		equipoPedroIgnacio = new Equipo("PedroIgnacio", jugadoresEquipo2);

		boolean seJuegaConFlor = true;
		
		mesa = new Mesa(equipoJuanRoberto, equipoPedroIgnacio, seJuegaConFlor);
		
		carta1 = new Carta(7,new Espada());
		carta2 = new Carta(7,new Basto());
		carta3 = new Carta(7,new Oro());
		carta4 = new Carta(3,new Espada());
		carta5 = new Carta(3,new Basto());
		carta6 = new Carta(3,new Oro());
		carta7 = new Carta(4,new Espada());
		carta8 = new Carta(4,new Basto());
		carta9 = new Carta(4,new Oro());
		carta10 = new Carta(12,new Espada());
		carta11 = new Carta(11,new Basto());
		carta12 = new Carta(10,new Oro());
		
		cartasJuan = new LinkedList<Carta>();
		cartasPedro = new LinkedList<Carta>();
		cartasRoberto = new LinkedList<Carta>();
		cartasIgnacio = new LinkedList<Carta>();

	}
	
	@Test
	public void envidoQueridoOtorgaDosPuntosAlGanador() {

		cartasJuan.add(carta1);
		cartasJuan.add(carta4);
		cartasJuan.add(carta5);
		cartasPedro.add(carta2);
		cartasPedro.add(carta3);
		cartasPedro.add(carta6);
		cartasRoberto.add(carta7);
		cartasRoberto.add(carta10);
		cartasRoberto.add(carta11);
		cartasIgnacio.add(carta8);
		cartasIgnacio.add(carta9);
		cartasIgnacio.add(carta12);
		
		Juan.setMano(new Mano(cartasJuan));
		Pedro.setMano(new Mano(cartasPedro));
		Roberto.setMano(new Mano(cartasRoberto));
		Ignacio.setMano(new Mano(cartasIgnacio));
		
		Assert.assertTrue(mesa.puntaje(equipoJuanRoberto) == 0);
		Assert.assertTrue(mesa.puntaje(equipoPedroIgnacio) == 0);
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.quieroEnvido();
		
		Assert.assertTrue(mesa.puntaje(equipoJuanRoberto) == 2);
		Assert.assertTrue(mesa.puntaje(equipoPedroIgnacio) == 0);
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		
		mesa.truco();
		mesa.retruco();
		mesa.noQuieroTruco();
		
		Assert.assertTrue(mesa.puntaje(equipoJuanRoberto) == 2);
		Assert.assertTrue(mesa.puntaje(equipoPedroIgnacio) == 2);
		
	}

	
}
