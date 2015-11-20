package fiuba.algo3.truco.modelo.Jugada.Envido;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RealEnvidoCantado implements EstadoEnvido {

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
        return new FaltaEnvidoCantado(puntos,this.puntos());
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof RealEnvidoCantado;
    }

}
