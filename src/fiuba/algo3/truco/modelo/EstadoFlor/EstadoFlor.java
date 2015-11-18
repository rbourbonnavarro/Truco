package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

/**
 * Created by GomezPeter on 17/11/2015.
 */
public interface EstadoFlor {
    int puntos();

    int noQuerido();

    EstadoFlor flor();

    EstadoFlor contraFlorAlResto(Puntaje puntos);

    EstadoFlor contraFlorAlPartido();
}
