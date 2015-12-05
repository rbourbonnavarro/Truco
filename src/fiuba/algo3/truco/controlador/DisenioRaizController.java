package fiuba.algo3.truco.controlador;

import fiuba.algo3.truco.vista.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

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

    @FXML
    private void acercaDeHandler() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Truco Algoritmos 3 FIUBA");
        alert.setHeaderText("");
        alert.setContentText(
                "Desarrollado por:\n\n" +
                "Rodrigo Bourbon Navarro, mail: rodrigobourbon44@gmail.com\n\n" +
                        "Federico Gomez Peter, mail: fedemgp@gmail.com\n\n" +
                        "Maximiliano Suppes, mail: maxisuppes@gmail.com\n" +
                        "\n\n" +
                        "Repositorio de github del proyecto:\n" +
                        "https://github.com/rbourbonnavarro/Truco"
        );
        alert.showAndWait();

    }


}
