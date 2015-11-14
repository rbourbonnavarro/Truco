package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.JuegoSinFlor;
import fiuba.algo3.truco.modelo.Mano;
import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


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
    @Test
    public void Test5AlAgregar3CartasLaManoInstanciaElEnvidoDelPaloCorrespondiente(){
        Carta carta1 = new Carta (3, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(carta1 , carta2, carta3, new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),30);
    }

}
