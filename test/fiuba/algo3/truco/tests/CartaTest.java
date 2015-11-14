package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by GomezPeter on 14/11/2015.
 */
public class CartaTest {
    @Test
    public void Test1SeCreoCorrectamenteUnaCarta () {
        Carta carta = new Carta(5, new Espada());
        Assert.assertEquals(5, carta.getValor());
        Assert.assertEquals(new Espada(), carta.getPalo() );
    }
    @Test
    public void Test2AgregarAManoIncrementaElNumeroDeCartasDeEspada () {
        Mano mano = new Mano();
        Carta carta = new Carta(7,new Espada());
        Assert.assertEquals(mano.getCantidadEspada(),0);
        carta.getPalo().AgregarA(mano);
        Assert.assertEquals(mano.getCantidadEspada(),1);
    }
    @Test
    public void Test3AgregarAManoIncrementaElNumeroDeCartasDeCopa () {
        Mano mano = new Mano();
        Carta carta = new Carta(7,new Copa());
        Assert.assertEquals(mano.getCantidadEspada(),0);
        Assert.assertEquals(mano.getCantidadCopa(),0);

        carta.getPalo().AgregarA(mano);
        Assert.assertEquals(mano.getCantidadCopa(),1);
    }
    @Test
    public void Test4AgregarAManoIncrementaElNumeroDeCartasDeOro () {
        Mano mano = new Mano();
        Carta carta = new Carta(7,new Oro());
        Assert.assertEquals(mano.getCantidadOro(),0);

        carta.getPalo().AgregarA(mano);
        Assert.assertEquals(mano.getCantidadOro(),1);
    }
    @Test
    public void Test5AgregarAManoIncrementaElNumeroDeCartasDeBasto () {
        Mano mano = new Mano();
        Carta carta = new Carta(7,new Basto());
        Assert.assertEquals(mano.getCantidadBasto(),0);

        carta.getPalo().AgregarA(mano);
        Assert.assertEquals(mano.getCantidadBasto(),1);
    }
}
