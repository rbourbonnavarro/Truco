package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class ContraFlorAlRestoCantada implements EstadoFlor {
    private int puntos;
    private int puntosNoQuerido;

    public ContraFlorAlRestoCantada(Puntaje puntaje, int puntos) {
        this.puntos = puntaje.faltaEnvido();
        this.puntosNoQuerido = puntos;
    }

    @Override
    public int puntos() {
        return this.puntos;
    }

    @Override
    public int noQuerido() {
        return this.puntosNoQuerido;
    }

    @Override
    public EstadoFlor flor() {
        throw new NoSePuedeCantarFlorException();
    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarContraFlorException();
    }

    @Override
    public EstadoFlor contraFlorAlPartido() {
        throw new NoSePuedeCantarContraFlorException();
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof ContraFlorAlRestoCantada;
    }

}
