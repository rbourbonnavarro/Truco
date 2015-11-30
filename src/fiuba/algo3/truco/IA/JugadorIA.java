package fiuba.algo3.truco.IA;

import fiuba.algo3.truco.modelo.*;
import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorNoAceptadaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;
import fiuba.algo3.truco.modelo.Ronda.PrimeraVuelta;

import java.util.NoSuchElementException;

public class JugadorIA extends Jugador {

    private Mesa mesa;
    private ValoresTruco valoresTruco;
    private Carta ultimaCartaJugada;

    public JugadorIA(String nombre) {

        super(nombre);

        this.valoresTruco = new ValoresTruco();

        this.ultimaCartaJugada = null;

    }

    public void setMesa(Mesa mesa) {

        this.mesa = mesa;

    }

    public void turno() {


        try {

            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof NadaCantado
                    || this.mesa.getEstadoVuelta().getEstadoJuego() instanceof TrucoCantadoTantoNoJugado) {

                try {

                    this.decisionTanto();

                } catch (NoHayDecisionException e) {

                    try {

                        this.decisionTruco();

                    } catch (NoHayDecisionException a) {

                        this.ultimaCartaJugada = this.decisionCarta();

                        this.mesa.hacerJugada(this.ultimaCartaJugada);

                    }

                }

            }
            else {
                try {

                    this.decisionTruco();

                } catch (NoHayDecisionException a) {

                    this.ultimaCartaJugada = this.decisionCarta();

                    this.mesa.hacerJugada(this.ultimaCartaJugada);

                }

            }

        } catch(EnvidoNoQueridoNoSePuedeJugarException e) {

            try {

                this.decisionFlor();

            } catch(JugadorNoTieneFlorException jugadorNoTieneFlorException) {

                int envido = this.envido();

                if (envido == 33) this.mesa.faltaEnvido();
                if (envido >= 30 && envido <= 32) this.mesa.realEnvido();
                if (envido < 30 && envido >= 28) this.mesa.envido();
                if (envido < 28 && envido >= 25) this.mesa.quieroEnvido();
                if (envido < 25) this.mesa.noQuieroTanto();

            }

        } catch(EnvidoEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido < 30 && envido >= 28) this.mesa.quieroEnvido();
            if(envido < 28) this.mesa.noQuieroTanto();

        } catch(RealEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido >= 32) this.mesa.faltaEnvido();
            if(envido >=28 && envido < 32) this.mesa.quieroEnvido();
            if(envido < 28) this.mesa.noQuieroTanto();

        } catch(FaltaEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido == 33)
                this.mesa.quieroEnvido();
            else
                this.mesa.noQuieroTanto();

        } catch(FlorNoAceptadaNoSePuedeJugarException e) {

            try {

                int flor = this.flor();

                if(flor > 35) this.mesa.contraFlorAlPartido();
                if(flor > 32 && flor <= 35) this.mesa.contraFlorAlResto();
                if(flor >= 25 && flor <= 32) this.mesa.flor();
                if(flor < 25) this.mesa.quieroFlor();

            } catch(JugadorNoTieneFlorException a) {

                this.mesa.quieroFlor();

            }

        } catch(FlorFlorNoQueridaNoSePuedeJugarException e) {

            if(this.flor() > 23)
                this.mesa.quieroFlor();
            else
                this.mesa.noQuieroTanto();

        } catch(ContraFlorAlRestoNoQueridaNoSePuedeJugarException e) {

            int flor = this.flor();

            if(flor < 30)
                this.mesa.noQuieroTanto();
            else
                this.mesa.quieroFlor();

        } catch(ContraFlorAlPartidoNoQueridaNoSePuedeJugarException e) {

            int flor = this.flor();

            if(flor > 33)
                this.mesa.quieroFlor();
            else
                this.mesa.noQuieroTanto();

        } catch(TrucoNoQueridoNoSePuedeJugarException e) {

            if(this.manoDeValeCuatro())
                this.mesa.retruco();
            if(this.manoDeTruco())
                this.mesa.quieroTruco();
            else
                this.mesa.noQuieroTruco();

        } catch(RetrucoNoQueridoNoSePuedeJugarException e) {

            if(this.manoDeValeCuatro())
                this.mesa.valeCuatro();
            if(this.manoDeRetruco())
                this.mesa.quieroTruco();
            else
                this.mesa.noQuieroTruco();

        } catch(ValeCuatroNoQueridoNoSePuedeJugarException e) {

            if(this.manoDeValeCuatro())
                this.mesa.quieroTruco();
            else
                this.mesa.noQuieroTruco();

        }


        /*try {

            this.evaluarCantos(this.mesa.getEstadoVuelta());

        } catch(NoHayDecisionException noHayDecisionException) {

            this.mesa.hacerJugada(this.evaluarCartas());

        }*/


    }

    private Carta decisionCarta() {

        try {

            Carta ultimaCarta = this.mesa.getCartasEnMesa().getLast();

            if ((this.mesa.getCartasEnMesa().size() % 2) == 0)
                return this.cartaMasAlta();
            else {

                return this.cartaApropiada(ultimaCarta);

            }

        } catch(NoSuchElementException noSuchElementException) {

            return this.cartaMasAlta();

        }

    }

    private Carta cartaApropiada(Carta ultimaCarta) {

        Carta cartaQueGana = null;
        Carta cartaQueParda = null;
        Carta cartaMasBaja = this.obtenerCartasEnMano().get(0);

        for(Carta carta : this.obtenerCartasEnMano()) {

            if(carta.truco(ultimaCarta) > 0) {

                if(cartaQueGana == null) cartaQueGana = carta;
                if(cartaQueGana.truco(carta) > 0) cartaQueGana = carta;

            }

            if(carta.truco(ultimaCarta) == 0) cartaQueParda = carta;

            if(cartaMasBaja.truco(carta) > 0) cartaMasBaja = carta;

        }

        if(cartaQueGana != null) return cartaQueGana;
        if(cartaQueParda != null) return cartaQueParda;

        return cartaMasBaja;

    }

    /*private void evaluarCantos(Vuelta estadoVuelta) {

        if(estadoVuelta instanceof PrimeraVuelta) {

            try {

                this.decisionTanto();

            } catch(NoHayDecisionException noHayDecisionException) {

                this.decisionTruco();

            }

        }
        else {

            this.decisionTruco();

        }


    }*/

    private void decisionTanto() {

        try {

            this.decisionFlor();

        } catch(JugadorNoTieneFlorException jugadorNoTieneFlorException) {

            decisionEnvido();

        }

    }

    private void decisionFlor() {

        this.flor();

        this.mesa.flor();

    }

    private void decisionEnvido() {

        int envido = this.envido();

        if (envido == 33) this.mesa.faltaEnvido();
        if (envido >= 30 && envido <= 32) this.mesa.realEnvido();
        if (envido < 30 && envido >= 25) this.mesa.envido();
        if (envido < 25) throw new NoHayDecisionException();

    }

    private void decisionTruco() {

        if(this.manoDeValeCuatro()) {

            try {

                this.mesa.truco();

                return;

            } catch (NoSePuedeCantarTrucoException e) {

            }

            try {

                this.mesa.retruco();

                return;

            } catch (NoSePuedeCantarRetrucoException | EquipoQueCantoTrucoNoPuedeCantarRetrucoException e) {

            }

            try {

                this.mesa.valeCuatro();

                return;

            } catch (NoSePuedeCantarValeCuatroException | EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException e) {

            }

        }

        if(this.manoDeRetruco()) {

            try {

                this.mesa.truco();

                return;

            } catch (NoSePuedeCantarTrucoException e) {

            }

            try {

                this.mesa.retruco();

                return;

            } catch (NoSePuedeCantarRetrucoException | EquipoQueCantoTrucoNoPuedeCantarRetrucoException e) {

            }

        }

        if(this.manoDeTruco()) {

            try {

                this.mesa.truco();

                return;

            } catch (NoSePuedeCantarTrucoException e) {}

        }

        int cartaMasAlta = this.valoresTruco.rankingCarta(this.cartaMasAlta());

        if(!(this.mesa.getEstadoVuelta() instanceof PrimeraVuelta)) {

            if (cartaMasAlta >= 7)
                throw new NoHayDecisionException();

            try {

                try {

                    mesa.truco();

                } catch (NoSePuedeCantarTrucoException e) {

                    if (cartaMasAlta < 6)
                        try {
                            mesa.retruco();
                        } catch (NoSePuedeCantarRetrucoException e2) {
                            if (cartaMasAlta < 4)
                                try {
                                    mesa.valeCuatro();
                                } catch(NoSePuedeCantarValeCuatroException e3){
                                    throw new NoHayDecisionException();
                                }
                            else throw new NoHayDecisionException();
                        }
                    else {

                        throw new NoHayDecisionException();

                    }

                }

            } catch (EquipoQueCantoTrucoNoPuedeCantarRetrucoException e) {

                throw new NoHayDecisionException();

            } catch (EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException e) {

                throw new NoHayDecisionException();

            }

        }
        else {

            throw new NoHayDecisionException();

        }

    }

    private boolean manoDeValeCuatro() {

        int cartasAltas = 0;

        for(Carta carta : this.obtenerCartas()) {

            if(this.valoresTruco.rankingCarta(carta) <= 4)
                cartasAltas++;

        }

        if(cartasAltas > 1) return true;

        return false;

    }

    private boolean manoDeRetruco() {

        boolean tengoAlta = false;
        boolean tengoUnTres = false;

        for(Carta carta : this.obtenerCartas()) {

            if(this.valoresTruco.rankingCarta(carta) <= 4)
                tengoAlta = true;
            if(this.valoresTruco.rankingCarta(carta) == 5)
                tengoUnTres = true;

        }

        return tengoAlta && tengoUnTres;

    }

    private boolean manoDeTruco() {

        boolean tengoAlta = false;
        boolean tengoUnDos = false;

        for(Carta carta : this.obtenerCartas()) {

            if(this.valoresTruco.rankingCarta(carta) <= 5)
                tengoAlta = true;
            if(this.valoresTruco.rankingCarta(carta) == 6)
                tengoUnDos = true;

        }

        return tengoAlta && tengoUnDos;

    }

    private Carta cartaMasAlta() {

        Carta cartaMasAlta = this.mano.getCartasEnMano().get(0);
        int rankingCartaMasAlta = this.valoresTruco.rankingCarta(cartaMasAlta);

        for(Carta carta : this.mano.getCartasEnMano()) {

            int rankingCartaSiguiente = this.valoresTruco.rankingCarta(carta);

            if(rankingCartaSiguiente < rankingCartaMasAlta) {
                cartaMasAlta = carta;
                rankingCartaMasAlta = rankingCartaSiguiente;
            }
        }

        return cartaMasAlta;

    }

    public Carta getUltimaCartaJugada() {

        return this.ultimaCartaJugada;

    }


}
