package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoRonda {

    void truco();

    void reTruco();

    void valeCuatro();

    void envido(Jugador jugadorActual);

    void envidoEnvido();

    void realEnvido(Jugador jugadorActual);

    void faltaEnvido(Jugador jugadorActual, Puntaje puntos);

    void flor();

    void contraFlorAlResto(Puntaje puntos);

    void contraFlorAlPartido();

    void terminarTanto();

    void quiero();

    int puntos();

    int noQuerido();

    EstadoRonda terminarVuelta();

    void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta);

    EstadoRonda terminar(Equipo equipoGanador, int puntos);

    Equipo getGanadorVuelta();


}
