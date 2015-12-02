package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Ronda.Vuelta;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MesaPicaPica{

    private Mesa mesaActual;

    private Equipo equipo1;
    private Equipo equipo2;

    private Mesa mesaGeneral;
    private int indiceMesa; // para recorrer la lista de forma circular (dsps lo mejoramos para que vea el jugador mano)
    private List<Mesa>  mesas;

    public MesaPicaPica(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        mesaGeneral = new Mesa(equipo1,equipo2,seJuegaConFlor);

        List<Jugador> jugadoresEquipo1 = equipo1.getIntegrantes();
        List<Jugador> jugadoresEquipo2 = equipo2.getIntegrantes();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        Mesa mesa1 = new Mesa(new Equipo(equipo1.getNombre(), Arrays.asList(jugadoresEquipo1.get(0))),
                new Equipo(equipo2.getNombre(), Arrays.asList(jugadoresEquipo2.get(1))), seJuegaConFlor);

        Mesa mesa2 = new Mesa(new Equipo(equipo1.getNombre(), Arrays.asList(jugadoresEquipo1.get(1))),
                new Equipo(equipo2.getNombre(), Arrays.asList(jugadoresEquipo2.get(2))), seJuegaConFlor);

        Mesa mesa3 = new Mesa(new Equipo(equipo1.getNombre(), Arrays.asList(jugadoresEquipo1.get(2))),
                new Equipo(equipo2.getNombre(), Arrays.asList(jugadoresEquipo2.get(0))), seJuegaConFlor);

        mesaActual = mesaGeneral;
        mesas = Arrays.asList(mesaActual, mesa1, mesa2, mesa3);
        this.indiceMesa = 0;
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
    /*public void realEnvido(){
        this.mesaActual.realEnvido();
    }
    public void faltaEnvido(){
        this.mesaActual.faltaEnvido();
    }*/
    public void flor(){
        this.mesaActual.flor();
    }
    /*public void contraFlorAlResto(){
        this.mesaActual.contraFlorAlResto();
    }
    public void contraFlorAlPartido(){
        this.mesaActual.contraFlorAlPartido();
    }*/
    public void truco(){
        this.mesaActual.truco();
    }
    public void reTruco(){
        this.mesaActual.retruco();
    }
    /*public void valeCuatro(){
        this.mesaActual.valeCuatro();
    }*/
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
        if( puntajeMaximo > 5 && puntajeMaximo < 25 ){
            this.indiceMesa++;
            int mesaAUsar = this.indiceMesa%4;
            if(mesaAUsar == 0){
                for(int i=1 ; i<4;i++) {
                    equipo1.sumarPuntos(mesas.get(i).puntaje(equipo1)); //podriamos hacer esto en un entero local y restarlos para que sean
                    equipo2.sumarPuntos(mesas.get(i).puntaje(equipo2));//pica a pica con diferencia de los puntos, como gusten
                    this.mesas.get(i).reiniciarPuntos(); // me aseguro de reiniciar los puntos de las mesas individuales
                }
                this.mesaActual = mesas.get(mesaAUsar);
            }   else {
                this.mesaActual = mesas.get(mesaAUsar);
            }
        }

    }

    public int getPuntajeMaximo() {
        return Math.max(mesaGeneral.puntaje(equipo1), mesaGeneral.puntaje(equipo2));
    }
}
