package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class JuegoSinFlor implements EstadoFlor {

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

        throw new JuegoSinFlorException();

    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {

        throw new JuegoSinFlorException();

    }

    @Override
    public EstadoFlor contraFlorAlPartido() {

        throw new JuegoSinFlorException();

    }
    
    
}
