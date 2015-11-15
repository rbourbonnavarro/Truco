package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Malas;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Test;

public class FaltaEnvidoCantadoTest {
    EstadoEnvido envido;
    Puntaje puntos;
    @Test
    public void Test1PuntosDevuelveLaDiferenciaDePuntosSiPuntajeEstaEnBuenas(){
        puntos = new Buenas(12);
        envido = new FaltaEnvidoCantado(puntos,1);
        Assert.assertEquals(envido.puntos(), 3);
    }
    @Test
    public void Test2PuntosDevuelve30PuntosSiPuntajeEstaEnMalas(){
        puntos = new Malas(12);
        envido = new FaltaEnvidoCantado(puntos,1);
        Assert.assertEquals(envido.puntos(), 30);
    }
    @Test
    public void Test3PuntosDevuelveLaDiferenciaDePuntosSiPuntajeEstaEnBuenas(){
        puntos = new Buenas();
        envido = new FaltaEnvidoCantado(puntos,1);
        Assert.assertEquals(envido.puntos(), 15);
    }
    @Test
    public void Test4NoQueridoDevuelve1PuntoSiSoloSeCantoFaltaEnvido(){
        puntos = new Malas();
        envido = new FaltaEnvidoCantado(puntos);
        Assert.assertEquals(envido.noQuerido(),1);
    }
    @Test
    public void Test5NoQueridoDevuelve2PuntoSiSeCantoEnvidoFaltaEnvido(){
        puntos = new Buenas(10);
        envido = new FaltaEnvidoCantado(puntos,new EnvidoCantado().puntos());
        Assert.assertEquals(envido.noQuerido(),2);
    }
    @Test
    public void Test6NoQueridoDevuelve4PuntoSiSeCantoEnvidoEnvidoFaltaEnvido(){
        puntos = new Malas(10);
        envido = new FaltaEnvidoCantado(puntos,new EnvidoEnvidoCantado().puntos());
        Assert.assertEquals(envido.noQuerido(),4);
    }
    @Test
    public void Test7NoQueridoDevuelve7PuntoSiSeCantoEnvidoEnvidoRealEnvidoFaltaEnvido(){
        puntos = new Malas(10);
        int puntosEnvidoEnvido= new EnvidoEnvidoCantado().puntos();
        envido = new FaltaEnvidoCantado(puntos,new RealEnvidoCantado(puntosEnvidoEnvido).puntos());
        Assert.assertEquals(envido.noQuerido(),7);
    }
    @Test
    public void Test8NoQueridoDevuelve5PuntoSiSeCantoEnvidoRealEnvidoFaltaEnvido(){
        puntos = new Malas(10);
        int puntosEnvido= new EnvidoCantado().puntos();
        envido = new FaltaEnvidoCantado(puntos,new RealEnvidoCantado(puntosEnvido).puntos());
        Assert.assertEquals(envido.noQuerido(),5);
    }
    @Test
    public void Test9NoSePuedeCantarEnvido(){
        puntos = new Malas();
        envido = new FaltaEnvidoCantado(puntos);
        Assert.assertFalse(envido.sePuedeCantarEnvido());
    }
    @Test
    public void Test10NoSePuedeCantarEnvidoEnvido(){
        puntos = new Malas();
        envido = new FaltaEnvidoCantado(puntos);
        Assert.assertFalse(envido.sePuedeCantarEnvidoEnvido());
    }
    @Test
    public void Test11NoSePuedeCantarRealEnvido(){
        puntos = new Malas();
        envido = new FaltaEnvidoCantado(puntos);
        Assert.assertFalse(envido.sePuedeCantarRealEnvido());
    }
    @Test
    public void Test12NoSePuedeCantarFaltaEnvido(){
        puntos = new Malas();
        envido = new FaltaEnvidoCantado(puntos);
        Assert.assertFalse(envido.sePuedeCantarFaltaEnvido());
    }
}
