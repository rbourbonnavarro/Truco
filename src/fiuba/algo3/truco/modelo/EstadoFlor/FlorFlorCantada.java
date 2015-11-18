package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FlorFlorCantada implements EstadoFlor {
    @Override
    public int puntos() {
        return 6;
    }

    @Override
    public int noQuerido() {
        throw new NoSePuedeNoQuererFlorException();
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
    public boolean equals(Object estado) {
        return estado instanceof FlorFlorCantada;
    }

}
