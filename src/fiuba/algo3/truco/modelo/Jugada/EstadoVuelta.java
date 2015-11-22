package fiuba.algo3.truco.modelo.Jugada;

import fiuba.algo3.truco.modelo.Jugada.Truco.GanadorVuelta;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

/**
 * Created by fedemgp on 20/11/15.
 */
public interface EstadoVuelta {
    void truco();
    void reTruco();
    void valeCuatro();

    void envido(Jugador jugadorActual);
    void envidoEnvido();
    void realEnvido();
    void faltaEnvido(Puntaje puntos);

    void flor();
    void contraFlorAlResto(Puntaje puntos);
    void contraFlorAlPartido();

    int trucoNoQuerido();
    int trucoQuerido();
    int envidoNoQuerido();
    int envidoQuerido();
}
