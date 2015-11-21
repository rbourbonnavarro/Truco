package fiuba.algo3.truco.modelo.EstadoFlor;

import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FlorNoCantada implements EstadoJuego {

    @Override
    public int puntos() {

        return 0;

    }

    @Override
    public int noQuerido() {

        return 0;

    }

    @Override
    public EstadoJuego truco() {



    }

    @Override
    public EstadoJuego reTruco() {



    }

    @Override
    public EstadoJuego valeCuatro() {



    }

    @Override
    public EstadoJuego envido() {
        return null;
    }

    @Override
    public EstadoJuego envidoEnvido() {
        return null;
    }

    @Override
    public EstadoJuego realEnvido() {
        return null;
    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return null;
    }

    @Override
    public EstadoFlor flor() {

        return new FlorCantada();

    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoFlor contraFlorAlPartido() {

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoJuego terminarTanto() {
        return null;
    }

    @Override
    public EstadoJuego quiero() {
        return null;
    }

    @Override
    public boolean equals(Object estado) {

        return estado instanceof FlorNoCantada;

    }


}
