package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.TrucoQuerido;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import fiuba.algo3.truco.modelo.Ronda.Vuelta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VentanaJuegoController {

    @FXML
    private Label turno;
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
        this.visibilizarBotones(Arrays.asList(
                botonNoQuieroTruco,botonQuieroTruco,botonRetruco,
                botonValeCuatro,botonQuieroEnvido,botonNoQuieroTanto,
                botonQuieroFlor), false);

    }


    public void setMain(Main main, Mesa mesa, Equipo equipo1, Equipo equipo2) {

        this.main = main;
        this.mesa = mesa;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.mostrarPuntos();

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
    private void trucoHandler(){
        mesa.truco();
        this.mostrarJugadorActual();
        this.botonRetruco.setVisible(true);
        this.botonTruco.setVisible(false);
        this.botonQuieroTruco.setVisible(true);
        this.botonNoQuieroTruco.setVisible(true);
    }

    @FXML
    private void reTrucoHandler(){
        mesa.retruco();
        this.mostrarJugadorActual();
        this.botonRetruco.setVisible(false);
        this.botonValeCuatro.setVisible(true);
        this.botonQuieroTruco.setVisible(true);
        this.botonNoQuieroTruco.setVisible(true);
    }

    @FXML
    private void valeCuatroHandler(){
        mesa.valeCuatro();
        this.mostrarJugadorActual();
        this.botonValeCuatro.setVisible(false);
        this.botonQuieroTruco.setVisible(true);
        this.botonNoQuieroTruco.setVisible(true);
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
        mesa.noQuieroTruco();
        this.nuevaRonda();
        this.mostrarJugadorActual();
    }

    @FXML
    private void MostarCartasHandler() {

        for(Button boton : this.botonesCartasJugadorActual) {

            boton.setDisable(false);

        }

        this.mostrarCartasJugadorActual();

    }

    @FXML
    private void JugarCarta1Handler() {
            mesa.hacerJugada(cartasJugadorActual.get(0));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(0));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if(this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();


    }

    @FXML
    private void JugarCarta2Handler() {

            mesa.hacerJugada(cartasJugadorActual.get(1));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(1));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if(this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();
    }

    @FXML
    private void JugarCarta3Handler() {

            mesa.hacerJugada(cartasJugadorActual.get(2));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(2));
            this.mostrarJugadorActual();
            this.mostrarPuntos();
            if(this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();


    }

    private void nuevaRonda() {

        for(int i = 0; i < 2; i++) {

            for (Button botonCartaJugada : this.botonesCartasJugadas.get(i)) {

                botonCartaJugada.setText("");
                botonCartaJugada.setVisible(false);

            }
            this.visibilizarBotones(Arrays.asList(
                    botonNoQuieroTruco,botonQuieroTruco,botonRetruco,
                    botonValeCuatro),false);
            this.botonTruco.setVisible(true);
            this.cantidadJugadasJugador.set(i, 0);

        }

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

    private void mostrarJugadorActual() {

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % 2;

        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.mesa.getJugadorActual().getNombre());

        this.cartasJugadorActual = this.mesa.getCartasDelJugadorActual();

        for(Button boton : this.botonesCartasJugadorActual) {

            boton.setText("Carta dada vuelta");
            boton.setDisable(true);

        }

    }

    @FXML
    private void cantarFlorHandler() {

        this.mesa.flor();

    }

    private void puedoCantar() {

        this.visibilizarBotones(this.botonesTanto, true);

        this.puedoCantarTruco();
        //this.puedoCantarEnvido();
        this.puedoCantarTanto();

    }

    private void puedoCantarTruco() {



    }

    private void puedoCantarEnvido() {



    }

    private void puedoCantarTanto() {

        Vuelta estadoVuelta = this.mesa.getEstadoVuelta();
        EstadoJuego estadoJuego = estadoVuelta.getEstadoJuego();

        if(!this.mesa.seJuegaConFlor()) this.visibilizarBotones(this.botonesFlor, false);

        if(estadoVuelta instanceof PrimeraVuelta) {

            if(estadoJuego instanceof EnvidoEnvidoCantado) this.visibilizarBotones(this.botonesFlor, false);

            if(estadoJuego instanceof EnvidoEnvidoCantado
                    || estadoJuego instanceof RealEnvidoCantado
                    || estadoJuego instanceof FaltaEnvidoCantado) {

                this.botonEnvido.setVisible(false);

            }

            if(estadoJuego instanceof FaltaEnvidoCantado) {

                this.botonEnvido.setVisible(false);
                this.botonRealEnvido.setVisible(false);

            }

            if(estadoJuego instanceof FlorCantada) this.visibilizarBotones(this.botonesEnvido, false);

            if(estadoJuego instanceof FlorFlorCantada
                    || estadoJuego instanceof ContraFlorAlRestoCantada
                    || estadoJuego instanceof ContraFlorAlPartidoCantado)
                this.visibilizarBotones(this.botonesTanto, false);

        }
        else {

            this.visibilizarBotones(this.botonesTanto, false);

        }

    }

    private void visibilizarBotones(List<Button> botones, boolean visibilidad) {

        for(Button boton : botones) {

            boton.setVisible(visibilidad);

        }

    }


}
