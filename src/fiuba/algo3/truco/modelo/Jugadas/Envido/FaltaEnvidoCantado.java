package fiuba.algo3.truco.modelo.Jugadas.Envido;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;

public class FaltaEnvidoCantado implements EstadoJuego {

    private boolean querido;
    private EstadoJuego estadoPrevio;
    private int puntos;
    private int puntosNoQuerido;

    public FaltaEnvidoCantado(EstadoJuego estadoPrevio, Puntaje puntaje) {

        this.querido = false;
        this.estadoPrevio = estadoPrevio;
        this.puntos = puntaje.faltaEnvido();
        this.puntosNoQuerido = 1;

    }

    public FaltaEnvidoCantado(EstadoJuego estadoPrevio, Puntaje puntaje, int puntos) {

        this.querido = false;
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
    public EstadoJuego truco(Equipo equipoIniciador) {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco(Equipo equipoIniciador) {

        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoJuego valeCuatro(Equipo equipoIniciador) {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido(Equipo equipoIniciador) {

        throw new NoSePuedeCantarEnvido();

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

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlPartido() {

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return this.estadoPrevio.terminarTanto();

    }

    @Override
    public EstadoJuego quiero() {

        this.querido = true;

        return this;

    }

    @Override
    public void estadoValido() {

        if(!this.querido) throw new FaltaEnvidoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public Equipo getEquipoIniciador() {
        return null;
    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof FaltaEnvidoCantado;

    }


}
