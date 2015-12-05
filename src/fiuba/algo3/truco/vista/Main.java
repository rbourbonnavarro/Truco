package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.controlador.*;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.MesaPicaPica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage ventanaPrincipal;
    private BorderPane disenioRaiz;
    @Override
    public void start(Stage primaryStage) {

        this.ventanaPrincipal = primaryStage;
        this.ventanaPrincipal.setTitle("Truco");

        iniciarVentanaRaiz();

        iniciarSeleccionModoDeJuego();

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

    public void iniciarPartidaContraLaPC(Mesa mesa, Equipo equipo1, Equipo equipo2) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("JuegoContraLaPC.fxml"));
            AnchorPane partidaDeADos = loader.load();

            this.disenioRaiz.setCenter(partidaDeADos);

            VentanaJuegoContraLaPCController controlador = loader.getController();
            controlador.setMain(this, mesa, equipo1, equipo2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void juegoTerminado(String equipoGanador){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("juegoTerminado.fxml"));
            AnchorPane juegoTerminado = loader.load();

            this.disenioRaiz.setCenter(juegoTerminado);

            VentanaJuegoTerminadoController controlador = loader.getController();
            controlador.setMain(this,equipoGanador);

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


    public void salir() {

        this.ventanaPrincipal.close();

    }

    public void iniciarPartidaDeACuatro(Mesa mesa, Equipo equipo1, Equipo equipo2) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("juegoDeACuatro.fxml"));
            AnchorPane partidaDeADos = loader.load();

            this.disenioRaiz.setCenter(partidaDeADos);

            VentanaJuegoController controlador = loader.getController();
            controlador.setMain(this, mesa, equipo1, equipo2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iniciarPartidaDeASeis(MesaPicaPica mesa, Equipo equipo1, Equipo equipo2) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("juegoDeASeis.fxml"));
            AnchorPane partidaDeADos = loader.load();

            this.disenioRaiz.setCenter(partidaDeADos);

            VentanaJuegoPicaPicaController controlador = loader.getController();
            controlador.setMain(this, mesa, equipo1, equipo2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
