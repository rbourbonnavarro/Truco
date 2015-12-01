package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TrucoCantadoTantoNoJugadoTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp(){

        this.estadoJuego = new TrucoCantadoTantoNoJugado(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = TrucoNoQueridoNoSePuedeJugarException.class)
    public void test1PuntosLanzaExcepcionPorqueNoSeQuiso(){

        this.estadoJuego.puntos();

    }

    @Test
    public void test2NoQueridoDevuelve1(){

        Assert.assertEquals(this.estadoJuego.noQuerido(), 1);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco() {

        this.estadoJuego.truco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test
    public void test4SePuedeCantarReTruco() {

        Assert.assertEquals(this.estadoJuego.reTruco(new Equipo("equipo", Arrays.asList(new Jugador("jugador")))),new RetrucoCantado(new Equipo("equipo", Arrays.asList(new Jugador("jugador")))));

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro() {

        this.estadoJuego.valeCuatro(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test
    public void TestSePuedeCantarEnvido(){

        this.estadoJuego = this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        Assert.assertEquals(estadoJuego, new EnvidoCantado(new NadaCantado()));

    }

    @Test
    public void testSePuedeCantarFlor() {

        this.estadoJuego = this.estadoJuego.flor(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

        Assert.assertEquals(this.estadoJuego, new FlorCantada(this.estadoJuego));

    }

    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void testNoSePuedeCantarContraFlorAlResto() {

        Puntaje puntos = new Puntaje();
        puntos.sumar(20);

        this.estadoJuego.contraFlorAlResto(puntos);

    }

    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void testNoSePuedeCantarContraFlorAlPartido() {

        this.estadoJuego.contraFlorAlPartido();

    }


}
