package fiuba.algo3.truco.modelo.Envido;

import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;

public class EnvidoQuerido implements EstadoJuego {

    private EstadoJuego estadoPrevio;

    public EnvidoQuerido(EstadoJuego estadoPrevio) {

        this.estadoPrevio = estadoPrevio;

    }

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 0;

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
    public void flor() {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public void contraFlorAlPartido() {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return null;

    }

    @Override
    public EstadoJuego quiero() {

        return this;

    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof EnvidoCantado;

    }


}
