package fiuba.algo3.truco.tests.Palo;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Palo.*;

import org.junit.Assert;
import org.junit.Test;

public class PalosTest {

    @Test
    public void Test1bastoSeConvierteCorrectamenteACadena() {

        Palo palo = new Basto();

        Assert.assertEquals("Basto", palo.toString());

    }

    @Test
    public void Test2copaSeConvierteCorrectamenteACadena() {

        Palo palo = new Copa();

        Assert.assertEquals("Copa", palo.toString());

    }

    @Test
    public void Test3espadaSeConvierteCorrectamenteACadena() {

        Palo palo = new Espada();

        Assert.assertEquals("Espada", palo.toString());

    }

    @Test
    public void Test4oroSeConvierteCorrectamenteACadena() {

        Palo palo = new Oro();

        Assert.assertEquals("Oro", palo.toString());

    }
    @Test
    public void Test5OroDevuelve20MasElEnteroRecibidoCuandoSeLlamaATantoOroYCeroEnLosDemas() {
        Palo palo = new Oro();
        Assert.assertEquals(palo.tantoBasto(1),0);
        Assert.assertEquals(palo.tantoEspada(1),0);
        Assert.assertEquals(palo.tantoCopa(1),0);
        Assert.assertEquals(palo.tantoOro(1),21);
    }
    @Test
    public void Test6EspadaDevuelve20MasElEnteroRecibidoCuandoSeLlamaATantoOroYCeroEnLosDemas() {
        Palo palo = new Espada();
        Assert.assertEquals(palo.tantoBasto(5),0);
        Assert.assertEquals(palo.tantoEspada(7),27);
        Assert.assertEquals(palo.tantoCopa(1),0);
        Assert.assertEquals(palo.tantoOro(1),0);
    }
    @Test
    public void Test7BastoDevuelve20MasElEnteroRecibidoCuandoSeLlamaATantoOroYCeroEnLosDemas() {
        Palo palo = new Basto();
        Assert.assertEquals(palo.tantoBasto(4),24);
        Assert.assertEquals(palo.tantoEspada(1),0);
        Assert.assertEquals(palo.tantoCopa(1),0);
        Assert.assertEquals(palo.tantoOro(1),0);
    }
    @Test
    public void Test8CopaDevuelve20MasElEnteroRecibidoCuandoSeLlamaATantoOroYCeroEnLosDemas() {
        Palo palo = new Copa();
        Assert.assertEquals(palo.tantoBasto(1),0);
        Assert.assertEquals(palo.tantoEspada(1),0);
        Assert.assertEquals(palo.tantoCopa(7),27);
        Assert.assertEquals(palo.tantoOro(1),0);
    }
    
    @Test
    public void Test9Devuelve20MasElNumeroDeLaCartaCuandoSeLlamaAGetTanto(){
    	Palo palo = new Basto();
    	
    	Carta carta = new Carta(1, palo);
    	
    	Assert.assertEquals(palo.getTanto(carta), 21);
    	
    }

}
