package fiuba.algo3.truco.modelo;

import java.util.*;

import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Truco.*;

public class Mesa {

    private EstadoRonda estadoRonda;
    private ValoresTruco valoresTruco;
    private Equipo equipo1;
    private Equipo equipo2;
    private Deque<Carta> cartasEnMesa;
    private Equipo equipoActual;
    private Equipo equipoContrario;
    private Jugador jugadorActual;
    private Ronda ronda;
    private Mazo mazo;

    public Mesa(Equipo equipo1, Equipo equipo2, EstadoFlor estadoRonda) {

        this.estadoRonda = new PrimeraVuelta(estadoRonda);
        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.ronda= new Ronda();

        this.mazo = new Mazo();

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

        this.equipo1.setPie();
        this.equipo2.setPie();

        List<Jugador> jugadores = new ArrayList<>(this.equipo1.getIntegrantes());
        jugadores.addAll(this.equipo2.getIntegrantes());

        this.mazo.repartir(jugadores);

    }

    public List<Carta> getCartasDelJugadorActual(){

        return this.jugadorActual.obtenerCartas();

    }

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

            this.estadoRonda.calcularGanadorJugada(this.equipoActual, this.equipoContrario, carta);

            this.terminarJugada();

            if (this.cartasEnMesa.size() == 2 * (this.equipoActual.getCantidadIntegrantes())) {

                this.terminarVuelta();

            }

        } catch(NullPointerException nullPointerException) {

            throw new NoHayCartasParaJugar();

        }

    }

    public void envido() {
    	
        if(!this.jugadorActual.jugadorPie()) throw new JugadorNoPieNoPuedeCantarEnvido();

        this.estadoRonda.envido();

        this.intercambiarEquipos();

    }

    public void envidoEnvido() {

        this.estadoRonda.envidoEnvido();

        this.intercambiarEquipos();

    }

    public void realEnvido() {

        this.estadoRonda.realEnvido();

        this.intercambiarEquipos();

    }

    public void faltaEnvido() {

        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoRonda.faltaEnvido(puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void truco() {

        estadoRonda.truco();
        this.intercambiarEquipos();

    }
    public void flor() {

    	estadoRonda.flor();
        this.intercambiarEquipos();

    }

    public void contraFlorAlResto(){

        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoRonda.contraFlorAlResto(puntosEnJuego);
        this.intercambiarEquipos();
    }

    private Puntaje obtenerMayorPuntaje() {

        return (this.equipoActual.getPuntos()>this.equipoContrario.getPuntos())?
                this.equipoActual.getPuntaje():this.equipoContrario.getPuntaje();

    }

    public void contraFlorAlPartido(){

    	this.estadoRonda.contraFlorAlPartido();
        this.intercambiarEquipos();

    }

    public void retruco() {

    	this.estadoRonda.reTruco();
        this.intercambiarEquipos();

    }

    public void valeCuatro() {

    	this.estadoRonda.valeCuatro();
        this.intercambiarEquipos();

    }

    public void quieroTruco(boolean quiero) {

        if(!quiero) {

            this.estadoRonda = this.estadoRonda.terminar(this.equipoContrario, this.estadoRonda.noQuerido());

            return;

        }

        this.estadoRonda.quiero();

        this.intercambiarEquipos();

    }

    public void quieroEnvido(boolean quiero) {

        if(!quiero) {

            this.equipoContrario.sumarPuntos(this.estadoRonda.noQuerido());

        }
        else{

            this.obtenerGanadorEnvido().sumarPuntos(this.estadoRonda.puntos());

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

        this.estadoRonda = this.estadoRonda.terminarVuelta();

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
    public Equipo getGanadorVuelta() {

        return this.estadoRonda.getGanadorVuelta();

    }


}
