package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Mesa;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by GomezPeter on 28/11/2015.
 */
public class ControladorVentanaJuego {

    @FXML
    private Label turno;
    @FXML
    private Label puntajeEquipo1;
    @FXML
    private Label puntajeEquipo2;

    private Mesa mesa;
    private Main main;
    private Equipo equipo1;
    private Equipo equipo2;

    public void setMain(Main main, Mesa mesa,Equipo equipo1, Equipo equipo2) {
        this.main = main;
        this.mesa = mesa;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    @FXML
    private void initialize(){
        mostrarPuntos();
        mostrarJugadorActual();
    }

    private void mostrarPuntos(){
        this.puntajeEquipo1.setText(Integer.toString(mesa.puntaje(equipo1)));
        this.puntajeEquipo2.setText(Integer.toString(mesa.puntaje(equipo1)));
    }
    private void mostrarJugadorActual(){
        this.turno.setText(mesa.getJugadorActual().getNombre());
    }

}
