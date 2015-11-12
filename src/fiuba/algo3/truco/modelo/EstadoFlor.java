package fiuba.algo3.truco.modelo;

public abstract class EstadoFlor {

    public abstract int flor(Carta carta1, Carta carta2, Carta carta3);

    public int envido(Carta carta1, Carta carta2, Carta carta3) {

        int envido1 = this.calcularEnvido(carta1, carta2);
        int envido2 = this.calcularEnvido(carta2, carta3);
        int envido3 = this.calcularEnvido(carta1, carta3);

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
