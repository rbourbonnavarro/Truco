package fiuba.algo3.truco.modelo.Jugadas.Envido;

import fiuba.algo3.truco.modelo.Carta;

import java.util.List;

public class CalculadorTanto {

    public int envido(List<Carta> cartas) throws CantasteEnvidoCuandoTenesFlorException {

        int envido1 = cartas.get(0).sumarParaEnvido(cartas.get(1));
        int envido2 = cartas.get(1).sumarParaEnvido(cartas.get(2));
        int envido3 = cartas.get(2).sumarParaEnvido(cartas.get(0));

        return Math.max(Math.max(envido1, envido2), envido3);

    }

    public int flor(List<Carta> cartas) {

        if(!this.hayFlor(cartas)) return 0;

        int flor = 0;
        for(Carta carta: cartas)
            flor += carta.getTanto();
        return flor +20;

    }

    private boolean hayFlor(List<Carta> cartas) {

        return ((cartas.get(0).getPalo().equals(cartas.get(1).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(1).getPalo())));

    }


}
