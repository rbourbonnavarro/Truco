package fiuba.algo3.truco.modelo.Jugadas;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoJuego {

    int puntos();

    int noQuerido();

    EstadoJuego truco(Equipo equipoIniciador);

    EstadoJuego reTruco(Equipo equipoIniciador);

    EstadoJuego valeCuatro(Equipo equipoIniciador);

    EstadoJuego envido();

    EstadoJuego realEnvido();

    EstadoJuego faltaEnvido(Puntaje puntos);

    EstadoJuego flor();

    EstadoJuego contraFlorAlResto(Puntaje puntos);

    EstadoJuego contraFlorAlPartido();

    EstadoJuego terminarTanto();

    EstadoJuego quiero();

    void estadoValido();


}
