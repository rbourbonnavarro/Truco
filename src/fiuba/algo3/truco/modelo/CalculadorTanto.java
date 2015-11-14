package fiuba.algo3.truco.modelo;

import java.util.List;

public abstract class CalculadorTanto {

    public abstract int flor(List<Carta> cartas);

    public int envido(List<Carta> cartas) {

        int envido1 = this.calcularEnvido(cartas.get(1), cartas.get(2));
        int envido2 = this.calcularEnvido(cartas.get(2), cartas.get(0));
        int envido3 = this.calcularEnvido(cartas.get(1), cartas.get(0));

        return Math.max(Math.max(envido1, envido2), envido3);

    }

    public int calcularEnvido(Carta carta1, Carta carta2) {

        if(carta1.getPalo().equals(carta2.getPalo())) {

            int envido = carta1.envido() + carta2.envido();

            if(envido == 40) return 20;

            if(envido < 20) return envido + 20;

            return envido;

        }

        return 0;

    }


}