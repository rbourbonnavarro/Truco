package fiuba.algo3.truco.tests.Jugada.Flor;

import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlorNoCantadaTest {
    EstadoFlor flor;
    @Before
    public void setUp(){
        flor = new FlorNoCantada();
    }
    @Test
    public void test1PuntosDevuelve0(){
        Assert.assertEquals(flor.puntos(), 0);
    }
    @Test
    public void test2NoQuieroDevuelve0(){
        Assert.assertEquals(flor.noQuerido(),0);
    }
    @Test
    public void test3FlorCreaFlorCantada() {
        Assert.assertEquals(flor.flor(),new FlorCantada());
    }
    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test4NoSePuedeCantarContraFlorAlResto(){
        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        flor.contraFlorAlResto(puntos);
    }
    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test5ContraFlorAlPartidoCreaDichaInstancia(){
        flor.contraFlorAlPartido();
    }
}
