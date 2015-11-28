package fiuba.algo3.truco.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage ventanaPrincipal;
    private BorderPane diseñoRaiz;

    @Override
    public void start(Stage primaryStage) {
        this.ventanaPrincipal = primaryStage;
        this.ventanaPrincipal.setTitle("Truco");

        iniciarVentanaRaiz();

    }

    public void iniciarVentanaRaiz() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("diseñoRaiz.fxml"));
            this.diseñoRaiz = (BorderPane) loader.load();

            Scene scene = new Scene(this.diseñoRaiz);
            this.ventanaPrincipal.setScene(scene);
            this.ventanaPrincipal.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
