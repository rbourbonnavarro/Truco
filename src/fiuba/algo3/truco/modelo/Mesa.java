package fiuba.algo3.truco.modelo;

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
    private Equipo ganadorRonda;

    public Mesa(Equipo equipo1, Equipo equipo2, CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;
        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<Carta>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

    }

    public void comenzarJuego() {

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

    }

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }

    public void terminarJugada(Carta carta) {

        this.cartasEnMesa.add(carta);

        this.ganadorRonda = this.calcularGanadorJugada(carta, this.cartasEnMesa.getLast());

       /* if(this.cartasEnMesa.size() == 2*(this.equipoActual.getCantidadIntegrantes()) {



        }*/

    }

    private Equipo calcularGanadorJugada(Carta cartaEquipoActual, Carta cartaEquipoContrario) {

        if(this.valoresTruco.rankingCarta(cartaEquipoActual) > this.valoresTruco.rankingCarta(cartaEquipoContrario))
            return this.equipoActual;
        else {
            if (this.valoresTruco.rankingCarta(cartaEquipoActual) < this.valoresTruco.rankingCarta(cartaEquipoContrario))
                return this.equipoContrario;


        }

        return this.equipo1;

    }


}
