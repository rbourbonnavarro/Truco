package fiuba.algo3.truco.modelo.EnvidoYFlor;

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
        return true;
    }


}
