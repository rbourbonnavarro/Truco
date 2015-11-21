package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoQuerido implements EstadoJuego {

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 0;

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

        throw new NoSePuedeCantarEnvido();

    }

    @Override
    public EstadoJuego envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

    }

    @Override
    public EstadoJuego realEnvido() {

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

        throw new NoSePuedeCantarFaltaEnvido();

    }

    @Override
    public EstadoJuego flor() {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlPartido() {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return null;

    }

    @Override
    public EstadoJuego quiero() {

        return null;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof TrucoQuerido;

    }


}
