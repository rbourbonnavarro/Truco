package fiuba.algo3.truco.tests.Mesa;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraVuelta;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorNoAceptadaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HacerJugadaConFlorTest {

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
    public void setUp(){

        Juan = new Jugador("Juan");
        Pedro = new Jugador("Pedro");
        Martin = new Jugador("Martin");
        Ignacio = new Jugador("Ignacio");

        jugadoresEquipo1 = new ArrayList<>(Arrays.asList(Juan, Pedro));
        jugadoresEquipo2 = new ArrayList<>(Arrays.asList(Martin, Ignacio));

        azules = new Equipo("equipo1", jugadoresEquipo1);
        rojos = new Equipo("equipo2", jugadoresEquipo2);

        boolean seJuegaConFlor = true;

        mesa = new Mesa(azules, rojos, seJuegaConFlor);

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void noSePuedeCantarEnvidoLuegoQueSeCantoFlor () {

        List<Carta> lista = new ArrayList<>(Arrays.asList(new Carta(7,new Espada()),new Carta(3,new Espada()),new Carta(2,new Espada())));
        Juan.setMano(new Mano(lista));

        Assert.assertEquals(mesa.getJugadorActual().getNombre(), Juan.getNombre());
        mesa.flor();
        mesa.quieroFlor();
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Martin.getNombre());
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Pedro.getNombre());
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Ignacio.getNombre());
        mesa.envido();

    }

    @Test
    public void trucoCantadoPermiteCantarEnvidoYVuelveATrucoCantadoAlFinalizarYSeSumanPuntosAEquipoGanador() {

        List<Carta> lista = new ArrayList<>(Arrays.asList(new Carta(7,new Espada()),new Carta(3,new Espada()),new Carta(2,new Espada())));
        Juan.setMano(new Mano(lista));

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.truco();
        mesa.envido();
        mesa.noQuieroTanto();
        mesa.noQuieroTruco();

        Assert.assertTrue(mesa.puntaje(azules) == 1);
        Assert.assertTrue(mesa.puntaje(rojos) == 1);

    }

    @Test(expected = FlorNoAceptadaNoSePuedeJugarException.class)
    public void noSePuedeHacerJugadaSiNoSeDecidioLaFlor() {

        mesa.flor();
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void seCantaFlorSeDecideYSeIntentaCantarFlorDeNuevoLanzaExcepcion() {

        List<Carta> lista = new ArrayList<>(Arrays.asList(new Carta(7,new Espada()),new Carta(3,new Espada()),new Carta(2,new Espada())));
        Juan.setMano(new Mano(lista));

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.flor();
        mesa.quieroFlor();
        mesa.flor();

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void seCantaFlorSeDecideYSeCantaTrucoSeIntentaCantarEnvidoDeNuevoLanzaExcepcion() {

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.flor();
        mesa.quieroFlor();
        mesa.truco();
        mesa.envido();

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void seCantaFlorSeDecideYSeCantaTrucoSeIntentaCantarFlorDeNuevoLanzaExcepcion() {

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.flor();
        mesa.quieroFlor();
        mesa.truco();
        mesa.flor();

    }

    @Test(expected = JugadorNoPuedeCantarTantoNoEsPrimeraVuelta.class)
    public void noSePuedeCantarFlorDespuesDePrimeraVuelta() {

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.flor();

    }

    @Test
    public void cuandoDosJugadoresTienenElMismoTantoGanaElQueVaAntesEnLaRonda() {

        Juan.setMano(new Mano(Arrays.asList(new Carta(1, new Espada()), new Carta(3, new Espada()), new Carta(5, new Basto()))));
        Pedro.setMano(new Mano(Arrays.asList(new Carta(4, new Oro()), new Carta(3, new Oro()), new Carta(6, new Oro()))));
        Martin.setMano(new Mano(Arrays.asList(new Carta(4, new Basto()), new Carta(2, new Basto()), new Carta(2, new Oro()))));
        Ignacio.setMano(new Mano(Arrays.asList(new Carta(4, new Espada()), new Carta(2, new Espada()), new Figura(12, new Espada()))));

        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        mesa.flor();
        mesa.quieroFlor();

        Assert.assertEquals(3, mesa.puntaje(azules));

    }


}
