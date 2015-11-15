package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;


public class Oro implements Palo {

    @Override
    public void agregarA(Mano mano) {
        mano.incrementarOro();
    }

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Oro;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName();

    }

    @Override
    public int getTanto(Carta carta) {
        return carta.tantoOro();
    }
    @Override
    public int tantoOro(int valor) {
        return valor + 20;
    }

    @Override
    public int tantoEspada(int valor) {
        return 0;
    }

    @Override
    public int tantoCopa(int valor) {
        return 0;
    }

    @Override
    public int tantoBasto(int valor) {
        return 0;
    }


}
