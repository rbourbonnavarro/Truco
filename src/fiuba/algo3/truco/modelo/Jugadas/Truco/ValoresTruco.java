package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

import java.util.Dictionary;
import java.util.Hashtable;

public class ValoresTruco {

    private static final Dictionary<Carta, Integer> RANKINGTRUCO;

    static {

        RANKINGTRUCO = new Hashtable<>(40);

        RANKINGTRUCO.put(new Carta(1, new Espada()), 1);
        RANKINGTRUCO.put(new Carta(1, new Basto()), 2);
        RANKINGTRUCO.put(new Carta(7, new Espada()), 3);
        RANKINGTRUCO.put(new Carta(7, new Oro()), 4);
        RANKINGTRUCO.put(new Carta(3, new Espada()), 5);
        RANKINGTRUCO.put(new Carta(3, new Basto()), 5);
        RANKINGTRUCO.put(new Carta(3, new Oro()), 5);
        RANKINGTRUCO.put(new Carta(3, new Copa()), 5);
        RANKINGTRUCO.put(new Carta(2, new Espada()), 6);
        RANKINGTRUCO.put(new Carta(2, new Basto()), 6);
        RANKINGTRUCO.put(new Carta(2, new Oro()), 6);
        RANKINGTRUCO.put(new Carta(2, new Copa()), 6);
        RANKINGTRUCO.put(new Carta(1, new Oro()), 7);
        RANKINGTRUCO.put(new Carta(1, new Copa()), 7);
        RANKINGTRUCO.put(new Figura(12, new Espada()), 8);
        RANKINGTRUCO.put(new Figura(12, new Basto()), 8);
        RANKINGTRUCO.put(new Figura(12, new Oro()), 8);
        RANKINGTRUCO.put(new Figura(12, new Copa()), 8);
        RANKINGTRUCO.put(new Figura(11, new Espada()), 9);
        RANKINGTRUCO.put(new Figura(11, new Basto()), 9);
        RANKINGTRUCO.put(new Figura(11, new Oro()), 9);
        RANKINGTRUCO.put(new Figura(11, new Copa()), 9);
        RANKINGTRUCO.put(new Figura(10, new Espada()), 10);
        RANKINGTRUCO.put(new Figura(10, new Basto()), 10);
        RANKINGTRUCO.put(new Figura(10, new Oro()), 10);
        RANKINGTRUCO.put(new Figura(10, new Copa()), 10);
        RANKINGTRUCO.put(new Carta(7, new Basto()), 11);
        RANKINGTRUCO.put(new Carta(7, new Copa()), 11);
        RANKINGTRUCO.put(new Carta(6, new Espada()), 12);
        RANKINGTRUCO.put(new Carta(6, new Basto()), 12);
        RANKINGTRUCO.put(new Carta(6, new Oro()), 12);
        RANKINGTRUCO.put(new Carta(6, new Copa()), 12);
        RANKINGTRUCO.put(new Carta(5, new Espada()), 13);
        RANKINGTRUCO.put(new Carta(5, new Basto()), 13);
        RANKINGTRUCO.put(new Carta(5, new Oro()), 13);
        RANKINGTRUCO.put(new Carta(5, new Copa()), 13);
        RANKINGTRUCO.put(new Carta(4, new Espada()), 14);
        RANKINGTRUCO.put(new Carta(4, new Basto()), 14);
        RANKINGTRUCO.put(new Carta(4, new Oro()), 14);
        RANKINGTRUCO.put(new Carta(4, new Copa()), 14);

    }

    public int rankingCarta(Carta carta) {

        return RANKINGTRUCO.get(carta);

    }


}
