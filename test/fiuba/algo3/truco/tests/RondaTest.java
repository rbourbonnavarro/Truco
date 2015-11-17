package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Ronda;
import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class RondaTest {

    private Ronda ronda = new Ronda();
    private Equipo equipo1;
    private Equipo equipo2;

    @Before
    public void setUp() {

        this.equipo1 = new Equipo("Equipo 1", Arrays.asList(new Jugador("J1")));
        this.equipo2 = new Equipo("Equipo 2", Arrays.asList(new Jugador("J2")));

    }

    @Test
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeUnaJugada() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));

        Assert.assertFalse(this.ronda.finalRonda());

    }

    @Test
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeDosJugadasGanadasPorDistintosEquipos() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo2, new Carta(3, new Espada())));

        Assert.assertFalse(this.ronda.finalRonda());

    }

    @Test
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeDosJugadasGanadasPorElMismoEqupo() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(6, new Espada())));

        Assert.assertTrue(this.ronda.finalRonda());

    }

    @Test
    public void rondaDeterminaCorrectamenteGanador() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo2, new Carta(2, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(1, new Espada())));

        Assert.assertTrue(this.ronda.finalRonda());

        Assert.assertEquals(this.equipo1, this.ronda.getEquipoGanador());

    }


}
