package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.RetrucoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrucoCantadoTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp(){

        boolean seJuegaConFlor = false;
        this.estadoJuego = new TrucoCantado(seJuegaConFlor);

    }

    @Test
    public void test1PuntosDevuelve2(){

        Assert.assertEquals(this.estadoJuego.puntos(), 2);

    }

    @Test
    public void test2NoQueridoDevuelve1(){

        Assert.assertEquals(this.estadoJuego.noQuerido(), 1);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco() {

        this.estadoJuego.truco();

    }

    @Test
    public void test4SePuedeCantarReTruco() {

        Assert.assertEquals(this.estadoJuego.reTruco(),new RetrucoCantado());

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro() {

        this.estadoJuego.valeCuatro();

    }


}
