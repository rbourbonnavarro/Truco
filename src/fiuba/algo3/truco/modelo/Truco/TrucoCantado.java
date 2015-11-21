package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

    private EstadoJuego estadoPrevio;

    public TrucoCantado(EstadoJuego estadoPrevio) {

        this.estadoPrevio = estadoPrevio;

    }

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public EstadoJuego truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco() {

        return new RetrucoCantado();

    }

    @Override
    public EstadoJuego valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public EstadoJuego envido() {



        return new EnvidoCantado(this);

    }

    @Override
    public EstadoJuego envidoEnvido() {

        throw new NoSePuedeCantarEnvidoEnvido();

    }

    @Override
    public EstadoJuego realEnvido() {

        return new RealEnvidoCantado(this);

    }

    @Override
    public EstadoJuego faltaEnvido(Puntaje puntos) {

        return new FaltaEnvidoCantado(this, puntos);

    }

    @Override
    public void flor() {

        this.estadoPrevio.flor();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        this.estadoPrevio.contraFlorAlResto(puntos);

    }

    @Override
    public void contraFlorAlPartido() {

        this.estadoPrevio.contraFlorAlPartido();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return this;

    }

    @Override
    public EstadoJuego quiero() {

        return new TrucoQuerido();

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof TrucoCantado;

    }


}
