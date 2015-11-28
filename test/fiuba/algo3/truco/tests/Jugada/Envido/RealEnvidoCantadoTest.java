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
import org.junit.Test;

import java.util.Arrays;

public class RealEnvidoCantadoTest {

    EstadoJuego estadoJuego;

    @Test
    public void Test1PuntosDevuelve3SiSoloSeCantoRealEnvido(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        Assert.assertEquals(this.estadoJuego.puntos(), 3);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void TestNoSePuedeCantarTruco(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.truco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void TestNoSePuedeCantarRetruco(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.reTruco(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void TestNoSePuedeCantarValeCuatro(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.valeCuatro(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test
    public void Test2NoQueridoDevuelve1PuntoSiSoloSeCantoRealEnvido(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        Assert.assertEquals(this.estadoJuego.noQuerido(),1);

    }

    @Test
    public void Test3PuntosDevuelve5SiSeCantoEnvidoRealEnvido(){

        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        Assert.assertEquals(this.estadoJuego.puntos(), 5);

    }

    @Test
    public void Test4NoQueridoDevuelve2PuntoSiSeCantoEnvidoRealEnvido(){

        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        Assert.assertEquals(this.estadoJuego.noQuerido(),2);

    }

    @Test
    public void Test5PuntosDevuelve7SiSeCantoEnvidoEnvidoRealEnvido(){

        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        this.estadoJuego = this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        Assert.assertEquals(this.estadoJuego.puntos(), 7);

    }

    @Test
    public void Test6NoQueridoDevuelve4PuntoSiSeCantoEnvidoEnvidoRealEnvido(){

        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        this.estadoJuego = this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));
        Assert.assertEquals(this.estadoJuego.noQuerido(),4);

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test7NoSePuedeCantarEnvido(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.envido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test(expected = NoSePuedeCantarRealEnvido.class)
    public void Test9NoSePuedeCantarRealEnvido(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.realEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }

    @Test
    public void Test10SePuedeCantarFaltaEnvido(){

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        Puntaje puntos = new Puntaje();
        puntos.sumar(16);

        Assert.assertEquals(this.estadoJuego.faltaEnvido(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))), puntos), new FaltaEnvidoCantado(this.estadoJuego, puntos));

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void testNoSePuedeCantarFlor() {

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.flor(new Equipo("equipo", Arrays.asList(new Jugador("jugador"))));

    }
    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void testNoSePuedeCantarContraFlorAlResto() {

        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.contraFlorAlResto(puntos);

    }

    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void testNoSePuedeCantarContraFlorAlPartido() {

        this.estadoJuego = new RealEnvidoCantado(this.estadoJuego);
        this.estadoJuego.contraFlorAlPartido();

    }


}
