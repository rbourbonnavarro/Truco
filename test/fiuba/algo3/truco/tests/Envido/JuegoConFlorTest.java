package fiuba.algo3.truco.tests.Envido;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.JuegoConFlor;
import fiuba.algo3.truco.modelo.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class JuegoConFlorTest {
    Carta carta1;
    Carta carta2;
    Carta carta3;
    List<Carta> cartas;
    CalculadorTanto calculador;
    @Before
    public void setUp(){
        cartas = new LinkedList<>();
        calculador = new JuegoConFlor();
    }
    @Test
    public void test1EnvidoDevuelve20SiHayDosFiguras() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(7,new Espada());
        carta2 = new Figura(12,new Copa());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(calculador.envido(cartas), 20);
    }
    @Test
    public void test2EnvidoDevuelve25SiHayFiguraYUnCinco() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(5,new Espada());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(calculador.envido(cartas),25);
    }
    @Test
    public void test3EnvidoDevuelveCartaMasAltaSiPalosDistintos() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(calculador.envido(cartas),5);
    }
    @Test(expected = CantasteEnvidoCuandoTenesFlorException.class)
    public void test4EnvidoLanzaExcepcionSiHayFlor() throws CantasteEnvidoCuandoTenesFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Oro());
        carta3 = new Figura(10,new Oro());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        calculador.envido(cartas);
    }
    @Test
    public void test5FlorDevuelveTanto() throws CantasteEnvidoCuandoTenesFlorException, JuegoSinFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Oro());
        carta3 = new Figura(10,new Oro());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(calculador.flor(cartas),25);
    }
    @Test(expected = NoHayFlorException.class)
    public void test6FlorDevuelveTanto() throws NoHayFlorException, JuegoSinFlorException {
        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Oro());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        calculador.flor(cartas);
    }
}

