package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Mano;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class Basto implements Palo {

    @Override
    public void AgregarA(Mano mano) {
        mano.incrementarBasto();
    }

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Basto;
    }

    @Override
    public String toString() {

        return "Basto";

    }


}
