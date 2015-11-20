package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RetrucoCantado implements EstadoJuego {

    public int puntos() {

        return 3;

    }

    public int noQuerido() {

        return 2;

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

        return new ValeCuatroCantado();

    }

    @Override
    public EstadoJuego envido() {

        throw new NoSePuedeCantarEnvido();

    }

    @Override
    public EstadoJuego envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

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
    public boolean equals (Object estado){
        return estado instanceof RetrucoCantado;
    }


}
