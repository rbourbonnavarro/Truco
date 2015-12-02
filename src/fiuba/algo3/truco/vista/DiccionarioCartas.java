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

    private static final String RUTA_IMAGENES = "/gui/images/imagenesCartas";

    static {

        REPRESENTACION_CARTA = new Hashtable<>(40);

        REPRESENTACION_CARTA.put(new Carta(1, new Espada()), RUTA_IMAGENES + "/1Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(1, new Basto()), RUTA_IMAGENES + "/1Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(1, new Oro()), RUTA_IMAGENES + "/1Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(1, new Copa()), RUTA_IMAGENES + "/1Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(3, new Espada()), RUTA_IMAGENES + "/3Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(3, new Basto()), RUTA_IMAGENES + "/3Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(3, new Oro()), RUTA_IMAGENES + "/3Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(3, new Copa()), RUTA_IMAGENES + "/3Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(2, new Espada()), RUTA_IMAGENES + "/2Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(2, new Basto()), RUTA_IMAGENES + "/2Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(2, new Oro()), RUTA_IMAGENES + "/2Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(2, new Copa()), RUTA_IMAGENES + "/2Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(12, new Espada()), RUTA_IMAGENES + "/12Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(12, new Basto()), RUTA_IMAGENES + "/12Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(12, new Oro()), RUTA_IMAGENES + "/12Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(12, new Copa()), RUTA_IMAGENES + "/12Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(11, new Espada()), RUTA_IMAGENES + "/11Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(11, new Basto()), RUTA_IMAGENES + "/11Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(11, new Oro()), RUTA_IMAGENES + "/11Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(11, new Copa()), RUTA_IMAGENES + "/11Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(10, new Espada()), RUTA_IMAGENES + "/10Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(10, new Basto()), RUTA_IMAGENES + "/10Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(10, new Oro()), RUTA_IMAGENES + "/10Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Figura(10, new Copa()), RUTA_IMAGENES + "/10Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(7, new Espada()), RUTA_IMAGENES + "/7Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(7, new Basto()), RUTA_IMAGENES + "/7Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(7, new Oro()), RUTA_IMAGENES + "/7Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(7, new Copa()), RUTA_IMAGENES + "/7Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(6, new Espada()), RUTA_IMAGENES + "/6Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(6, new Basto()), RUTA_IMAGENES + "/6Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(6, new Oro()), RUTA_IMAGENES + "/6Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(6, new Copa()), RUTA_IMAGENES + "/6Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(5, new Espada()), RUTA_IMAGENES + "/5Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(5, new Basto()), RUTA_IMAGENES + "/5Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(5, new Oro()), RUTA_IMAGENES + "/5Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(5, new Copa()), RUTA_IMAGENES + "/5Copa (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(4, new Espada()), RUTA_IMAGENES + "/4Espada (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(4, new Basto()), RUTA_IMAGENES + "/4Basto (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(4, new Oro()), RUTA_IMAGENES + "/4Oro (Custom).png");
        REPRESENTACION_CARTA.put(new Carta(4, new Copa()), RUTA_IMAGENES + "/4Copa (Custom).png");

    }

    public String representacionCarta(Carta carta) {

        return REPRESENTACION_CARTA.get(carta);

    }


}
