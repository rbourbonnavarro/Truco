package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GomezPeter on 21/11/2015.
 */
public class PartidaCompletaTest {
    Mesa mesa;

    Jugador J1;
    Jugador J2;

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
    public void setUp(){

        J1 = new Jugador("J1");
        J2 = new Jugador("J2");

        jugadoresEquipo1 = new ArrayList<>(Arrays.asList(J1));
        jugadoresEquipo2 = new ArrayList<>(Arrays.asList(J2));

        equipo1 = new Equipo("Juan", jugadoresEquipo1);
        equipo2 = new Equipo("Pedro", jugadoresEquipo2);

        boolean seJuegaConFlor = true;

        cartasJ1 = new LinkedList<>(Arrays.asList(carta1,carta2,carta3));
        cartasJ2 = new LinkedList<>(Arrays.asList(carta4,carta5,carta6));

        mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

    }

    @Test
    public void partidaCompleta(){
        carta1 = new Carta(7,new Espada());
        carta2 = new Carta(3,new Espada());
        carta3 = new Carta(2, new Basto());

        carta4 = new Carta(1,new Espada());
        carta5 = new Carta(2,new Espada());
        carta6 = new Figura(12, new Basto());

        J1.setMano(new Mano(cartasJ1));
        J2.setMano(new Mano(cartasJ2));

        Assert.assertEquals(J1.getNombre(),mesa.getJugadorActual().getNombre());
        mesa.envido();
        Assert.assertEquals(J2.getNombre(),mesa.getJugadorActual().getNombre());
        mesa.envido();

    }
}
