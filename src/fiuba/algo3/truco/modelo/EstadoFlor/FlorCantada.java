package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

/**
 * Created by GomezPeter on 17/11/2015.
 */
public class FlorCantada implements EstadoFlor {
    @Override
    public int puntos() {
        return 3;
    }

    @Override
    public int noQuerido() {
        throw new NoSePuedeNoQuererFlorException();
    }

    @Override
    public EstadoFlor flor() {
        return new FlorFlorCantada();
    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {
        return new ContraFlorAlRestoCantada(puntos,this.puntos());
    }

    @Override
    public EstadoFlor contraFlorAlPartido() {
        return new ContraFlorAlPartido();
    }
}
