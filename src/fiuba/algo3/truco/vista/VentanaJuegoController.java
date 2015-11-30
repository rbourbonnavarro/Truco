package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
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
    private Label turno;
    @FXML
    private Label labelEquipo1;
    @FXML
    private Label labelEquipo2;
    @FXML
    private Label puntajeEquipo1;
    @FXML
    private Label puntajeEquipo2;
    @FXML
    private Button botonMostrarCartas;
    @FXML
    private Button botonCarta1;
    @FXML
    private Button botonCarta2;
    @FXML
    private Button botonCarta3;
    @FXML
    private Button botonCartaJugada1Jugador1;
    @FXML
    private Button botonCartaJugada2Jugador1;
    @FXML
    private Button botonCartaJugada3Jugador1;
    @FXML
    private Button botonCartaJugada1Jugador2;
    @FXML
    private Button botonCartaJugada2Jugador2;
    @FXML
    private Button botonCartaJugada3Jugador2;
    @FXML
    private List<Button> botonesCartasJugadorActual;
    @FXML
    private List<Button> botonesCartasJugadasJugador1;
    @FXML
    private List<Button> botonesCartasJugadasJugador2;
    @FXML
    private List<List<Button>> botonesCartasJugadas;
    @FXML
    private Button botonFlor;
    @FXML
    private Button botonContraFlorAlResto;
    @FXML
    private Button botonContraFlorAlPartido;
    @FXML
    private Button botonEnvido;
    @FXML
    private Button botonRealEnvido;
    @FXML
    private Button botonFaltaEnvido;
    @FXML
    private Button botonTruco;
    @FXML
    private Button botonRetruco;
    @FXML
    private Button botonValeCuatro;
    @FXML
    private Button botonQuieroTruco;
    @FXML
    private Button botonNoQuieroTruco;
    @FXML
    private Button botonQuieroEnvido;
    @FXML
    private Button botonQuieroFlor;
    @FXML
    private Button botonNoQuieroTanto;

    private Mesa mesa;
    private Main main;
    private Equipo equipo1;
    private Equipo equipo2;
    private List<Carta> cartasJugadorActual;
    private DiccionarioCartas diccionarioCartas;
    private int cantidadJugadasJugador1 = 0;
    private int cantidadJugadasJugador2 = 0;
    private List<Integer> cantidadJugadasJugador;
    private Jugador jugadorPrevio;
    private int indiceJugador = 0;
    private List<Button> botonesEnvido;
    private List<Button> botonesFlor;
    private List<Button> botonesTanto;
    private List<Button> botonesTruco;
    private List<Button> botonesQuiero;

    @FXML
    private void initialize() {

        this.botonesCartasJugadorActual = new ArrayList<>(Arrays.asList(this.botonCarta1, this.botonCarta2, this.botonCarta3));
        this.botonesCartasJugadasJugador1 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador1, this.botonCartaJugada2Jugador1, this.botonCartaJugada3Jugador1));
        this.botonesCartasJugadasJugador2 = new ArrayList<>(Arrays.asList(this.botonCartaJugada1Jugador2, this.botonCartaJugada2Jugador2, this.botonCartaJugada3Jugador2));
        this.botonesCartasJugadas = new ArrayList<>(Arrays.asList(this.botonesCartasJugadasJugador1, this.botonesCartasJugadasJugador2));
        this.cantidadJugadasJugador = new ArrayList<>(Arrays.asList(this.cantidadJugadasJugador1, this.cantidadJugadasJugador2));
        this.diccionarioCartas = new DiccionarioCartas();
        this.botonesEnvido = new ArrayList<>(Arrays.asList(this.botonEnvido, this.botonRealEnvido, this.botonFaltaEnvido));
        this.botonesFlor = new ArrayList<>(Arrays.asList(this.botonFlor, this.botonContraFlorAlResto, this.botonContraFlorAlPartido));
        this.botonesTanto = new ArrayList<>(this.botonesEnvido);
        this.botonesTanto.addAll(this.botonesFlor);
        this.botonesTruco = new ArrayList<>(Arrays.asList(this.botonTruco, this.botonRetruco, this.botonValeCuatro));
        this.botonesQuiero = new ArrayList<>(Arrays.asList(this.botonQuieroTruco, this.botonNoQuieroTruco, this.botonQuieroEnvido, this.botonQuieroFlor, this.botonNoQuieroTanto));

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


    private void mostrarCartasJugadorActual() {

        for (int i = 0; i < this.cartasJugadorActual.size(); i++) {

            this.botonesCartasJugadorActual.get(i).setText(this.diccionarioCartas.representacionCarta(this.cartasJugadorActual.get(i)));
            if(!this.mesa.getJugadorActual().obtenerCartasEnMano().contains(this.cartasJugadorActual.get(i)))
                this.botonesCartasJugadorActual.get(i).setDisable(true);

        }

    }

    @FXML
    private void MostarCartasHandler() {

        EstadoJuego estadoJuego = this.mesa.getEstadoVuelta().getEstadoJuego();
        if(!(estadoJuego instanceof NadaCantado
                || estadoJuego instanceof TrucoQuerido
                || estadoJuego instanceof RetrucoQuerido
                || estadoJuego instanceof ValeCuatroCantado))
            this.desactivarBotones(this.botonesCartasJugadorActual, true);
        else
            this.desactivarBotones(this.botonesCartasJugadorActual, false);

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
        }catch (JuegoTerminadoException terminado) {
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
        }catch (JuegoTerminadoException terminado) {
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
        }catch (JuegoTerminadoException terminado) {
            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());
        }
    }

    private void nuevaRonda() {

        for(int i = 0; i < 2; i++) {

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

    private void mostrarCartaEnMesa(Carta cartaJugada) {

        Integer numeroJugada = this.cantidadJugadasJugador.get(this.indiceJugador);
        Button botonCartaJugada = this.botonesCartasJugadas.get(this.indiceJugador).get(numeroJugada);

        botonCartaJugada.setVisible(true);
        botonCartaJugada.setDisable(true);
        botonCartaJugada.setText(this.diccionarioCartas.representacionCarta(cartaJugada));

        this.cantidadJugadasJugador.set(this.indiceJugador, numeroJugada + 1);

    }


    private void mostrarPuntos() {

        this.puntajeEquipo1.setText(Integer.toString(this.mesa.puntaje(equipo1)));
        this.puntajeEquipo2.setText(Integer.toString(this.mesa.puntaje(equipo2)));

    }

    @FXML
    private void trucoHandler(){

        mesa.truco();
        this.mostrarJugadorActual();
        this.botonRetruco.setVisible(true);
        this.botonTruco.setVisible(false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroTruco.setVisible(true);
        this.botonNoQuieroTruco.setVisible(true);

    }

    @FXML
    private void reTrucoHandler(){

        try {

            mesa.retruco();
            this.mostrarJugadorActual();
            this.botonRetruco.setVisible(false);
            this.botonValeCuatro.setVisible(true);
            this.visibilizarBotones(this.botonesQuiero, false);
            this.botonQuieroTruco.setVisible(true);
            this.botonNoQuieroTruco.setVisible(true);

        } catch (EquipoQueCantoTrucoNoPuedeCantarRetrucoException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador no puede cantar Retruco");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar retruco ya que usted canto truco");
            alert.showAndWait();

        }
        
    }

    @FXML
    private void valeCuatroHandler(){

        try{

            mesa.valeCuatro();
            this.mostrarJugadorActual();
            this.botonValeCuatro.setVisible(false);
            this.visibilizarBotones(this.botonesQuiero, false);
            this.botonQuieroTruco.setVisible(true);
            this.botonNoQuieroTruco.setVisible(true);

        } catch (EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException e){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador no puede cantar Vale Cuatro");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar vale cuatro ya que usted canto re truco");
            alert.showAndWait();

        }

    }

    @FXML
    private void quieroTrucoHandler(){

        mesa.quieroTruco();
        this.mostrarJugadorActual();
        this.botonNoQuieroTruco.setVisible(false);
        this.botonQuieroTruco.setVisible(false);

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
    private void cantarFlorHandler() {

        this.mesa.flor();

        if(this.mesa.getEstadoVuelta().getEstadoJuego() instanceof FlorFlorCantada)
            this.visibilizarBotones(this.botonesFlor, false);
        else
            this.visibilizarBotones(Arrays.asList(this.botonContraFlorAlResto, this.botonContraFlorAlPartido), true);

        this.visibilizarBotones(this.botonesEnvido, false);
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroFlor.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);

        this.mostrarJugadorActual();

    }

    @FXML
    private void cantarContraFlorAlRestoHandler() {

        this.mesa.contraFlorAlResto();
        this.visibilizarBotones(this.botonesTanto, false);
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroFlor.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);

        this.mostrarJugadorActual();

    }

    @FXML
    private void cantarContraFlorAlPartidoHandler() {

        this.mesa.contraFlorAlPartido();
        this.visibilizarBotones(this.botonesTanto, false);
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroFlor.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);

        this.mostrarJugadorActual();

    }

    @FXML
    private void cantarEnvidoHandler() {

        this.mesa.envido();
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroEnvido.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);
        if(mesa.getEstadoVuelta().getEstadoJuego() instanceof EnvidoEnvidoCantado)
            this.botonEnvido.setVisible(false);

        this.mostrarJugadorActual();

    }

    @FXML
    private void cantarRealEnvidoHandler() {

        this.mesa.realEnvido();
        this.botonEnvido.setVisible(false);
        this.botonRealEnvido.setVisible(false);
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroEnvido.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);

        this.mostrarJugadorActual();

    }

    @FXML
    private void cantarFaltaEnvidoHandler() {

        this.mesa.faltaEnvido();
        this.visibilizarBotones(this.botonesEnvido,false);
        this.visibilizarBotones(this.botonesTruco, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.botonQuieroEnvido.setVisible(true);
        this.botonNoQuieroTanto.setVisible(true);

        this.mostrarJugadorActual();

    }

    @FXML
    private void quieroEnvidoHandler() {
        try {
            this.mesa.quieroEnvido();
            this.visibilizarBotones(this.botonesTanto, false);
            this.visibilizarBotones(this.botonesQuiero, false);
            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof TrucoCantado)
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
            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof TrucoCantado)
                this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonQuieroTruco, this.botonNoQuieroTruco), true);
            else
                this.visibilizarBotones(Collections.singletonList(this.botonTruco), true);

            this.mostrarPuntos();
            this.mostrarJugadorActual();
        }catch (JuegoTerminadoException terminado) {
            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());
        }
    }

    private void mostrarJugadorActual() {

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % 2;

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

    private void visibilizarBotones(List<Button> botones, boolean visibilidad) {

        for(Button boton : botones) {

            boton.setVisible(visibilidad);

        }

    }

    private void desactivarBotones(List<Button> botones, boolean activar) {

        for(Button boton : botones) {

            boton.setDisable(activar);

        }

    }


}
