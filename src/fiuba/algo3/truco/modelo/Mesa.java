package fiuba.algo3.truco.modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import fiuba.algo3.truco.modelo.EnvidoYFlor.CalculadorTanto;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EnvidoNoCantado;
import fiuba.algo3.truco.modelo.EnvidoYFlor.EstadoEnvido;
import fiuba.algo3.truco.modelo.Truco.EstadoTruco;
import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;
import fiuba.algo3.truco.modelo.Truco.Parda;
import fiuba.algo3.truco.modelo.Truco.RetrucoCantado;
import fiuba.algo3.truco.modelo.Truco.TrucoCantado;
import fiuba.algo3.truco.modelo.Truco.TrucoNoCantado;
import fiuba.algo3.truco.modelo.Truco.ValeCuatroCantado;
import fiuba.algo3.truco.modelo.Truco.ValoresTruco;

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
    private Mazo mazo;

    public Mesa(Equipo equipo1, Equipo equipo2, CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;
        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.ronda= new Ronda();

        this.estadoTruco = new TrucoNoCantado();
        this.estadoEnvido = new EnvidoNoCantado();

        this.mazo = new Mazo();

    }

    public void comenzarJuego() throws SeNecesitanDosEquiposParaJugar {

    	if ((equipo1.getCantidadIntegrantes() == 0) || (equipo2.getCantidadIntegrantes() == 0)) {
    		throw new SeNecesitanDosEquiposParaJugar();
    	}else{
    		this.equipoActual = this.equipo1;
    		this.equipoContrario = this.equipo2;
    		this.jugadorActual = this.equipoActual.getJugadorActual();
    	}

        List<Jugador> jugadores = new ArrayList<>(this.equipo1.getIntegrantes());
        jugadores.addAll(this.equipo2.getIntegrantes());

        this.mazo.repartir(jugadores, this.calculadorTanto);

    }

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }
    
    private void intercambiarEquipos() {

        Equipo aux = this.equipoActual;
        this.equipoActual = this.equipoContrario;
        this.equipoContrario = aux;

        this.jugadorActual = this.equipoActual.getJugadorActual();

    }

    public void hacerJugada(Carta carta) throws NoHayCartasParaJugar {

    	if (carta == null){
    		throw new NoHayCartasParaJugar();
    	}else{
    		this.cartasEnMesa.add(carta);

    		if(this.cartasEnMesa.size() > 0)
    			this.resultadoGanadorVuelta = this.calcularGanadorJugada(carta, this.resultadoGanadorVuelta.getCarta());

    		this.terminarJugada();

    		if(this.cartasEnMesa.size() == 2*(this.equipoActual.getCantidadIntegrantes())) {

    			this.terminarVuelta();

    		}

    	}	

    }

    public void envido() {

        if(!this.jugadorActual.jugadorPie()) throw new JugadorNoPieNoPuedeCantarEnvido();

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

            this.ronda.setEquipoGanador(this.equipoContrario);

            this.terminarRonda();

        }

        this.intercambiarEquipos();

    }

    public void quieroEnvido(boolean quiero) {

        if(!quiero) {

            this.equipoContrario.sumarPuntos(this.estadoEnvido.noQuerido());

        }

        this.obtenerGanadorEnvido().sumarPuntos(this.estadoEnvido.puntos());

        this.intercambiarEquipos();

    }

    private Equipo obtenerGanadorEnvido() {

        return (this.equipoActual.calcularEnvido() > this.equipoContrario.calcularEnvido()) ? this.equipoActual : this.equipoContrario;

    }

    private void terminarJugada() {

        this.equipoActual.terminarJugada();

        this.intercambiarEquipos();

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

        //if(this.ronda.getEquipoGanador().getPuntos() >= 30) this.terminarJuego();

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
