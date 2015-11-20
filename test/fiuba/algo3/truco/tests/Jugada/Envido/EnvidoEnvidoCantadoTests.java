package fiuba.algo3.truco.tests.Jugada.Envido;

import fiuba.algo3.truco.modelo.Jugada.Envido.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EnvidoEnvidoCantadoTests {

    EstadoEnvido envido;
    @Before
    public void setUp() {
        envido = new EnvidoEnvidoCantado();
    }
    @Test
    public void Test1PuntosDevuelve4(){
        Assert.assertEquals(envido.puntos(), 4);
    }
    @Test
    public void test2NoQueridoDevuelve2Puntos(){
        Assert.assertEquals(2,envido.noQuerido());
    }
    @Test (expected = NoSePuedeCantarEnvido.class)
    public void test3NoSePuedeCantarEnvido(){
        envido.envido();
    }
    @Test (expected = NoSePuedeCantarEnvidoEnvido.class)
    public void test4NoSePuedeCantarEnvidoEnvido(){
        envido.envidoEnvido();
    }
    @Test
    public void test5SePuedeCantarRealEnvido() {
        Assert.assertEquals(new RealEnvidoCantado(4),envido.realEnvido());
    }
    @Test
    public void test6SePuedeCantarFaltaEnvido() {
        Puntaje puntos = new Puntaje();
        puntos.sumar(15);
        Assert.assertEquals(envido.faltaEnvido(puntos),new FaltaEnvidoCantado(puntos));
    }
}
