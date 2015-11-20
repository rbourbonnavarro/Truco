package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RealEnvidoCantado implements EstadoJuego {

    private final int puntosRealEnvido = 3;

    private int puntos;
    private int puntosNoQuerido;

    public RealEnvidoCantado(int puntos) {

        this.puntos = puntos + this.puntosRealEnvido;
        this.puntosNoQuerido = puntos;

    }

    public RealEnvidoCantado() {
        this.puntos = this.puntosRealEnvido;
        this.puntosNoQuerido = 1;
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
        return new FaltaEnvidoCantado(puntos,this.puntos());
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof RealEnvidoCantado;
    }

}
