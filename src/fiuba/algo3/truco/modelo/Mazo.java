package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {

        this.cartas = new ArrayList<>();

        this.cartas.add(new Carta(1, new Espada()));
        this.cartas.add(new Carta(1, new Basto()));
        this.cartas.add(new Carta(1, new Oro()));
        this.cartas.add(new Carta(1, new Copa()));
        this.cartas.add(new Carta(2, new Espada()));
        this.cartas.add(new Carta(2, new Basto()));
        this.cartas.add(new Carta(2, new Oro()));
        this.cartas.add(new Carta(2, new Copa()));
        this.cartas.add(new Carta(3, new Espada()));
        this.cartas.add(new Carta(3, new Basto()));
        this.cartas.add(new Carta(3, new Oro()));
        this.cartas.add(new Carta(3, new Copa()));
        this.cartas.add(new Carta(4, new Espada()));
        this.cartas.add(new Carta(4, new Basto()));
        this.cartas.add(new Carta(4, new Oro()));
        this.cartas.add(new Carta(4, new Copa()));
        this.cartas.add(new Carta(5, new Espada()));
        this.cartas.add(new Carta(5, new Basto()));
        this.cartas.add(new Carta(5, new Oro()));
        this.cartas.add(new Carta(5, new Copa()));
        this.cartas.add(new Carta(6, new Espada()));
        this.cartas.add(new Carta(6, new Basto()));
        this.cartas.add(new Carta(6, new Oro()));
        this.cartas.add(new Carta(6, new Copa()));
        this.cartas.add(new Carta(7, new Espada()));
        this.cartas.add(new Carta(7, new Basto()));
        this.cartas.add(new Carta(7, new Oro()));
        this.cartas.add(new Carta(7, new Copa()));
        this.cartas.add(new Figura(10, new Espada()));
        this.cartas.add(new Figura(10, new Basto()));
        this.cartas.add(new Figura(10, new Oro()));
        this.cartas.add(new Figura(10, new Copa()));
        this.cartas.add(new Figura(11, new Espada()));
        this.cartas.add(new Figura(11, new Basto()));
        this.cartas.add(new Figura(11, new Oro()));
        this.cartas.add(new Figura(11, new Copa()));
        this.cartas.add(new Figura(12, new Espada()));
        this.cartas.add(new Figura(12, new Basto()));
        this.cartas.add(new Figura(12, new Oro()));
        this.cartas.add(new Figura(12, new Copa()));

    }

    public void repartir(List<Jugador> jugadores, CalculadorTanto calculadorTanto) {

        List<Carta> aux = new ArrayList<>(this.cartas);

        for(Jugador jugador : jugadores) {

            jugador.setMano(this.armarMano(aux, calculadorTanto));

        }

    }

    private Mano armarMano(List<Carta> aux, CalculadorTanto calculadorTanto) {

        List<Carta> cartasMano = new ArrayList<>();
        Random random = new Random();
        int limite = aux.size();

        for(int i = 0; i < 3; i++) {

            int posicionCarta = random.nextInt(limite);

            cartasMano.add(aux.get(posicionCarta));
            aux.remove(posicionCarta);

        }

        return new Mano(cartasMano, calculadorTanto);

    }


}
