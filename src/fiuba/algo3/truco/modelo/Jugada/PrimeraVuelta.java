package fiuba.algo3.truco.modelo.Jugada;

import fiuba.algo3.truco.modelo.Jugada.Envido.EnvidoNoCantado;
import fiuba.algo3.truco.modelo.Jugada.Envido.EstadoEnvido;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Jugada.EstadoFlor.FlorNoCantada;
import fiuba.algo3.truco.modelo.Jugada.Truco.EstadoTruco;
import fiuba.algo3.truco.modelo.Jugada.Truco.TrucoCantado;
import fiuba.algo3.truco.modelo.Jugada.Truco.TrucoNoCantado;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.JugadorNoPieNoPuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

/**
 * Created by fedemgp on 20/11/15.
 */
public class PrimeraVuelta implements EstadoVuelta {
    EstadoTruco truco;
    EstadoEnvido envido;
    EstadoFlor flor;

    public PrimeraVuelta(){
        truco = new TrucoNoCantado();
        envido = new EnvidoNoCantado();
        flor = new FlorNoCantada();
    }
    @Override
    public void truco() {
        this.truco = truco.truco();
    }

    @Override
    public void reTruco() {
        this.truco = truco.reTruco();
    }

    @Override
    public void valeCuatro() {
        this.truco = truco.valeCuatro();
    }

    @Override
    public void envido(Jugador jugadorActual) {
        if(!jugadorActual.jugadorPie())
            if(this.truco instanceof TrucoCantado)
                this.envido = this.flor.envido(this.envido);
            else
                throw new JugadorNoPieNoPuedeCantarEnvido();
        else
            this.envido = this.flor.envido(this.envido);

    }
    @Override
    public void envidoEnvido(){
        this.envido = this.flor.envidoEnvido(this.envido);
    }

    @Override
    public void realEnvido() {
        this.envido = this.flor.realEnvido(this.envido);
    }

    @Override
    public void faltaEnvido(Puntaje puntos) {
        this.envido = this.flor.faltaEnvido(this.envido, puntos);
    }

    @Override
    public void flor() {
        this.flor = this.flor.flor();
    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {
        this.flor = this.flor.contraFlorAlResto(puntos);
    }

    @Override
    public void contraFlorAlPartido() {
        this.flor = this.flor.contraFlorAlPartido();
    }

    @Override
    public int trucoNoQuerido() {
        return this.truco.noQuerido();
    }

    @Override
    public int envidoNoQuerido() {
        return this.envido.noQuerido();
    }

    @Override
    public int envidoQuerido() {
        return this.envido.puntos();
    }

    @Override
    public int TrucoQuerido() {
        return this.truco.puntos();
    }
}
