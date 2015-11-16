package fiuba.algo3.truco.tests.EnvidoYFlor;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by GomezPeter on 15/11/2015.
 */
public class JuegoSinFlorTest {

    Carta carta1;
    Carta carta2;
    Carta carta3;
    List<Carta> cartas;
    CalculadorTanto calculador;
    @Before
    public void setUp(){
        cartas = new LinkedList<>();
        calculador = new JuegoSinFlor();
    }
    @Test
    public void test1EnvidoDevuelve20SiHayDosFiguras() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(7,new Espada());
        carta2 = new Figura(12,new Copa());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(20, calculador.envido(cartas));
    }
    @Test
    public void test2EnvidoDevuelve25SiHayFiguraYUnCinco() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(5,new Espada());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(25, calculador.envido(cartas));
    }
    @Test
    public void test3EnvidoDevuelveCartaMasAltaSiPalosDistintos() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(5, calculador.envido(cartas));
    }
    @Test(expected = JuegoSinFlorException.class)
    public void test5FlorLanzaExcepcion() throws CantasteEnvidoCuandoTenesFlorException, JuegoSinFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Oro());
        carta3 = new Figura(10,new Oro());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        calculador.flor(cartas);
    }
}
