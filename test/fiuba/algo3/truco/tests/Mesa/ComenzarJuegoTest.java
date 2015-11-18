package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.NoHayCartasParaJugar;
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
		
		mesa = new Mesa(equipo1, equipo2, calculadorTanto);
	}
	
	
	@Test
	public void mesaSeInicioCorrectamente(){
			
		mesa.comenzarJuego();
		Assert.assertTrue(mesa.getJugadorActual() == jugador1);
		Assert.assertEquals(mesa.getJugadorActual().obtenerCartas().size(), 3);
	}
	
	@Test(expected = NoHayCartasParaJugar.class)
	public void hacerJugadaConCartaNulaFalla(){
	
		mesa.hacerJugada(null);
		
	}
	
	
}
