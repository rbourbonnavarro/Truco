package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EstadoEnvido;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EnvidoEnvidoCantadoTests {
    EstadoEnvido envido;
    @Before
    public void setUp(){
        envido = new EnvidoEnvidoCantado();
    }
    @Test
    public void Test1PuntosDevuelve4(){
        Assert.assertEquals(envido.puntos(), 4);
    }
    @Test
    public void Test2NoQueridoDevuelve2Puntos(){
        Assert.assertEquals(envido.noQuerido(),2);
    }
    @Test
    public void Test3NoSePuedeCantarEnvido(){
        Assert.assertFalse(envido.sePuedeCantarEnvido());
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
