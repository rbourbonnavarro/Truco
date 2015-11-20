package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class PrimeraVuelta implements EstadoRonda {

    private EstadoJuego estadoJuego;

    public PrimeraVuelta(EstadoFlor estadoFlor) {

        this.estadoJuego = new NadaCantado(estadoFlor);

    }

    @Override
    public void truco() {

        this.estadoJuego = this.estadoJuego.truco();

    }

    @Override
    public void reTruco() {

        this.estadoJuego = this.estadoJuego.reTruco();

    }

    @Override
    public void valeCuatro() {

        this.estadoJuego = this.estadoJuego.valeCuatro();

    }

    @Override
    public void envido() {

        this.estadoJuego = this.estadoJuego.envido();

    }

    @Override
    public void envidoEnvido() {

        this.estadoJuego = this.estadoJuego.envidoEnvido();

    }

    @Override
    public void realEnvido() {

        this.estadoJuego = this.estadoJuego.realEnvido();

    }

    @Override
    public void faltaEnvido(Puntaje puntos) {

        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

    }

    @Override
    public void flor() {

        this.estadoJuego.flor();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        this.estadoJuego.contraFlorAlResto(puntos);

    }

    @Override
    public void contraFlorAlPartido() {

        this.estadoJuego.contraFlorAlPartido();

    }

    @Override
    public void terminarTanto() {

        this.estadoJuego = this.estadoJuego.terminarTanto();

    }

    @Override
    public void quiero() {

        this.estadoJuego = this.estadoJuego.quiero();

    }

    @Override
    public int puntos() {

        return this.estadoJuego.puntos();

    }

    @Override
    public int noQuerido() {

        return this.estadoJuego.noQuerido();

    }

    @Override
    public EstadoRonda terminarVuelta() {

        return new SegundaTerceraVuelta(this.estadoJuego);

    }


}
