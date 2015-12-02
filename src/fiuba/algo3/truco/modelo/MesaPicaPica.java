package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Ronda.Vuelta;

import java.util.*;

public class MesaPicaPica{

    private Mesa mesaActual;

    private Equipo equipo1;
    private Equipo equipo2;

    private Mesa mesaGeneral;
    private Mesa mesa1;
    private Mesa mesa2;
    private Mesa mesa3;

    private boolean esPicaPica;

    private List<Jugador> jugadores;
    private int indiceJugadores;
    private List<Equipo> equipos;

    private boolean seJuegaConFlor;

    private Mazo mazo;
    private int indiceMesa;
    private List<Mesa>  mesas;

    public MesaPicaPica(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        this.mesaGeneral = new Mesa(equipo1, equipo2, seJuegaConFlor);

        List<Jugador> jugadoresEquipo1 = equipo1.getIntegrantes();
        List<Jugador> jugadoresEquipo2 = equipo2.getIntegrantes();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.equipos = new ArrayList<>(Arrays.asList(equipo1,equipo2));

        this.jugadores = new ArrayList<>();

        for(int i = 0; i < 3; i++){

            this.jugadores.add(jugadoresEquipo1.get(i));
            this.jugadores.add(jugadoresEquipo2.get(i));

        }

        this.indiceJugadores = 0;

        this.mazo = new Mazo();

        this.mesaActual = this.mesaGeneral;

        this.indiceMesa = 0;
        this.esPicaPica = false;
        this.seJuegaConFlor = seJuegaConFlor;

    }

    public List<Carta> getCartasDelJugadorActual() {

        return this.mesaActual.getCartasDelJugadorActual();

    }

    public Jugador getJugadorActual() {

        return this.mesaActual.getJugadorActual();

    }

    public int puntaje(Equipo equipo) {

        return this.mesaGeneral.puntaje(equipo);

    }

    public void hacerJugada(Carta carta) throws NoHayCartasParaJugar {

        this.mesaActual.hacerJugada(carta);
        if(this.mesaActual.getCartasEnMesa().size() == 0)
            this.interCambiarMesa();

    }

    public void envido() {

        this.mesaActual.envido();

    }

    public void realEnvido() {

        this.mesaActual.realEnvido();

    }

    public void faltaEnvido() {

        this.mesaActual.faltaEnvido();

    }

    public void flor() {

        this.mesaActual.flor();

    }

    public void contraFlorAlResto() {

        this.mesaActual.contraFlorAlResto();

    }

    public void contraFlorAlPartido() {

        this.mesaActual.contraFlorAlPartido();

    }

    public void truco() {

        this.mesaActual.truco();

    }

    public void reTruco() {

        this.mesaActual.retruco();

    }

    public void valeCuatro() {

        this.mesaActual.valeCuatro();

    }

    public void quieroTruco(){

        this.mesaActual.quieroTruco();

    }

    public void noQuieroTruco() {

        this.mesaActual.noQuieroTruco();
        this.interCambiarMesa();

    }
    public void quieroEnvido() {

        this.mesaActual.quieroEnvido();

    }

    public void quieroFlor() {

        this.mesaActual.quieroFlor();

    }

    public void noQuieroTanto() {

        this.mesaActual.noQuieroTanto();

    }

   public Equipo getEquipoGanador() {

       return this.mesaGeneral.getEquipoGanadorJuego();

   }

    public Equipo getEquipoActual() {

        return this.mesaActual.getEquipoActual();

    }

    public Vuelta getEstadoVuelta() {

        return this.mesaActual.getEstadoVuelta();

    }

    public Deque<Carta> getCartasEnMesa() {

        return this.mesaActual.getCartasEnMesa();

    }

    public boolean seJuegaConFlor() {

        return this.mesaActual.seJuegaConFlor();

    }

    private void interCambiarMesa() {

        int puntajeMaximo = this.getPuntajeMaximo();

        if(puntajeMaximo >= 5 && puntajeMaximo < 25 && !this.esPicaPica) {

            this.esPicaPica = true;
            this.indiceJugadores++;

            this.mesa1 = new Mesa(new Equipo(this.equipos.get(this.indiceJugadores % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores) % 6))),
                    new Equipo(this.equipos.get((this.indiceJugadores + 1) % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores + 3) %6 ))),
                    this.seJuegaConFlor());
            this.mesa2 = new Mesa(new Equipo(this.equipos.get((this.indiceJugadores + 1) % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores + 1) % 6))),
                    new Equipo(this.equipos.get(this.indiceJugadores % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores + 4) % 6))),
                    this.seJuegaConFlor());
            this.mesa3 = new Mesa(new Equipo(this.equipos.get(this.indiceJugadores % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores + 2) % 6))),
                    new Equipo(this.equipos.get((this.indiceJugadores + 1) % 2).getNombre(), Collections.singletonList(this.jugadores.get((this.indiceJugadores + 5) % 6))),
                    this.seJuegaConFlor);

            this.mesas = new ArrayList<>(Arrays.asList(this.mesa1, this.mesa2, this.mesa3));
            this.mazo.repartir(this.jugadores);
            this.indiceMesa = 0;

        }

        if(this.esPicaPica) {

            this.mesaActual = this.mesas.get(this.indiceMesa % 3);
            this.indiceMesa++;

            if((this.indiceMesa % 4) == 0) {

                for (int i = 0; i < 3; i++){

                    this.equipo1.sumarPuntos(this.mesas.get(i).puntaje(this.equipo1));
                    this.equipo2.sumarPuntos(this.mesas.get(i).puntaje(this.equipo2));
                }

                this.mesaActual = this.mesaGeneral;
                this.esPicaPica = false;
                this.mesaGeneral.terminarRonda();
                this.indiceJugadores++;

            }

        }

    }

    public int getPuntajeMaximo() {

        return Math.max(this.mesaGeneral.puntaje(this.equipo1), this.mesaGeneral.puntaje(this.equipo2));

    }

    public boolean esPicaPica() {

        return this.esPicaPica;

    }

    public Equipo getEquipo2() {

        return this.mesaActual.getEquipo2();

    }

    public Equipo getEquipoGanadorRonda() {

        return this.mesaGeneral.getEquipoGanadorRonda();

    }


}
