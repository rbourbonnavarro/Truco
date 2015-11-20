package fiuba.algo3.truco.tests.Truco;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;
import fiuba.algo3.truco.modelo.Truco.Parda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GanadorVueltaTest {
    List<Jugador> lista;
    Equipo equipo1;
    Carta carta;
    GanadorVuelta ganador;

    @Before
    public void setUp(){
        lista = new LinkedList<>();
        lista.add(new Jugador("carlos"));
        equipo1 = new Equipo("algo3", lista);
        carta = new Carta(3,new Espada());
        ganador = new GanadorVuelta(equipo1,carta);
    }
    @Test
    public void test1GetCartaDevuelveCarta(){
        Assert.assertEquals(ganador.getCarta(),carta);
    }
    @Test
    public void test2GetEquipoDevuelveEquipoGanador(){
        Assert.assertEquals(ganador.getEquipoGanador(),equipo1);
    }
    @Test
    public void test3PardaDevuelveNullEnEquipoGanador(){
        ganador = new Parda(carta);
        Assert.assertEquals(ganador.getEquipoGanador(),null);
    }
}
