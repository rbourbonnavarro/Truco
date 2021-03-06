package fiuba.algo3.truco.tests.Jugada.Flor;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoCantado;
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


public class ContraFlorAlPartidoTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp(){

        this.estadoJuego = new ContraFlorAlPartidoCantado(this.estadoJuego);

    }

    @Test
    public void test1PuntosDevuelve30(){

        Assert.assertEquals(this.estadoJuego.puntos(), 30);

    }

    @Test
    public void test2NoQuieroDevuelve3(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),3);

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void test3NoSePuedeCantarFlor() {

        this.estadoJuego.flor(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test4NoSePuedeCantarContraFlorAlResto(){

        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        this.estadoJuego.contraFlorAlResto(puntos);

    }

    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test5ContraFlorAlPartidoCreaDichaInstancia(){

        this.estadoJuego.contraFlorAlPartido();

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void testNoSePuedeCantarTruco(){

        this.estadoJuego.truco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void testNoSePuedeCantarReTruco(){

        this.estadoJuego.reTruco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void testNoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void TestNoSePuedeCantarEnvido(){

        this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarRealEnvido.class)
    public void TestNoSePuedeCantarRealEnvido(){

        this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarFaltaEnvido.class)
    public void TestNoSePuedeCantarFaltaEnvido(){

        Puntaje puntos = new Puntaje();
        this.estadoJuego.faltaEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))), puntos);

    }


}
