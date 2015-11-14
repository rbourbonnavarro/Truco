package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Mano;

/**
 * Created by GomezPeter on 14/11/2015.
 */
public class Copa implements Palo {
    @Override
    public void AgregarA(Mano mano) {
        mano.incrementarCopa();
    }

    @Override
    public boolean equals(Object palo) {
        return palo instanceof Copa;
    }
}
