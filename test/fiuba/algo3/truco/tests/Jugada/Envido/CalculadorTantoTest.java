package fiuba.algo3.truco.tests.Jugada.Envido;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Jugadas.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class CalculadorTantoTest {
    
    Carta carta1;
    Carta carta2;
    Carta carta3;
    List<Carta> cartas;
    
    CalculadorTanto calculadorTanto;

    @Before
    public void setUp(){

        cartas = new LinkedList<>();
        this.calculadorTanto = new CalculadorTanto();

    }

    @Test
    public void test1EnvidoDevuelve20SiHayDosFiguras() {

        carta1 = new Carta(7,new Espada());
        carta2 = new Figura(12,new Copa());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(this.calculadorTanto.envido(cartas), 20);
        
    }

    @Test
    public void test2EnvidoDevuelve25SiHayFiguraYUnCinco() {

        carta1 = new Carta(5,new Espada());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(this.calculadorTanto.envido(cartas),25);

    }

    @Test
    public void test3EnvidoDevuelveCartaMasAltaSiPalosDistintos() {

        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Espada());
        carta3 = new Figura(10,new Copa());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(this.calculadorTanto.envido(cartas),5);

    }

    @Test
    public void test5FlorDevuelveTanto() {

        carta1 = new Carta(5,new Oro());
        carta2 = new Figura(12,new Oro());
        carta3 = new Figura(10,new Oro());
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        Assert.assertEquals(this.calculadorTanto.flor(cartas),25);

    }


}

