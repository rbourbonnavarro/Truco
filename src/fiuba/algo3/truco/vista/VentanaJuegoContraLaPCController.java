package fiuba.algo3.truco.vista;

import fiuba.algo3.truco.IA.JugadorIA;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorCantada;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;
import fiuba.algo3.truco.modelo.Ronda.Vuelta;
import javafx.scene.control.Button;

public class VentanaJuegoContraLaPCController extends VentanaJuegoController {

    @Override
    protected void mostrarJugadorActual() {

        if(!this.jugadorPrevio.equals(this.mesa.getJugadorActual())) {

            this.indiceJugador = (this.indiceJugador + 1) % 2;

        }

        this.jugadorPrevio = this.mesa.getJugadorActual();

        this.turno.setText(this.jugadorPrevio.getNombre());

        this.cartasJugadorActual = this.jugadorPrevio.obtenerCartas();

        if(this.mesa.getJugadorActual().equals(this.equipo1.getJugadorActual())) {

            this.puedoCantar();

            if (!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

                this.visibilizarBotones(this.botonesTanto, false);

            }

            this.mostrarCartasJugadorActual();

        }
        else {

            JugadorIA jugadorIA = (JugadorIA) this.mesa.getJugadorActual();
            jugadorIA.turno();

            if(jugadorIA.obtenerCartas().contains(this.mesa.getCartasEnMesa().getLast())) {

                this.mostrarCartaEnMesa(this.mesa.getCartasEnMesa().getLast());

            }

        }

    }

    private void puedoCantar() {

        Vuelta estadoVuelta = this.mesa.getEstadoVuelta();
        EstadoJuego estadoJuego = estadoVuelta.getEstadoJuego();

        this.visibilizarBotones(this.botonesTruco, true);
        this.visibilizarBotones(this.botonesTanto, true);

        this.puedoCantarTruco();
        this.puedoCantarTanto();

    }

    private void puedoCantarTruco() {

        Vuelta estadoVuelta = this.mesa.getEstadoVuelta();
        EstadoJuego estadoJuego = estadoVuelta.getEstadoJuego();

        //if(estadoJuego instanceof)

    }

    private void puedoCantarTanto() {

        Vuelta estadoVuelta = this.mesa.getEstadoVuelta();
        EstadoJuego estadoJuego = estadoVuelta.getEstadoJuego();

        if(!this.mesa.seJuegaConFlor()) this.visibilizarBotones(this.botonesFlor, false);

        if(estadoVuelta instanceof PrimeraVuelta) {

            if(estadoJuego instanceof EnvidoEnvidoCantado) this.visibilizarBotones(this.botonesFlor, false);

            if(estadoJuego instanceof EnvidoEnvidoCantado
                    || estadoJuego instanceof RealEnvidoCantado
                    || estadoJuego instanceof FaltaEnvidoCantado) {

                this.botonEnvido.setVisible(false);

            }

            if(estadoJuego instanceof FaltaEnvidoCantado) {

                this.botonEnvido.setVisible(false);
                this.botonRealEnvido.setVisible(false);

            }

            if(estadoJuego instanceof FlorCantada) this.visibilizarBotones(this.botonesEnvido, false);

            if(estadoJuego instanceof FlorFlorCantada
                    || estadoJuego instanceof ContraFlorAlRestoCantada
                    || estadoJuego instanceof ContraFlorAlPartidoCantado)
                this.visibilizarBotones(this.botonesTanto, false);

        }
        else {

            this.visibilizarBotones(this.botonesTanto, false);

        }

    }


}
