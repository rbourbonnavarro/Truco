package fiuba.algo3.truco.modelo.Jugadas;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantadoTantoNoJugado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TantoJugado implements EstadoJuego {

    private Equipo equipoIniciadorTanto = null;

    public TantoJugado(Equipo equipoIniciadorTanto) {

        this.equipoIniciadorTanto = equipoIniciadorTanto;

    }

    @Override
    public int puntos() {

        return 1;

    }

    @Override
    public int noQuerido() {

        throw new NadaCantadoException();

    }

    @Override
    public EstadoJuego truco(Equipo equipoIniciador) {

        return new TrucoCantadoTantoJugado(equipoIniciador, this.equipoIniciadorTanto);

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

        return this;

    }

    @Override
    public EstadoJuego quiero() {

        throw new NadaCantadoException();

    }

    @Override
    public void estadoValido() {}

    @Override
    public Equipo getEquipoIniciador() {

        return this.equipoIniciadorTanto;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof TantoJugado;

    }

    @Override
    public int hashCode() {

        return 0;

    }


}
