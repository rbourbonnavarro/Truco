package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.LaCartaNoSeEncuentraEnLaManoDelJugadorException;
import fiuba.algo3.truco.modelo.Mesa;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by GomezPeter on 28/11/2015.
 */
public class VentanaJuegoController {

    @FXML
    private Label turno;
    @FXML
    private Label puntajeEquipo1;
    @FXML
    private Label puntajeEquipo2;
    @FXML
    private Label carta1;
    @FXML
    private Label carta2;
    @FXML
    private Label carta3;
    @FXML
    private List<Label> cartas;


    private Mesa mesa;
    private Main main;
    private Equipo equipo1;
    private Equipo equipo2;
    private List<Carta> cartasJugadorActual;

    public VentanaJuegoController(){
    }


    public void setMain(Main main, Mesa mesa,Equipo equipo1, Equipo equipo2) {
        this.main = main;
        this.mesa = mesa;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        mostrarPuntos();
        mostrarJugadorActual();
        mostrarCartasJugadorActual();
    }

    private void mostrarCartasJugadorActual() {
        cartasJugadorActual = mesa.getCartasDelJugadorActual();
       for (int i=0; i<cartasJugadorActual.size();i++) {
           cartas.get(i).setText(this.toString(cartasJugadorActual.get(i)));
       }
    }

    private String toString(Carta carta) {
        return Integer.toString(carta.getValor()) +" de "+ carta.getPalo().getClass().getSimpleName();
    }

    @FXML
    private void JugarCarta1Handler() {
        try {
            mesa.hacerJugada(cartasJugadorActual.get(0));
            this.mostrarJugadorActual();
            this.mostrarCartasJugadorActual();
        } catch (LaCartaNoSeEncuentraEnLaManoDelJugadorException e){
            this.mostrarAlertaCartaInvalida();
        }
    }
    @FXML
    private void JugarCarta2Handler() {
        try {
            mesa.hacerJugada(cartasJugadorActual.get(1));
            this.mostrarJugadorActual();
            this.mostrarCartasJugadorActual();
        } catch (LaCartaNoSeEncuentraEnLaManoDelJugadorException e){
            this.mostrarAlertaCartaInvalida();
        }
    }
    @FXML
    private void JugarCarta3Handler() {
        try {
            mesa.hacerJugada(cartasJugadorActual.get(2));
            this.mostrarJugadorActual();
            this.mostrarCartasJugadorActual();
        } catch (LaCartaNoSeEncuentraEnLaManoDelJugadorException e){
            this.mostrarAlertaCartaInvalida();
        }
    }

    private void mostrarAlertaCartaInvalida() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Carta invalida");
        alert.setHeaderText(null);
        alert.setContentText("No puede jugar esta carta no la tiene mas en su mano.");
        alert.showAndWait();
    }

    @FXML
    private void initialize(){
        this.cartas = new LinkedList<>();
    }

    private void mostrarPuntos(){
        this.puntajeEquipo1.setText(Integer.toString(mesa.puntaje(equipo1)));
        this.puntajeEquipo2.setText(Integer.toString(mesa.puntaje(equipo1)));
    }
    private void mostrarJugadorActual(){
        this.turno.setText(mesa.getJugadorActual().getNombre());
    }

}
