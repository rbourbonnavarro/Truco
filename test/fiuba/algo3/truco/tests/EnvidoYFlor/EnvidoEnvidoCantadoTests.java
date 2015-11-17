package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EnvidoEnvidoCantadoTests {

    EstadoEnvido envido;
    @Test
    public void Test1PuntosDevuelve4(){
        envido = new EnvidoEnvidoCantado();
        Assert.assertEquals(envido.puntos(), 4);
    }

    @Test
    public void Test2NoQueridoDevuelve2Puntos(){
        envido = new EnvidoEnvidoCantado();
        Assert.assertEquals(envido.noQuerido(),2);
    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test3NoSePuedeCantarEnvido(){
        envido = new EnvidoEnvidoCantado();
        envido.envido();
    }

    @Test(expected = NoSePuedeCantarEnvidoEnvido.class)
    public void Test4SePuedeCantarEnvidoEnvido(){
        envido = new EnvidoEnvidoCantado();
        envido.envidoEnvido();
    }

    @Test
    public void Test5SePuedeCantarRealEnvido(){
        envido = new EnvidoEnvidoCantado();
        Assert.assertEquals(envido.realEnvido(), new RealEnvidoCantado(3));
    }

    @Test
    public void Test6SePuedeCantarFaltaEnvido(){
        envido = new EnvidoEnvidoCantado();
        Puntaje puntos = new Puntaje();
        puntos.sumar(19);
        Assert.assertEquals(envido.faltaEnvido(puntos),new FaltaEnvidoCantado(puntos));
    }


}
