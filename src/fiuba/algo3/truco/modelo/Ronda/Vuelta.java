package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public abstract class Vuelta {

    protected EstadoJuego estadoJuego;
    protected Equipo ganadorVuelta;
    protected Carta cartaGanadora;
    protected boolean seJuegaConFlor;

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

            if(this.cartaGanadora.truco(carta) < 0) {

                this.ganadorVuelta = equipoActual;
                this.cartaGanadora = carta;

            } else {

                if(this.cartaGanadora.truco(carta) > 0) {

                    this.ganadorVuelta = equipoContrario;

                } else {

                    this.ganadorVuelta = null;

                }

            }

        } catch(NullPointerException nullPointerException) {

            this.cartaGanadora = carta;

        }

    }

    public abstract Equipo getGanadorVuelta();

    public abstract int numeroVuelta();

    public void estadoValido() {

        this.estadoJuego.estadoValido();

    }


}
