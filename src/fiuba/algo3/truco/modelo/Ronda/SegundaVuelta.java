package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class SegundaVuelta extends Vuelta {

    private List<Equipo> ganadoresVuelta;

    public SegundaVuelta(EstadoJuego estadoJuego, Equipo ganadorPrimera, boolean seJuegaConFlor) {

        super(seJuegaConFlor);

        this.estadoJuego = estadoJuego;
        this.ganadoresVuelta = new ArrayList<>();
        this.ganadoresVuelta.add(ganadorPrimera);

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
    public void terminarTanto() {

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
    public Vuelta terminarVuelta(Mesa mesa) {

        try {

            if (ganadoresVuelta.get(0) == equipoGanadorVuelta) {

                this.equipoGanadorVuelta.sumarPuntos(this.estadoJuego.puntos());

                return mesa.terminarRonda();

            }

            if (ganadoresVuelta.get(0) == null && this.equipoGanadorVuelta != null) {

                this.equipoGanadorVuelta.sumarPuntos(this.estadoJuego.puntos());

                return mesa.terminarRonda();

            }

            if (ganadoresVuelta.get(0) != null && this.equipoGanadorVuelta == null) {

                this.ganadoresVuelta.get(0).sumarPuntos(this.estadoJuego.puntos());

                return mesa.terminarRonda();

            }

        } catch(NullPointerException ignored) {}

        this.ganadoresVuelta.add(this.equipoGanadorVuelta);

        return new TerceraVuelta(this.estadoJuego, this.ganadoresVuelta, this.seJuegaConFlor);

    }

    @Override
    public Equipo getEquipoGanadorVuelta() {

        return this.equipoGanadorVuelta;

    }

    @Override
    public int numeroVuelta() {

        return 2;

    }



}
