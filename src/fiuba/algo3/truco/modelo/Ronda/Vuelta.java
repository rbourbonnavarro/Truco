package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.List;

public abstract class Vuelta {

    protected EstadoJuego estadoJuego;
    protected Equipo equipoGanadorVuelta;
    protected Carta cartaGanadora;
    protected boolean seJuegaConFlor;
    protected Jugador jugadorGanadorVuelta;

    public Vuelta(boolean seJuegaConFlor) {

        this.seJuegaConFlor = seJuegaConFlor;

    }

    public void truco() {

        this.estadoJuego = this.estadoJuego.truco();

    }

    public void reTruco() {

        this.estadoJuego = this.estadoJuego.reTruco();

    }

    public void valeCuatro() {

        this.estadoJuego = this.estadoJuego.valeCuatro();

    }

    public abstract void envido(Jugador jugadorActual);

    public abstract void realEnvido(Jugador jugadorActual);

    public abstract void faltaEnvido(Jugador jugadorActual, Puntaje puntos);

    public abstract void flor();

    public abstract void contraFlorAlResto(Puntaje puntos);

    public abstract void contraFlorAlPartido();

    public void terminarTanto() {

        this.estadoJuego = this.estadoJuego.terminarTanto();

    }

    public void quiero() {

        this.estadoJuego = this.estadoJuego.quiero();

    }

    public int puntos() {

        return this.estadoJuego.puntos();

    }

    public int noQuerido() {

        return this.estadoJuego.noQuerido();

    }

    public abstract Vuelta terminarVuelta(Mesa mesa);

    public void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta) {

        try {

            int cartaDominante = this.cartaGanadora.truco(carta);

            if(cartaDominante < 0) {

                this.equipoGanadorVuelta = equipoActual;
                this.jugadorGanadorVuelta = this.equipoGanadorVuelta.getJugadorActual();
                this.cartaGanadora = carta;

            }

            if(cartaDominante == 0) {

                this.equipoGanadorVuelta = null;
                this.jugadorGanadorVuelta = null;

            }

        } catch(NullPointerException nullPointerException) {

            this.cartaGanadora = carta;
            this.equipoGanadorVuelta = equipoActual;
            this.jugadorGanadorVuelta = equipoActual.getJugadorActual();

        }

    }

    public abstract Equipo getEquipoGanadorVuelta();

    public abstract int numeroVuelta();

    public void estadoValido() {

        this.estadoJuego.estadoValido();

    }

    public Jugador getJugadorGanadorVuelta() {

        return this.jugadorGanadorVuelta;

    }

    public EstadoJuego getEstadoJuego() {

        return this.estadoJuego;

    }




}
