package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Truco.EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException;
import fiuba.algo3.truco.modelo.Jugadas.Truco.EquipoQueCantoTrucoNoPuedeCantarRetrucoException;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GomezPeter on 02/12/2015.
 */
public class VentanaJuegoPicaPicaController {
    private static final String DORSO_CARTA = "/gui/images/imagenesCartas/dorsoCarta (Custom).png";
    @FXML
    protected ImageView imagenMazoJ1;
    @FXML
    protected ImageView imagenMazoJ2;
    @FXML
    protected ImageView imagenMazoJ3;
    @FXML
    protected ImageView imagenMazoJ4;
    @FXML
    protected ImageView imagenMazoJ5;
    @FXML
    protected ImageView imagenMazoJ6;
    @FXML
    protected Label turno;
    @FXML
    private Label labelEstadoJuego;
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

    protected MesaPicaPica mesa;
    protected Main main;
    protected Equipo equipo1;
    protected Equipo equipo2;
    protected List<Carta> cartasJugadorActual;
    protected DiccionarioCartas diccionarioCartas;
    protected List<Button> botonesCartasJugadorActual;
    protected List<Button> botonesCartasJugadasJugador1;
    protected List<Button> botonesCartasJugadasJugador2;
    private List<Button> botonesCartasJugadasJugador3;
    private List<Button> botonesCartasJugadasJugador4;
    private List<Button> botonesCartasJugadasJugador5;
    private List<Button> botonesCartasJugadasJugador6;
    protected List<List<Button>> botonesCartasJugadas;
    protected int cantidadJugadasJugador1 = 0;
    protected int cantidadJugadasJugador2 = 0;
    private int cantidadJugadasJugador3 = 0;
    private int cantidadJugadasJugador4 = 0;
    private int cantidadJugadasJugador5 = 0;
    private int cantidadJugadasJugador6 = 0;
    protected List<Integer> cantidadJugadasJugador;
    protected int cantidadDeRondas = 0;
    protected Jugador jugadorPrevio;
    protected int indiceJugador = 0;
    protected List<Button> botonesEnvido;
    protected List<Button> botonesFlor;
    protected List<Button> botonesTanto;
    protected List<Button> botonesTruco;
    protected List<Button> botonesQuiero;
    protected List<ImageView> imagenesMazo;
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

        this.visibilizarBotones(this.botonesCartasJugadasJugador1, false);
        this.visibilizarBotones(this.botonesCartasJugadasJugador2, false);
        this.visibilizarBotones(this.botonesCartasJugadasJugador3, false);
        this.visibilizarBotones(this.botonesCartasJugadasJugador4, false);
        this.visibilizarBotones(this.botonesCartasJugadasJugador5, false);
        this.visibilizarBotones(this.botonesCartasJugadasJugador6, false);
        this.visibilizarBotones(this.botonesQuiero, false);
        this.visibilizarBotones(Arrays.asList(this.botonRetruco, this.botonValeCuatro), false);
        //this.imagenMesa.setImage(new Image("/gui/images/mesa.png"));

