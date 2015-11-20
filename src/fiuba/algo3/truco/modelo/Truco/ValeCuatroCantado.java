package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class ValeCuatroCantado implements EstadoJuego {

    public int puntos() {

        return 4;

    }

    public int noQuerido() {

        return 3;

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
        return estado instanceof ValeCuatroCantado;
    }
}
