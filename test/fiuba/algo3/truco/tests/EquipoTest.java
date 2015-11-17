package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.EquipoSinIntegrantesException;
import fiuba.algo3.truco.modelo.Jugador;

import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Malas;
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
    public void test1EquipoDevuelveJugadorActualCorrectamente() {

        Assert.assertEquals(this.jugadores.get(0), this.equipo.getJugadorActual());

    }

    @Test
    public void test2EquipoDevuelveJugadorActualCorrectamenteLuegoDeTerminarJugada() {

        this.equipo.terminarJugada();

        Assert.assertEquals(this.jugadores.get(1), this.equipo.getJugadorActual());

        this.equipo.terminarJugada();

        Assert.assertEquals(this.jugadores.get(0), this.equipo.getJugadorActual());
    }

    @Test(expected = EquipoSinIntegrantesException.class)
    public void test3CrearEquipoVacioLanzaExcepcion(){
        equipo = new Equipo("equipo1",new ArrayList<>());
    }
    @Test
    public void test4GetCantidadIntegrantesDevuelveCantidadIntegrantesEnEquipo(){
        Assert.assertEquals(2,this.equipo.getCantidadIntegrantes());
    }
    @Test
    public void test5AlComenzarElJuegoElPuntajeEs0DeLasMalas(){
        Assert.assertEquals(this.equipo.getPuntaje().getEstadoPuntaje(),new Malas());
    }
    @Test
    public void test6SumarPuntosIncrementaPuntosDelEquipo(){
        this.equipo.sumarPuntos(5);
        Assert.assertEquals(this.equipo.getPuntaje().getEstadoPuntaje(),new Malas());
        Assert.assertEquals(this.equipo.getPuntos(),5);
    }
    @Test
    public void test7SiSumoMasDe15ElEquipoTienePuntosDeBuenas(){
        this.equipo.sumarPuntos(20);
        Assert.assertEquals(this.equipo.getPuntaje().getEstadoPuntaje(),new Buenas());
        Assert.assertEquals(this.equipo.getPuntos(),20);
    }

}
