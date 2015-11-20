package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Jugada.Envido.EstadoEnvido;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.List;

public class JuegoSinFlor implements EstadoFlor {

    public int flor(List<Carta> cartas) throws JuegoSinFlorException {

        throw new JuegoSinFlorException();

    }

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

        throw new JuegoSinFlorException();

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
    public EstadoEnvido envidoEnvido(EstadoEnvido estado) {
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



}
