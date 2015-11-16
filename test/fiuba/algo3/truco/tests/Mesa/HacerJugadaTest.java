package fiuba.algo3.truco.tests.Mesa;

import java.util.List;

import org.junit.Before;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;

public class HacerJugadaTest {
	
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
		
		jugadoresEquipo1.add(jugador1);
		jugadoresEquipo2.add(jugador2);
		
		equipo1 = new Equipo("equipo1", jugadoresEquipo1);
		equipo2 = new Equipo("equipo2", jugadoresEquipo2);
		
		mesa = new Mesa(equipo1, equipo2, calculadorTanto);
	}
	
	
	
}
