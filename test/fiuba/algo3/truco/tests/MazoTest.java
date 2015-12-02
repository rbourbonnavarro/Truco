package fiuba.algo3.truco.tests;

import com.sun.javaws.exceptions.InvalidArgumentException;
import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mazo;
import fiuba.algo3.truco.vista.DiccionarioCartas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        this.jugadores.add(new Jugador("J1"));
        this.jugadores.add(new Jugador("JIA"));

    }

    @Test
    public void mazoReparteCartasYSonTodasDiferentes() {

        this.mazo.repartir(this.jugadores);

        for(Carta cartaJ1 : this.jugadores.get(0).obtenerCartas()) {

            for(Carta cartaJ2 : this.jugadores.get(1).obtenerCartas()) {

                Assert.assertNotEquals(cartaJ1, cartaJ2);

            }

        }

    }

    Button boton1 = new Button();
    DiccionarioCartas diccionarioCartas = new DiccionarioCartas();

    @Test(expected = InvalidArgumentException.class)
    public void fasdf() {

        for(Carta carta : this.mazo.getCartas()) {

            boton1.setGraphic(new ImageView(diccionarioCartas.representacionCarta(carta)));

        }

    }



}
