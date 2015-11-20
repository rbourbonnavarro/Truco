package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarFlorException;
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

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public void contraFlorAlPartido() {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof RetrucoCantado;

    }


}
