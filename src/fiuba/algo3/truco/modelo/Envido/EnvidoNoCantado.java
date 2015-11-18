package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoNoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 1;

    }

    @Override
    public int noQuerido() {

        return 0;

    }

    @Override
    public EstadoEnvido envido() {
        return new EnvidoCantado();
    }

    @Override
    public EstadoEnvido envidoEnvido() {
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoEnvido realEnvido() {
        return new RealEnvidoCantado();
    }

    @Override
    public EstadoEnvido faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos);
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof EnvidoNoCantado;
    }


}
