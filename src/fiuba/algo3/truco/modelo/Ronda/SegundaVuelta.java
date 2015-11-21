package fiuba.algo3.truco.modelo.Ronda;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class SegundaVuelta implements EstadoRonda {

    private EstadoJuego estadoJuego;
    private List<Equipo> ganadoresVuelta;
    private Equipo ganadorSegunda;
    private Carta cartaGanadora;
    private boolean seJuegaConFlor;

    public SegundaVuelta(EstadoJuego estadoJuego, Equipo ganadorPrimera, boolean seJuegaConFlor) {

        this.estadoJuego = estadoJuego;
        this.ganadoresVuelta = new ArrayList<>();
        this.ganadoresVuelta.add(ganadorPrimera);
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

        return this.estadoJuego.puntos();

    }

    @Override
    public int noQuerido() {

        return this.estadoJuego.noQuerido();

    }

    @Override
    public EstadoRonda terminarVuelta() {

        try {

            if (ganadoresVuelta.get(0) == ganadoresVuelta.get(1)) {

                this.ganadoresVuelta.get(0).sumarPuntos(this.estadoJuego.puntos());

                return new PrimeraVuelta(this.seJuegaConFlor);

            }

        } catch(NullPointerException nullPointerException) {}

        this.ganadoresVuelta.add(ganadorSegunda);

        return new TerceraVuelta(this.estadoJuego, this.ganadoresVuelta, this.seJuegaConFlor);

    }

    @Override
    public void calcularGanadorJugada(Equipo equipoActual, Equipo equipoContrario, Carta carta) {

        try {

            if(this.cartaGanadora.truco(carta) < 0) {

                this.ganadorSegunda = equipoActual;
                this.cartaGanadora = carta;

            } else {

                if(this.cartaGanadora.truco(carta) > 0) {

                    this.ganadorSegunda = equipoContrario;

                } else {

                    this.ganadorSegunda = null;

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

        return this.ganadoresVuelta.get(0);

    }


}
