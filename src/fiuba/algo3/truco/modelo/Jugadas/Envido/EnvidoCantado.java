package fiuba.algo3.truco.modelo.Jugadas.Envido;

import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;

public class EnvidoCantado implements EstadoJuego {

    private EstadoJuego estadoPrevio;

    public EnvidoCantado(EstadoJuego estadoPrevio) {

        this.estadoPrevio = estadoPrevio;

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

        return new EnvidoEnvidoCantado(this);

    }

    @Override
    public EstadoJuego realEnvido() {

        return new RealEnvidoCantado(this, this.puntos());

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

        return new FaltaEnvidoCantado(this, puntos, this.puntos());

    }

    @Override
    public EstadoJuego flor() {

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

        return new EnvidoQuerido(this);

    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof EnvidoCantado;

    }


}