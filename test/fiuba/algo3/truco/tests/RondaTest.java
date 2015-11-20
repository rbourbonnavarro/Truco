package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Jugada.Truco.GanadorVuelta;
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

    @Test(expected = LaRondaNoTerminoAunException.class)
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeUnaJugada() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));

        this.ronda.terminar();

    }

    @Test(expected = LaRondaNoTerminoAunException.class)
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeDosJugadasGanadasPorDistintosEquipos() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo2, new Carta(3, new Espada())));

        this.ronda.terminar();

    }

    @Test
    public void rondaDeterminaCorrectamenteSiEsElFinalDeLaRondaLuegoDeDosJugadasGanadasPorElMismoEqupo() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(6, new Espada())));

        this.ronda.terminar();

        Assert.assertEquals(null, this.ronda.getEquipoGanador());

    }

    @Test
    public void rondaDeterminaCorrectamenteGanador() {

        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(7, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo2, new Carta(2, new Espada())));
        this.ronda.setGanadorVuelta(new GanadorVuelta(this.equipo1, new Carta(1, new Espada())));

        this.ronda.terminar();

        Assert.assertEquals(null, this.ronda.getEquipoGanador());

    }

    /*@Test
    public void test3RondaSumaPuntosAlEquipoGanador(){
        this.ronda.agregarPuntosRonda(new RetrucoCantado().puntos()+new EnvidoCantado().puntos());
        this.ronda.setEquipoGanador(equipo1);
        this.ronda.sumarPuntosEquipoGanador();

        Assert.assertEquals(5, equipo1.getPuntos());
    }*/


}
