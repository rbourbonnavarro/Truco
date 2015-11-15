package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
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
    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test3NoSePuedeCantarEnvido(){
        envido.envido();
    }
    @Test(expected = NoSePuedeCantarEnvidoEnvido.class)
    public void Test4SePuedeCantarEnvidoEnvido(){
        envido.envidoEnvido();
    }
    @Test
    public void Test5SePuedeCantarRealEnvido(){
        Assert.assertEquals(envido.realEnvido(), new RealEnvidoCantado(3));
    }
    @Test
    public void Test6SePuedeCantarFaltaEnvido(){
        Puntaje puntos = new Buenas(4);
        Assert.assertEquals(envido.faltaEnvido(puntos),new FaltaEnvidoCantado(puntos));
    }
}
