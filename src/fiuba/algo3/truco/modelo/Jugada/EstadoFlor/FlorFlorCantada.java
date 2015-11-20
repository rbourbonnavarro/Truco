package fiuba.algo3.truco.modelo.Jugada.EstadoFlor;

import fiuba.algo3.truco.modelo.Jugada.Envido.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FlorFlorCantada implements EstadoFlor {
    @Override
    public int puntos() {
        return 6;
    }

    @Override
    public int noQuerido() {
        return 3;
    }

    @Override
    public EstadoFlor flor() {
        throw new NoSePuedeCantarFlorException();
    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {
        throw new NoSePuedeCantarContraFlorException();
    }

    @Override
    public EstadoFlor contraFlorAlPartido() {
        throw new NoSePuedeCantarContraFlorException();
    }

    @Override
    public EstadoEnvido envido(EstadoEnvido envido) {
        throw new NoSePuedeCantarEnvido();
    }

    @Override
    public EstadoEnvido envidoEnvido(EstadoEnvido estado){
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoEnvido realEnvido(EstadoEnvido envido) {
        throw new NoSePuedeCantarRealEnvido();
    }

    @Override
    public EstadoEnvido faltaEnvido(EstadoEnvido envido, Puntaje puntos) {
        throw new NoSePuedeCantarFaltaEnvido();
    }

    @Override
    public boolean equals(Object estado) {
        return estado instanceof FlorFlorCantada;
    }

}
