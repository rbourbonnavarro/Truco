package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Envido.*;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoFlor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Truco.NoSePuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Truco.TrucoCantado;

public class JuegoEmpezado implements EstadoJuego {

    private EstadoEnvido estadoEnvido;
    private EstadoFlor estadoFlor;

    public JuegoEmpezado(EstadoFlor estadoFlor) {

        this.estadoEnvido = new EnvidoNoCantado();
        this.estadoFlor = estadoFlor;

    }

    public int puntos() {

        return 1;

    }

    @Override
    public EstadoJuego truco() {

        return new TrucoCantado(this.estadoEnvido, this.estadoFlor);
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

        return estado instanceof JuegoEmpezado;

    }


}
