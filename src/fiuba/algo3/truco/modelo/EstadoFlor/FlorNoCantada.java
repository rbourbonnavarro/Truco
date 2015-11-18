package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

/**
 * Created by GomezPeter on 17/11/2015.
 */
public class FlorNoCantada implements EstadoFlor {
    @Override
    public int puntos() {
        return 0;
    }

    @Override
    public int noQuerido() {
        return 0;
    }

    @Override
    public EstadoFlor flor() {
        return new FlorCantada();
    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {
        throw new NoSePuedeCantarContraFlorException();
    }

    @Override
    public EstadoFlor contraFlorAlPartido() {
        throw new NoSePuedeCantarContraFlorException();
    }
}
