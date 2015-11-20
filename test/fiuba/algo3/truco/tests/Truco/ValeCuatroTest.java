package fiuba.algo3.truco.tests.Truco;

import fiuba.algo3.truco.modelo.Truco.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValeCuatroTest {
    EstadoTruco truco;
    @Before
    public void setUp() {
        truco = new ValeCuatroCantado();
    }
    @Test
    public void test1PuntosDevuelve4(){
        Assert.assertEquals(truco.puntos(), 4);
    }
    @Test
    public void test2NoQueridoDevuelve3(){
        Assert.assertEquals(truco.noQuerido(),3);
    }
    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco(){
        truco.truco();
    }
    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco(){
        truco.reTruco();
    }
    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro(){
        truco.valeCuatro();
    }
}
