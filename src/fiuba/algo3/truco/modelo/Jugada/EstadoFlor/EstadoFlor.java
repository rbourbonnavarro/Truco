package fiuba.algo3.truco.modelo.Jugada.EstadoFlor;

import fiuba.algo3.truco.modelo.Jugada.Envido.EstadoEnvido;
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

    EstadoEnvido envido(EstadoEnvido estado);

    EstadoEnvido envidoEnvido(EstadoEnvido estado);

    EstadoEnvido realEnvido(EstadoEnvido estado);

    EstadoEnvido faltaEnvido(EstadoEnvido estado, Puntaje puntos);
}
