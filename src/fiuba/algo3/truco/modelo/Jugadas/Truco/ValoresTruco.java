package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Carta;

import java.util.Dictionary;
import java.util.Hashtable;

public class ValoresTruco {

    private static final Dictionary<String, Integer> RANKINGTRUCO;

    static {

        RANKINGTRUCO = new Hashtable<>(40);

        RANKINGTRUCO.put("1Espada", 1);
        RANKINGTRUCO.put("1Basto", 2);
        RANKINGTRUCO.put("7Espada", 3);
        RANKINGTRUCO.put("7Oro", 4);
        RANKINGTRUCO.put("3Espada", 5);
        RANKINGTRUCO.put("3Basto", 5);
        RANKINGTRUCO.put("3Oro", 5);
        RANKINGTRUCO.put("3Copa", 5);
        RANKINGTRUCO.put("2Espada", 6);
        RANKINGTRUCO.put("2Basto", 6);
        RANKINGTRUCO.put("2Oro", 6);
        RANKINGTRUCO.put("2Copa", 6);
        RANKINGTRUCO.put("1Oro", 7);
        RANKINGTRUCO.put("1Copa", 7);
        RANKINGTRUCO.put("12Espada", 8);
        RANKINGTRUCO.put("12Basto", 8);
        RANKINGTRUCO.put("12Oro", 8);
        RANKINGTRUCO.put("12Copa", 8);
        RANKINGTRUCO.put("11Espada", 9);
        RANKINGTRUCO.put("11Basto", 9);
        RANKINGTRUCO.put("11Oro", 9);
        RANKINGTRUCO.put("11Copa", 9);
        RANKINGTRUCO.put("10Espada", 10);
        RANKINGTRUCO.put("10Basto", 10);
        RANKINGTRUCO.put("10Oro", 10);
        RANKINGTRUCO.put("10Copa", 10);
        RANKINGTRUCO.put("7Basto", 11);
        RANKINGTRUCO.put("7Copa", 11);
        RANKINGTRUCO.put("6Espada", 12);
        RANKINGTRUCO.put("6Basto", 12);
        RANKINGTRUCO.put("6Oro", 12);
        RANKINGTRUCO.put("6Copa", 12);
        RANKINGTRUCO.put("5Espada", 13);
        RANKINGTRUCO.put("5Basto", 13);
        RANKINGTRUCO.put("5Oro", 13);
        RANKINGTRUCO.put("5Copa", 13);
        RANKINGTRUCO.put("4Espada", 14);
        RANKINGTRUCO.put("4Basto", 14);
        RANKINGTRUCO.put("4Oro", 14);
        RANKINGTRUCO.put("4Copa", 14);

    }

    public ValoresTruco() {

        

    }

    public int rankingCarta(Carta carta) {

        return RANKINGTRUCO.get(carta.toString());

    }


}
