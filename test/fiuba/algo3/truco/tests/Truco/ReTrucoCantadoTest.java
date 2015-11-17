package fiuba.algo3.truco.tests.Truco;

import fiuba.algo3.truco.modelo.Truco.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReTrucoCantadoTest {
    EstadoTruco truco;
    @Before
    public void setUp() {
        truco = new RetrucoCantado();
    }
    @Test
    public void test1PuntosDevuelve3(){
        Assert.assertEquals(truco.puntos(),3);
    }
    @Test
    public void test2NoQueridoDevuelve2(){
        Assert.assertEquals(truco.noQuerido(),2);
    }
    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco(){
        truco.truco();
    }
    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco(){
        truco.reTruco();
    }
    @Test
    public void test5SePuedeCantarValeCuatro(){
        Assert.assertEquals(truco.valeCuatro(),new ValeCuatroCantado());
    }
}
