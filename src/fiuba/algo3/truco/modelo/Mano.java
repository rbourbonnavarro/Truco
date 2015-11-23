package fiuba.algo3.truco.modelo;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.Jugadas.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Jugadas.Envido.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;

public class Mano {

    private List<Carta> cartasEnMano;
    private List<Carta> cartasIniciales;
    private CalculadorTanto calculadorTanto;

    public Mano(List<Carta> cartas) {

        this.cartasEnMano = new LinkedList<>(cartas);
        this.cartasIniciales = new LinkedList<>(cartas);
        this.calculadorTanto = new CalculadorTanto();

    }


    public int flor() throws JuegoSinFlorException {

        return this.calculadorTanto.flor(this.cartasIniciales);

    }

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        return this.calculadorTanto.envido(this.cartasIniciales);

    }

    public List<Carta> getCartas() {

        return this.cartasIniciales;

    }

    public List<Carta> getCartasEnMano() {

        return this.cartasEnMano;

    }

    public void jugar(Carta carta) {

        this.cartasEnMano.remove(carta);

    }


}
