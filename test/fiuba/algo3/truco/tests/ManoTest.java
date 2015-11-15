package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.JuegoSinFlor;
import fiuba.algo3.truco.modelo.Mano;
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
        Assert.assertEquals(mano.getCantidadEspada(),2);
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
    public void Test5AlAgregar3CartasLaManoCalculaElEnvido(){
        Carta carta1 = new Carta (3, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),30);
    }
    @Test
    public void Test6SiTengo2FigurasElEnvidoDevuelve20(){
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (10, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),20);
    }
    @Test
    public void Test7SiTengoTresCartasDeDistintoPaloDevuelvoLaDeMayorValor(){
        Carta carta1 = new Carta (3, new Copa());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),7);
    }
    @Test
    public void Test8SiTengo1FiguraYOtraDelMismoPaloElEnvidoDevuelveValorCorrecto(){
        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3), new JuegoSinFlor());
        Assert.assertEquals(mano.envido(),27);
    }

}
