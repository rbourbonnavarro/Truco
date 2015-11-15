package fiuba.algo3.truco.modelo.Palo;

import com.sun.org.apache.xpath.internal.operations.Equals;
import fiuba.algo3.truco.modelo.Mano;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class Espada implements Palo {

    @Override
    public void agregarA(Mano mano) {
        mano.incrementarEspada();
    }
    @Override
    public boolean equals(Object palo) {
        return palo instanceof Espada;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName();

    }

    @Override
    public int getTanto(int valor) {
        return valor + tantoEspada();
    }

    @Override
    public int tantoEspada() {
        return 20;
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
        return 0;
    }


}
