package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private List<GanadorVuelta> ganadoresVueltas;

    public Ronda() {

        this.ganadoresVueltas = new ArrayList<>();

    }

    public void setGanadorVuelta(GanadorVuelta ganadorVuelta) {

        this.ganadoresVueltas.add(ganadorVuelta);

    }

    public boolean finalRonda() {

        return false;

    }

    public void sumarPuntosEquipoGanador() {



    }


}
