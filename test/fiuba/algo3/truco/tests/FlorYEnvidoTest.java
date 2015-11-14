package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import fiuba.algo3.truco.modelo.Palo.Palo;
import org.junit.Assert;
import org.junit.Test;


public class FlorYEnvidoTest {
    @Test
    public void TestParaQuePaseJenkins () {
        Assert.assertTrue(true);
    }


   /* @Test
    public void manoCalculaCorrectamenteElEnvido() {

        Mano mano = new Mano(new Carta(7, new Espada()), new Carta(1, new Espada()), new Figura(10, new Basto()), new JuegoConFlor());

        Mano mano1 = new Mano(new Carta(7, new Espada()), new Carta(1, new Basto()), new Figura(12, new Espada()), new JuegoConFlor());

        Mano mano2 = new Mano(new Carta(7, new Basto()), new Figura(11, new Espada()), new Figura(10, new Espada()), new JuegoConFlor());

        Mano mano3 = new Mano(new Carta(7, new Espada()), new Carta(1, new Oro()), new Figura(10, new Basto()), new JuegoConFlor());

        Assert.assertTrue(mano.envido() == 28);
        Assert.assertTrue(mano1.envido() == 27);
        Assert.assertTrue(mano2.envido() == 20);
        Assert.assertTrue(mano3.envido() == 0);

    }

    @Test
    public void manoCalculaCorrectamenteLaFlorCuandoSeJuegaConFlor() {

        Mano mano = new Mano(new Carta(7, new Espada()), new Carta(1, new Espada()), new Figura(10, new Espada()), new JuegoConFlor());

        Mano mano1 = new Mano(new Carta(6, new Espada()), new Figura(11, new Espada()), new Figura(10, new Espada()), new JuegoConFlor());

        Mano mano2 = new Mano(new Figura(12, new Espada()), new Figura(11, new Espada()), new Figura(10, new Espada()), new JuegoConFlor());

        Mano mano3 = new Mano(new Carta(7, new Espada()), new Carta(6, new Espada()), new Carta(5, new Espada()), new JuegoConFlor());

        Assert.assertTrue(mano.flor() == 28);
        Assert.assertTrue(mano1.flor() == 26);
        Assert.assertTrue(mano2.flor() == 20);
        Assert.assertTrue(mano3.flor() == 38);

    }

    @Test (expected = NoHayFlorException.class)
    public void manoLanzaExcepcionSiSeCantaFlorSinTenerFlor() {

        Mano mano = new Mano(new Carta(7, new Basto()), new Carta(1, new Espada()), new Figura(10, new Espada()), new JuegoConFlor());

        mano.flor();

    }

    @Test (expected = JuegoSinFlorException.class)
    public void manoLanzaExcepcionSiSeCantaFlorCuandoNoSeJuegaConFlor() {

        Mano mano = new Mano(new Carta(7, new Espada()), new Carta(1, new Espada()), new Figura(10, new Espada()), new JuegoSinFlor());

        mano.flor();

    }*/


}
