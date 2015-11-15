package fiuba.algo3.truco.tests;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Palo.Espada;
import fiuba.algo3.truco.modelo.Truco.ValoresTruco;
import org.junit.Assert;
import org.junit.Test;

public class TrucoTest {

    @Test
    public void valoresTrucoDevuelveRankingCorrecto() {

        ValoresTruco valoresTruco = new ValoresTruco();

        Carta carta = new Carta(7, new Espada());

        Assert.assertTrue(valoresTruco.rankingCarta(carta) == 3);

    }


}
