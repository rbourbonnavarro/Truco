package fiuba.algo3.truco.modelo;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;
import fiuba.algo3.truco.modelo.EnvidoYFlor.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoSinFlor;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.EnvidoYFlor.JugadorNoPuedeCantarTantoNoEsPrimeraRonda;

public class Mano {

    private List<Carta> cartasRecibidas;
    private List<Carta> cartasEnMano;
    private int cantidadEspada;
    private int cantidadBasto;
    private int cantidadCopa;
    private int cantidadOro;
    private CalculadorTanto calculadorTanto;

    public Mano(List<Carta> cartas, CalculadorTanto calculadorTanto) {

        this.cartasRecibidas = new LinkedList<>(cartas);
        this.cartasEnMano = new LinkedList<>(cartas);

        for(Carta carta : this.cartasRecibidas) {

            carta.getPalo().agregarA(this);
        }

        this.calculadorTanto = calculadorTanto;

    }

    public Mano() {
        this.cartasRecibidas = new LinkedList<>();
        calculadorTanto = new JuegoSinFlor();
        cantidadEspada = 0;
        cantidadBasto = 0;
        cantidadOro = 0;
        cantidadCopa = 0;
    }
/*
    public Mano(Carta carta1, Carta carta2, Carta carta3) {
        this.cartasRecibidas = new LinkedList<>();
        cantidadEspada = 0;
        cantidadBasto = 0;
        cantidadOro = 0;
        cantidadCopa = 0;
        this.agregar(carta1);
        this.agregar(carta2);
        this.agregar(carta3);
    }*/

    public int flor() throws JuegoSinFlorException {

        if(this.cartasEnMano.size() < 3) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();

        return this.calculadorTanto.flor(this.cartasEnMano);

    }

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        if(this.cartasEnMano.size() < 3) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();

        return this.calculadorTanto.envido(this.cartasEnMano);

    }


    public int getCantidadEspada() {
        return this.cantidadEspada;
    }

    public void incrementarEspada() {
        this.cantidadEspada++;
    }

    public void incrementarCopa() {
        this.cantidadCopa++;
    }

    public void incrementarOro() {
        this.cantidadOro++;
    }

    public void incrementarBasto() {
        this.cantidadBasto++;
    }

    public int getCantidadCopa() {
        return this.cantidadCopa;
    }
    public int getCantidadOro() {
        return this.cantidadOro;
    }
    public int getCantidadBasto() {
        return this.cantidadBasto;
    }


    public List<Carta> getCartas() {

        return this.cartasEnMano;

    }

    public void jugar(Carta carta) {

        this.cartasEnMano.remove(carta);

    }


}
