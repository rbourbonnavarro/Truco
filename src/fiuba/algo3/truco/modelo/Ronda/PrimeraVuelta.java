package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantadoTantoNoJugado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class PrimeraVuelta extends Vuelta {

    public PrimeraVuelta(boolean seJuegaConFlor, Equipo equipo1, Equipo equipo2, Mazo mazo) {

        super(seJuegaConFlor);
        
        this.estadoJuego = new NadaCantado();

        List<Jugador> jugadores = new ArrayList<>(equipo1.getIntegrantes());
        jugadores.addAll(equipo2.getIntegrantes());

        mazo.repartir(jugadores);

    }

    @Override
    public void envido(Equipo equipoIniciador) {

        if(!equipoIniciador.getJugadorActual().jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantadoTantoNoJugado
                    || this.estadoJuego instanceof EnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.envido(equipoIniciador);

    }


    @Override
    public void realEnvido(Equipo equipoIniciador) {

        if(!equipoIniciador.getJugadorActual().jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantadoTantoNoJugado
                    || this.estadoJuego instanceof EnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.realEnvido(equipoIniciador);

    }

    @Override
    public void faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        if(!equipoIniciador.getJugadorActual().jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantadoTantoNoJugado
                    || this.estadoJuego instanceof EnvidoCantado
                    || this.estadoJuego instanceof RealEnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.faltaEnvido(equipoIniciador, puntos);

    }

    @Override
    public void flor(Equipo equipoIniciador) {

        if(!this.seJuegaConFlor) throw new JuegoSinFlorException();

        this.estadoJuego = this.estadoJuego.flor(equipoIniciador);

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
    public Vuelta terminarVuelta(Mesa mesa) {

        return new SegundaVuelta(this.estadoJuego, this.equipoGanadorVuelta, this.seJuegaConFlor);

    }

    @Override
    public Equipo getEquipoGanadorRonda() {

        return this.equipoGanadorVuelta;

    }

    @Override
    public int numeroVuelta() {

        return 1;

    }



}
