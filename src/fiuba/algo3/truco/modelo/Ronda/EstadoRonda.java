package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mazo;
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

    EstadoRonda terminarVuelta(Equipo equipo1, Equipo equipo2, Mazo mazo);

    void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta);

    EstadoRonda terminar(Equipo equipoGanador, int puntos, Equipo equipo1, Equipo equipo2, Mazo mazo);


    Equipo getGanadorVuelta();


    int numeroVuelta();
}
