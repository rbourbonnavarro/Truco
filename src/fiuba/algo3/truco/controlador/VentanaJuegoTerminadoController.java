package fiuba.algo3.truco.controlador;

import fiuba.algo3.truco.vista.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Created by GomezPeter on 29/11/2015.
 */
public class VentanaJuegoTerminadoController {
    @FXML
    private Button comenzarJuego;
    @FXML
    private Button salir;
    @FXML
    private Text equipoGanador;

    private Main main;


    public void setMain(Main main,String equipoGanador) {
        this.main = main;
        this.equipoGanador.setText(equipoGanador);
    }

    @FXML
    private void setComenzarJuego(){
        this.main.iniciarSeleccionModoDeJuego();
    }
    @FXML
    private void salir(){
            this.main.salir();

    }
}
