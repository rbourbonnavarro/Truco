package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public abstract class Vuelta {

    protected EstadoJuego estadoJuego;
    protected Equipo equipoGanadorVuelta;
    protected Carta cartaGanadora;
    protected boolean seJuegaConFlor;
    protected Jugador jugadorGanadorVuelta;

    public Vuelta(boolean seJuegaConFlor) {

        this.seJuegaConFlor = seJuegaConFlor;

    }

    public void truco(Equipo equipoIniciador) {

        this.estadoJuego = this.estadoJuego.truco(equipoIniciador);

    }

    public void reTruco(Equipo equipoIniciador) {

        this.estadoJuego = this.estadoJuego.reTruco(equipoIniciador);

    }

    public void valeCuatro(Equipo equipoIniciador) {

        this.estadoJuego = this.estadoJuego.valeCuatro(equipoIniciador);

    }

    public abstract void envido(Equipo jugadorActual);

    public abstract void realEnvido(Equipo jugadorActual);

    public abstract void faltaEnvido(Equipo jugadorActual, Puntaje puntos);

    public abstract void flor(Equipo equipoActual);

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

    public Equipo getEquipoIniciador() {

        return this.estadoJuego.getEquipoIniciador();

    }


}
