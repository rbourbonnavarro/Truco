package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoNoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EstadoEnvido;
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
        Assert.assertTrue(envido.sePuedeCantarEnvido());
    }
    @Test
    public void Test4SePuedeCantarEnvidoEnvido(){
        Assert.assertFalse(envido.sePuedeCantarEnvidoEnvido());
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
