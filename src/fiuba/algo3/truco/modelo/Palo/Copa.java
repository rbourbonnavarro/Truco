package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Mano;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class Copa implements Palo {

    @Override
    public void agregarA(Mano mano) {
        mano.incrementarCopa();
    }

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Copa;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName();

    }

    @Override
    public int getTanto(int valor) {
        return valor + tantoCopa();
    }

    @Override
    public int tantoEspada() {
        return 0;
    }

    @Override
    public int tantoOro() {
        return 0;
    }

    @Override
    public int tantoBasto() {
        return 0;
    }

    @Override
    public int tantoCopa() {
        return 20;
    }


}
