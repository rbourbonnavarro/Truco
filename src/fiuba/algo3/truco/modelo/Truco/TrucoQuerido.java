package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoQuerido implements EstadoJuego {

    public int puntos() {

        return 2;

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
    public void envido() {

        throw new NoSePuedeCantarEnvido();

    }

    @Override
    public void envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

    }

    @Override
    public void realEnvido() {

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public void faltaEnvido(Puntaje puntos) {

        throw new NoSePuedeCantarFaltaEnvido();

    }

    @Override
    public void flor() {

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

    }

    @Override
    public void contraFlorAlPartido() {

    }

    @Override
    public boolean equals (Object estado){
        return estado instanceof TrucoQuerido;
    }

}
