package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.EnvidoYFlor.*;
import fiuba.algo3.truco.modelo.Truco.*;

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
    private EstadoEnvido estadoEnvido;
    private EstadoTruco estadoTruco;

    public Mesa(Equipo equipo1, Equipo equipo2, CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;
        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.ronda= new Ronda();

        this.estadoTruco = new TrucoNoCantado();
        this.estadoEnvido = new EnvidoNoCantado();

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

    public void envido() {

        this.estadoEnvido = this.estadoEnvido.envido();

        this.intercambiarEquipos();

    }

    public void envidoEnvido() {

        this.estadoEnvido =this.estadoEnvido.envidoEnvido();

        this.intercambiarEquipos();

    }

    public void realEnvido() {

        this.estadoEnvido = this.estadoEnvido.realEnvido();

        this.intercambiarEquipos();

    }

    public void faltaEnvido() {

        this.estadoEnvido = this.estadoEnvido.faltaEnvido(this.equipoContrario.getPuntaje());

        this.intercambiarEquipos();

    }

    public void truco() {

        if(!this.estadoTruco.sePuedeCantarTruco()) throw new NoSePuedeCantarTrucoException();

        this.estadoTruco = new TrucoCantado();

        this.intercambiarEquipos();

    }

    public void retruco() {

        if(!this.estadoTruco.sePuedeCantarRetruco()) throw new NoSePuedeCantarRetrucoException();

        this.estadoTruco = new RetrucoCantado();

        this.intercambiarEquipos();

    }

    public void valeCuatro() {

        if(!this.estadoTruco.sePuedeCantarValeCuatro()) throw new NoSePuedeCantarValeCuatroException();

        this.estadoTruco = new ValeCuatroCantado();

        this.intercambiarEquipos();

    }

    public void quieroTruco(boolean quiero) {

        if(!quiero) {

            this.ronda.agregarPuntosRonda(this.estadoTruco.noQuerido());

            this.terminarRonda();

        }

        this.intercambiarEquipos();

    }

    public void quieroEnvido(boolean quiero) {

        if(!quiero) {

            this.ronda.agregarPuntosRonda(this.estadoEnvido.noQuerido());

        }

        //this.obtenerGanadorEnvido();

    }

    private void terminarJugada() {

        this.equipoActual.terminarJugada();

        this.intercambiarEquipos();

    }

    private void intercambiarEquipos() {

        Equipo aux = this.equipoActual;
        this.equipoActual = this.equipoContrario;
        this.equipoContrario = aux;

        this.jugadorActual = this.equipoActual.getJugadorActual();

    }

    private void terminarVuelta() {

        this.ronda.setGanadorVuelta(this.resultadoGanadorVuelta);

        if(this.ronda.finalRonda()) {

            this.ronda.agregarPuntosRonda(this.estadoTruco.puntos());

            this.terminarRonda();

        }

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
