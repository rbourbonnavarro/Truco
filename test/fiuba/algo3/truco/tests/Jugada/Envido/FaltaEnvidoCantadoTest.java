package fiuba.algo3.truco.tests.Jugada.Envido;

import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Test;

public class FaltaEnvidoCantadoTest {

    EstadoJuego estadoJuego;
    Puntaje puntos;

    @Test
    public void Test1PuntosDevuelveLaDiferenciaDePuntosSiPuntajeEstaEnBuenas(){

        puntos = new Puntaje();
        puntos.sumar(27);
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos, 1);

        Assert.assertEquals(this.estadoJuego.puntos(), 3);

    }

    @Test
    public void Test2PuntosDevuelve30PuntosSiPuntajeEstaEnMalas(){

        puntos = new Puntaje();
        puntos.sumar(12);
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos, 1);

        Assert.assertEquals(this.estadoJuego.puntos(), 30);

    }

    @Test
    public void Test3PuntosDevuelveLaDiferenciaDePuntosSiPuntajeEstaEnBuenas(){

        puntos = new Puntaje();
        puntos.sumar(15);
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos,1);

        Assert.assertEquals(this.estadoJuego.puntos(), 15);

    }

    @Test
    public void Test4NoQueridoDevuelve1PuntoSiSoloSeCantoFaltaEnvido(){

        puntos = new Puntaje();
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos);

        Assert.assertEquals(this.estadoJuego.noQuerido(),1);

    }

    @Test
    public void Test5NoQueridoDevuelve2PuntoSiSeCantoEnvidoFaltaEnvido(){

        puntos = new Puntaje();
        puntos.sumar(25);
        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

        Assert.assertEquals(this.estadoJuego.noQuerido(),2);

    }

    @Test
    public void Test6NoQueridoDevuelve4PuntoSiSeCantoEnvidoEnvidoFaltaEnvido(){
        puntos = new Puntaje();
        puntos.sumar(10);
        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.envidoEnvido();
        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

        Assert.assertEquals(this.estadoJuego.noQuerido(),4);

    }

    @Test
    public void Test7NoQueridoDevuelve7PuntoSiSeCantoEnvidoEnvidoRealEnvidoFaltaEnvido(){
        puntos = new Puntaje();
        puntos.sumar(10);
        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.envidoEnvido();
        this.estadoJuego = this.estadoJuego.realEnvido();
        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

        Assert.assertEquals(this.estadoJuego.noQuerido(),7);

    }

    @Test
    public void Test8NoQueridoDevuelve5PuntoSiSeCantoEnvidoRealEnvidoFaltaEnvido(){

        puntos = new Puntaje();
        puntos.sumar(10);
        this.estadoJuego = new EnvidoCantado(this.estadoJuego);
        this.estadoJuego = this.estadoJuego.realEnvido();
        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

        Assert.assertEquals(this.estadoJuego.noQuerido(),5);

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test9NoSePuedeCantarEnvido(){

        puntos = new Puntaje();
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos);

        this.estadoJuego.envido();

    }

    @Test(expected = NoSePuedeCantarEnvidoEnvido.class)
    public void Test10NoSePuedeCantarEnvidoEnvido(){

        puntos = new Puntaje();
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos);
        this.estadoJuego.envidoEnvido();

    }

    @Test(expected = NoSePuedeCantarRealEnvido.class)
    public void Test11NoSePuedeCantarRealEnvido(){

        puntos = new Puntaje();
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos);
        this.estadoJuego.realEnvido();

    }

    @Test(expected = NoSePuedeCantarFaltaEnvido.class)
    public void Test12NoSePuedeCantarFaltaEnvido(){

        puntos = new Puntaje();
        this.estadoJuego = new FaltaEnvidoCantado(this.estadoJuego, puntos);
        this.estadoJuego.faltaEnvido(puntos);

    }


}
