package fiuba.algo3.truco.tests.Flor;

import fiuba.algo3.truco.modelo.EstadoFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlorFlorCantadaTest {
    EstadoFlor flor;
    @Before
    public void setUp(){
        flor = new FlorFlorCantada();
    }
    @Test
    public void test1PuntosDevuelve6(){
        Assert.assertEquals(flor.puntos(), 6);
    }
    @Test
    public void test2NoQuieroDevuelve3(){
        Assert.assertEquals(flor.noQuerido(),3);
    }
    @Test(expected = NoSePuedeCantarFlorException.class)
    public void test3NoSePuedeCantarFlor() {
        flor.flor();
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