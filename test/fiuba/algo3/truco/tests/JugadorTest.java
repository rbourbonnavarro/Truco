package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoSinFlor;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class JugadorTest {

    private Jugador jugador;
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;

    @Before
    public void setUp() {

        this.jugador = new Jugador("J1");
        this.carta1 = new Carta(4, new Basto());
        this.carta2 = new Carta(5, new Basto());
        this.carta3= new Figura(11, new Espada());
        this.jugador.setMano(new Mano(Arrays.asList(carta1,carta2,carta3), new JuegoSinFlor()));
    }

    @Test
    public void test1JugadorCalculaCorrectamenteElEnvido() {
        Assert.assertEquals(29, this.jugador.envido());
    }

    @Test
    public void test2JugarCartaEliminaCartaDeLaManoDelJugador(){
        jugador.jugar(carta1);
        Assert.assertEquals(jugador.obtenerCartas().size(),2);
        Assert.assertFalse(jugador.obtenerCartas().contains(carta1));
    }



}
