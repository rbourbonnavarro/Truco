package fiuba.algo3.truco.modelo.Jugadas;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;

public class NadaCantado implements EstadoJuego {

    private boolean tantoCantado = false;
    private Equipo equipoIniciadorTanto = null;

    @Override
    public int puntos() {

        return 1;

    }

    @Override
    public int noQuerido() {

        return 0;

    }

    @Override
    public EstadoJuego truco(Equipo equipoIniciador) {

        return new TrucoCantado(equipoIniciador, this.tantoCantado);
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

        if(this.tantoCantado) throw new NoSePuedeCantarEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = equipoIniciador;

        return new EnvidoCantado(this);

    }

    @Override
    public EstadoJuego realEnvido(Equipo equipoIniciador) {

        if(this.tantoCantado) throw new NoSePuedeCantarRealEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = equipoIniciador;

        return new RealEnvidoCantado(this);

    }

    @Override
    public EstadoJuego faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        if(this.tantoCantado) throw new NoSePuedeCantarFaltaEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = equipoIniciador;

        return new FaltaEnvidoCantado(this, puntos);

    }

    @Override
    public EstadoJuego flor(Equipo equipoIniciador) {

        if(this.tantoCantado) throw new NoSePuedeCantarFlorException();

        this.tantoCantado = true;

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

        this.tantoCantado = true;

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

        return estado instanceof NadaCantado;

    }

    @Override
    public int hashCode() {

        return 0;

    }


}
