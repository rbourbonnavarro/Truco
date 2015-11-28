package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RetrucoCantado implements EstadoJuego {

    private Equipo equipoIniciadorJugada;
    private Equipo equipoQueCantoUltimo;

    public RetrucoCantado(Equipo equipoIniciador) {

        this.equipoIniciadorJugada = equipoIniciador;
        this.equipoQueCantoUltimo = equipoIniciador;

    }

    public RetrucoCantado(Equipo equipoIniciadorJugada, Equipo equipoQueCantoUltimo) {

        this.equipoIniciadorJugada = equipoIniciadorJugada;
        this.equipoQueCantoUltimo = equipoQueCantoUltimo;

    }

    @Override
    public int puntos() {

        throw new RetrucoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public int noQuerido() {

        return 2;

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

        return new ValeCuatroCantado(this.equipoIniciadorJugada);

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

        return null;

    }

    @Override
    public EstadoJuego quiero() {

        return new RetrucoQuerido(this.equipoIniciadorJugada, this.equipoQueCantoUltimo);

    }

    @Override
    public void estadoValido() {

        throw new RetrucoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public Equipo getEquipoIniciador() {

        return this.equipoIniciadorJugada;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof RetrucoCantado;

    }


}
