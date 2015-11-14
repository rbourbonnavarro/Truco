package fiuba.algo3.truco.modelo;

import java.util.List;

public class Jugador {

    private String nombre;
    private Mano mano;
    private boolean jugadorPie;

    public Jugador(String nombre) {

        this.nombre = nombre;
        this.jugadorPie = false;

    }

    public void setMano(Mano mano) {

        this.mano = mano;

    }

    public void setJugadorPie(boolean jugadorPie) {

        this.jugadorPie = jugadorPie;

    }

    public List<Carta> obtenerCartas() {

        return this.mano.getCartas();

    }

    public void envido() {

        if(!this.jugadorPie) throw new JugadorNoPuedeCantarEnvidoNoEsPie();

        this.mano.envido();

    }

    public void jugar(Carta carta) {

        this.mano.jugar(carta);

    }


}