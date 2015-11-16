package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.EnvidoYFlor.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoConFlor;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoSinFlor;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ManoTest {

    Carta carta;
    Mano mano;
    @Test
    public void Test1AgregarCartaIncrementaCantidadDeEspada(){
        List<Carta> lista = new LinkedList<>();
        lista.add(new Carta(7,new Espada()));
        lista.add(new Carta(3,new Espada()));
        lista.add(new Carta(7,new Copa()));
        mano = new Mano(lista, new JuegoSinFlor());
        Assert.assertEquals(mano.getCantidadEspada(), 2);
    }
    @Test
    public void Test2AgregarCartaIncrementaCantidadDeCopa(){
        List<Carta> lista = new LinkedList<>();
        lista.add(new Carta(7,new Espada()));
        lista.add(new Carta(3,new Espada()));
        lista.add(new Carta(7,new Copa()));
        mano = new Mano(lista, new JuegoSinFlor());
        Assert.assertEquals(mano.getCantidadCopa(),1);
    }
    @Test
    public void Test3AgregarCartaIncrementaCantidadDeBasto(){
        List<Carta> lista = new LinkedList<>();
        lista.add(new Carta(7,new Basto()));
        lista.add(new Carta(3,new Basto()));
        lista.add(new Carta(7,new Copa()));
        mano = new Mano(lista, new JuegoSinFlor());
        Assert.assertEquals(mano.getCantidadBasto(),2);
    }
    @Test
    public void Test4AgregarCartaIncrementaCantidadDeOro(){
        List<Carta> lista = new LinkedList<>();
        lista.add(new Carta(7,new Espada()));
        lista.add(new Carta(3,new Espada()));
        lista.add(new Carta(7,new Oro()));
        mano = new Mano(lista, new JuegoSinFlor());
        Assert.assertEquals(mano.getCantidadOro(),1);
    }
    @Test
    public void Test5AlAgregar3CartasLaManoCalculaElEnvido() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Carta (3, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),30);
    }
    @Test
    public void Test6SiTengo2FigurasElEnvidoDevuelve20() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (10, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),20);
    }
    @Test
    public void Test7SiTengoTresCartasDeDistintoPaloDevuelvoLaDeMayorValor() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Carta (3, new Copa());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),7);
    }
    @Test
    public void Test8SiTengo1FiguraYOtraDelMismoPaloElEnvidoDevuelveValorCorrecto() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),27);
    }
    @Test (expected = CantasteEnvidoCuandoTenesFlorException.class)
    public void Test9TengoFlorSeJuegaConFlorYCantoEnvidoLanzaExcepcion() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoConFlor());
        mano.envido();
    }
    @Test
    public void Test10NoTengoFlorSeJuegaConFlorEntoncesEnvidoDevuelveElTanto() throws CantasteEnvidoCuandoTenesFlorException {
        Carta carta1 = new Carta(6, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoConFlor());
        Assert.assertEquals(mano.envido(),33);
    }
    @Test
    public void Test11FlorDevuelveElTanto() throws JuegoSinFlorException {
        Carta carta1 = new Carta(2, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoConFlor());
        Assert.assertEquals(mano.flor(),32);
    }
    @Test
    public void Test12FlorDevuelveElTantoCorrectoSiTengo1Figura() throws JuegoSinFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoConFlor());
        Assert.assertEquals(mano.flor(),30);
    }
    @Test
    public void Test13FlorDevuelve20SiTengo3Figuras() throws JuegoSinFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (11, new Espada());
        Carta carta3 = new Figura (10, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoConFlor());
        Assert.assertEquals(mano.flor(),20);
    }
    @Test(expected = JuegoSinFlorException.class)
    public void Test14FlorLanzaExcepcionSiSeJuegaSinFlor() throws JuegoSinFlorException {
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (11, new Espada());
        Carta carta3 = new Figura (10, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        mano.flor();
    }


}
