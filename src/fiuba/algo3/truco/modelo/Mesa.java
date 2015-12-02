package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeQuererFlorException;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import fiuba.algo3.truco.modelo.Ronda.Vuelta;

import java.util.*;

public class Mesa {

    private Vuelta estadoVuelta;
    private Equipo equipo1;
    private Equipo equipo2;
    private List<Equipo> equipos;
    private Deque<Carta> cartasEnMesa;
    private Equipo equipoActual;
    private Equipo equipoContrario;
    private Jugador jugadorActual;
    private Equipo equipoGanadorJuego;
    private Equipo equipoGanadorRonda;
    private Mazo mazo;
    private boolean seJuegaConFlor;

    public Mesa(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        this.cartasEnMesa = new ArrayDeque<>();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipos = new ArrayList<>(Arrays.asList(equipo1,equipo2));

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

        return equipos.get(equipos.indexOf(equipo)).getPuntos();
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

        } catch (NullPointerException nullPointerException) {

            throw new NoHayCartasParaJugar();

        }

    }

    public void envido() {

        this.estadoVuelta.envido(this.equipoActual);
        this.intercambiarEquipos();

    }


    public void realEnvido() {

        this.estadoVuelta.realEnvido(this.equipoActual);
        this.intercambiarEquipos();

    }

    public void faltaEnvido() {

        Puntaje puntosEnJuego = this.obtenerMayorPuntaje();
        this.estadoVuelta.faltaEnvido(this.equipoActual, puntosEnJuego);
        this.intercambiarEquipos();

    }

    public void flor() {

        this.equipoActual.flor();
        this.estadoVuelta.flor(this.equipoActual);
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

    public void truco() {

        this.estadoVuelta.truco(this.equipoActual);
        this.intercambiarEquipos();

    }

    public void retruco() {

        this.estadoVuelta.reTruco(this.equipoActual);
        this.intercambiarEquipos();

    }

    public void valeCuatro() {

        this.estadoVuelta.valeCuatro(this.equipoActual);
        this.intercambiarEquipos();

    }

    public void quieroTruco() {

        this.estadoVuelta.quiero();
        this.recuperarEquipoIniciadorJugada();

    }

    public void noQuieroTruco() {

        try {

            this.equipoContrario.sumarPuntos(this.estadoVuelta.noQuerido());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanadorJuego = this.equipoContrario;

            throw new JuegoTerminadoException();

        }

        this.equipoActual.terminarJugada();

        this.equipoGanadorRonda = this.equipoContrario;

        this.estadoVuelta = this.terminarRonda();

    }

    public void quieroEnvido() {

        this.estadoVuelta.quiero();

        try {

            this.obtenerGanadorEnvido().sumarPuntos(this.estadoVuelta.puntos());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanadorJuego = this.obtenerGanadorEnvido();

            throw new JuegoTerminadoException();

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoIniciadorJugada();

    }

    public void quieroFlor() {

        try {

            this.estadoVuelta.quiero();

            try {

                this.obtenerGanadorFlor().sumarPuntos(this.estadoVuelta.puntos());

            } catch(JuegoTerminadoException juegoTerminadoException) {

                this.equipoGanadorJuego = this.obtenerGanadorFlor();

                throw new JuegoTerminadoException();

            }

        } catch(NoSePuedeQuererFlorException noSePuedeQuererFlorException) {

            try {

                this.equipoContrario.sumarPuntos(this.estadoVuelta.puntos());

            } catch(JuegoTerminadoException juegoTerminadoException) {

                this.equipoGanadorJuego = this.equipoContrario;

                throw new JuegoTerminadoException();

            }

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoIniciadorJugada();

    }

    public void noQuieroTanto() {

        try {

            this.equipoContrario.sumarPuntos(this.estadoVuelta.noQuerido());

        } catch(JuegoTerminadoException juegoTerminadoException) {

            this.equipoGanadorJuego = this.equipoContrario;

            throw new JuegoTerminadoException();

        }

        this.estadoVuelta.terminarTanto();

        this.recuperarEquipoIniciadorJugada();

    }

    private Equipo obtenerGanadorEnvido() {

        Jugador jugadorConEnvidoMasAltoEquipo1 = this.equipoActual.jugadorEnvidoMasAlto();
        Jugador jugadorConEnvidoMasAltoEquipo2 =this.equipoContrario.jugadorEnvidoMasAlto();
        int envidoEquipo1 = jugadorConEnvidoMasAltoEquipo1.envido();
        int envidoEquipo2 = jugadorConEnvidoMasAltoEquipo2.envido();

        if(envidoEquipo1 > envidoEquipo2)
            return this.equipoActual;
        else {

            if(envidoEquipo1 < envidoEquipo2)
                return this.equipoContrario;

        }

        return (jugadorConEnvidoMasAltoEquipo1.getOrdenMesa() < jugadorConEnvidoMasAltoEquipo2.getOrdenMesa()) ? this.equipoActual : this.equipoContrario;

    }

    private Equipo obtenerGanadorFlor() {

        if(this.equipoActual.jugadorFlorMasAlta().flor() > this.equipoContrario.jugadorEnvidoMasAlto().flor())
            return this.equipoActual;
        else {

            if(this.equipoActual.jugadorEnvidoMasAlto().flor() < this.equipoContrario.jugadorEnvidoMasAlto().flor())
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

        if(this.estadoVuelta.getEquipoGanadorRonda() != null) {

            if(this.equipoActual != this.estadoVuelta.getEquipoGanadorRonda())
                this.intercambiarEquipos();

            this.jugadorActual = this.estadoVuelta.getJugadorGanadorVuelta();

            this.equipoActual.setIndiceJugador(this.jugadorActual);
            this.equipoContrario.setIndiceJugador(this.equipoActual.getIndiceJugador());

        }


        this.estadoVuelta = this.estadoVuelta.terminarVuelta(this);

    }

    private void recuperarEquipoIniciadorJugada() {

        if(Objects.equals(this.estadoVuelta.getEquipoIniciador(), this.equipoContrario)) {

            this.intercambiarEquipos();

        }

    }

    public Vuelta terminarRonda() {

        this.cartasEnMesa = new ArrayDeque<>();

        if(this.equipo1.primeroEnRonda()) {

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

    public Equipo getEquipo2() {

        return this.equipo2;

    }

    public Equipo getEquipoGanadorJuego() {

        return this.equipoGanadorJuego;

    }

    public Equipo getEquipoActual() {

        return this.equipoActual;

    }

    public Vuelta getEstadoVuelta() {

        return this.estadoVuelta;

    }

    public Deque<Carta> getCartasEnMesa() {

        return this.cartasEnMesa;

    }

    public boolean seJuegaConFlor() {

        return this.seJuegaConFlor;

    }

    public Equipo getEquipoGanadorRonda() {

        return this.equipoGanadorRonda;

    }

    public void setEquipoGanadorRonda(Equipo equipoGanadorRonda) {

        this.equipoGanadorRonda = equipoGanadorRonda;

    }


}
