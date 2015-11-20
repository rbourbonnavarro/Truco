package fiuba.algo3.truco.modelo.Truco;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class TrucoCantado implements EstadoJuego {

    private EstadoEnvido estadoEnvido;
    private EstadoFlor estadoFlor;

    public TrucoCantado(EstadoEnvido estadoEnvido, EstadoFlor estadoFlor) {

        this.estadoEnvido = estadoEnvido;
        this.estadoFlor = estadoFlor;

    }

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
    public void envido() {

        this.estadoEnvido = this.estadoEnvido.envido();

    }

    @Override
    public void envidoEnvido() {

        this.estadoEnvido = this.estadoEnvido.envidoEnvido();

    }

    @Override
    public void realEnvido() {

        this.estadoEnvido = this.estadoEnvido.realEnvido();

    }

    @Override
    public void faltaEnvido(Puntaje puntos) {

        this.estadoEnvido = this.estadoEnvido.faltaEnvido(puntos);

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
    public boolean equals (Object estado){

        return estado instanceof TrucoCantado;

    }


}
