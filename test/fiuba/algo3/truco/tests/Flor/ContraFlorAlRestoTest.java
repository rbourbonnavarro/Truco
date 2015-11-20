package fiuba.algo3.truco.tests.Flor;

import fiuba.algo3.truco.modelo.EstadoFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContraFlorAlRestoTest {
    EstadoFlor flor;
    Puntaje puntos;
    @Before
    public void setUp(){
        puntos = new Puntaje ();
        puntos.sumar(5);
        flor = new ContraFlorAlRestoCantada(puntos,new FlorCantada().puntos());
    }
    @Test
    public void test1PuntosDevuelve25(){
        Assert.assertEquals(flor.puntos(), 25);
    }
    @Test
    public void test2PuntosDevuelve10(){
        puntos.sumar(15);
        flor = new ContraFlorAlRestoCantada(puntos,new FlorCantada().puntos());
        Assert.assertEquals(flor.puntos(), 10);
    }
    @Test
    public void test3NoQuieroDevuelve3(){
        Assert.assertEquals(flor.noQuerido(),3);
    }
    @Test(expected = NoSePuedeCantarFlorException.class)
    public void test4NoSePuedeCantarFlor() {
        flor.flor();
    }
    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test5NoSePuedeCantarContraFlorAlResto(){
        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        flor.contraFlorAlResto(puntos);
    }
    @Test(expected = NoSePuedeCantarContraFlorException.class)
    public void test6ContraFlorAlPartidoCreaDichaInstancia(){
        flor.contraFlorAlPartido();
    }
}
