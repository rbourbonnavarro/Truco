package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FaltaEnvidoCantado implements EstadoEnvido {

    private int puntos;
    private int puntosNoQuerido;

    public FaltaEnvidoCantado(Puntaje puntaje) {
        this.puntos = puntaje.faltaEnvido();
        this.puntosNoQuerido = 1;
    }
    public FaltaEnvidoCantado(Puntaje puntaje, int puntos ) {

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
    public EstadoEnvido envido() {
        throw new NoSePuedeCantarEnvido();
    }

    @Override
    public EstadoEnvido envidoEnvido() {
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoEnvido realEnvido() {
        throw new NoSePuedeCantarRealEnvido();
    }

    @Override
    public EstadoEnvido faltaEnvido(Puntaje puntos) {
        throw new NoSePuedeCantarFaltaEnvido();
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof FaltaEnvidoCantado;
    }

}
