package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

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
    public EstadoJuego flor() {
        return null;
    }

    @Override
    public EstadoJuego contraFlorAlResto(Puntaje puntos) {
        return null;
    }

    @Override
    public EstadoJuego contraFlorAlPartido() {
        return null;
    }

    @Override
    public boolean equals (Object estado){
        return estado instanceof TrucoCantado;
    }

}
