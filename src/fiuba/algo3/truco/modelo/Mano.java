package fiuba.algo3.truco.modelo;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.Jugada.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Jugada.Envido.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugada.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraRonda;

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

        if(this.cartasEnMano.size() < 3) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();

        return this.calculadorTanto.flor(this.cartasEnMano);

    }

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        return this.calculadorTanto.envido(this.cartasIniciales);

    }

    public List<Carta> getCartas() {

        return this.cartasEnMano;

    }

    public void jugar(Carta carta) {

        this.cartasEnMano.remove(carta);

    }


}
