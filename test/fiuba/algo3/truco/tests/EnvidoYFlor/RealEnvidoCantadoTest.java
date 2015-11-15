package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EstadoEnvido;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RealEnvidoCantadoTest {
    EstadoEnvido envido;
    @Test
    public void Test1PuntosDevuelve3SiSoloSeCantoRealEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertEquals(envido.puntos(), 3);
    }
    @Test
    public void Test2NoQueridoDevuelve1PuntoSiSoloSeCantoRealEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertEquals(envido.noQuerido(),1);
    }
    @Test
    public void Test3PuntosDevuelve5SiSeCantoEnvidoRealEnvido(){
        envido = new RealEnvidoCantado(new EnvidoCantado().puntos());
        Assert.assertEquals(envido.puntos(), 5);
    }
    @Test
    public void Test4NoQueridoDevuelve2PuntoSiSeCantoEnvidoRealEnvido(){
        envido = new RealEnvidoCantado(new EnvidoCantado().puntos());
        Assert.assertEquals(envido.noQuerido(),2);
    }
    @Test
    public void Test5PuntosDevuelve7SiSeCantoEnvidoEnvidoRealEnvido(){
        envido = new RealEnvidoCantado(new EnvidoEnvidoCantado().puntos());
        Assert.assertEquals(envido.puntos(), 7);
    }
    @Test
    public void Test6NoQueridoDevuelve4PuntoSiSeCantoEnvidoEnvidoRealEnvido(){
        envido = new RealEnvidoCantado(new EnvidoEnvidoCantado().puntos());
        Assert.assertEquals(envido.noQuerido(),4);
    }
    @Test
    public void Test7NoSePuedeCantarEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertFalse(envido.sePuedeCantarEnvido());
    }
    @Test
    public void Test8NoSePuedeCantarEnvidoEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertFalse(envido.sePuedeCantarEnvidoEnvido());
    }
    @Test
    public void Test9NoSePuedeCantarRealEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertFalse(envido.sePuedeCantarRealEnvido());
    }
    @Test
    public void Test10SePuedeCantarFaltaEnvido(){
        envido = new RealEnvidoCantado();
        Assert.assertTrue(envido.sePuedeCantarFaltaEnvido());
    }
}
