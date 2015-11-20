package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FaltaEnvidoCantado implements EstadoJuego {

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

    public int puntos() {

        return this.puntos;

    }

    public int noQuerido() {

        return this.puntosNoQuerido;

    }

    @Override
    public EstadoJuego truco() {
        return null;
    }

    @Override
    public EstadoJuego reTruco() {
        return null;
    }

    @Override
    public EstadoJuego valeCuatro() {
        return null;
    }

    @Override
    public EstadoJuego envido() {
        throw new NoSePuedeCantarEnvido();
    }

    @Override
    public EstadoJuego envidoEnvido() {
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoJuego realEnvido() {
        throw new NoSePuedeCantarRealEnvido();
    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        throw new NoSePuedeCantarFaltaEnvido();
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof FaltaEnvidoCantado;
    }

}
