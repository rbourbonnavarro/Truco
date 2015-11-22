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

public class JugarDeADosTest {

Mesa mesa;
	
	Jugador Juan;
	Jugador Pedro;
	
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	
	Equipo equipoJuan;
	Equipo equipoPedro;
	
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	
	LinkedList<Carta> cartasJuan;
	LinkedList<Carta> cartasPedro; 
	
	@Before
	public void setUp(){
		
		Juan = new Jugador("Juan");
		Pedro = new Jugador("Pedro");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Pedro));
		
		equipoJuan = new Equipo("Juan", jugadoresEquipo1);
		equipoPedro = new Equipo("Pedro", jugadoresEquipo2);

		boolean seJuegaConFlor = true;
		
		mesa = new Mesa(equipoJuan, equipoPedro, seJuegaConFlor);
		
		carta1 = new Carta(7,new Espada());
		carta2 = new Carta(7,new Basto());
		carta3 = new Carta(7,new Oro());
		carta4 = new Carta(3,new Espada());
		carta5 = new Carta(3,new Basto());
		carta6 = new Carta(3,new Oro());
		
		cartasJuan = new LinkedList<>();
		cartasPedro = new LinkedList<>();

	}
	
	@Test
	public void jugadaUno() {

		cartasJuan.add(carta1);
		cartasJuan.add(carta4);
		cartasJuan.add(carta5);
		cartasPedro.add(carta2);
		cartasPedro.add(carta3);
		cartasPedro.add(carta6);
		
		Juan.setMano(new Mano(cartasJuan));
		Pedro.setMano(new Mano(cartasPedro));
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
		mesa.envido();
		mesa.quieroEnvido();
		Assert.assertTrue(mesa.puntaje(equipoJuan) == 0);
		Assert.assertTrue(mesa.puntaje(equipoPedro) == 2);
		
	}

	
}
