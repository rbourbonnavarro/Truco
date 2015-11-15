package fiuba.algo3.truco.modelo.EnvidoYFlor;

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
    public boolean sePuedeCantarEnvido() {

        return false;

    }

    @Override
    public boolean sePuedeCantarEnvidoEnvido() {

        return false;

    }

    @Override
    public boolean sePuedeCantarRealEnvido() {

        return false;

    }

    @Override
    public boolean sePuedeCantarFaltaEnvido() {

        return false;

    }


}
