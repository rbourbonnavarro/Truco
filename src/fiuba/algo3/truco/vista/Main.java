package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mesa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class Main extends Application {

    private Stage ventanaPrincipal;
    private BorderPane disenioRaiz;
    private Mesa mesa;
    private Equipo equipo1;
    private Equipo equipo2;

    @Override
    public void start(Stage primaryStage) {


        this.ventanaPrincipal = primaryStage;
        this.ventanaPrincipal.setTitle("Truco");

        iniciarVentanaRaiz();

        /*this.equipo1 = new Equipo("equipo1",Arrays.asList(new Jugador("J1")));
        this.equipo2 = new Equipo("equipo2",Arrays.asList(new Jugador("J2")));
        this.mesa = new Mesa(equipo1, equipo2,false);*/

        iniciarSeleccionModoDeJuego();

        //iniciarPartidaDeADos();

    }

    public void iniciarSeleccionModoDeJuego() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SeleccionModoDeJuego.fxml"));
            AnchorPane seleccionModoDeJuego = loader.load();

            this.disenioRaiz.setCenter(seleccionModoDeJuego);

            VentanaSeleccionModoDeJuegoController controlador = loader.getController();
            controlador.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iniciarPartidaDeADos(Mesa mesa, Equipo equipo1, Equipo equipo2) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("juegoDeADos.fxml"));
            AnchorPane partidaDeADos = loader.load();

            this.disenioRaiz.setCenter(partidaDeADos);

            VentanaJuegoController controlador = loader.getController();
            controlador.setMain(this, mesa, equipo1, equipo2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iniciarVentanaRaiz() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("disenioRaiz.fxml"));
            this.disenioRaiz = loader.load();

            DisenioRaizController controlador = loader.getController();
            controlador.setMain(this);

            Scene scene = new Scene(this.disenioRaiz);
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
