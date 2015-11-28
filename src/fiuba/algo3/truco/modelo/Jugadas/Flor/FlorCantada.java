package fiuba.algo3.truco.modelo.Jugadas.Flor;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;


public class FlorCantada implements EstadoJuego {

    private boolean aceptado;
    private EstadoJuego estadoPrevio;

    public FlorCantada(EstadoJuego estadoPrevio) {

        this.aceptado = false;
        this.estadoPrevio = estadoPrevio;

    }

    @Override
    public int puntos() {

        return 3;

    }

    @Override
    public int noQuerido() {

        throw new NoSePuedeNoQuererFlorException();

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

        throw new NoSePuedeCantarFaltaEnvido();

    }

    @Override
    public EstadoJuego flor(Equipo equipoIniciador) {

        return new FlorFlorCantada(this);

    }

    @Override
    public EstadoJuego contraFlorAlResto(Puntaje puntos) {

        return new ContraFlorAlRestoCantada(this, puntos, this.puntos());

    }

    @Override
    public EstadoJuego contraFlorAlPartido() {

        return new ContraFlorAlPartidoCantado(this);

    }

    @Override
    public EstadoJuego terminarTanto() {

        return this.estadoPrevio.terminarTanto();

    }

    @Override
    public EstadoJuego quiero() {

        this.aceptado = true;

        throw new NoSePuedeQuererFlorException();

    }

    @Override
    public void estadoValido() {

        if(!this.aceptado) throw new FlorNoAceptadaNoSePuedeJugarException();

    }

    @Override
    public Equipo getEquipoIniciador() {
        return null;
    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof FlorCantada;

    }


}
