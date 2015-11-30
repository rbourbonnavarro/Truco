package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.TantoJugado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VentanaJuegoController {

    @FXML
    protected Label turno;
    @FXML
    protected Label labelEquipo1;
    @FXML
    protected Label labelEquipo2;
    @FXML
    protected Label puntajeEquipo1;
    @FXML
    protected Label puntajeEquipo2;
    @FXML
    protected Button botonMostrarCartas;
    @FXML
    protected Button botonCarta1;
    @FXML
    protected Button botonCarta2;
    @FXML
    protected Button botonCarta3;
    @FXML
    protected Button botonCartaJugada1Jugador1;
    @FXML
    protected Button botonCartaJugada2Jugador1;
    @FXML
    protected Button botonCartaJugada3Jugador1;
    @FXML
    protected Button botonCartaJugada1Jugador2;
    @FXML
    protected Button botonCartaJugada2Jugador2;
    @FXML
    protected Button botonCartaJugada3Jugador2;
    @FXML
    private Button botonCartaJugada1Jugador3;
    @FXML
    private Button botonCartaJugada2Jugador3;
    @FXML
    private Button botonCartaJugada3Jugador3;
    @FXML
    private Button botonCartaJugada1Jugador4;
    @FXML
    private Button botonCartaJugada2Jugador4;
    @FXML
    private Button botonCartaJugada3Jugador4;
    @FXML
    private Button botonCartaJugada1Jugador5;
    @FXML
    private Button botonCartaJugada2Jugador5;
    @FXML
    private Button botonCartaJugada3Jugador5;
    @FXML
    private Button botonCartaJugada1Jugador6;
    @FXML
    private Button botonCartaJugada2Jugador6;
    @FXML
    private Button botonCartaJugada3Jugador6;
    @FXML
    protected List<Button> botonesCartasJugadorActual;
    @FXML
    protected List<Button> botonesCartasJugadasJugador1;
    @FXML
    protected List<Button> botonesCartasJugadasJugador2;
    @FXML
    private List<Button> botonesCartasJugadasJugador3;
    @FXML
    private List<Button> botonesCartasJugadasJugador4;
    @FXML
    private List<Button> botonesCartasJugadasJugador5;
    @FXML
    private List<Button> botonesCartasJugadasJugador6;
    @FXML
    protected List<List<Button>> botonesCartasJugadas;
    @FXML
    protected Button botonFlor;
    @FXML
    protected Button botonContraFlorAlResto;
    @FXML
    protected Button botonContraFlorAlPartido;
    @FXML
    protected Button botonEnvido;
    @FXML
    protected Button botonRealEnvido;
    @FXML
    protected Button botonFaltaEnvido;
    @FXML
    protected Button botonTruco;
    @FXML
    protected Button botonRetruco;
    @FXML
    protected Button botonValeCuatro;
    @FXML
    protected Button botonQuieroTruco;
    @FXML
    protected Button botonNoQuieroTruco;
    @FXML
    protected Button botonQuieroEnvido;
    @FXML
    protected Button botonQuieroFlor;
    @FXML
    protected Button botonNoQuieroTanto;

    protected Mesa mesa;
    protected Main main;
    protected Equipo equipo1;
    protected Equipo equipo2;
    protected List<Carta> cartasJugadorActual;
    protected DiccionarioCartas diccionarioCartas;
    protected int cantidadJugadasJugador1 = 0;
    protected int cantidadJugadasJugador2 = 0;
    private int cantidadJugadasJugador3 = 0;
    private int cantidadJugadasJugador4 = 0;
    private int cantidadJugadasJugador5 = 0;
    private int cantidadJugadasJugador6 = 0;
    protected List<Integer> cantidadJugadasJugador;
    protected Jugador jugadorPrevio;
    protected int indiceJugador = 0;
    protected List<Button> botonesEnvido;
    protected List<Button> botonesFlor;
    protected List<Button> botonesTanto;
    protected List<Button> botonesTruco;
    protected List<Button> botonesQuiero;
    protected DiccionarioEstadosJuego diccionarioEstadosJuego;

    @FXML
    protected void initialize() {

        this.botonesCartasJugadorActual = new ArrayList<>(Arrays.asList(this.botonCarta1, this.botonCarta2, this.botonCarta3));
        this.botonesCartasJugadasJugador1 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador1, this.botonCartaJugada2Jugador1, this.botonCartaJugada3Jugador1));
        this.botonesCartasJugadasJugador2 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador2, this.botonCartaJugada2Jugador2, this.botonCartaJugada3Jugador2));
        this.botonesCartasJugadasJugador3 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador3, this.botonCartaJugada2Jugador3, this.botonCartaJugada3Jugador3));
        this.botonesCartasJugadasJugador4 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador4, this.botonCartaJugada2Jugador4, this.botonCartaJugada3Jugador4));
        this.botonesCartasJugadasJugador5 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador5, this.botonCartaJugada2Jugador5, this.botonCartaJugada3Jugador5));
        this.botonesCartasJugadasJugador6 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador6, this.botonCartaJugada2Jugador6, this.botonCartaJugada3Jugador6));
        this.botonesCartasJugadas = new ArrayList<>(Arrays.asList(this.botonesCartasJugadasJugador1, this.botonesCartasJugadasJugador2,
                this.botonesCartasJugadasJugador3,this.botonesCartasJugadasJugador4,this.botonesCartasJugadasJugador5,this.botonesCartasJugadasJugador6));
        this.cantidadJugadasJugador = new ArrayList<>(Arrays.asList(this.cantidadJugadasJugador1, this.cantidadJugadasJugador2,
                this.cantidadJugadasJugador3,this.cantidadJugadasJugador4,this.cantidadJugadasJugador5,this.cantidadJugadasJugador6));
        this.diccionarioCartas = new DiccionarioCartas();
        this.botonesEnvido = new ArrayList<>(Arrays.asList(this.botonEnvido, this.botonRealEnvido, this.botonFaltaEnvido));
        this.botonesFlor = new ArrayList<>(Arrays.asList(this.botonFlor, this.botonContraFlorAlResto, this.botonContraFlorAlPartido));
        this.botonesTanto = new ArrayList<>(this.botonesEnvido);
        this.botonesTanto.addAll(this.botonesFlor);
        this.botonesTruco = new ArrayList<>(Arrays.asList(this.botonTruco, this.botonRetruco, this.botonValeCuatro));
        this.botonesQuiero = new ArrayList<>(Arrays.asList(this.botonQuieroTruco, this.botonNoQuieroTruco, this.botonQuieroEnvido, this.botonQuieroFlor, this.botonNoQuieroTanto));

        this.diccionarioEstadosJuego = new DiccionarioEstadosJuego(this.botonesTruco, this.botonesTanto, this.botonesQuiero);

        this.visibilizarBotones(this.botonesQuiero, false);
        this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonValeCuatro), false);

    }


    public void setMain(Main main, Mesa mesa, Equipo equipo1, Equipo equipo2) {

        this.main = main;
        this.mesa = mesa;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.labelEquipo1.setText(this.equipo1.getNombre());
        this.labelEquipo2.setText(this.equipo2.getNombre());
        this.mostrarPuntos();

        this.visibilizarBotones(this.botonesFlor, this.mesa.seJuegaConFlor());
        this.visibilizarBotones(Arrays.asList(this.botonContraFlorAlResto, this.botonContraFlorAlPartido), false);

        this.jugadorPrevio = this.mesa.getJugadorActual();
        this.mostrarJugadorActual();

    }


    protected void mostrarCartasJugadorActual() {

        for (int i = 0; i < this.cartasJugadorActual.size(); i++) {

            this.botonesCartasJugadorActual.get(i).setText(this.diccionarioCartas.representacionCarta(this.cartasJugadorActual.get(i)));
            if(!this.mesa.getJugadorActual().obtenerCartasEnMano().contains(this.cartasJugadorActual.get(i)))
                this.botonesCartasJugadorActual.get(i).setDisable(true);

        }

    }

    @FXML
    protected void MostarCartasHandler() {

        EstadoJuego estadoJuego = this.mesa.getEstadoVuelta().getEstadoJuego();

        try {

            this.mesa.getEstadoVuelta().estadoValido();

            this.desactivarBotones(this.botonesCartasJugadorActual, false);

        } catch(Exception e) {

            this.desactivarBotones(this.botonesCartasJugadorActual, true);

        }

        this.mostrarCartasJugadorActual();

    }

    @FXML
    private void JugarCarta1Handler() {

        try {

            mesa.hacerJugada(cartasJugadorActual.get(0));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(0));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void JugarCarta2Handler() {

        try {

            mesa.hacerJugada(cartasJugadorActual.get(1));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(1));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void JugarCarta3Handler() {

        try {

            mesa.hacerJugada(cartasJugadorActual.get(2));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(2));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    protected void nuevaRonda() {

        int cantidadJugadores = this.mesa.getEquipoActual().getCantidadIntegrantes()*2;

        for(int i = 0; i < cantidadJugadores; i++) {

            for (Button botonCartaJugada : this.botonesCartasJugadas.get(i)) {

                botonCartaJugada.setText("");
                botonCartaJugada.setVisible(false);

            }

            this.cantidadJugadasJugador.set(i, 0);

        }

        this.visibilizarBotones(this.botonesQuiero, false);
        this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonValeCuatro), false);
        this.botonTruco.setVisible(true);

        this.visibilizarBotones(this.botonesTanto, true);

        this.visibilizarBotones(this.botonesFlor, this.mesa.seJuegaConFlor());

    }

    protected void mostrarCartaEnMesa(Carta cartaJugada) {

        Integer numeroJugada = this.cantidadJugadasJugador.get(this.indiceJugador);
        Button botonCartaJugada = this.botonesCartasJugadas.get(this.indiceJugador).get(numeroJugada);

        botonCartaJugada.setVisible(true);
        botonCartaJugada.setDisable(true);
        botonCartaJugada.setText(this.diccionarioCartas.representacionCarta(cartaJugada));

        this.cantidadJugadasJugador.set(this.indiceJugador, numeroJugada + 1);

    }


    protected void mostrarPuntos() {

        this.puntajeEquipo1.setText(Integer.toString(this.mesa.puntaje(equipo1)));
        this.puntajeEquipo2.setText(Integer.toString(this.mesa.puntaje(equipo2)));

    }

    @FXML
    protected void trucoHandler(){

        mesa.truco();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void reTrucoHandler(){

        try {

            mesa.retruco();

            this.mostrarJugadorActual();

        } catch (EquipoQueCantoTrucoNoPuedeCantarRetrucoException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador no puede cantar Retruco");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar retruco ya que usted canto truco");
            alert.showAndWait();

        }
        
    }

    @FXML
    protected void valeCuatroHandler(){

        try{

            mesa.valeCuatro();

            this.mostrarJugadorActual();

        } catch (EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador no puede cantar Vale Cuatro");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar vale cuatro ya que usted canto re truco");
            alert.showAndWait();

        }

    }

    @FXML
    protected void quieroTrucoHandler(){

        mesa.quieroTruco();

        this.mostrarJugadorActual();

    }

    @FXML
    private void noQuieroTrucoHandler() {
        try {
            mesa.noQuieroTruco();
            this.nuevaRonda();
            this.mostrarPuntos();
            this.mostrarJugadorActual();
        }catch (JuegoTerminadoException terminado) {
            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());
        }
    }

    @FXML
    protected void cantarFlorHandler() {

        this.mesa.flor();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarContraFlorAlRestoHandler() {

        this.mesa.contraFlorAlResto();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarContraFlorAlPartidoHandler() {

        this.mesa.contraFlorAlPartido();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarEnvidoHandler() {

        this.mesa.envido();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarRealEnvidoHandler() {

        this.mesa.realEnvido();

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarFaltaEnvidoHandler() {

        this.mesa.faltaEnvido();

        this.mostrarJugadorActual();

    }

    @FXML
    private void quieroEnvidoHandler() {

        try {

            this.mesa.quieroEnvido();
            this.visibilizarBotones(this.botonesTanto, false);
            this.visibilizarBotones(this.botonesQuiero, false);
            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof TrucoCantadoTantoNoJugado)
                this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonQuieroTruco, this.botonNoQuieroTruco), true);
            else
                this.visibilizarBotones(Collections.singletonList(this.botonTruco), true);

            this.mostrarPuntos();
            this.mostrarJugadorActual();

        }catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }
    }

    @FXML
    private void noQuieroTantoHandler() {

        try {

            this.mesa.noQuieroTanto();
            this.visibilizarBotones(this.botonesTanto, false);
            this.visibilizarBotones(this.botonesQuiero, false);
            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof TrucoCantadoTantoNoJugado)
                this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonQuieroTruco, this.botonNoQuieroTruco), true);
            else
                this.visibilizarBotones(Collections.singletonList(this.botonTruco), true);

            this.mostrarPuntos();
            this.mostrarJugadorActual();

        }catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    protected void mostrarJugadorActual() {

        this.setearBotones();

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % (this.mesa.getEquipoActual().getCantidadIntegrantes()*2);

        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.jugadorPrevio.getNombre());

        this.cartasJugadorActual = this.jugadorPrevio.obtenerCartas();

        for(Button boton : this.botonesCartasJugadorActual) {

            boton.setText("Carta dada vuelta");
            boton.setDisable(true);

        }

        if(!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

            this.visibilizarBotones(this.botonesTanto, false);

        }

    }

    protected void visibilizarBotones(List<Button> botones, boolean visibilidad) {

        for(Button boton : botones) {

            boton.setVisible(visibilidad);

        }

    }

    protected void desactivarBotones(List<Button> botones, boolean activar) {

        for(Button boton : botones) {

            boton.setDisable(activar);

        }

    }

    protected void setearBotones() {

        EstadoJuego estadoJuego = this.mesa.getEstadoVuelta().getEstadoJuego();

        this.visibilizarBotones(this.botonesTruco, true);
        this.visibilizarBotones(this.botonesTanto, true);
        this.visibilizarBotones(this.botonesQuiero, true);

        this.visibilizarBotones(this.diccionarioEstadosJuego.obtenerBotones(estadoJuego), false);
        if(! this.mesa.seJuegaConFlor())
           this.visibilizarBotones(this.botonesFlor, false);

    }


}
