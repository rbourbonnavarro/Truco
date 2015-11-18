package fiuba.algo3.truco.modelo;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Envido.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraRonda;

public class Mano {

    private List<Carta> cartasEnMano;
    private CalculadorTanto calculadorTanto;

    public Mano(List<Carta> cartas, CalculadorTanto calculadorTanto) {

        this.cartasEnMano = new LinkedList<>(cartas);
        this.calculadorTanto = calculadorTanto;

    }


    public int flor() throws JuegoSinFlorException {

        if(this.cartasEnMano.size() < 3) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();

        return this.calculadorTanto.flor(this.cartasEnMano);

    }

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        if(this.cartasEnMano.size() < 3) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();

        return this.calculadorTanto.envido(this.cartasEnMano);

    }

    public List<Carta> getCartas() {

        return this.cartasEnMano;

    }

    public void jugar(Carta carta) {

        this.cartasEnMano.remove(carta);

    }


}
