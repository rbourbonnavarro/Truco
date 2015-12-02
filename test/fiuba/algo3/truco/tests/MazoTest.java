package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mazo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MazoTest {

    private Mazo mazo = new Mazo();
    private List<Jugador> jugadores;

    @Before
    public void setUp() {

        this.jugadores = new ArrayList<>();

        for(int i = 0; i < 13; i++) {

            this.jugadores.add(new Jugador("Jugador " + i));

        }

    }

    @Test
    public void mazoReparteCartasYSonTodasDiferentes() {

        this.mazo.repartir(this.jugadores);

        for(int i = 0; i < this.jugadores.size() - 1; i++) {

            for (Carta cartaJ1 : this.jugadores.get(i).obtenerCartas()) {

                for (Carta cartaJ2 : this.jugadores.get(i + 1).obtenerCartas()) {

                    Assert.assertNotEquals(cartaJ1, cartaJ2);

                }

            }

        }


    }



}
