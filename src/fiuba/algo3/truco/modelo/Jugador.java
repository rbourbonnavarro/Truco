package fiuba.algo3.truco.modelo;

import java.util.List;

import fiuba.algo3.truco.modelo.Jugadas.Envido.CantasteEnvidoCuandoTenesFlorException;

public class Jugador {

    private String nombre;
    private Mano mano;
    private boolean jugadorPie;
    private int ordenMesa;

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

    public int envido() throws CantasteEnvidoCuandoTenesFlorException {

        return this.mano.envido();

    }

    public int calcularFlor() {

        return this.mano.flor();

    }

    public void jugar(Carta carta) {

        this.mano.jugar(carta);

    }

    public boolean jugadorPie() {

        return this.jugadorPie;

    }

    public void flor() {

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
