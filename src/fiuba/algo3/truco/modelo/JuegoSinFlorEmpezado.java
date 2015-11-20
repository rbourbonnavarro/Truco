package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Truco.TrucoCantado;

public class JuegoSinFlorEmpezado implements EstadoJuego {

    public int puntos() {

        return 1;

    }

    public int noQuerido() {

        return 0;

    }

    @Override
    public EstadoJuego truco() {

        return new TrucoCantado();
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

        return new EnvidoCantado();

    }

    @Override
    public EstadoJuego envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

    }

    @Override
    public EstadoJuego realEnvido() {

        return new RealEnvidoCantado();

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos);
    }

    @Override
    public boolean equals (Object estado){
        return estado instanceof JuegoSinFlorEmpezado;
    }

}
