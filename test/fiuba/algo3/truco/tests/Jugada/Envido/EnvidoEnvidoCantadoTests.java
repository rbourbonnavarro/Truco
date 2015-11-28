package fiuba.algo3.truco.tests.Jugada.Envido;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class EnvidoEnvidoCantadoTests {

    EstadoJuego estadoJuego;
    
    @Before
    public void setUp() {

        this.estadoJuego = new EnvidoEnvidoCantado(this.estadoJuego);

    }

    @Test
    public void Test1PuntosDevuelve4(){

        Assert.assertEquals(this.estadoJuego.puntos(), 4);

    }

    @Test
    public void test2NoQueridoDevuelve2Puntos(){

        Assert.assertEquals(2,this.estadoJuego.noQuerido());

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void TestNoSePuedeCantarTruco(){

        this.estadoJuego.truco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void TestNoSePuedeCantarRetruco(){

        this.estadoJuego.reTruco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void TestNoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }


    @Test (expected = NoSePuedeCantarEnvidoEnvido.class)
    public void test4NoSePuedeCantarEnvidoEnvido(){

        this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test
    public void test5SePuedeCantarRealEnvido() {

        Assert.assertEquals(new RealEnvidoCantado(this.estadoJuego, 4), this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador")))));
    }

    @Test
    public void test6SePuedeCantarFaltaEnvido() {

        Puntaje puntos = new Puntaje();
        puntos.sumar(15);
        Assert.assertEquals(this.estadoJuego.faltaEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))), puntos), new FaltaEnvidoCantado(this.estadoJuego, puntos));

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void testNoSePuedeCantarFlor() {

        this.estadoJuego.flor(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

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
