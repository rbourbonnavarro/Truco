package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Carta;

import java.util.Dictionary;
import java.util.Hashtable;

public class ValoresTruco {

    Dictionary<String, Integer> rankingTruco;

    public ValoresTruco() {

        this.rankingTruco = new Hashtable<>(40);

        this.rankingTruco.put("1Espada", 1);
        this.rankingTruco.put("1Basto", 2);
        this.rankingTruco.put("7Espada", 3);
        this.rankingTruco.put("7Oro", 4);
        this.rankingTruco.put("3Espada", 5);
        this.rankingTruco.put("3Basto", 5);
        this.rankingTruco.put("3Oro", 5);
        this.rankingTruco.put("3Copa", 5);
        this.rankingTruco.put("2Espada", 6);
        this.rankingTruco.put("2Basto", 6);
        this.rankingTruco.put("2Oro", 6);
        this.rankingTruco.put("2Copa", 6);
        this.rankingTruco.put("1Oro", 7);
        this.rankingTruco.put("1Copa", 7);
        this.rankingTruco.put("12Espada", 8);
        this.rankingTruco.put("12Basto", 8);
        this.rankingTruco.put("12Oro", 8);
        this.rankingTruco.put("12Copa", 8);
        this.rankingTruco.put("11Espada", 9);
        this.rankingTruco.put("11Basto", 9);
        this.rankingTruco.put("11Oro", 9);
        this.rankingTruco.put("11Copa", 9);
        this.rankingTruco.put("10Espada", 10);
        this.rankingTruco.put("10Basto", 10);
        this.rankingTruco.put("10Oro", 10);
        this.rankingTruco.put("10Copa", 10);
        this.rankingTruco.put("7Basto", 11);
        this.rankingTruco.put("7Copa", 11);
        this.rankingTruco.put("6Espada", 12);
        this.rankingTruco.put("6Basto", 12);
        this.rankingTruco.put("6Oro", 12);
        this.rankingTruco.put("6Copa", 12);
        this.rankingTruco.put("5Espada", 13);
        this.rankingTruco.put("5Basto", 13);
        this.rankingTruco.put("5Oro", 13);
        this.rankingTruco.put("5Copa", 13);
        this.rankingTruco.put("4Espada", 14);
        this.rankingTruco.put("4Basto", 14);
        this.rankingTruco.put("4Oro", 14);
        this.rankingTruco.put("4Copa", 14);

    }

    public int rankingCarta(Carta carta) {

        return this.rankingTruco.get(carta.toString());

    }


}
