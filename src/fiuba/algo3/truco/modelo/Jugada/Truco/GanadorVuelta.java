package fiuba.algo3.truco.modelo.Jugada.Truco;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Equipo;

public class GanadorVuelta {

    private Equipo equipoGanador;
    private Carta carta;

    public GanadorVuelta(Equipo equipoGanador, Carta carta) {

        this.equipoGanador = equipoGanador;
        this.carta = carta;

    }

    public Carta getCarta() {

        return carta;

    }

    public Equipo getEquipoGanador() {

        return this.equipoGanador;

    }


}
