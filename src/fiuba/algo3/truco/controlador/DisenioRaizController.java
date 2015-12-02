package fiuba.algo3.truco.controlador;

import fiuba.algo3.truco.vista.Main;
import javafx.fxml.FXML;

public class DisenioRaizController {

    private Main main;

    public void setMain(Main main) {

        this.main = main;

    }

    @FXML
    private void nuevoJuegoHandler() {

        this.main.iniciarSeleccionModoDeJuego();

    }

    @FXML
    private void salirHandler() {

        System.exit(0);

    }


}
