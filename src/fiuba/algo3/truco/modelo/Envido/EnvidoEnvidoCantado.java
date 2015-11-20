package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;

public class EnvidoEnvidoCantado implements EstadoJuego {

    public int puntos() {

        return 4;

    }

    public int noQuerido() {

        return 2;

    }

    @Override
    public EstadoJuego truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco() {
        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoJuego valeCuatro() {
        throw new NoSePuedeCantarValeCuatroException();

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
