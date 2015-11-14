package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Palo;
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
    public void Test2AgregarAManoIncrementaElNumeroDeCartasDelPalo () {
        Mano mano = new Mano();
        Carta carta = new Carta(7,new Espada());
        Assert.assertEquals(mano.getCantidadEspada(),0);
        carta.getPalo().AgregarA(mano);
        Assert.assertEquals(mano.getCantidadEspada(),1);
    }

}
