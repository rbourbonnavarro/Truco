package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;
import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;
import fiuba.algo3.truco.modelo.Truco.Parda;
import fiuba.algo3.truco.modelo.Truco.ValoresTruco;

import java.util.ArrayDeque;
import java.util.Deque;

public class Mesa {

    private CalculadorTanto calculadorTanto;
    private ValoresTruco valoresTruco;
    private Equipo equipo1;
    private Equipo equipo2;
    private Deque<Carta> cartasEnMesa;
    private Equipo equipoActual;
    private Equipo equipoContrario;
    private Jugador jugadorActual;
    private GanadorVuelta resultadoGanadorVuelta;
    private Ronda ronda;

    public Mesa(Equipo equipo1, Equipo equipo2, CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;
        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.ronda= new Ronda();

    }

    public void comenzarJuego() {

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

    }

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }

    public void hacerJugada(Carta carta) {

        this.cartasEnMesa.add(carta);

        if(this.cartasEnMesa.size() > 0)
            this.resultadoGanadorVuelta = this.calcularGanadorJugada(carta, this.resultadoGanadorVuelta.getCarta());

        this.terminarJugada();

        if(this.cartasEnMesa.size() == 2*(this.equipoActual.getCantidadIntegrantes())) {

            this.terminarVuelta();

        }


    }

    private void terminarJugada() {

        this.equipoActual.terminarJugada();

        Equipo aux = this.equipoActual;
        this.equipoActual = this.equipoContrario;
        this.equipoContrario = aux;

        this.jugadorActual = this.equipoActual.getJugadorActual();

    }


    private void terminarVuelta() {

        this.ronda.setGanadorVuelta(this.resultadoGanadorVuelta);

        if(this.ronda.finalRonda()) this.terminarRonda();

    }

    private void terminarRonda() {

        this.ronda.sumarPuntosEquipoGanador();

    }

    private GanadorVuelta calcularGanadorJugada(Carta cartaEquipoActual, Carta cartaEquipoContrario) {

        if(this.valoresTruco.rankingCarta(cartaEquipoActual) > this.valoresTruco.rankingCarta(cartaEquipoContrario))
            return new GanadorVuelta(this.equipoActual, cartaEquipoActual);
        else {
            if (this.valoresTruco.rankingCarta(cartaEquipoActual) < this.valoresTruco.rankingCarta(cartaEquipoContrario))
                return new GanadorVuelta(this.equipoContrario, cartaEquipoContrario);
            else
                return new Parda(cartaEquipoActual);

        }

    }


}
