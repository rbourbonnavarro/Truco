package fiuba.algo3.truco.controlador;

import fiuba.algo3.truco.IA.JugadorIA;
import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Puntos.JuegoTerminadoException;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.NoSuchElementException;

public class VentanaJuegoContraLaPCController extends VentanaJuegoController {

    @FXML
    private Button botonContinuar;

    @FXML
    private void botonContinuarHandler() {
        try {
            JugadorIA jugadorIA = (JugadorIA) this.mesa.getJugadorActual();

            EstadoJuego estadoJuegoPrevio = this.mesa.getEstadoVuelta().getEstadoJuego();

            Carta ultimaCartaJugadaIA = jugadorIA.getUltimaCartaJugada();

            jugadorIA.turno();

            if (!(estadoJuegoPrevio instanceof NadaCantado)
                    && this.mesa.getEstadoVuelta().getEstadoJuego() instanceof NadaCantado) {

                this.nuevaRonda();

            } else {

                try {

                    if (ultimaCartaJugadaIA != jugadorIA.getUltimaCartaJugada()) {

                        this.mostrarCartaEnMesa(jugadorIA.getUltimaCartaJugada());

                    }

                    if(jugadorIA.obtenerCartasEnMano().size() == 0 && this.mesa.getCartasEnMesa().size() == 6)
                        this.nuevaRonda();

                } catch (NoSuchElementException noSuchElementException) {

                    if (jugadorIA.obtenerCartasEnMano().size() < 3) {

                        this.nuevaRonda();

                    }

                }

            }

            this.mostrarEstadoJuego();
            this.mostrarPuntos();

            this.mostrarJugadorActual();
        }catch (JuegoTerminadoException e) {
            this.main.juegoTerminado(mesa.getEquipoGanador().getNombre());
        }
    }

    @Override
    protected void mostrarJugadorActual() {

        this.setearBotones();
        this.mostrarEstadoJuego();

        this.mostrarPuntos();

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % 2;

        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.jugadorPrevio.getNombre());

        this.cartasJugadorActual = this.jugadorPrevio.obtenerCartas();

        if(this.mesa.getJugadorActual().equals(this.equipo1.getJugadorActual())) {

            this.botonContinuar.setDisable(true);

            if (!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

                this.visibilizarBotones(this.botonesTanto, false);

            }

            try {

                this.mesa.getEstadoVuelta().estadoValido();

                this.desactivarBotones(this.botonesCartasJugadorActual, false);

            } catch(Exception e) {

                this.desactivarBotones(this.botonesCartasJugadorActual, true);

            }

            this.mostrarCartasJugadorActual();

        }
        else {

            this.botonContinuar.setDisable(false);

            this.visibilizarBotones(this.botonesTanto, false);
            this.visibilizarBotones(this.botonesTruco, false);
            this.visibilizarBotones(this.botonesQuiero, false);

            this.desactivarBotones(this.botonesCartasJugadorActual, true);

        }

    }


}
