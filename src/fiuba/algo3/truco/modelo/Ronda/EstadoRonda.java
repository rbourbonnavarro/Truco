package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.Deque;

public interface EstadoRonda {

    void truco();

    void reTruco();

    void valeCuatro();

    void envido(Jugador jugadorActual);


    void realEnvido(Jugador jugadorActual);

    void faltaEnvido(Jugador jugadorActual, Puntaje puntos);

    void flor();

    void contraFlorAlResto(Puntaje puntos);

    void contraFlorAlPartido();

    void terminarTanto();

    void quiero();

    int puntos();

    int noQuerido();

    EstadoRonda terminarVuelta(Mesa mesa);

    void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta);

    EstadoRonda terminar(Equipo equipoGanador, int puntos, Mesa mesa);


    Equipo getGanadorVuelta();


    int numeroVuelta();
}
