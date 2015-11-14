package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class ManoTest {
    Carta carta;
    Mano mano;
    @Before
    public void setUp(){
        mano = new Mano();
    }
    @Test
    public void Test1AgregarCartaIncrementaCantidadDeEspada(){
        carta = new Carta(7,new Espada());
        mano.agregar(carta);
        Assert.assertEquals(mano.getCantidadEspada(),1);
    }
    @Test
    public void Test2AgregarCartaIncrementaCantidadDeCopa(){
        carta = new Carta(7,new Copa());
        mano.agregar(carta);
        Assert.assertEquals(mano.getCantidadCopa(),1);
    }
    @Test
    public void Test3AgregarCartaIncrementaCantidadDeBasto(){
        carta = new Carta(7,new Basto());
        mano.agregar(carta);
        Assert.assertEquals(mano.getCantidadBasto(),1);
    }
    @Test
    public void Test4AgregarCartaIncrementaCantidadDeOro(){
        carta = new Carta(7,new Oro());
        mano.agregar(carta);
        Assert.assertEquals(mano.getCantidadOro(),1);
    }
}
