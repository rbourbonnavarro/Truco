package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Test;

public class PalosTest {

    @Test
    public void bastoSeConvierteCorrectamenteACadena() {

        Palo palo = new Basto();

        Assert.assertEquals("Basto", palo.toString());

    }

    @Test
    public void copaSeConvierteCorrectamenteACadena() {

        Palo palo = new Copa();

        Assert.assertEquals("Copa", palo.toString());

    }

    @Test
    public void espadaSeConvierteCorrectamenteACadena() {

        Palo palo = new Espada();

        Assert.assertEquals("Espada", palo.toString());

    }

    @Test
    public void oroSeConvierteCorrectamenteACadena() {

        Palo palo = new Oro();

        Assert.assertEquals("Oro", palo.toString());

    }


}
