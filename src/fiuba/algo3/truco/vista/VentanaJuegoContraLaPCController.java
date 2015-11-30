package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.IA.JugadorIA;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.NoSuchElementException;

public class VentanaJuegoContraLaPCController extends VentanaJuegoController {

    @FXML
    private Label labelEstadoJuego;

    @Override
    protected void mostrarJugadorActual() {

        this.setearBotones();

        this.labelEstadoJuego.setText(this.diccionarioEstadosJuego.obtenerMensajeEstado(this.mesa.getEstadoVuelta().getEstadoJuego()));

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % 2;

        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.jugadorPrevio.getNombre());

        this.cartasJugadorActual = this.jugadorPrevio.obtenerCartas();

        if(this.mesa.getJugadorActual().equals(this.equipo1.getJugadorActual())) {

            if (!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

                this.visibilizarBotones(this.botonesTanto, false);

            }

            this.mostrarCartasJugadorActual();

        }
        else {

            JugadorIA jugadorIA = (JugadorIA) this.mesa.getJugadorActual();
            jugadorIA.turno();

            this.labelEstadoJuego.setText(this.diccionarioEstadosJuego.obtenerMensajeEstado(this.mesa.getEstadoVuelta().getEstadoJuego()));

            try {

                if (jugadorIA.obtenerCartas().contains(this.mesa.getCartasEnMesa().getLast())) {

                    this.mostrarCartaEnMesa(this.mesa.getCartasEnMesa().getLast());

                }

            } catch(NoSuchElementException noSuchElementException) {}

        }

    }


}
