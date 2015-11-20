package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoJuego {

    int puntos();

    int noQuerido();

    EstadoJuego truco();

    EstadoJuego reTruco();

    EstadoJuego valeCuatro();

    EstadoJuego envido();

    EstadoJuego envidoEnvido();

    EstadoJuego realEnvido();

    EstadoJuego faltaEnvido(Puntaje puntos);

    void flor();

    void contraFlorAlResto(Puntaje puntos);

    void contraFlorAlPartido();

    EstadoJuego terminarTanto();

    EstadoJuego quiero();


}