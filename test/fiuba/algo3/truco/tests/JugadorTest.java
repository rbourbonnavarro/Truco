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

    @Before
    public void setUp() {

        this.jugador = new Jugador("J1");

    }

    @Test
    public void jugadorCalculaCorrectamenteElEnvido() {

        this.jugador.setMano(new Mano(Arrays.asList(new Carta(4, new Basto()), new Carta(5, new Basto()), new Figura(11, new Espada())), new JuegoSinFlor()));

        Assert.assertEquals(29, this.jugador.envido());

    }


}
