package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RetrucoCantado implements EstadoJuego {

    public int puntos() {

        return 3;

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

        return new ValeCuatroCantado();

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
        return estado instanceof RetrucoCantado;
    }


}
