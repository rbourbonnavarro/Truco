package fiuba.algo3.truco.modelo;

import java.util.List;

public class JuegoConFlor extends CalculadorTanto {

    @Override
    public int envido(List<Carta> cartas) throws CantasteEnvidoCuandoTenesFlorException {
        if(hayFlor(cartas)) throw new CantasteEnvidoCuandoTenesFlorException();
        return super.envido(cartas);
    }
    public int flor(List<Carta> cartas) {

        if(!this.hayFlor(cartas)) throw new NoHayFlorException();

        int flor = cartas.get(1).getTanto() + cartas.get(2).getTanto() + cartas.get(3).getTanto();

        if(flor == 60) return 20;

        if(flor > 40) return flor - 20;

        if(flor > 20) return flor;

        return flor + 20;

    }

    private boolean hayFlor(List<Carta> cartas) {

        return (cartas.get(0).getPalo().equals(cartas.get(1).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(1).getPalo()));

    }


}
