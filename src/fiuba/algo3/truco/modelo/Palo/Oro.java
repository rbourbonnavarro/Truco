package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Mano;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class Oro implements Palo {
    String palo;
    @Override
    public void agregarA(Mano mano) {
        mano.incrementarOro();
    }

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Oro;
    }
}
