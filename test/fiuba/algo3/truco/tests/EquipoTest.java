package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;

import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Puntos.Buenas;
import fiuba.algo3.truco.modelo.Puntos.Malas;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EquipoTest {

    private Equipo equipo;
    private List<Jugador> jugadores;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp() {
        this.jugador1 = new Jugador("J1");
        this.jugador2 = new Jugador("J2");
        this.jugadores = new ArrayList<>(Arrays.asList(jugador1, jugador2));

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
    @Test
    public void test8calcularEnvidoDevuelveElEnvidoMasAltoDelEquipo(){
        Carta carta1 = new Carta(7,new Espada());
        Carta carta2 = new Carta(3,new Espada());
        Carta carta3 = new Carta(2,new Basto());

        Carta carta4 = new Carta(7,new Basto());
        Carta carta5 = new Carta(6,new Basto());
        Carta carta6 = new Carta(2,new Basto());

        LinkedList<Carta> cartas1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
        LinkedList<Carta> cartas2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));

        jugador1.setMano(new Mano(cartas1));
        jugador2.setMano(new Mano(cartas2));

        Assert.assertEquals(33,this.equipo.jugadorEnvidoMasAlto().envido());

    }

}
