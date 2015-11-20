package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class EnvidoNoCantado implements EstadoJuego {

    public int puntos() {

        return 1;

    }

    public int noQuerido() {

        return 0;

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
        return new EnvidoCantado();
    }

    @Override
    public EstadoJuego envidoEnvido() {
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoJuego realEnvido() {
        return new RealEnvidoCantado();
    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos);
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof EnvidoNoCantado;
    }


}
