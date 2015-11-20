package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Truco.TrucoCantado;

public class NadaCantado implements EstadoJuego {

    private EstadoFlor estadoFlor;

    public NadaCantado(EstadoFlor estadoFlor) {

        this.estadoFlor = estadoFlor;

    }

    @Override
    public int puntos() {

        return 1;

    }

    @Override
    public int noQuerido() {

        return 0;

    }

    @Override
    public EstadoJuego truco() {

        return new TrucoCantado(this);
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

        this.estadoFlor = this.estadoFlor.flor();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        this.estadoFlor = this.estadoFlor.flor();

    }

    @Override
    public void contraFlorAlPartido() {

        this.estadoFlor = this.estadoFlor.flor();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return this;

    }

    @Override
    public EstadoJuego quiero() {

        return null;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof NadaCantado;

    }


}
