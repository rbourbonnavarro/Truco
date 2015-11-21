package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;

import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.RetrucoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValeCuatroCantado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReTrucoCantadoTest {
    
    EstadoJuego estadoJuego;
    
    @Before
    public void setUp() {

        this.estadoJuego = new RetrucoCantado();

    }

    @Test
    public void test1PuntosDevuelve3(){

        Assert.assertEquals(this.estadoJuego.puntos(),3);

    }

    @Test
    public void test2NoQueridoDevuelve2(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),2);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void test3NoSePuedeCantarTruco(){

        this.estadoJuego.truco();

    }
    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void test4NoSePuedeCantarReTruco(){

        this.estadoJuego.reTruco();

    }

    @Test
    public void test5SePuedeCantarValeCuatro(){

        Assert.assertEquals(this.estadoJuego.valeCuatro(), new ValeCuatroCantado());

    }


}
