package fiuba.algo3.truco.tests.Mesa;

import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mesa;
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

        mesa.flor();
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Martin.getNombre());
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Pedro.getNombre());
        mesa.hacerJugada(mesa.getJugadorActual().obtenerCartas().get(0));
        Assert.assertEquals(mesa.getJugadorActual().getNombre(),Ignacio.getNombre());
        mesa.envido();

    }


}
