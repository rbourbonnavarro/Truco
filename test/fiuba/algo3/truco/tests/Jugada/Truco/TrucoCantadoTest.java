package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.RetrucoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrucoCantadoTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp(){
        this.estadoJuego = new TrucoCantado(false);

    }

    @Test
    public void test1PuntosDevuelve2(){

        Assert.assertEquals(this.estadoJuego.puntos(), 2);

    }

    @Test
    public void test2NoQueridoDevuelve1(){

        Assert.assertEquals(this.estadoJuego.noQuerido(), 1);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco() {

        this.estadoJuego.truco();

    }

    @Test
    public void test4SePuedeCantarReTruco() {

        Assert.assertEquals(this.estadoJuego.reTruco(),new RetrucoCantado());

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro() {

        this.estadoJuego.valeCuatro();

    }

    @Test
    public void TestSePuedeCantarEnvido(){

        this.estadoJuego = this.estadoJuego.envido();
        Assert.assertEquals(estadoJuego, new EnvidoCantado(new NadaCantado()));

    }

    @Test
    public void testSePuedeCantarFlor() {

        this.estadoJuego = this.estadoJuego.flor();

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
