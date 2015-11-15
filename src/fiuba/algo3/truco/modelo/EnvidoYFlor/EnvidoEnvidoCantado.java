package fiuba.algo3.truco.modelo.EnvidoYFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoEnvidoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 4;

    }

    @Override
    public int noQuerido() {

        return 2;

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
        return new RealEnvidoCantado(this.puntos());
    }

    @Override
    public EstadoEnvido faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos, this.puntos());
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof EnvidoEnvidoCantado;
    }

}
