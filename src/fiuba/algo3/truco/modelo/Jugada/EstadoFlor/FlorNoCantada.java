package fiuba.algo3.truco.modelo.Jugada.EstadoFlor;

import fiuba.algo3.truco.modelo.Jugada.Envido.EstadoEnvido;
import fiuba.algo3.truco.modelo.Jugada.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class FlorNoCantada implements EstadoFlor {

    @Override
    public int puntos() {
        return 0;
    }

    @Override
    public int noQuerido() {
        return 0;
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
    public EstadoEnvido envido(EstadoEnvido estado) {
        return estado.envido();
    }
    @Override
    public EstadoEnvido envidoEnvido(EstadoEnvido estado){
        return estado.envidoEnvido();
    }

    @Override
    public EstadoEnvido realEnvido(EstadoEnvido estado) {
        return estado.realEnvido();
    }

    @Override
    public EstadoEnvido faltaEnvido(EstadoEnvido estado, Puntaje puntos) {
        return estado.faltaEnvido(puntos);
    }

    @Override
    public boolean equals(Object estado) {
        return estado instanceof FlorNoCantada;
    }


}
