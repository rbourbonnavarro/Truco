package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoEnvidoCantado implements EstadoJuego {

    public int puntos() {

        return 4;

    }

    public int noQuerido() {

        return 2;

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
        return new RealEnvidoCantado(this.puntos());
    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos, this.puntos());
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof EnvidoEnvidoCantado;
    }

}
