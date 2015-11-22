package fiuba.algo3.truco.tests.Jugada.Flor;

import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContraFlorAlRestoTest {
    
    EstadoJuego estadoJuego;
    Puntaje puntos;

    @Before
    public void setUp(){

        puntos = new Puntaje ();
        puntos.sumar(5);
        this.estadoJuego = new ContraFlorAlRestoCantada(this.estadoJuego, puntos, new FlorCantada(this.estadoJuego).puntos());

    }

    @Test
    public void test1PuntosDevuelve25(){

        Assert.assertEquals(this.estadoJuego.puntos(), 25);

    }

    @Test
    public void test2PuntosDevuelve10(){

        puntos.sumar(15);
        this.estadoJuego = new ContraFlorAlRestoCantada(this.estadoJuego, puntos, new FlorCantada(this.estadoJuego).puntos());
        Assert.assertEquals(this.estadoJuego.puntos(), 10);

    }

    @Test
    public void test3NoQuieroDevuelve3(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),3);

    }

    @Test(expected = NoSePuedeCantarFlorException.class)
    public void testNoSePuedeCantarFlor() {

        this.estadoJuego.flor();

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

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void TestNoSePuedeCantarTruco() {

        this.estadoJuego.truco();

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void TestNoSePuedeCantarRetruco(){

        this.estadoJuego.reTruco();

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void TestNoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro();

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void TestNoSePuedeCantarEnvido(){

        this.estadoJuego.envido();

    }

    @Test(expected = NoSePuedeCantarEnvidoEnvido.class)
    public void TestNoSePuedeCantarEnvidoEnvido(){

        this.estadoJuego.envidoEnvido();

    }

    @Test(expected = NoSePuedeCantarRealEnvido.class)
    public void TestNoSePuedeCantarRealEnvido(){

        this.estadoJuego.realEnvido();

    }

    @Test(expected = NoSePuedeCantarFaltaEnvido.class)
    public void TestNoSePuedeCantarFaltaEnvido(){

        Puntaje puntos = new Puntaje();
        this.estadoJuego.faltaEnvido(puntos);

    }


}
