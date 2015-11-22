package fiuba.algo3.truco.modelo.Jugadas.Flor;

import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarTrucoException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.NoSePuedeCantarValeCuatroException;


public class FlorCantada implements EstadoJuego {

    private EstadoJuego estadoPrevio;

    public FlorCantada(EstadoJuego estadoPrevio) {

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
    public EstadoJuego realEnvido() {

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

        throw new NoSePuedeCantarFaltaEnvido();

    }

    @Override
    public EstadoJuego flor() {

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

        throw new NoSePuedeQuererFlorException();

    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof FlorCantada;

    }


}
