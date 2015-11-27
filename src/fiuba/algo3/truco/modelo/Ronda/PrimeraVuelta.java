package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Flor.JuegoSinFlorException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;

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

            if(!(this.estadoJuego instanceof TrucoCantado
                    || this.estadoJuego instanceof EnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.envido(equipoIniciador);

    }


    @Override
    public void realEnvido(Jugador jugadorActual) {

        if(!jugadorActual.jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantado
                    || this.estadoJuego instanceof EnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

        this.estadoJuego = this.estadoJuego.realEnvido();

    }

    @Override
    public void faltaEnvido(Jugador jugadorActual, Puntaje puntos) {

        if(!jugadorActual.jugadorPie()) {

            if(!(this.estadoJuego instanceof TrucoCantado
                    || this.estadoJuego instanceof EnvidoCantado
                    || this.estadoJuego instanceof RealEnvidoCantado)) {

                throw new JugadorNoPieNoPuedeCantarEnvido();

            }

        }

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
    public Vuelta terminarVuelta(Mesa mesa) {

        return new SegundaVuelta(this.estadoJuego, this.equipoGanadorVuelta, this.seJuegaConFlor);

    }

    @Override
    public Equipo getEquipoGanadorVuelta() {

        return this.equipoGanadorVuelta;

    }

    @Override
    public int numeroVuelta() {

        return 1;

    }



}
