package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class ContraFlorAlPartidoCantado implements EstadoFlor {
    @Override
    public int puntos() {
        return 30;
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
    public boolean equals(Object estado) {
        return estado instanceof ContraFlorAlPartidoCantado;
    }

}