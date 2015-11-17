package fiuba.algo3.truco.tests.Truco;

import fiuba.algo3.truco.modelo.Truco.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrucoNoCantadoTest {
    EstadoTruco truco;
    @Before
    public void setUp(){
        truco = new TrucoNoCantado();
    }
    @Test
    public void test1PuntosDevuelve1(){
        Assert.assertEquals(truco.puntos(), 1);
    }
    @Test
    public void test2NoQueridoDevuelve0(){
        Assert.assertEquals(truco.noQuerido(), 0);
    }
    @Test
    public void test3SePuedeCantarTruco() {
        Assert.assertEquals(truco.truco(), new TrucoCantado());
    }
    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco() {
        Assert.assertEquals(truco.reTruco(),new RetrucoCantado());
    }
    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro() {
        truco.valeCuatro();
    }
    @Test
    public void test6ProbandoEquals() {
        Assert.assertEquals(truco,new TrucoNoCantado());
    }
}
