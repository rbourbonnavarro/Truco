package fiuba.algo3.truco.modelo.Palo;

import com.sun.org.apache.xpath.internal.operations.Equals;
import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;

public class Espada implements Palo {

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Espada;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName();

    }

    @Override
    public int getTanto(Carta carta) {
        return carta.tantoEspada();
    }

    @Override
    public int tantoOro(int valor) {
        return 0;
    }

    @Override
    public int tantoEspada(int valor) {
        return valor + 20;
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
