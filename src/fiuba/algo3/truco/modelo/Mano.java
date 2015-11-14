package fiuba.algo3.truco.modelo;

import java.util.LinkedList;
import java.util.List;

public class Mano {

    private List<Carta> cartas;
    private int cantidadEspada;
    private int cantidadBasto;
    private int cantidadCopa;
    private int cantidadOro;
    private CalculadorTanto calculadorTanto;

    public Mano(Carta carta1, Carta carta2, Carta carta3, CalculadorTanto calculadorTanto) {
        this.cartas = new LinkedList<>();
        this.agregar(carta1);
        this.agregar(carta2);
        this.agregar(carta3);
        this.calculadorTanto = calculadorTanto;

    }

    public Mano() {
        this.cartas = new LinkedList<>();
        calculadorTanto = new JuegoSinFlor();
        cantidadEspada = 0;
        cantidadBasto = 0;
        cantidadOro = 0;
        cantidadCopa = 0;
    }

    public Mano(Carta carta1, Carta carta2, Carta carta3) {
        this.cartas = new LinkedList<>();
        cantidadEspada = 0;
        cantidadBasto = 0;
        cantidadOro = 0;
        cantidadCopa = 0;
        this.agregar(carta1);
        this.agregar(carta2);
        this.agregar(carta3);
    }

    public int flor() {

        return this.calculadorTanto.flor(cartas);

    }

    public int envido() {

        return this.calculadorTanto.envido(cartas);

    }


    public int getCantidadEspada() {
        return cantidadEspada;
    }

    public void incrementarEspada() {
        cantidadEspada++;
    }

    public void incrementarCopa() {
        cantidadCopa++;
    }

    public void incrementarOro() {
        cantidadOro++;
    }

    public void incrementarBasto() {
        cantidadBasto++;
    }

    public int getCantidadCopa() {
        return cantidadCopa;
    }
    public int getCantidadOro() {
        return cantidadOro;
    }
    public int getCantidadBasto() {
        return cantidadBasto;
    }

    public void agregar(Carta carta) {
        cartas.add(carta);
        carta.getPalo().agregarA(this);
    }
}
