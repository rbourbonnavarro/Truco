package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Test;


public class CartaTest {
    @Test
    public void Test1SeCreoCorrectamenteUnaCarta () {
        Carta carta = new Carta(5, new Espada());
        Assert.assertEquals(5, carta.getValor());
        Assert.assertEquals(new Espada(), carta.getPalo() );
    }

    @Test
    public void Test6toStringFunciona() {

        Carta carta = new Carta(7, new Espada());

        Assert.assertEquals("7Espada", carta.toString());

    }
    @Test
    public void Test7ProbandoEquals(){
        Carta carta = new Carta(1,new Espada());
        Assert.assertEquals(carta, new Carta(1,new Espada()));
        Assert.assertFalse(carta.equals(new Carta(1,new Basto())));
        Assert.assertFalse(carta.equals(new Carta(2,new Espada())));
    }


}
