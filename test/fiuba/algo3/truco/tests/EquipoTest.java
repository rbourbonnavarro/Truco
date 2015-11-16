package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquipoTest {

    private Equipo equipo;
    private List<Jugador> jugadores;

    @Before
    public void setUp() {

        this.jugadores = new ArrayList<>(Arrays.asList(new Jugador("J1"), new Jugador("J2")));

        this.equipo = new Equipo("Equipo 1", this.jugadores);

    }

    @Test
    public void equipoDevuelveJugadorActualCorrectamente() {

        Assert.assertEquals(this.jugadores.get(0), this.equipo.getJugadorActual());

    }

    @Test
    public void equipoDevuelveJugadorActualCorrectamenteLuegoDeTerminarJugada() {

        this.equipo.terminarJugada();

        Assert.assertEquals(this.jugadores.get(1), this.equipo.getJugadorActual());

        this.equipo.terminarJugada();

        Assert.assertEquals(this.jugadores.get(0), this.equipo.getJugadorActual());

    }


}
