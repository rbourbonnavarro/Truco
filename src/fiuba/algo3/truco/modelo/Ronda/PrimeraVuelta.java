package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrimeraVuelta implements EstadoRonda {

    private EstadoJuego estadoJuego;
    private Equipo ganadorPrimera;
    private Carta cartaGanadora;
    private boolean seJuegaConFlor;

    public PrimeraVuelta(boolean seJuegaConFlor, Equipo equipo1, Equipo equipo2, Mazo mazo) {

        this.estadoJuego = new NadaCantado();
        this.seJuegaConFlor = seJuegaConFlor;

        List<Jugador> jugadores = new ArrayList<>(equipo1.getIntegrantes());
        jugadores.addAll(equipo2.getIntegrantes());

        mazo.repartir(jugadores);

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
    public void envido(Jugador jugadorActual) {

        if(!jugadorActual.jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.envido();

    }


    @Override
    public void realEnvido(Jugador jugadorActual) {

        if(!jugadorActual.jugadorPie()) throw new JugadorNoPieNoPuedeCantarEnvido();

        this.estadoJuego = this.estadoJuego.realEnvido();

    }

    @Override
    public void faltaEnvido(Jugador jugadorActual, Puntaje puntos) {

        if(!jugadorActual.jugadorPie()) throw new JugadorNoPieNoPuedeCantarEnvido();

        this.estadoJuego = this.estadoJuego.faltaEnvido(puntos);

    }

    @Override
    public void flor() {

        if(!this.seJuegaConFlor) throw new JuegoSinFlorException();

        this.estadoJuego = this.estadoJuego.flor();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        if(!this.seJuegaConFlor) throw new JuegoSinFlorException();

        this.estadoJuego = this.estadoJuego.contraFlorAlResto(puntos);

    }

    @Override
    public void contraFlorAlPartido() {

        if(!this.seJuegaConFlor) throw new JuegoSinFlorException();

        this.estadoJuego = this.estadoJuego.contraFlorAlPartido();

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
    public EstadoRonda terminarVuelta(Mesa mesa) {

        return new SegundaVuelta(this.estadoJuego, this.ganadorPrimera, this.seJuegaConFlor);

    }

    @Override
    public void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta) {

        try {

            if(this.cartaGanadora.truco(carta) < 0) {

                this.ganadorPrimera = equipoActual;
                this.cartaGanadora = carta;

            } else {

                if(this.cartaGanadora.truco(carta) > 0) {

                    this.ganadorPrimera = equipoContrario;

                } else {

                    this.ganadorPrimera = null;

                }

            }

        } catch(NullPointerException nullPointerException) {

            this.cartaGanadora = carta;

        }

    }

    @Override
    public EstadoRonda terminar(Equipo equipoGanador, int puntos, Mesa mesa) {

        equipoGanador.sumarPuntos(puntos);

        return mesa.terminarRonda();

    }

    @Override
    public Equipo getGanadorVuelta() {

        return null;

    }

    @Override
    public int numeroVuelta() {
        return 1;
    }


}
