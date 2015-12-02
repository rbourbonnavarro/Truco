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
    public void envido(Equipo equipoIniciador) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void realEnvido(Equipo equipoIniciador) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void flor(Equipo equipoIniciador) {

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

            this.equipoGanadorVuelta.sumarPuntos(this.estadoJuego.puntos());

            mesa.setEquipoGanadorRonda(equipoGanadorVuelta);

        } catch(NullPointerException nullPointerException) {

            try {

                this.ganadoresVuelta.get(0).sumarPuntos(this.estadoJuego.puntos());

                mesa.setEquipoGanadorRonda(this.ganadoresVuelta.get(0));

            } catch(NullPointerException e) {

                mesa.setEquipoGanadorRonda(mesa.getEquipoActual());

                mesa.getEquipoActual().sumarPuntos(this.estadoJuego.puntos());

            }

        }

        return mesa.terminarRonda();

    }

    @Override
    public Equipo getEquipoGanadorRonda() {

        return this.ganadoresVuelta.get(1);

    }

    @Override
    public int numeroVuelta() {

        return 3;

    }


}
