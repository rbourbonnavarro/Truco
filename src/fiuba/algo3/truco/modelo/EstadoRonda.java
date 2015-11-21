package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoRonda {

    void truco();

    void reTruco();

    void valeCuatro();

    void envido();

    void envidoEnvido();

    void realEnvido();

    void faltaEnvido(Puntaje puntos);

    void flor();

    void contraFlorAlResto(Puntaje puntos);

    void contraFlorAlPartido();

    void terminarTanto();

    void quiero();

    int puntos();

    int noQuerido();

    EstadoRonda terminarVuelta();

    void calcularGanadorJugada(Equipo equipo, Carta carta);


}
