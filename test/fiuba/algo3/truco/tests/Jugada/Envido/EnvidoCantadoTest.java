package fiuba.algo3.truco.tests.Jugada.Envido;

import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoCantadoTest {

    EstadoJuego estadoJuego;

    @Before
    public void setUp() {

        this.estadoJuego = new EnvidoCantado(new NadaCantado());

    }

    @Test
    public void Test1PuntosDevuelve2(){

        Assert.assertEquals(this.estadoJuego.puntos(), 2);

    }

    @Test
    public void Test2NoQueridoDevuelve1Punto(){

        Assert.assertEquals(this.estadoJuego.noQuerido(),1);

    }

    @Test(expected = NoSePuedeCantarTrucoException.class)
    public void TestNoSePuedeCantarTruco(){

        this.estadoJuego.truco();

    }

    @Test(expected = NoSePuedeCantarRetrucoException.class)
    public void TestNoSePuedeCantarRetruco(){

        this.estadoJuego.reTruco();

    }

    @Test(expected = NoSePuedeCantarValeCuatroException.class)
    public void TestNoSePuedeCantarValeCuatro(){

        this.estadoJuego.valeCuatro();

    }

    @Test(expected = NoSePuedeCantarEnvido.class)
    public void Test3NoSePuedeCantarEnvido(){

        this.estadoJuego.envido();

    }

    @Test
    public void Test4SePuedeCantarEnvidoEnvido(){

        this.estadoJuego = this.estadoJuego.envidoEnvido();
        Assert.assertEquals(this.estadoJuego, new EnvidoEnvidoCantado(this.estadoJuego));

    }

    @Test
    public void Test5SePuedeCantarRealEnvido(){

        this.estadoJuego = this.estadoJuego.realEnvido();
        Assert.assertEquals(this.estadoJuego, new RealEnvidoCantado(this.estadoJuego));

    }

    @Test
    public void Test6SePuedeCantarFaltaEnvido(){

        Puntaje puntos = new Puntaje();
        puntos.sumar(3);
        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

        Assert.assertEquals(this.estadoJuego, new FaltaEnvidoCantado(this.estadoJuego, puntos));

    }


}
