package fiuba.algo3.truco.modelo.Jugadas.Envido;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;

public class RealEnvidoCantado implements EstadoJuego {

    private EstadoJuego estadoPrevio;
    private final int puntosRealEnvido = 3;
    private boolean envidoCantado;

    private int puntos;
    private int puntosNoQuerido;

    public RealEnvidoCantado(EstadoJuego estadoPrevio, int puntos, boolean envidoCantado) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = puntos + this.puntosRealEnvido;
        this.puntosNoQuerido = puntos;
        this.envidoCantado = envidoCantado;

    }

    public RealEnvidoCantado(EstadoJuego estadoPrevio, boolean envidoCantado) {

        this.estadoPrevio = estadoPrevio;
        this.puntos = this.puntosRealEnvido;
        this.puntosNoQuerido = 1;
        this.envidoCantado = envidoCantado;

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
    public EstadoJuego realEnvido(Equipo equipoIniciador) {

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public EstadoJuego faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        return new FaltaEnvidoCantado(this, puntos, this.puntos());

    }

    @Override
    public EstadoJuego flor(Equipo equipoIniciador) {

        if(this.envidoCantado) throw new NoSePuedeCantarFlorException();

        return new FlorCantada(this.estadoPrevio);

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

        return this;

    }

    @Override
    public void estadoValido() {

        throw new RealEnvidoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public Equipo getEquipoIniciador() {

        return null;

    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof RealEnvidoCantado && ((RealEnvidoCantado) estado).envidoCantado == this.envidoCantado;

    }

    @Override
    public int hashCode() {

        return 10 + ((Boolean) this.envidoCantado).hashCode();

    }


}
