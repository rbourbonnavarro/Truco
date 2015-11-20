package fiuba.algo3.truco.modelo.Jugada.Envido;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoEnvido {

    int puntos();

    int noQuerido();

    EstadoEnvido envido();

    EstadoEnvido envidoEnvido();

    EstadoEnvido realEnvido();

    EstadoEnvido faltaEnvido(Puntaje puntos);
}
