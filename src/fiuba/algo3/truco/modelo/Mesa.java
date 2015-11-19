package fiuba.algo3.truco.modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import fiuba.algo3.truco.modelo.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Envido.EnvidoNoCantado;
import fiuba.algo3.truco.modelo.Envido.EstadoEnvido;
import fiuba.algo3.truco.modelo.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraRonda;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.EstadoFlor.FlorNoCantada;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.*;

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
    private EstadoFlor estadoFlor;
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
        this.estadoFlor = new FlorNoCantada();

        this.mazo = new Mazo();

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

        this.equipo1.setPie();
        this.equipo2.setPie();

        List<Jugador> jugadores = new ArrayList<>(this.equipo1.getIntegrantes());
        jugadores.addAll(this.equipo2.getIntegrantes());

        this.mazo.repartir(jugadores, this.calculadorTanto);

        this.resultadoGanadorVuelta = new GanadorVuelta(this.equipoActual, this.jugadorActual.obtenerCartas().get(0));

    }

    public List<Carta> getCartasDelJugadorActual(){
        return this.jugadorActual.obtenerCartas();
    }

    /*public void comenzarJuego() {



    }*/

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }
    
    public int puntaje(Equipo equipo){
    	return equipo.getPuntos();
    }

    public void hacerJugada(Carta carta) throws NoHayCartasParaJugar {

        try {

            this.cartasEnMesa.add(carta);
            this.jugadorActual.jugar(carta);

            if (this.cartasEnMesa.size() > 0) {

                this.resultadoGanadorVuelta = this.calcularGanadorJugada(carta, this.resultadoGanadorVuelta.getCarta());

            }

            this.terminarJugada();

            if (this.cartasEnMesa.size() == 2 * (this.equipoActual.getCantidadIntegrantes())) {

                this.terminarVuelta();

            }

        } catch(NullPointerException nullPointerException) {

            throw new NoHayCartasParaJugar();

        }

    }

    public void envido() {

    	if(this.ronda.sePuedeCantarEnvido()) throw new JugadorNoPuedeCantarTantoNoEsPrimeraRonda();
    	
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
        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoEnvido = this.estadoEnvido.faltaEnvido(puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void truco() {

        this.estadoTruco = estadoTruco.truco();
        this.intercambiarEquipos();

    }
    public void flor() {

    	this.estadoFlor = estadoFlor.flor();
        this.intercambiarEquipos();

    }

    public void contraFlorAlResto(){
        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoFlor = estadoFlor.contraFlorAlResto(puntosEnJuego);
        this.intercambiarEquipos();
    }

    private Puntaje obtenerMayorPuntaje() {
        return (this.equipoActual.getPuntos()>this.equipoContrario.getPuntos())?
                this.equipoActual.getPuntaje():this.equipoContrario.getPuntaje();
    }

    public void contraFlorAlPartido(){
    	this.estadoFlor = estadoFlor.contraFlorAlPartido();
        this.intercambiarEquipos();
    }

    public void retruco() {

    	this.estadoTruco = this.estadoTruco.reTruco();
        this.intercambiarEquipos();

    }

    public void valeCuatro() {

    	this.estadoTruco = this.estadoTruco.valeCuatro();
        this.intercambiarEquipos();

    }

    public void quieroTruco(boolean quiero) {

        if(!quiero) {

            this.ronda.agregarPuntosRonda(this.estadoTruco.noQuerido());

            this.ronda.setEquipoGanador(this.equipoContrario);

            this.ronda.terminar();

        }

        this.intercambiarEquipos();

    }

    public void quieroEnvido(boolean quiero) {

        if(!quiero) {

            this.equipoContrario.sumarPuntos(this.estadoEnvido.noQuerido());

        }
        else{

            this.obtenerGanadorEnvido().sumarPuntos(this.estadoEnvido.puntos());

        }
    }

    private Equipo obtenerGanadorEnvido() {

        return (this.equipoActual.calcularEnvido() > this.equipoContrario.calcularEnvido()) ? this.equipoActual : this.equipoContrario;

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

        this.ronda.agregarPuntosRonda(this.estadoTruco.puntos());

        try {

            this.ronda.terminar();

        } catch(LaRondaNoTerminoAunException laRondaNoTerminoAunException) {}

    }

    /*private void terminarRonda() {

        this.ronda.sumarPuntosEquipoGanador();

        //if(this.ronda.getEquipoGanador().getPuntos() >= 30) this.terminarJuego();

    }*/

    private GanadorVuelta calcularGanadorJugada(Carta cartaEquipoActual, Carta cartaEquipoContrario) {

        if(this.valoresTruco.rankingCarta(cartaEquipoActual) < this.valoresTruco.rankingCarta(cartaEquipoContrario))
            return new GanadorVuelta(this.equipoActual, cartaEquipoActual);
        else {
            if (this.valoresTruco.rankingCarta(cartaEquipoActual) > this.valoresTruco.rankingCarta(cartaEquipoContrario))
                return new GanadorVuelta(this.equipoContrario, cartaEquipoContrario);
            else
                return new Parda(cartaEquipoActual);

        }

    }
    public GanadorVuelta getGanadorVuelta (){
        return resultadoGanadorVuelta;
    }


}
