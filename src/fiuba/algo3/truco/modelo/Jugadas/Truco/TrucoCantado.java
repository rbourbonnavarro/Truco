package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

    private boolean tantoCantado;

    public TrucoCantado(boolean tantoCantado) {

        this.tantoCantado = tantoCantado;

    }

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public EstadoJuego truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco() {

        return new RetrucoCantado();

    }

    @Override
    public EstadoJuego valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido() {

        if(this.tantoCantado) throw new NoSePuedeCantarEnvido();

        return new EnvidoCantado(this);

    }

    @Override
    public EstadoJuego realEnvido() {

        if(this.tantoCantado) throw new NoSePuedeCantarRealEnvido();

        return new RealEnvidoCantado(this);

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

        if(this.tantoCantado) throw new NoSePuedeCantarFaltaEnvido();

        return new FaltaEnvidoCantado(this, puntos);

    }

    @Override
    public EstadoJuego flor() {

        if(this.tantoCantado) throw new NoSePuedeCantarFlorException();

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

        return this;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof TrucoCantado;

    }


}
