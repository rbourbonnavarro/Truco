package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mazo {

    private static final List<Carta> CARTAS = new ArrayList<>(
            Arrays.asList(
                    new Carta(1, new Espada()),
                    new Carta(1, new Basto()),
                    new Carta(1, new Oro()),
                    new Carta(1, new Copa()),
                    new Carta(2, new Espada()),
                    new Carta(2, new Basto()),
                    new Carta(2, new Oro()),
                    new Carta(2, new Copa()),
                    new Carta(3, new Espada()),
                    new Carta(3, new Basto()),
                    new Carta(3, new Oro()),
                    new Carta(3, new Copa()),
                    new Carta(4, new Espada()),
                    new Carta(4, new Basto()),
                    new Carta(4, new Oro()),
                    new Carta(4, new Copa()),
                    new Carta(5, new Espada()),
                    new Carta(5, new Basto()),
                    new Carta(5, new Oro()),
                    new Carta(5, new Copa()),
                    new Carta(6, new Espada()),
                    new Carta(6, new Basto()),
                    new Carta(6, new Oro()),
                    new Carta(6, new Copa()),
                    new Carta(7, new Espada()),
                    new Carta(7, new Basto()),
                    new Carta(7, new Oro()),
                    new Carta(7, new Copa()),
                    new Figura(10, new Espada()),
                    new Figura(10, new Basto()),
                    new Figura(10, new Oro()),
                    new Figura(10, new Copa()),
                    new Figura(11, new Espada()),
                    new Figura(11, new Basto()),
                    new Figura(11, new Oro()),
                    new Figura(11, new Copa()),
                    new Figura(12, new Espada()),
                    new Figura(12, new Basto()),
                    new Figura(12, new Oro()),
                    new Figura(12, new Copa())
            )
    );

    public void repartir(List<Jugador> jugadores) {

        List<Carta> aux = new ArrayList<>(CARTAS);

        for(Jugador jugador : jugadores) {

            jugador.setMano(this.armarMano(aux));

        }

    }

    private Mano armarMano(List<Carta> aux) {

        List<Carta> cartasMano = new ArrayList<>();
        Random random = new Random();
        int limite = aux.size();

        for(int i = 0; i < 3; i++) {

            int posicionCarta = random.nextInt(limite);

            cartasMano.add(aux.get(posicionCarta));
            aux.remove(posicionCarta);
            limite -= 1;

        }

        return new Mano(cartasMano);

    }


}
