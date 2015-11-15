package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnvidoNoCantadoTest {
    EstadoEnvido envido;
    @Before
    public void setUp(){
        envido = new EnvidoNoCantado();
    }
    @Test
    public void Test1PuntosDevuelve1(){
        Assert.assertEquals(envido.puntos(), 1);
    }
    @Test
    public void Test2NoQueridoDevuelve0Puntos(){
        Assert.assertEquals(envido.noQuerido(),0);
    }
    @Test
    public void Test3SePuedeCantarEnvido(){
        Assert.assertEquals(envido.envido(), new EnvidoCantado());
    }
    @Test(expected = NoSePuedeCantarEnvidoEnvido.class)
    public void Test4NoSePuedeCantarEnvidoEnvido(){
        envido.envidoEnvido();
    }
    @Test
    public void Test5SePuedeCantarRealEnvido(){
        Assert.assertEquals(envido.realEnvido(), new RealEnvidoCantado());
    }
    @Test
    public void Test6SePuedeCantarFaltaEnvido(){
        Puntaje puntos = new Puntaje();
        puntos.sumar(16);
        Assert.assertEquals(envido.faltaEnvido(puntos),new FaltaEnvidoCantado(puntos));
    }
}
