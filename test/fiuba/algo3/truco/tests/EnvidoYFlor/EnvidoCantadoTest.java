package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EstadoEnvido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnvidoCantadoTest {
    EstadoEnvido envido;
    @Before
    public void setUp(){
        envido = new EnvidoCantado();
    }
    @Test
    public void Test1PuntosDevuelve2(){
        Assert.assertEquals(envido.puntos(),2);
    }
    @Test
    public void Test2NoQueridoDevuelve1Punto(){
        Assert.assertEquals(envido.noQuerido(),1);
    }
    @Test
    public void Test3NoSePuedeCantarEnvido(){
        Assert.assertFalse(envido.sePuedeCantarEnvido());
    }
    @Test
    public void Test4SePuedeCantarEnvidoEnvido(){
        Assert.assertTrue(envido.sePuedeCantarEnvidoEnvido());
    }
    @Test
    public void Test5SePuedeCantarRealEnvido(){
        Assert.assertTrue(envido.sePuedeCantarRealEnvido());
    }
    @Test
    public void Test6SePuedeCantarFaltaEnvido(){
        Assert.assertTrue(envido.sePuedeCantarFaltaEnvido());
    }
}
