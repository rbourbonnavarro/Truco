package fiuba.algo3.truco.modelo;

public class JugadorIA extends Jugador {

    private Mesa mesa;

    public JugadorIA(String nombre, Mesa mesa) {

        super(nombre);

        this.mesa = mesa;

    }

    /*@Override
    public void turno() {

        this.mesa.hacerJugada(this.mano.getCartas());

    }*/


}
