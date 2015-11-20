package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public interface EstadoJuego {

    EstadoJuego truco();

    EstadoJuego reTruco();

    EstadoJuego valeCuatro();

    EstadoJuego envido();

    EstadoJuego envidoEnvido();

    EstadoJuego realEnvido();

    EstadoJuego faltaEnvido(Puntaje puntos);


}
