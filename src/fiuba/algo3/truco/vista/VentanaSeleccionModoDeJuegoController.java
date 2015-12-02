package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.IA.JugadorIA;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Mesa;
import fiuba.algo3.truco.modelo.MesaPicaPica;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
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
    private TextField textEquipo1;
    @FXML
    private TextField textEquipo2;
    @FXML
    private CheckBox checkJugarConFlor;
    @FXML
    private Button botonComenzarJuego;

    private Main main;
    private List<TextField> nombresJugadores;
    private List<TextField> nombresEquipos;
    private int cantidadJugadores;

    @FXML
    private void initialize() {

        this.nombresJugadores = new ArrayList<>(Arrays.asList(this.textJ1E1, this.textJ1E2, this.textJ2E1, this.textJ2E2, this.textJ3E1, this.textJ3E2));
        this.nombresEquipos = new ArrayList<>(Arrays.asList(this.textEquipo1, this.textEquipo2));
        this.visibilizarElementos(this.nombresJugadores, false);
        this.visibilizarElementos(this.nombresEquipos, false);

        this.botonComenzarJuego.setDisable(true);

    }

    public void setMain(Main main) {

        this.main = main;

    }

    @FXML
    private void opcionDeADosContraLaPCHandler() {

        this.cantidadJugadores = 1;

        this.visibilizarElementos(this.nombresJugadores, false);
        this.visibilizarElementos(this.nombresEquipos, false);

        this.nombresJugadores.get(0).setVisible(true);

        this.botonComenzarJuego.setDisable(false);

    }

    @FXML
    private void opcionDeADosHandler() {

        this.cantidadJugadores = 2;

        this.visibilizarElementos(this.nombresJugadores, false);

        for(int i = 0; i < this.cantidadJugadores; i++) {

            this.nombresJugadores.get(i).setVisible(true);

        }

        this.botonComenzarJuego.setDisable(false);

    }

    @FXML
    private void opcionDeACuatroHandler() {

        this.cantidadJugadores = 4;

        this.visibilizarElementos(this.nombresJugadores, false);

        for(int i = 0; i < this.cantidadJugadores; i++) {

            this.nombresJugadores.get(i).setVisible(true);

        }

        this.visibilizarElementos(this.nombresEquipos, true);

        this.botonComenzarJuego.setDisable(false);

    }

    @FXML
    private void opcionDeASeisHandler() {

        this.cantidadJugadores = 6;

        this.visibilizarElementos(this.nombresJugadores, true);
        this.visibilizarElementos(this.nombresEquipos, true);

        this.botonComenzarJuego.setDisable(false);

    }

    @FXML
    private void comenzarJuegoHandler() {

        List<Jugador> jugadoresEquipo1 = new ArrayList<>();
        List<Jugador> jugadoresEquipo2 = new ArrayList<>();
        Equipo equipo1;
        Equipo equipo2;
        boolean seJuegaConFlor = this.checkJugarConFlor.isSelected();
        int jugadoresPorEquipo = this.cantidadJugadores / 2;

        for(int i = 0; i < this.cantidadJugadores; i++) {

            if(this.nombresJugadores.get(i).getText().equals(""))
                this.nombresJugadores.get(i).setText("Jugador " + (i + 1));

        }

        for(int i = 0; i < jugadoresPorEquipo; i++){

            jugadoresEquipo1.add(new Jugador(this.nombresJugadores.get(2 * i).getText()));
            jugadoresEquipo2.add(new Jugador(this.nombresJugadores.get(i * 2 + 1).getText()));

        }

        if(this.textEquipo1.getText().equals("")) this.textEquipo1.setText("Equipo 1");
        if(this.textEquipo2.getText().equals("")) this.textEquipo2.setText("Equipo 2");

        if(this.cantidadJugadores == 1) {

            if(this.textJ1E1.getText().equals("")) this.textJ1E1.setText("Jugador 1");
            this.textEquipo1.setText(this.textJ1E1.getText());
            jugadoresEquipo1.add(new Jugador(this.textJ1E1.getText()));
            this.textEquipo2.setText("PC");
            jugadoresEquipo2.add(new JugadorIA("PC"));

        }

        if(this.cantidadJugadores == 2) {

            this.textEquipo1.setText(this.textJ1E1.getText());
            this.textEquipo2.setText(this.textJ1E2.getText());

        }

        equipo1 = new Equipo(this.textEquipo1.getText(), jugadoresEquipo1);
        equipo2 = new Equipo(this.textEquipo2.getText(), jugadoresEquipo2);

        if(this.cantidadJugadores == 1) {

            Mesa mesa = new Mesa(equipo1, equipo2, seJuegaConFlor);

            ((JugadorIA) jugadoresEquipo2.get(0)).setMesa(mesa);
            this.main.iniciarPartidaContraLaPC(mesa, equipo1, equipo2);

        }

        if(this.cantidadJugadores == 2)
            this.main.iniciarPartidaDeADos(new Mesa(equipo1, equipo2, seJuegaConFlor), equipo1, equipo2);

        if(this.cantidadJugadores == 4)
            this.main.iniciarPartidaDeACuatro(new Mesa(equipo1, equipo2, seJuegaConFlor),equipo1,equipo2);

        if(this.cantidadJugadores == 6)
            this.main.iniciarPartidaDeASeis(new MesaPicaPica(equipo1, equipo2, seJuegaConFlor),equipo1,equipo2);

    }

    private void visibilizarElementos(List<TextField> elementos, boolean visibilidad) {

        for(Node nodo : elementos) {

            nodo.setVisible(visibilidad);

        }

    }


}
