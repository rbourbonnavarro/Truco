package fiuba.algo3.truco.modelo;

import java.util.List;

import fiuba.algo3.truco.modelo.EnvidoYFlor.CantasteEnvidoCuandoTenesFlorException;

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

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        return this.mano.envido();

    }

    public void jugar(Carta carta) {

        this.mano.jugar(carta);

    }

    public boolean jugadorPie() {

        return this.jugadorPie;

    }


}
