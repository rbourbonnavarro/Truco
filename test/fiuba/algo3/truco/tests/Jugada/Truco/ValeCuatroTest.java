package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValeCuatroCantado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValeCuatroTest {
    
    EstadoJuego estadoJuego;

    @Before
    public void setUp() {

        this.estadoJuego = new ValeCuatroCantado();

    }

    @Test
    public void test1PuntosDevuelve4(){

        Assert.assertEquals(this.estadoJuego.puntos(), 4);

    }

    @Test
    public void test2NoQueridoDevuelve3(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),3);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco(){

        this.estadoJuego.truco();

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco(){

        this.estadoJuego.reTruco();

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void test5NoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro();

    }


}
