package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Jugadas.Envido.*;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorNoQueridaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorNoAceptadaNoSePuedeJugarException;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValoresTruco;

public class JugadorIA extends Jugador {

    private Mesa mesa;
    private ValoresTruco valoresTruco;

    public JugadorIA(String nombre) {

        super(nombre);

        this.valoresTruco = new ValoresTruco();

    }

    public void setMesa(Mesa mesa) {

        this.mesa = mesa;

    }

    public void turno() {


        try {

            if (this.mesa.getEstadoVuelta().getEstadoJuego() instanceof NadaCantado) {

                try {

                    this.decisionTanto();

                } catch (NoHayDecisionException e) {

                    try {

                        this.decisionTruco();

                    } catch (NoHayDecisionException a) {

                        this.mesa.hacerJugada(this.cartaMasAlta());

                    }

                }

            }
            else {

                this.mesa.hacerJugada(this.cartaMasAlta());

            }

        } catch(EnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido == 33) this.mesa.faltaEnvido();
            if(envido >=30 && envido <= 32) this.mesa.realEnvido();
            if(envido < 30 && envido >= 28) this.mesa.envido();
            if(envido < 28 && envido >= 25) this.mesa.quieroEnvido();
            if(envido < 25) this.mesa.noQuieroEnvido();

        } /*catch(EnvidoEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido == 33) this.mesa.faltaEnvido();
            if(envido >=30 && envido <= 32) this.mesa.realEnvido();
            if(envido < 30 && envido >= 27) this.mesa.quieroEnvido();
            if(envido < 27) this.mesa.noQuieroEnvido();

        } catch(RealEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido > 32) this.mesa.faltaEnvido();
            if(envido >=28 && envido < 32) this.mesa.quieroEnvido();
            if(envido < 28) this.mesa.noQuieroEnvido();

        } catch(FaltaEnvidoNoQueridoNoSePuedeJugarException e) {

            int envido = this.envido();

            if(envido > 32)
                this.mesa.quieroEnvido();
            else
                this.mesa.noQuieroEnvido();

        }*/ catch(FlorNoAceptadaNoSePuedeJugarException e) {

            try {

                int flor = this.flor();

                if(flor > 35) this.mesa.contraFlorAlPartido();
                if(flor > 32 && flor <= 35) this.mesa.contraFlorAlResto();
                if(flor >= 25 && flor <= 32) this.mesa.flor();
                if(flor < 25) this.mesa.quieroFlor();

            } catch(JugadorNoTieneFlorException a) {

                this.mesa.quieroFlor();

            }

        }/* catch(FlorFlorNoQueridaNoSePuedeJugarException e) {

            int flor = this.flor();

            if(flor > 35) this.mesa.contraFlorAlPartido();
            if(flor > 32 && flor <= 35) this.mesa.contraFlorAlResto();
            if(flor >= 25 && flor <= 32) this.mesa.quieroFlor();
            if(flor < 25) this.mesa.noQuieroFlor();

        } catch(ContraFlorAlRestoNoQueridaNoSePuedeJugarException e) {

            int flor = this.flor();

            if(flor > 35) this.mesa.contraFlorAlPartido();
            if(flor > 32 && flor <= 35) this.mesa.quieroFlor();
            if(flor < 30) this.mesa.noQuieroFlor();

        } catch(ContraFlorAlPartidoNoQueridaNoSePuedeJugarException e) {

            int flor = this.flor();

            if(flor > 35)
                this.mesa.quieroFlor();
            else
                this.mesa.noQuieroFlor();

        }*/


        /*try {

            this.evaluarCantos(this.mesa.getEstadoVuelta());

        } catch(NoHayDecisionException noHayDecisionException) {

            this.mesa.hacerJugada(this.evaluarCartas());

        }*/


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

        throw new NoHayDecisionException();

    }

    private Carta cartaMasAlta() {

        Carta cartaMasAlta = this.mano.getCartasEnMano().get(0);
        int rankingCartaMasAlta = this.valoresTruco.rankingCarta(cartaMasAlta);

        for(Carta carta : this.mano.getCartasEnMano()) {

            int rankingCartaSiguiente = this.valoresTruco.rankingCarta(carta);

            cartaMasAlta = (rankingCartaSiguiente < rankingCartaMasAlta) ? carta : cartaMasAlta;

            rankingCartaMasAlta = (rankingCartaSiguiente < rankingCartaMasAlta) ? rankingCartaSiguiente : rankingCartaMasAlta;

        }

        return cartaMasAlta;

    }


}
