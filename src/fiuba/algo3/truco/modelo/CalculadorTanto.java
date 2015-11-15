package fiuba.algo3.truco.modelo;

import java.util.List;

public abstract class CalculadorTanto {

    public abstract int flor(List<Carta> cartas) throws JuegoSinFlorException;

    public int envido(List<Carta> cartas) throws CantasteEnvidoCuandoTenesFlorException {

        int envido1 = cartas.get(0).sumarParaEnvido(cartas.get(1));
        int envido2 = cartas.get(1).sumarParaEnvido(cartas.get(2));
        int envido3 = cartas.get(2).sumarParaEnvido(cartas.get(0));

        return Math.max(Math.max(envido1, envido2), envido3);

    }



}
