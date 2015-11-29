package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Figura;
import fiuba.algo3.truco.modelo.Palo.Basto;
import fiuba.algo3.truco.modelo.Palo.Copa;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Palo.Oro;

import java.util.Dictionary;
import java.util.Hashtable;

public class DiccionarioCartas {

    private static final Dictionary<Carta, String> REPRESENTACION_CARTA;

    static {

        REPRESENTACION_CARTA = new Hashtable<>(40);

        REPRESENTACION_CARTA.put(new Carta(1, new Espada()), "1 de Espada");
        REPRESENTACION_CARTA.put(new Carta(1, new Basto()), "1 de Basto");
        REPRESENTACION_CARTA.put(new Carta(7, new Espada()), "7 de Espada");
        REPRESENTACION_CARTA.put(new Carta(7, new Oro()), "7 de Oro");
        REPRESENTACION_CARTA.put(new Carta(3, new Espada()), "3 de Espada");
        REPRESENTACION_CARTA.put(new Carta(3, new Basto()), "3 de Basto");
        REPRESENTACION_CARTA.put(new Carta(3, new Oro()), "3 de Oro");
        REPRESENTACION_CARTA.put(new Carta(3, new Copa()), "3 de Copa");
        REPRESENTACION_CARTA.put(new Carta(2, new Espada()), "2 de Espada");
        REPRESENTACION_CARTA.put(new Carta(2, new Basto()), "2 de Basto");
        REPRESENTACION_CARTA.put(new Carta(2, new Oro()), "2 de Oro");
        REPRESENTACION_CARTA.put(new Carta(2, new Copa()), "2 de Copa");
        REPRESENTACION_CARTA.put(new Carta(1, new Oro()), "1 de Oro");
        REPRESENTACION_CARTA.put(new Carta(1, new Copa()), "1 de Copa");
        REPRESENTACION_CARTA.put(new Figura(12, new Espada()), "12 de Espada");
        REPRESENTACION_CARTA.put(new Figura(12, new Basto()), "12 de Basto");
        REPRESENTACION_CARTA.put(new Figura(12, new Oro()), "12 de Oro");
        REPRESENTACION_CARTA.put(new Figura(12, new Copa()), "12 de Oro");
        REPRESENTACION_CARTA.put(new Figura(11, new Espada()), "11 de Espada");
        REPRESENTACION_CARTA.put(new Figura(11, new Basto()), "11 de Basto");
        REPRESENTACION_CARTA.put(new Figura(11, new Oro()), "11 de Oro");
        REPRESENTACION_CARTA.put(new Figura(11, new Copa()), "11 de Copa");
        REPRESENTACION_CARTA.put(new Figura(10, new Espada()), "10 de Espada");
        REPRESENTACION_CARTA.put(new Figura(10, new Basto()), "10 de Basto");
        REPRESENTACION_CARTA.put(new Figura(10, new Oro()), "10 de Oro");
        REPRESENTACION_CARTA.put(new Figura(10, new Copa()), "10 de Copa");
        REPRESENTACION_CARTA.put(new Carta(7, new Basto()), "7 de Basto");
        REPRESENTACION_CARTA.put(new Carta(7, new Copa()), "7 de Copa");
        REPRESENTACION_CARTA.put(new Carta(6, new Espada()), "6 de Espada");
        REPRESENTACION_CARTA.put(new Carta(6, new Basto()), "6 de Basto");
        REPRESENTACION_CARTA.put(new Carta(6, new Oro()), "6 de Oro");
        REPRESENTACION_CARTA.put(new Carta(6, new Copa()), "6 de Copa");
        REPRESENTACION_CARTA.put(new Carta(5, new Espada()), "5 de Espada");
        REPRESENTACION_CARTA.put(new Carta(5, new Basto()), "5 de Basto");
        REPRESENTACION_CARTA.put(new Carta(5, new Oro()), "5 de Oro");
        REPRESENTACION_CARTA.put(new Carta(5, new Copa()), "5 de Copa");
        REPRESENTACION_CARTA.put(new Carta(4, new Espada()), "4 de Espada");
        REPRESENTACION_CARTA.put(new Carta(4, new Basto()), "4 de Basto");
        REPRESENTACION_CARTA.put(new Carta(4, new Oro()), "4 de Oro");
        REPRESENTACION_CARTA.put(new Carta(4, new Copa()), "4 de Copa");

    }

    public String representacionCarta(Carta carta) {

        return REPRESENTACION_CARTA.get(carta);

    }


}
