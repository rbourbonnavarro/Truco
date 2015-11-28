package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

    private Equipo equipoIniciador;
    private Equipo equipoIniciadorTanto;
    private boolean tantoCantado;

    public TrucoCantado(Equipo equipoIniciador, boolean tantoCantado) {

        this.equipoIniciador = equipoIniciador;
        this.tantoCantado = tantoCantado;

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

        if(this.tantoCantado) throw new NoSePuedeCantarEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = equipoIniciador;

        return new EnvidoCantado(this);

    }

    @Override
    public EstadoJuego realEnvido(Equipo equipoIniciador) {

        if(this.tantoCantado) throw new NoSePuedeCantarRealEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = this.equipoIniciador;

        return new RealEnvidoCantado(this);

    }

    @Override
    public EstadoJuego faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        if(this.tantoCantado) throw new NoSePuedeCantarFaltaEnvido();

        this.tantoCantado = true;

        this.equipoIniciadorTanto = this.equipoIniciador;

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

        return this;

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

        return estado instanceof TrucoCantado;

    }


}
