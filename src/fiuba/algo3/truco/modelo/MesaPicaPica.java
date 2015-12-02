package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Ronda.Vuelta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

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

    public List<Carta> getCartasDelJugadorActual(){
        return this.mesaActual.getCartasDelJugadorActual();
    }

    public Jugador getJugadorActual(){
        return this.mesaActual.getJugadorActual();
    }

    public int puntaje(Equipo equipo){
        return this.mesaGeneral.puntaje(equipo);
    }

    public void hacerJugada(Carta carta) throws NoHayCartasParaJugar{
        this.mesaActual.hacerJugada(carta);
        if(this.mesaActual.getCartasEnMesa().size() == 0)
            this.interCambiarMesa();
    }

    public void envido() {
        this.mesaActual.envido();
    }
    public void realEnvido(){
        this.mesaActual.realEnvido();
    }
    public void faltaEnvido(){
        this.mesaActual.faltaEnvido();
    }
    public void flor(){
        this.mesaActual.flor();
    }
    public void contraFlorAlResto(){
        this.mesaActual.contraFlorAlResto();
    }
    public void contraFlorAlPartido(){
        this.mesaActual.contraFlorAlPartido();
    }
    public void truco(){
        this.mesaActual.truco();
    }
    public void reTruco(){
        this.mesaActual.retruco();
    }
    public void valeCuatro(){
        this.mesaActual.valeCuatro();
    }
    public void quieroTruco(){
        this.mesaActual.quieroTruco();
    }
    public void noQuieroTruco(){
        this.mesaActual.noQuieroTruco();
        this.interCambiarMesa();
    }
    public void quieroEnvido(){
        this.mesaActual.quieroEnvido();
    }
    public void quieroFlor(){
        this.mesaActual.quieroFlor();
    }
    public void noQuieroTanto(){
        this.mesaActual.noQuieroTanto();
    }
   public Equipo getEquipoGanador(){
       return this.mesaGeneral.getEquipoGanador();
   }
    public Equipo getEquipoActual(){
        return this.mesaActual.getEquipoActual();
    }
    public Vuelta getEstadoVuelta(){
        return this.mesaActual.getEstadoVuelta();
    }
    public Deque<Carta> getCartasEnMesa(){
        return this.mesaActual.getCartasEnMesa();
    }
    public boolean seJuegaConFlor(){
        return this.mesaActual.seJuegaConFlor();
    }

    private void interCambiarMesa() {
        int puntajeMaximo = this.getPuntajeMaximo();
        int jugadorParaMesa = this.indiceJugadores;
        if( puntajeMaximo >= 5 && puntajeMaximo < 25 && !this.esPicaPica ){
            //esto se va a llamar cuando se este jugando en mesa redonda, se termine la ronda, y se tenga que jugar pica a pica,
            //crea mesas con puntaje cero y en el orden que sigue la mesa general
            this.esPicaPica = true;
            this.indiceJugadores++;
            //esto no lo puedo meter en una lista y un ciclo porque la lista maneja referencias, si creo una mesa nueva la referncia de la lista apunta
            //a otro lado
            this.mesa1 = new Mesa(new Equipo(this.equipos.get(indiceJugadores % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores) % 6))),
                    new Equipo(this.equipos.get((indiceJugadores + 1) % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores + 3)%6))),
                    this.seJuegaConFlor());
            this.mesa2 = new Mesa(new Equipo(this.equipos.get((indiceJugadores + 1) % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores + 1) %6))),
                    new Equipo(this.equipos.get(indiceJugadores % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores + 4)%6))),
                    this.seJuegaConFlor());
            this.mesa3 = new Mesa(new Equipo(this.equipos.get(indiceJugadores % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores + 2)%6))),
                    new Equipo(this.equipos.get((indiceJugadores + 1) % 2).getNombre(), Arrays.asList(jugadores.get((indiceJugadores + 5)%6))),
                    this.seJuegaConFlor);
            //esto es un pijaso lo se, pero manejo la ronda desde aca y crea mesas ordenadas que respetan el orden de la mesa general, which is nice
            mesas = new ArrayList<>(Arrays.asList(mesa1,mesa2,mesa3));//agrego las tres mesas ordenadas para jugar al pica a pica
            this.mazo.repartir(this.jugadores); //para que no haya cartas repetidas entras las tres mesas.
            this.indiceMesa = 0; //sino hay una una mesa que se la fuma en la segunda vuelta dle pica a pica
        }
        if(this.esPicaPica){
            //luego de que se llamo al condicional anterior, entra aca durante los tres juegos de pica a pica, se juegan los tres tranquilamente
            //luego sumo puntos cuando se terminen los tres
            this.mesaActual = mesas.get(this.indiceMesa % 3);
            this.indiceMesa++;
            if((this.indiceMesa % 4) == 0) {
                //si entra aca, se jugaron las tres mesas del pica a pica
                //entonces tengo que sumar puntos y meter la mesa principal
                for (int i = 0; i < 3; i++){
                    this.equipo1.sumarPuntos(mesas.get(i).puntaje(this.equipo1));
                    this.equipo2.sumarPuntos(mesas.get(i).puntaje(this.equipo2));
                }
                this.mesaActual = this.mesaGeneral;
                this.esPicaPica = false;
                this.mesaGeneral.terminarRonda(); //porque la ronda que se jugo fue la pica a pica
                this.indiceJugadores++;//idem
            }
        }

    }

    public int getPuntajeMaximo() {
        return Math.max(mesaGeneral.puntaje(equipo1), mesaGeneral.puntaje(equipo2));
    }


}
