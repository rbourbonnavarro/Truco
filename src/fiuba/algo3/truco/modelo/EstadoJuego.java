package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoJuego {

    EstadoJuego truco();

    EstadoJuego reTruco();

    EstadoJuego valeCuatro();

    void envido();

    void envidoEnvido();

    void realEnvido();

    void faltaEnvido(Puntaje puntos);

    void flor();

    void contraFlorAlResto(Puntaje puntos);

    void contraFlorAlPartido();


}
