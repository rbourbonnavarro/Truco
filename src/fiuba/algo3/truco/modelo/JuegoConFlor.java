package fiuba.algo3.truco.modelo;

import java.util.List;

public class JuegoConFlor extends CalculadorTanto {

    public int flor(List<Carta> cartas) {

        if(!this.hayFlor(cartas)) throw new NoHayFlorException();

        int flor = cartas.get(1).envido() + cartas.get(2).envido() + cartas.get(3).envido();

        if(flor == 60) return 20;

        if(flor > 40) return flor - 20;

        if(flor > 20) return flor;

        return flor + 20;

    }

    private boolean hayFlor(List<Carta> cartas) {

        return (cartas.get(1).getPalo().equals(cartas.get(2).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(3).getPalo()));

    }


}
