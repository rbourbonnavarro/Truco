package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantadoTantoNoJugado implements EstadoJuego {

    private Equipo equipoIniciador;
    private Equipo equipoIniciadorTanto;

    public TrucoCantadoTantoNoJugado(Equipo equipoIniciador) {

        this.equipoIniciador = equipoIniciador;

    }

    @Override
    public int puntos() {

        throw new TrucoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public EstadoJuego truco(Equipo equipoIniciador) {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco(Equipo equipoIniciador) {

        return new RetrucoCantado(this.equipoIniciador, equipoIniciador);

    }

    @Override
    public EstadoJuego valeCuatro(Equipo equipoIniciador) {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido(Equipo equipoIniciador) {

        this.equipoIniciadorTanto = equipoIniciador;

        return new EnvidoCantado(this);

    }

    @Override
    public EstadoJuego realEnvido(Equipo equipoIniciador) {

        this.equipoIniciadorTanto = this.equipoIniciador;

        return new RealEnvidoCantado(this, false);

    }

    @Override
    public EstadoJuego faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        this.equipoIniciadorTanto = this.equipoIniciador;

        return new FaltaEnvidoCantado(this, puntos);

    }

    @Override
    public EstadoJuego flor(Equipo equipoIniciador) {

        this.equipoIniciadorTanto = equipoIniciador;

        return new FlorCantada(this);

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

        return new TrucoCantadoTantoJugado(this.equipoIniciador, this.equipoIniciadorTanto);

    }

    @Override
    public EstadoJuego quiero() {

        return new TrucoQuerido(this.equipoIniciador);

    }

    @Override
    public void estadoValido() {

        throw new TrucoNoQueridoNoSePuedeJugarException();

    }

    @Override
    public Equipo getEquipoIniciador() {

        return this.equipoIniciadorTanto;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof TrucoCantadoTantoNoJugado;

    }

    @Override
    public int hashCode() {

        return this.noQuerido();

    }


}
