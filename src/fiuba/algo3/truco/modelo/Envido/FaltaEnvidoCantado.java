package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;

public class FaltaEnvidoCantado implements EstadoJuego {

    private EstadoJuego estadoPrevio;
    private int puntos;
    private int puntosNoQuerido;

    public FaltaEnvidoCantado(EstadoJuego estadoPrevio, Puntaje puntaje) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = puntaje.faltaEnvido();
        this.puntosNoQuerido = 1;

    }
    public FaltaEnvidoCantado(EstadoJuego estadoPrevio, Puntaje puntaje, int puntos) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = puntaje.faltaEnvido();
        this.puntosNoQuerido = puntos;

    }

    @Override
    public int puntos() {

        return this.puntos;

    }

    @Override
    public int noQuerido() {

        return this.puntosNoQuerido;

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

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

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
    public EstadoJuego terminarTanto() {

        return this.estadoPrevio.terminarTanto();

    }

    @Override
    public EstadoJuego quiero() {

        return this;

    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof FaltaEnvidoCantado;

    }


}