        this.imagenesMazo = new ArrayList<>(Arrays.asList(this.imagenMazoJ1, this.imagenMazoJ2, this.imagenMazoJ3, this.imagenMazoJ4, this.imagenMazoJ5,
                this.imagenMazoJ6));
        this.visibilizarImagenes(this.imagenesMazo, false);
        this.imagenesMazo.get(0).setVisible(true);

    }


    public void setMain(Main main, MesaPicaPica mesa, Equipo equipo1, Equipo equipo2) {

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

            // boolean continuar = false;

            //  while(!continuar) {
            //     try {
            this.botonesCartasJugadorActual.get(i).setGraphic(new ImageView(this.diccionarioCartas.representacionCarta(this.cartasJugadorActual.get(i))));
            //          continuar = true;
            //   } catch (RuntimeException a) {

            //  }
            //}

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
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();
            this.mostrarJugadorActual();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void JugarCarta2Handler() {

        try {

            mesa.hacerJugada(cartasJugadorActual.get(1));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(1));
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();
            this.mostrarJugadorActual();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void JugarCarta3Handler() {

        try {

            mesa.hacerJugada(cartasJugadorActual.get(2));
            this.mostrarCartaEnMesa(cartasJugadorActual.get(2));
            this.mostrarPuntos();
            if (this.mesa.getCartasEnMesa().size() == 0) this.nuevaRonda();
            this.mostrarJugadorActual();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    protected void nuevaRonda() {

        int cantidadJugadores = this.mesa.getEquipoActual().getCantidadIntegrantes() * 2;

        this.cantidadDeRondas++;

        for(int i = 0; i < cantidadJugadores; i++) {

            for (Button botonCartaJugada : this.botonesCartasJugadas.get(i)) {

                botonCartaJugada.setVisible(false);

            }

            this.cantidadJugadasJugador.set(i, 0);

        }

        this.visibilizarImagenes(this.imagenesMazo, false);
        this.imagenesMazo.get(this.cantidadDeRondas % cantidadJugadores).setVisible(true);

    }

    protected void mostrarCartaEnMesa(Carta cartaJugada) {

        Integer numeroJugada = this.cantidadJugadasJugador.get(this.indiceJugador);
        Button botonCartaJugada = this.botonesCartasJugadas.get(this.indiceJugador).get(numeroJugada);

        botonCartaJugada.setVisible(true);

        //boolean continuar = false;

        // while(!continuar) {

        //   try {
        botonCartaJugada.setGraphic(new ImageView(this.diccionarioCartas.representacionCarta(cartaJugada)));
        //      continuar = true;
        //   } catch (RuntimeException a) {

        //   }

        //}

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

            mesa.reTruco();

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

        try {

            this.mesa.envido();

        } catch(JugadorNoPieNoPuedeCantarEnvido jugadorNoPieNoPuedeCantarEnvido) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador que no es pie no puede cantar tanto");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar envido ya que usted no es pie.");
            alert.showAndWait();

        }

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarRealEnvidoHandler() {

        try {

            this.mesa.realEnvido();

        } catch(JugadorNoPieNoPuedeCantarEnvido jugadorNoPieNoPuedeCantarEnvido) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador que no es pie no puede cantar tanto");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar real envido ya que usted no es pie.");
            alert.showAndWait();

        }

        this.mostrarJugadorActual();

    }

    @FXML
    protected void cantarFaltaEnvidoHandler() {

        try {

            this.mesa.faltaEnvido();

        } catch(JugadorNoPieNoPuedeCantarEnvido jugadorNoPieNoPuedeCantarEnvido) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Jugador que no es pie no puede cantar tanto");
            alert.setHeaderText("");
            alert.setContentText("No puede cantar falta envido ya que usted no es pie.");
            alert.showAndWait();

        }

        this.mostrarJugadorActual();

    }

    @FXML
    private void quieroEnvidoHandler() {

        try {

            this.mesa.quieroEnvido();

            this.mostrarPuntos();
            this.mostrarJugadorActual();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void quieroFlorHandler() {

        try {

            this.mesa.quieroFlor();

            this.mostrarPuntos();
            this.mostrarJugadorActual();

        } catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    @FXML
    private void noQuieroTantoHandler() {

        try {

            this.mesa.noQuieroTanto();

            this.mostrarPuntos();
            this.mostrarJugadorActual();

        }catch (JuegoTerminadoException terminado) {

            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());

        }

    }

    protected void mostrarJugadorActual() {

        this.setearBotones();
        this.mostrarEstadoJuego();

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % (this.mesa.getEquipoActual().getCantidadIntegrantes() * 2);

        }

        try {
            this.mesa.getJugadorActual().flor();
        } catch(JugadorNoTieneFlorException jugadorNoTieneFlorException) {
            this.botonFlor.setVisible(false);
        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.jugadorPrevio.getNombre());

        this.cartasJugadorActual = this.jugadorPrevio.obtenerCartas();

        for(Button boton : this.botonesCartasJugadorActual) {

            boton.setGraphic(new ImageView(DORSO_CARTA));
            boton.setDisable(true);

        }

        if(!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

            this.visibilizarBotones(this.botonesTanto, false);

        }

    }

    protected void visibilizarBotones(List<Button> botones, boolean visibilidad) {

        try {

            for(Button boton : botones) {

                boton.setVisible(visibilidad);

            }

        } catch(NullPointerException nullPointerException) {

        }

    }

    protected void visibilizarImagenes(List<ImageView> imagenes, boolean visibilidad) {

        try {

            for(ImageView imagen : imagenes) {

                imagen.setVisible(visibilidad);

            }

        } catch(NullPointerException nullPointerException) {

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

    protected void mostrarEstadoJuego() {

        EstadoJuego estadoJuego = this.mesa.getEstadoVuelta().getEstadoJuego();

        this.labelEstadoJuego.setText(this.diccionarioEstadosJuego.obtenerMensajeEstado(estadoJuego));

    }

}
