package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

    public int puntos() {

        return 2;

    }

    public int noQuerido() {

        return 1;

    }

    @Override
    public EstadoJuego truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco() {

        return new RetrucoCantado();

    }

    @Override
    public EstadoJuego valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido() {
        return null;
    }

    @Override
    public EstadoJuego envidoEnvido() {
        return null;
    }

    @Override
    public EstadoJuego realEnvido() {
        return null;
    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return null;
    }

    @Override
    public boolean equals (Object estado){
        return estado instanceof TrucoCantado;
    }

}
