package fiuba.algo3.truco.vista;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VentanaSeleccionModoDeJuegoController {

    @FXML
    private TextField textJ1E1;
    @FXML
    private TextField textJ1E2;
    @FXML
    private TextField textJ2E1;
    @FXML
    private TextField textJ2E2;
    @FXML
    private TextField textJ3E1;
    @FXML
    private TextField textJ3E2;
    @FXML
    private List<TextField> jugadores;

    private Main main;

    @FXML
    private void initialize() {

        this.jugadores = new ArrayList<>(Arrays.asList(this.textJ1E1, this.textJ1E2, this.textJ2E1, this.textJ2E2, this.textJ3E1, this.textJ3E2));
        for(TextField textField : this.jugadores) {

            textField.setVisible(false);

        }

    }

    public void setMain(Main main) {

        this.main = main;

    }

    @FXML
    private void opcionDeADosContraLaPCHandler() {

        for(TextField textField : this.jugadores) {

            textField.setVisible(false);

        }

        this.jugadores.get(0).setVisible(true);

    }

    @FXML
    private void opcionDeADosHandler() {

        for(TextField textField : this.jugadores) {

            textField.setVisible(false);

        }

        for(int i = 0; i < 2; i++) {

            this.jugadores.get(i).setVisible(true);

        }

    }

    @FXML
    private void opcionDeACuatroHandler() {

        for(TextField textField : this.jugadores) {

            textField.setVisible(false);

        }

        for(int i = 0; i < 4; i++) {

            this.jugadores.get(i).setVisible(true);

        }

    }

    @FXML
    private void opcionDeASeisHandler() {

        for(TextField textField : this.jugadores) {

            textField.setVisible(true);

        }

    }


}
