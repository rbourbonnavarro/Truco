package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JugadasConIA {

    Mesa mesa;

    Jugador J1;
    JugadorIA JIA;

    List<Jugador> jugadoresEquipo1;
    List<Jugador> jugadoresEquipo2;

    Equipo equipo1;
    Equipo equipo2;

    LinkedList<Carta> cartasJ1;
    LinkedList<Carta> cartasJ2;

    Carta carta1;
    Carta carta2;
    Carta carta3;
    Carta carta4;
    Carta carta5;
    Carta carta6;

    @Before
    public void setUp() {

        J1 = new Jugador("J1");
        JIA = new JugadorIA("JIA");

        jugadoresEquipo1 = new ArrayList<>(Arrays.asList(J1));
        jugadoresEquipo2 = new ArrayList<>(Arrays.asList(JIA));

        equipo1 = new Equipo("equipo1", jugadoresEquipo1);
        equipo2 = new Equipo("equipo2", jugadoresEquipo2);

        boolean seJuegaConFlor = true;

        mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

        JIA.setMesa(mesa);

    }

    @Test
    public void jugadorIACantaEnvidoTeniendo25() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(3, new Espada());
        carta5 = new Carta(2, new Espada());
        carta6 = new Figura(12, new Basto());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 2);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIACantaRealEnvidoTeniendo31() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(6, new Espada());
        carta5 = new Carta(5, new Espada());
        carta6 = new Figura(12, new Basto());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 0);
        Assert.assertEquals(equipo2.getPuntos(), 3);

    }

    @Test
    public void jugadorIACantaFaltaEnvidoTeniendo33() {

        try {

            carta1 = new Carta(3, new Espada());

            carta2 = new Carta(1, new Espada());
            carta3 = new Carta(2, new Basto());

            carta4 = new Carta(6, new Espada());
            carta5 = new Carta(7, new Espada());
            carta6 = new Figura(12, new Basto());

            cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
            cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

            J1.setMano(new Mano(cartasJ1));
            JIA.setMano(new Mano(cartasJ2));

            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.hacerJugada(carta1);
            Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
            JIA.turno();
            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.quieroEnvido();

            Assert.assertEquals(equipo1.getPuntos(), 0);
            Assert.assertEquals(equipo2.getPuntos(), 30);

        } catch(JuegoTerminadoException juegoTerminadoException) {

            Assert.assertEquals(equipo2, mesa.getEquipoGanador());

        }

    }

    @Test
    public void jugadorIACantaFlorTeniendo() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(6, new Espada());
        carta5 = new Carta(5, new Espada());
        carta6 = new Figura(12, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroFlor();

        Assert.assertEquals(equipo1.getPuntos(), 0);
        Assert.assertEquals(equipo2.getPuntos(), 3);

    }

    @Test
    public void jugadorIANoTieneDecisionYJuegaCartaMasAlta() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(2, new Espada());
        carta5 = new Carta(4, new Basto());
        carta6 = new Figura(12, new Basto());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();

        Assert.assertFalse(JIA.obtenerCartasEnMano().contains(carta4));

    }

    @Test
    public void jugadorIAAceptaFlorCuandoNoTiene() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Espada());

        carta4 = new Carta(6, new Basto());
        carta5 = new Carta(5, new Espada());
        carta6 = new Figura(12, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.flor();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();

        Assert.assertEquals(equipo1.getPuntos(), 3);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIARespondeFlorConFlorCantadaCuandoTiene31() {

        carta1 = new Carta(7, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Espada());

        carta4 = new Carta(6, new Espada());
        carta5 = new Carta(5, new Espada());
        carta6 = new Figura(12, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.flor();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroFlor();

        Assert.assertEquals(equipo1.getPuntos(), 0);
        Assert.assertEquals(equipo2.getPuntos(), 6);

    }

    @Test
    public void jugadorIARespondeContraFlorAlRestoConFlorCantadaCuandoTiene33() {

        try {

            carta1 = new Carta(5, new Espada());
            carta2 = new Carta(1, new Espada());
            carta3 = new Carta(2, new Espada());

            carta4 = new Carta(6, new Espada());
            carta5 = new Carta(7, new Espada());
            carta6 = new Figura(12, new Espada());

            cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
            cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

            J1.setMano(new Mano(cartasJ1));
            JIA.setMano(new Mano(cartasJ2));

            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.flor();
            Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
            JIA.turno();
            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.quieroFlor();

        } catch (JuegoTerminadoException juegoTerminadoException) {

            Assert.assertEquals(equipo1.getPuntos(), 0);
            Assert.assertEquals(equipo2.getPuntos(), 30);
            Assert.assertEquals(equipo2, mesa.getEquipoGanador());

        }

    }

    @Test
    public void jugadorIARespondeContraFlorAlPartidoConFlorCantadaCuandoTiene36() {

        try {

            carta1 = new Carta(5, new Espada());
            carta2 = new Carta(1, new Espada());
            carta3 = new Carta(2, new Espada());

            carta4 = new Carta(6, new Espada());
            carta5 = new Carta(7, new Espada());
            carta6 = new Carta(3, new Espada());

            cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
            cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

            J1.setMano(new Mano(cartasJ1));
            JIA.setMano(new Mano(cartasJ2));

            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.flor();
            Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
            JIA.turno();
            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.quieroFlor();

        } catch (JuegoTerminadoException juegoTerminadoException) {

            Assert.assertEquals(equipo1.getPuntos(), 0);
            Assert.assertEquals(equipo2.getPuntos(), 30);
            Assert.assertEquals(equipo2, mesa.getEquipoGanador());

        }

    }

    @Test
    public void jugadorIACantaEnvidoCuandoTiene25() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(6, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(1, new Basto());
        carta5 = new Carta(3, new Espada());
        carta6 = new Carta(2, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 2);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIACantaRealEnvidoCuandoTiene30() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(6, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(1, new Basto());
        carta5 = new Carta(3, new Espada());
        carta6 = new Carta(7, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.hacerJugada(carta1);
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 3);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIACantaFaltaEnvidoConCuandoTiene33() {

        try {

            carta1 = new Carta(4, new Espada());
            carta2 = new Carta(6, new Espada());
            carta3 = new Carta(2, new Basto());

            carta4 = new Carta(1, new Basto());
            carta5 = new Carta(3, new Espada());
            carta6 = new Carta(7, new Espada());

            cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
            cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

            J1.setMano(new Mano(cartasJ1));
            JIA.setMano(new Mano(cartasJ2));

            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.hacerJugada(carta1);
            Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
            JIA.turno();
            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.quieroEnvido();

            Assert.assertEquals(equipo1.getPuntos(), 3);
            Assert.assertEquals(equipo2.getPuntos(), 0);

        } catch (JuegoTerminadoException juegoTerminadoException) {

            Assert.assertEquals(equipo1.getPuntos(), 30);
            Assert.assertEquals(equipo2.getPuntos(), 0);
            Assert.assertEquals(equipo1, mesa.getEquipoGanador());

        }

    }

    @Test
    public void jugadorIANoQuiereEnvidoConEnvidoCantadoCuandoTiene24() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(6, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(1, new Basto());
        carta5 = new Carta(3, new Espada());
        carta6 = new Carta(1, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.envido();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();

        Assert.assertEquals(equipo1.getPuntos(), 1);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIAQuiereEnvidoConEnvidoCantadoCuandoTiene25() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(6, new Basto());
        carta5 = new Carta(2, new Espada());
        carta6 = new Carta(3, new Espada());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.envido();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();

        Assert.assertEquals(equipo1.getPuntos(), 2);
        Assert.assertEquals(equipo2.getPuntos(), 0);

    }

    @Test
    public void jugadorIARespondeEnvidoConEnvidoCantadoCuandoTiene28() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(6, new Espada());
        carta5 = new Carta(2, new Espada());
        carta6 = new Carta(3, new Basto());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.envido();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 0);
        Assert.assertEquals(equipo2.getPuntos(), 4);

    }

    @Test
    public void jugadorIARespondeRealEnvidoConEnvidoCantadoCuandoTiene30() {

        carta1 = new Carta(5, new Espada());
        carta2 = new Carta(1, new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(6, new Espada());
        carta5 = new Carta(4, new Espada());
        carta6 = new Carta(3, new Basto());

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

        J1.setMano(new Mano(cartasJ1));
        JIA.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.envido();
        Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
        JIA.turno();
        Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
        mesa.quieroEnvido();

        Assert.assertEquals(equipo1.getPuntos(), 0);
        Assert.assertEquals(equipo2.getPuntos(), 5);

    }

    @Test
    public void jugadorIARespondeFaltaEnvidoConEnvidoCantadoCuandoTiene33() {

        try {

            carta1 = new Carta(5, new Espada());
            carta2 = new Carta(1, new Espada());
            carta3 = new Carta(2, new Basto());

            carta4 = new Carta(6, new Espada());
            carta5 = new Carta(7, new Espada());
            carta6 = new Carta(3, new Basto());

            cartasJ1 = new LinkedList<>(Arrays.asList(carta1, carta2, carta3));
            cartasJ2 = new LinkedList<>(Arrays.asList(carta4, carta5, carta6));

            J1.setMano(new Mano(cartasJ1));
            JIA.setMano(new Mano(cartasJ2));

            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.envido();
            Assert.assertEquals(JIA.getNombre(), mesa.getJugadorActual().getNombre());
            JIA.turno();
            Assert.assertEquals(J1.getNombre(), mesa.getJugadorActual().getNombre());
            mesa.quieroEnvido();

        } catch (JuegoTerminadoException juegoTerminadoException) {

            Assert.assertEquals(equipo1.getPuntos(), 0);
            Assert.assertEquals(equipo2.getPuntos(), 30);
            Assert.assertEquals(equipo2, mesa.getEquipoGanador());

        }

    }


}
