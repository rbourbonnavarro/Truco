package fiuba.algo3.truco.modelo.Jugada.EstadoFlor;

import fiuba.algo3.truco.modelo.Jugada.Envido.*;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;


public class FlorCantada implements EstadoFlor {
    @Override
    public int puntos() {
        return 3;
    }

    @Override
    public int noQuerido() {
        throw new NoSePuedeNoQuererFlorException();
    }

    @Override
    public EstadoFlor flor() {
        return new FlorFlorCantada();
    }

    @Override
    public EstadoFlor contraFlorAlResto(Puntaje puntos) {
        return new ContraFlorAlRestoCantada(puntos,this.puntos());
    }

    @Override
    public EstadoFlor contraFlorAlPartido() {
        return new ContraFlorAlPartidoCantado();
    }
    @Override
    public boolean equals(Object estado) {
        return estado instanceof FlorCantada;
    }
    @Override
    public EstadoEnvido envido(EstadoEnvido envido) {
        throw new NoSePuedeCantarEnvido();
    }
    @Override
    public EstadoEnvido envidoEnvido(EstadoEnvido estado){
        throw new NoSePuedeCantarEnvidoEnvido();
    }

    @Override
    public EstadoEnvido realEnvido(EstadoEnvido envido) {
        throw new NoSePuedeCantarRealEnvido();
    }

    @Override
    public EstadoEnvido faltaEnvido(EstadoEnvido envido, Puntaje puntos) {
        throw new NoSePuedeCantarFaltaEnvido();
    }


}
