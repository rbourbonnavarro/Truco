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

        int flor = 0;
        for(Carta carta: cartas)
            flor += carta.getTanto();
        return flor +20;

    }

    private boolean hayFlor(List<Carta> cartas) {

        return (cartas.get(0).getPalo().equals(cartas.get(1).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(1).getPalo()));

    }


}
