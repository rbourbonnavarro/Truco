package fiuba.algo3.truco.tests.Flor;

import fiuba.algo3.truco.modelo.EstadoFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlorCantadaTest {
    EstadoFlor flor;
    @Before
    public void setUp(){
        flor = new FlorCantada();
    }
    @Test
    public void test1PuntosDevuelve3(){
        Assert.assertEquals(flor.puntos(),3);
    }
    @Test(expected = NoSePuedeNoQuererFlorException.class)
    public void test2NoSePuedeNoQuererFlor(){
        flor.noQuerido();
    }
    @Test
    public void test3FlorCreaFlorFlorCantada() {
        Assert.assertEquals(flor.flor(),new FlorFlorCantada());
    }
    @Test
    public void test4ContraFlorAlRestoCreaInstanciaCorrespondiente(){
        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        Assert.assertEquals(flor.contraFlorAlResto(puntos),new ContraFlorAlRestoCantada(puntos,3));
    }
    @Test
    public void test5ContraFlorAlPartidoCreaDichaInstancia(){
        Assert.assertEquals(flor.contraFlorAlPartido(),new ContraFlorAlPartidoCantado());
    }
}
