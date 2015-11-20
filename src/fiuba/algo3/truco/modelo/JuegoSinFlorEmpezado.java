package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Envido.NoSePuedeCantarEnvidoEnvido;
import fiuba.algo3.truco.modelo.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.EstadoFlor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Truco.TrucoCantado;

public class JuegoSinFlorEmpezado implements EstadoJuego {

    public int puntos() {

        return 1;

    }

    @Override
    public EstadoJuego truco() {

        return new TrucoCantado();
    }

    @Override
    public EstadoJuego reTruco() {

        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoJuego valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido() {

        return new EnvidoCantado();

    }

    @Override
    public EstadoJuego envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

    }

    @Override
    public EstadoJuego realEnvido() {

        return new RealEnvidoCantado();

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {
        return new FaltaEnvidoCantado(puntos);
    }

    @Override
    public EstadoJuego flor() {

        throw new JuegoSinFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlResto(Puntaje puntos) {
        throw new NoSePuedeCantarContraFlorException();
    }

    @Override
    public EstadoJuego contraFlorAlPartido() {
        throw new NoSePuedeCantarContraFlorException();
    }
    
    @Override
    public boolean equals (Object estado){
        return estado instanceof JuegoSinFlorEmpezado;
    }


}
