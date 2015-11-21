package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Envido.JugadorNoPuedeCantarTantoNoEsPrimeraVuelta;
import fiuba.algo3.truco.modelo.EstadoFlor.EstadoFlor;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class TerceraVuelta implements EstadoRonda {

    private EstadoJuego estadoJuego;
    private List<Equipo> ganadoresVuelta;
    private Equipo ganadorTercera;
    private Carta cartaGanadora;
    private boolean seJuegaConFlor;

    public TerceraVuelta(EstadoJuego estadoJuego, List<Equipo> ganadoresVuelta, boolean seJuegaConFlor) {

        this.estadoJuego = estadoJuego;
        this.ganadoresVuelta = new ArrayList<>(ganadoresVuelta);
        this.seJuegaConFlor = seJuegaConFlor;

    }

    @Override
    public void truco() {

        this.estadoJuego = this.estadoJuego.truco();

    }

    @Override
    public void reTruco() {

        this.estadoJuego = this.estadoJuego.reTruco();

    }

    @Override
    public void valeCuatro() {

        this.estadoJuego = this.estadoJuego.valeCuatro();

    }

    @Override
    public void envido(Jugador jugadorActual) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void envidoEnvido() {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void realEnvido(Jugador jugadorActual) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void faltaEnvido(Jugador jugadorActual, Puntaje puntos) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void flor() {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void contraFlorAlResto(Puntaje puntos) {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void contraFlorAlPartido() {

        throw new JugadorNoPuedeCantarTantoNoEsPrimeraVuelta();

    }

    @Override
    public void terminarTanto() {

    }

    @Override
    public void quiero() {

        this.estadoJuego = this.estadoJuego.quiero();

    }

    @Override
    public int puntos() {
        return 0;
    }

    @Override
    public int noQuerido() {
        return 0;
    }

    @Override
    public EstadoRonda terminarVuelta() {

        try {

            this.ganadoresVuelta.get(2).sumarPuntos(this.estadoJuego.puntos());

            return new PrimeraVuelta(this.seJuegaConFlor);


        } catch(NullPointerException nullPointerException) {

            try {

                this.ganadoresVuelta.get(0).sumarPuntos(this.estadoJuego.puntos());

                return new PrimeraVuelta(this.seJuegaConFlor);

            } catch(NullPointerException e) {

                return new PrimeraVuelta(this.seJuegaConFlor);

            }

        }

    }

    @Override
    public void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta) {

        try {

            if(this.cartaGanadora.truco(carta) < 0) {

                this.ganadorTercera = equipoActual;
                this.cartaGanadora = carta;

            } else {

                if(this.cartaGanadora.truco(carta) > 0) {

                    this.ganadorTercera = equipoContrario;

                } else {

                    this.ganadorTercera = null;

                }

            }

        } catch(NullPointerException nullPointerException) {

            this.cartaGanadora = carta;

        }

    }

    @Override
    public EstadoRonda terminar(Equipo equipoGanador, int puntos) {

        equipoGanador.sumarPuntos(puntos);

        return new PrimeraVuelta(this.seJuegaConFlor);

    }

    @Override
    public Equipo getGanadorVuelta() {

        return this.ganadoresVuelta.get(1);

    }


}
