package fiuba.algo3.truco.modelo;

import java.util.List;

public class Jugador {

    protected String nombre;
    protected Mano mano;
    protected boolean jugadorPie;
    protected int ordenMesa;

    public Jugador(String nombre) {

        this.nombre = nombre;
        this.jugadorPie = false;

    }
    public String getNombre(){

        return nombre;

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

    public List<Carta> obtenerCartasEnMano() {

        return this.mano.getCartasEnMano();

    }

    public int envido() {

        return this.mano.envido();

    }

    public int flor() {

        this.hayFlor();

        return this.mano.flor();

    }

    public void jugar(Carta carta) {

        this.mano.jugar(carta);

    }

    public boolean jugadorPie() {

        return this.jugadorPie;

    }

    private void hayFlor() {

        if (!(this.mano.getCartas().get(0).getPalo().equals(this.mano.getCartas().get(1).getPalo()) &&
                this.mano.getCartas().get(2).getPalo().equals(this.mano.getCartas().get(1).getPalo())))
            throw new JugadorNoTieneFlorException();

    }

    public void setOrdenMesa(int ordenMesa) {

        this.ordenMesa = ordenMesa;

    }

    public int getOrdenMesa() {

        return this.ordenMesa;

    }


}
