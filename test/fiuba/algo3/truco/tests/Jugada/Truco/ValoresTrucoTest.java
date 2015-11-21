package fiuba.algo3.truco.tests.Jugada.Truco;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValoresTruco;
import fiuba.algo3.truco.modelo.Palo.Espada;
import org.junit.Assert;
import org.junit.Test;

public class ValoresTrucoTest {

    @Test
    public void valoresTrucoDevuelveRankingCorrecto() {

        ValoresTruco valoresTruco = new ValoresTruco();

        Carta carta = new Carta(7, new Espada());

        Assert.assertTrue(valoresTruco.rankingCarta(carta) == 3);

    }


}
