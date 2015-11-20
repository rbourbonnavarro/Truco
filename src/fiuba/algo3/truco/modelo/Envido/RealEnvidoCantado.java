package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;

public class RealEnvidoCantado implements EstadoJuego {

    private EstadoJuego estadoPrevio;
    private final int puntosRealEnvido = 3;

    private int puntos;
    private int puntosNoQuerido;

    public RealEnvidoCantado(EstadoJuego estadoPrevio, int puntos) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = puntos + this.puntosRealEnvido;
        this.puntosNoQuerido = puntos;

    }

    public RealEnvidoCantado(EstadoJuego estadoPrevio) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = this.puntosRealEnvido;
        this.puntosNoQuerido = 1;

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

        return new FaltaEnvidoCantado(this, puntos, this.puntos());

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

        return estado instanceof RealEnvidoCantado;

    }


}
