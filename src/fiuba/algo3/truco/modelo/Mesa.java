package fiuba.algo3.truco.modelo;

import java.util.*;

import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeQuererFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Ronda.EstadoRonda;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;

public class Mesa {

    private EstadoRonda estadoRonda;
    private ValoresTruco valoresTruco;
    private Equipo equipo1;
    private Equipo equipo2;
    private Deque<Carta> cartasEnMesa;
    private Equipo equipoActual;
    private Equipo equipoContrario;
    private Jugador jugadorActual;
    private Equipo equipoIniciadorTruco;
    private Equipo equipoIniciadorEnvido;
    private Equipo equipoIniciadorFlor;
    private Mazo mazo;
    private boolean seJuegaConFlor;

    public Mesa(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        this.valoresTruco = new ValoresTruco();
        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.mazo = new Mazo();

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

        this.equipo1.setPie();
        this.equipo2.setPie();

        this.seJuegaConFlor = seJuegaConFlor;

        this.estadoRonda = new PrimeraVuelta(seJuegaConFlor, equipo1, equipo2,this.mazo);

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

            if (this.cartasEnMesa.size() == 2 * this.equipoActual.getCantidadIntegrantes() * this.estadoRonda.numeroVuelta()) {

                this.terminarVuelta();

            }

        } catch(NullPointerException nullPointerException) {

            throw new NoHayCartasParaJugar();

        }

    }

    public void envido() {
        this.guardarEquipoIniciadorEnvido();
        this.estadoRonda.envido(this.jugadorActual);

        this.intercambiarEquipos();

    }


    public void realEnvido() {
        this.guardarEquipoIniciadorEnvido();
        this.estadoRonda.realEnvido(this.jugadorActual);

        this.intercambiarEquipos();

    }

    public void faltaEnvido() {
        this.guardarEquipoIniciadorEnvido();
        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoRonda.faltaEnvido(this.jugadorActual, puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void truco() {
        this.guardarEquipoIniciadorTruco();
        this.estadoRonda.truco();
        this.intercambiarEquipos();

    }

    public void flor() {
        this.guardarEquipoIniciadorFlor();
        this.equipoActual.flor();
    	this.estadoRonda.flor();
        this.intercambiarEquipos();

    }

    public void contraFlorAlResto(){

        this.equipoActual.flor();

        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoRonda.contraFlorAlResto(puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void contraFlorAlPartido(){

        this.equipoActual.flor();

        this.estadoRonda.contraFlorAlPartido();
        this.intercambiarEquipos();

    }

    private Puntaje obtenerMayorPuntaje() {

        return (this.equipoActual.getPuntos()>this.equipoContrario.getPuntos())?
                this.equipoActual.getPuntaje():this.equipoContrario.getPuntaje();

    }

    public void retruco() {

    	this.estadoRonda.reTruco();
        this.intercambiarEquipos();

    }

    public void valeCuatro() {

    	this.estadoRonda.valeCuatro();
        this.intercambiarEquipos();

    }

    public void quieroTruco() {

        this.estadoRonda.quiero();
        this.recuperarEquipoActualTruco();

    }

    public void noQuieroTruco() {

        this.estadoRonda = this.estadoRonda.terminar(this.equipoContrario,estadoRonda.noQuerido(),this);
    }

    public void quieroEnvido() {

        this.obtenerGanadorEnvido().sumarPuntos(this.estadoRonda.puntos());
        this.estadoRonda.terminarTanto();

        this.recuperarEquipoActualEnvido();

    }

    public void noQuieroEnvido(){

        this.equipoContrario.sumarPuntos(this.estadoRonda.noQuerido());
        this.estadoRonda.terminarTanto();

        this.recuperarEquipoActualEnvido();

    }

    public void quieroFlor() {

        this.obtenerGanadorFlor().sumarPuntos(this.estadoRonda.puntos());

        this.estadoRonda.terminarTanto();

        this.recuperarEquipoActualFlor();

    }

    public void noQuieroFlor() {

        this.equipoContrario.sumarPuntos(this.estadoRonda.noQuerido());

        this.estadoRonda.terminarTanto();

        this.recuperarEquipoActualFlor();

    }

    private Equipo obtenerGanadorEnvido() {

        return (this.equipoActual.calcularEnvido() > this.equipoContrario.calcularEnvido()) ? this.equipoActual : this.equipoContrario;

    }

    private Equipo obtenerGanadorFlor() {

        return (this.equipoActual.calcularFlor() > this.equipoContrario.calcularFlor()) ? this.equipoActual : this.equipoContrario;

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

        this.estadoRonda = this.estadoRonda.terminarVuelta(this);

    }

    public Equipo getGanadorVuelta() {

        return this.estadoRonda.getGanadorVuelta();

    }

    private void recuperarEquipoActualTruco() {

        if(Objects.equals(this.equipoIniciadorTruco.getNombre(), this.equipoContrario.getNombre())) {
            this.intercambiarEquipos();
        }
        this.equipoIniciadorTruco = null;
    }

    private void guardarEquipoIniciadorTruco() {
        if(this.equipoIniciadorTruco == null)
            this.equipoIniciadorTruco = this.equipoActual;
    }

    private void recuperarEquipoActualEnvido() {

        if(Objects.equals(this.equipoIniciadorEnvido.getNombre(), this.equipoContrario.getNombre())) {
            this.intercambiarEquipos();
        }
        this.equipoIniciadorEnvido = null;
    }

    private void guardarEquipoIniciadorEnvido() {
        if(this.equipoIniciadorEnvido == null)
            this.equipoIniciadorEnvido = this.equipoActual;
    }

    private void recuperarEquipoActualFlor() {

        if(Objects.equals(this.equipoIniciadorFlor.getNombre(), this.equipoContrario.getNombre())) {
            this.intercambiarEquipos();
        }
        this.equipoIniciadorFlor = null;
    }

    private void guardarEquipoIniciadorFlor() {
        if(this.equipoIniciadorFlor == null)
            this.equipoIniciadorFlor = this.equipoActual;
    }

    public EstadoRonda terminarRonda() {
        this.cartasEnMesa = new ArrayDeque<>();
        this.intercambiarEquipos();
        return new PrimeraVuelta(this.seJuegaConFlor,this.equipo1,this.equipo2,this.mazo);
    }
}
