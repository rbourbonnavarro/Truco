package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeQuererFlorException;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import fiuba.algo3.truco.modelo.Ronda.Vuelta;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class Mesa {

    private Vuelta estadoVuelta;
    private Equipo equipo1;
    private Equipo equipo2;
    private Deque<Carta> cartasEnMesa;
    private Equipo equipoActual;
    private Equipo equipoContrario;
    private Jugador jugadorActual;
    private Equipo equipoIniciadorTruco;
    private Equipo equipoIniciadorEnvido;
    private Equipo equipoIniciadorFlor;
    private Equipo equipoGanador;
    private Mazo mazo;
    private boolean seJuegaConFlor;

    public Mesa(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.equipo1.setOrdenMesa(0);
        this.equipo2.setOrdenMesa(1);

        this.mazo = new Mazo();

        this.equipoActual = this.equipo1;
        this.equipoContrario = this.equipo2;
        this.jugadorActual = this.equipoActual.getJugadorActual();

        this.equipo1.setPie();
        this.equipo2.setPie();

        this.seJuegaConFlor = seJuegaConFlor;

        this.estadoVuelta = new PrimeraVuelta(seJuegaConFlor, equipo1, equipo2, this.mazo);

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

        this.estadoVuelta.estadoValido();

        try {

            this.cartasEnMesa.add(carta);
            this.jugadorActual.jugar(carta);

            this.estadoVuelta.calcularGanadorJugada(this.equipoActual, this.equipoContrario, carta);

            this.terminarJugada();

            if (this.cartasEnMesa.size() == 2 * this.equipoActual.getCantidadIntegrantes() * this.estadoVuelta.numeroVuelta()) {

                this.terminarVuelta();

            }

        } catch(NullPointerException nullPointerException) {

            throw new NoHayCartasParaJugar();

        }

    }

    public void envido() {

        this.guardarEquipoIniciadorEnvido();
        this.estadoVuelta.envido(this.jugadorActual);

        this.intercambiarEquipos();

    }


    public void realEnvido() {

        this.guardarEquipoIniciadorEnvido();
        this.estadoVuelta.realEnvido(this.jugadorActual);

        this.intercambiarEquipos();

    }

    public void faltaEnvido() {

        this.guardarEquipoIniciadorEnvido();
        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoVuelta.faltaEnvido(this.jugadorActual, puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void truco() {

        this.guardarEquipoIniciadorTruco();
        this.estadoVuelta.truco();
        this.intercambiarEquipos();

    }

    public void flor() {

        this.guardarEquipoIniciadorFlor();
        this.equipoActual.flor();
    	this.estadoVuelta.flor();
        this.intercambiarEquipos();

    }

    public void contraFlorAlResto(){

        this.equipoActual.flor();

        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoVuelta.contraFlorAlResto(puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void contraFlorAlPartido(){

        this.equipoActual.flor();

        this.estadoVuelta.contraFlorAlPartido();
        this.intercambiarEquipos();

    }

    private Puntaje obtenerMayorPuntaje() {

        return (this.equipoActual.getPuntos()>this.equipoContrario.getPuntos())?
                this.equipoActual.getPuntaje():this.equipoContrario.getPuntaje();

    }

    public void retruco() {

    	this.estadoVuelta.reTruco();
        this.intercambiarEquipos();

    }

    public void valeCuatro() {

    	this.estadoVuelta.valeCuatro();
        this.intercambiarEquipos();

    }

    public void quieroTruco() {

        this.estadoVuelta.quiero();
        this.recuperarEquipoActualTruco();

    }

    public void noQuieroTruco() {

        try {

            this.equipoContrario.sumarPuntos(this.estadoVuelta.noQuerido());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanador = this.equipoContrario;

        }

        this.equipoActual.terminarJugada();

        this.estadoVuelta = this.terminarRonda();

    }

    public void quieroEnvido() {

        this.estadoVuelta.quiero();

        try {

            this.obtenerGanadorEnvido().sumarPuntos(this.estadoVuelta.puntos());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanador = this.obtenerGanadorEnvido();

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoActualEnvido();

    }

    public void noQuieroEnvido(){

        try {

            this.equipoContrario.sumarPuntos(this.estadoVuelta.noQuerido());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanador = this.equipoContrario;

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoActualEnvido();

    }

    public void quieroFlor() {

        try {

            this.estadoVuelta.quiero();

            try {

                this.obtenerGanadorFlor().sumarPuntos(this.estadoVuelta.puntos());

            } catch(JuegoTerminadoException juegoTerminadoException) {

                this.equipoGanador = this.obtenerGanadorFlor();

            }

        } catch(NoSePuedeQuererFlorException noSePuedeQuererFlorException) {

            try {

                this.equipoContrario.sumarPuntos(this.estadoVuelta.puntos());

            } catch(JuegoTerminadoException juegoTerminadoException) {

                this.equipoGanador = this.equipoContrario;

            }

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoActualFlor();

    }

    public void noQuieroFlor() {

        try {

            this.equipoContrario.sumarPuntos(this.estadoVuelta.noQuerido());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanador = this.equipoContrario;

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoActualFlor();

    }

    private Equipo obtenerGanadorEnvido() {

        if(this.equipoActual.jugadorEnvidoMasAlto().envido() > this.equipoContrario.jugadorEnvidoMasAlto().envido())
            return this.equipoActual;
        else {

            if(this.equipoActual.jugadorEnvidoMasAlto().envido() < this.equipoContrario.jugadorEnvidoMasAlto().envido())
                return this.equipoContrario;

        }

        return (this.equipoActual.jugadorEnvidoMasAlto().getOrdenMesa() < this.equipoContrario.jugadorEnvidoMasAlto().getOrdenMesa()) ? this.equipoActual : this.equipoContrario;

    }

    private Equipo obtenerGanadorFlor() {

        if(this.equipoActual.jugadorFlorMasAlta().calcularFlor() > this.equipoContrario.jugadorEnvidoMasAlto().calcularFlor())
            return this.equipoActual;
        else {

            if(this.equipoActual.jugadorEnvidoMasAlto().calcularFlor() < this.equipoContrario.jugadorEnvidoMasAlto().calcularFlor())
                return this.equipoContrario;

        }

        return (this.equipoActual.jugadorEnvidoMasAlto().getOrdenMesa() < this.equipoContrario.jugadorEnvidoMasAlto().getOrdenMesa()) ? this.equipoActual : this.equipoContrario;

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

        this.estadoVuelta = this.estadoVuelta.terminarVuelta(this);

    }

    public Equipo getGanadorVuelta() {

        return this.estadoVuelta.getGanadorVuelta();

    }

    private void recuperarEquipoActualTruco() {

        if(Objects.equals(this.equipoIniciadorTruco, this.equipoContrario)) {

            this.intercambiarEquipos();

        }

        this.equipoIniciadorTruco = null;

    }

    private void guardarEquipoIniciadorTruco() {

        if(this.equipoIniciadorTruco == null)
            this.equipoIniciadorTruco = this.equipoActual;

    }

    private void recuperarEquipoActualEnvido() {

        if(Objects.equals(this.equipoIniciadorEnvido, this.equipoContrario)) {

            this.intercambiarEquipos();

        }

        this.equipoIniciadorEnvido = null;

    }

    private void guardarEquipoIniciadorEnvido() {

        if(this.equipoIniciadorEnvido == null)
            this.equipoIniciadorEnvido = this.equipoActual;

    }

    private void recuperarEquipoActualFlor() {

        if(Objects.equals(this.equipoIniciadorFlor, this.equipoContrario)) {

            this.intercambiarEquipos();

        }

        this.equipoIniciadorFlor = null;

    }

    private void guardarEquipoIniciadorFlor() {

        if(this.equipoIniciadorFlor == null)
            this.equipoIniciadorFlor = this.equipoActual;

    }

    public Vuelta terminarRonda() {

        this.cartasEnMesa = new ArrayDeque<>();

        if(this.equipo1.primeroEnRonda()){
            this.equipoActual = this.equipo2;
            this.equipoContrario = this.equipo1;
        }
        else {
            this.equipoActual = this.equipo1;
            this.equipoContrario = this.equipo2;
        }
        this.equipoActual.setOrdenMesa(0);
        this.equipoContrario.setOrdenMesa(1);

        this.equipo1.setPie();
        this.equipo2.setPie();

        this.jugadorActual = this.equipoActual.getJugadorActual();

        return new PrimeraVuelta(this.seJuegaConFlor, this.equipo1, this.equipo2, this.mazo);

    }

    public Equipo getEquipoGanador() {

        return this.equipoGanador;

    }


}
