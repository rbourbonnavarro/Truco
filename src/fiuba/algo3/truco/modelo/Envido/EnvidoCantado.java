package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public EstadoEnvido envido() {
        throw new NoSePuedeCantarEnvido();
    }

    @Override
    public EstadoEnvido envidoEnvido() {
        return new EnvidoEnvidoCantado();
    }

    @Override
    public EstadoEnvido realEnvido() {
        return new RealEnvidoCantado(this.puntos());
    }

    @Override
    public EstadoEnvido faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos,this.puntos());
    }

    @Override
    public boolean equals(Object estado) {
        return estado instanceof EnvidoCantado;
    }


}
