package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValeCuatroCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValeCuatroTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp() {

        this.estadoJuego = new ValeCuatroCantado();

    }

    @Test
    public void test1PuntosDevuelve4(){

        Assert.assertEquals(this.estadoJuego.puntos(), 4);

    }

    @Test
    public void test2NoQueridoDevuelve3(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),3);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco(){

        this.estadoJuego.truco();

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco(){

        this.estadoJuego.reTruco();

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro();

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void TestNoSePuedeCantarEnvido(){

        this.estadoJuego.envido();

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


}
