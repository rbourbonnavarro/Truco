package fiuba.algo3.truco.tests.Jugada.Flor;

import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlorCantadaTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp(){

        this.estadoJuego = new FlorCantada(this.estadoJuego);

    }

    @Test
    public void test1PuntosDevuelve3(){

        Assert.assertEquals(this.estadoJuego.puntos(),3);

    }

    @Test(expected = NoSePuedeQuererFlorException.class)
    public void test2NoSePuedeQuererFlor(){

        this.estadoJuego.quiero();

    }

    @Test(expected = NoSePuedeNoQuererFlorException.class)
    public void test2NoSePuedeNoQuererFlor(){

        this.estadoJuego.noQuerido();

    }

    @Test
    public void test3FlorCreaFlorFlorCantada() {

        Assert.assertEquals(this.estadoJuego.flor(), new FlorFlorCantada(this.estadoJuego));

    }

    @Test
    public void test4ContraFlorAlRestoCreaInstanciaCorrespondiente(){

        Puntaje puntos = new Puntaje();
        puntos.sumar(20);
        Assert.assertEquals(this.estadoJuego.contraFlorAlResto(puntos), new ContraFlorAlRestoCantada(this.estadoJuego, puntos,3));

    }

    @Test
    public void test5ContraFlorAlPartidoCreaDichaInstancia(){

        Assert.assertEquals(this.estadoJuego.contraFlorAlPartido(),new ContraFlorAlPartidoCantado(this.estadoJuego));

    }


}
