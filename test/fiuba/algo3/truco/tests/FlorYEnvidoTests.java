package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import org.junit.Assert;
import org.junit.Test;

public class FlorYEnvidoTests {

    @Test
    public void manoCalculaCorrectamenteElEnvido() {

        Mano mano = new Mano(new Carta(7, Palo.ESPADA), new Carta(1, Palo.ESPADA), new Figura(10, Palo.BASTO), new JuegoConFlor());

        Mano mano1 = new Mano(new Carta(7, Palo.ESPADA), new Carta(1, Palo.BASTO), new Figura(12, Palo.ESPADA), new JuegoConFlor());

        Mano mano2 = new Mano(new Carta(7, Palo.BASTO), new Figura(11, Palo.ESPADA), new Figura(10, Palo.ESPADA), new JuegoConFlor());

        Mano mano3 = new Mano(new Carta(7, Palo.ESPADA), new Carta(1, Palo.ORO), new Figura(10, Palo.BASTO), new JuegoConFlor());

        Assert.assertTrue(mano.envido() == 28);
        Assert.assertTrue(mano1.envido() == 27);
        Assert.assertTrue(mano2.envido() == 20);
        Assert.assertTrue(mano3.envido() == 0);

    }

    @Test
    public void manoCalculaCorrectamenteLaFlorCuandoSeJuegaConFlor() {

        Mano mano = new Mano(new Carta(7, Palo.ESPADA), new Carta(1, Palo.ESPADA), new Figura(10, Palo.ESPADA), new JuegoConFlor());

        Mano mano1 = new Mano(new Carta(6, Palo.ESPADA), new Figura(11, Palo.ESPADA), new Figura(10, Palo.ESPADA), new JuegoConFlor());

        Mano mano2 = new Mano(new Figura(12, Palo.ESPADA), new Figura(11, Palo.ESPADA), new Figura(10, Palo.ESPADA), new JuegoConFlor());

        Mano mano3 = new Mano(new Carta(7, Palo.ESPADA), new Carta(6, Palo.ESPADA), new Carta(5, Palo.ESPADA), new JuegoConFlor());

        Assert.assertTrue(mano.flor() == 28);
        Assert.assertTrue(mano1.flor() == 26);
        Assert.assertTrue(mano2.flor() == 20);
        Assert.assertTrue(mano3.flor() == 38);

    }




}
