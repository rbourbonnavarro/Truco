package fiuba.algo3.truco.tests.Mesa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoNoQueridoNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.EquipoQueCantoTrucoNoPuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoNoQueridoNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Jugadas.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraVuelta;

public class HacerJugadaTest {

	Mesa mesa;
	
	Jugador Juan;
	Jugador Pedro;
	Jugador Martin;
	Jugador Ignacio;
	
	List<Jugador> jugadoresEquipo1;
	List<Jugador> jugadoresEquipo2;
	
	Equipo azules;
	Equipo rojos;
	
	@Before
	public void setUp() {
		
		Juan = new Jugador("Juan");
		Pedro = new Jugador("Pedro");
		Martin = new Jugador("Martin");
		Ignacio = new Jugador("Ignacio");
		
		jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan, Pedro));
		jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Martin, Ignacio));
		
		azules = new Equipo("equipo1", jugadoresEquipo1);
		rojos = new Equipo("equipo2", jugadoresEquipo2);

		boolean seJuegaConFlor = false;
		
		mesa = new Mesa(azules, rojos, seJuegaConFlor);

	}
	
	@Test(expected = JugadorNoPieNoPuedeCantarEnvido.class)
	public void siJugadorNoEsPieNoPuedeCantarEnvido() {
		
		mesa.envido();
		
	}
	
	@Test
	public void envidoNoQueridoEsUnPuntoParaElEquipoContrario() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.noQuieroTanto();
		Assert.assertEquals(mesa.puntaje(azules), 1);

	}
	
	@Test
	public void trucoNoQueridoEsUnPuntoParaElEquipoContrario() {
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.truco();
		mesa.noQuieroTruco();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 1);

	}
	
	@Test(expected = JugadorNoPuedeCantarTantoNoEsPrimeraVuelta.class)
	public void noSePuedeCantarEnvidoDespuesDeLaPrimerRonda() {
		
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();

	}

	@Test(expected = JuegoSinFlorException.class)
	public void noSePuedeCantarFlorCuandoSeJuegaSinFlor() {

		List<Carta> lista = new ArrayList<>(Arrays.asList(new Carta(7,new Espada()),new Carta(3,new Espada()),new Carta(2,new Espada())));
		Juan.setMano(new Mano(lista));
		Assert.assertEquals(Juan.getNombre(),mesa.getJugadorActual().getNombre());
		mesa.flor();

	}

	@Test
	public void envidoEnvidoNoQueridoFuncionaCorrectamente() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.envido();
		mesa.noQuieroTanto();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 2);

	}

	@Test
	public void retrucoNoQueridoFuncionaCorrectamente() {

		mesa.truco();
		mesa.retruco();
		mesa.noQuieroTruco();
		Assert.assertTrue(mesa.puntaje(azules) == 0);
		Assert.assertTrue(mesa.puntaje(rojos) == 2);

	}

	@Test
	public void vale4NoQueridoFuncionaCorrectamente() {

		mesa.truco();
		mesa.retruco();
		mesa.valeCuatro();
		mesa.noQuieroTruco();
		Assert.assertEquals(mesa.puntaje(azules), 3);
		Assert.assertEquals(mesa.puntaje(rojos), 0);

	}

	@Test
	public void envidoVaAntesQueTruco() {

		mesa.truco();
		mesa.envido();
		mesa.noQuieroTanto();
		Assert.assertEquals(mesa.puntaje(azules), 0);
		Assert.assertEquals(mesa.puntaje(rojos), 1);

	}

	@Test
	public void faltaEnvidoQueridaTerminaElJuego() {

		try {

			mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
			mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
			mesa.faltaEnvido();
			mesa.quieroEnvido();

		} catch(JuegoTerminadoException juegoTerminadoException) {

			Assert.assertTrue(
					mesa.puntaje(rojos) == 0 && mesa.puntaje(azules) == 30
							||
							mesa.puntaje(rojos) == 30 && mesa.puntaje(azules) == 0);

		}

	}

	@Test
	public void cantaEnvidoElUltimoJugadorDeLaRondaYElPrimeroLePuedeContestar() {

		Juan.setMano(new Mano(Arrays.asList(new Carta(7,new Espada()), new Carta(3,new Espada()), new Carta(2, new Basto()))));
		Pedro.setMano(new Mano(Arrays.asList(new Carta(4,new Espada()), new Carta(2,new Espada()), new Carta(1, new Basto()))));
		Martin.setMano(new Mano(Arrays.asList(new Carta(6,new Espada()), new Carta(3,new Oro()), new Carta(2, new Oro()))));
		Ignacio.setMano(new Mano(Arrays.asList(new Carta(4,new Oro()), new Carta(3,new Copa()), new Carta(5, new Basto()))));

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.realEnvido();
		mesa.quieroEnvido();

		Assert.assertTrue(mesa.puntaje(azules) == 5);

	}

	@Test(expected = TrucoNoQueridoNoSePuedeJugarException.class)
	public void noSePuedeHacerJugadaSiNoSeDecidioElTruco() {

		mesa.truco();
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));

	}

	@Test(expected = EnvidoNoQueridoNoSePuedeJugarException.class)
	public void noSePuedeHacerJugadaSiNoSeDecidioElEnvido() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));

	}

	@Test(expected = NoSePuedeCantarEnvido.class)
	public void seCantaTrucoYDespuesEnvidoSeDecideYSeIntentaCantarTantoDeNuevoLanzaExcepcion() {

		mesa.truco();
		mesa.envido();
		mesa.quieroEnvido();
		mesa.envido();

	}

	@Test(expected = NoSePuedeCantarEnvido.class)
	public void seCantaTrucoYDespuesRealEnvidoSeDecideYSeIntentaCantarTantoDeNuevoLanzaExcepcion() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.truco();
		mesa.realEnvido();
		mesa.quieroEnvido();
		mesa.envido();

	}

	@Test(expected = NoSePuedeCantarEnvido.class)
	public void seCantaEnvidoSeDecideYSeIntentaCantarTantoDeNuevoLanzaExcepcion() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.quieroEnvido();
		mesa.envido();

	}

	@Test(expected = NoSePuedeCantarEnvido.class)
	public void seCantaEnvidoSeDecideYSeCantaTrucoSeIntentaCantarTantoDeNuevoLanzaExcepcion() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.quieroEnvido();
		mesa.truco();
		mesa.envido();

	}

	@Test(expected = JugadorNoPuedeCantarTantoNoEsPrimeraVuelta.class)
	public void noSePuedeCantarEnvidoDespuesDePrimeraVuelta() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();

	}

	@Test
	public void cuandoDosJugadoresTienenElMismoTantoGanaElQueVaAntesEnLaRonda() {

		Juan.setMano(new Mano(Arrays.asList(new Carta(1, new Espada()), new Carta(3, new Espada()), new Carta(5, new Basto()))));
		Pedro.setMano(new Mano(Arrays.asList(new Carta(4, new Espada()), new Carta(2, new Espada()), new Carta(1, new Basto()))));
		Martin.setMano(new Mano(Arrays.asList(new Carta(4, new Basto()), new Carta(2, new Basto()), new Carta(2, new Oro()))));
		Ignacio.setMano(new Mano(Arrays.asList(new Carta(4, new Oro()), new Carta(3, new Copa()), new Carta(6, new Basto()))));

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.envido();
		mesa.quieroEnvido();

		Assert.assertEquals(2, mesa.puntaje(rojos));

	}

	@Test(expected = EquipoQueCantoTrucoNoPuedeCantarRetrucoException.class)
	public void elEquipoQueCantoTrucoNoPuedeCantarRetruco() {

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.truco();
		mesa.quieroTruco();
		mesa.retruco();

	}

	@Test(expected = EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException.class)
	public void elEquipoQueCantoRetrucoNoPuedeCantarValeCuatro() {

		Juan.setMano(new Mano(Arrays.asList(new Carta(1, new Espada()), new Carta(3, new Espada()), new Carta(5, new Basto()))));
		Pedro.setMano(new Mano(Arrays.asList(new Carta(4, new Espada()), new Carta(2, new Espada()), new Carta(1, new Basto()))));
		Martin.setMano(new Mano(Arrays.asList(new Carta(4, new Basto()), new Carta(2, new Basto()), new Carta(2, new Oro()))));
		Ignacio.setMano(new Mano(Arrays.asList(new Carta(4, new Oro()), new Carta(3, new Copa()), new Carta(6, new Basto()))));

		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.truco();
		mesa.quieroTruco();
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.retruco();
		mesa.quieroTruco();
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.hacerJugada(mesa.getJugadorActual().obtenerCartasEnMano().get(0));
		mesa.valeCuatro();

	}
	

}
