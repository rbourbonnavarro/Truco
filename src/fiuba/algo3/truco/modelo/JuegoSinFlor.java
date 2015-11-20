package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoFlor.FlorCantada;
import fiuba.algo3.truco.modelo.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarContraFlorException;
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


}
