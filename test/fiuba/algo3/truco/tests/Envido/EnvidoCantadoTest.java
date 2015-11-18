package fiuba.algo3.truco.tests.Envido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.EstadoEnvido;
import fiuba.algo3.truco.modelo.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

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

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test3NoSePuedeCantarEnvido(){
      envido.envido();
    }

    @Test
    public void Test4SePuedeCantarEnvidoEnvido(){
        envido.envidoEnvido();
        Assert.assertEquals(envido.envidoEnvido(),new EnvidoEnvidoCantado());
    }

    @Test
    public void Test5SePuedeCantarRealEnvido(){
        envido.realEnvido();
        Assert.assertEquals(envido.realEnvido(),new RealEnvidoCantado());
    }

    @Test
    public void Test6SePuedeCantarFaltaEnvido(){
        Puntaje puntos = new Puntaje();
        puntos.sumar(3);
        envido.faltaEnvido(puntos);
        Assert.assertEquals(envido.faltaEnvido(puntos),new FaltaEnvidoCantado(puntos));
    }


}