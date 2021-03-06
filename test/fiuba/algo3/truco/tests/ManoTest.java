package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Palo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class ManoTest {

    Mano mano;

    @Test
    public void Test5AlAgregar3CartasLaManoCalculaElEnvido() {

        Carta carta1 = new Carta (3, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.envido(),30);

    }

    @Test
    public void Test6SiTengo2FigurasElEnvidoDevuelve20() {

        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (10, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.envido(),20);

    }

    @Test
    public void Test7SiTengoTresCartasDeDistintoPaloDevuelvoLaDeMayorValor() {

        Carta carta1 = new Carta (3, new Copa());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.envido(),7);

    }

    @Test
    public void Test8SiTengo1FiguraYOtraDelMismoPaloElEnvidoDevuelveValorCorrecto() {

        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.envido(),27);

    }

    @Test
    public void Test10NoTengoFlorSeJuegaConFlorEntoncesEnvidoDevuelveElTanto() {

        Carta carta1 = new Carta(6, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Basto());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.envido(),33);

    }

    @Test
    public void Test11FlorDevuelveElTanto() {

        Carta carta1 = new Carta(2, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.flor(),32);

    }

    @Test
    public void Test12FlorDevuelveElTantoCorrectoSiTengo1Figura() {

        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Carta (7, new Espada());
        Carta carta3 = new Carta (3, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.flor(),30);

    }

    @Test
    public void Test13FlorDevuelve20SiTengo3Figuras() {

        Carta carta1 = new Figura(12, new Espada());
        Carta carta2 = new Figura (11, new Espada());
        Carta carta3 = new Figura (10, new Espada());
        mano = new Mano(Arrays.asList(carta1 , carta2, carta3));
        Assert.assertEquals(mano.flor(),20);

    }

}
