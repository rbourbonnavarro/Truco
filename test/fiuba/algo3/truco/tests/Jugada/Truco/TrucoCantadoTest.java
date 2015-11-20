package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugada.Truco.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrucoCantadoTest {
    EstadoTruco truco;
    @Before
    public void setUp(){
        truco = new TrucoCantado();
    }

    @Test
    public void test1PuntosDevuelve2(){
        Assert.assertEquals(truco.puntos(), 2);
    }
    @Test
    public void test2NoQueridoDevuelve1(){
        Assert.assertEquals(truco.noQuerido(), 1);
    }
    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco() {
        truco.truco();
    }
    @Test
    public void test4SePuedeCantarReTruco() {
        Assert.assertEquals(truco.reTruco(),new RetrucoCantado());
    }
    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro() {
        truco.valeCuatro();
    }

}
