package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraVuelta;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class TerceraVuelta extends Vuelta {

    private List<Equipo> ganadoresVuelta;

    public TerceraVuelta(EstadoJuego estadoJuego, List<Equipo> ganadoresVuelta, boolean seJuegaConFlor) {

        super(seJuegaConFlor);

        this.estadoJuego = estadoJuego;
        this.ganadoresVuelta = new ArrayList<>(ganadoresVuelta);

    }

    @Override
    public void envido(Jugador jugadorActual) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void realEnvido(Jugador jugadorActual) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void faltaEnvido(Jugador jugadorActual, Puntaje puntos) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void flor() {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void contraFlorAlPartido() {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public Vuelta terminarVuelta(Mesa mesa) {

        try {

            this.ganadorVuelta.sumarPuntos(this.estadoJuego.puntos());

        } catch(NullPointerException nullPointerException) {

            try {

                this.ganadoresVuelta.get(0).sumarPuntos(this.estadoJuego.puntos());

            } catch(NullPointerException e) {}

        }

        return mesa.terminarRonda();

    }

    @Override
    public Equipo getGanadorVuelta() {

        return this.ganadoresVuelta.get(1);

    }

    @Override
    public int numeroVuelta() {

        return 3;

    }


}
