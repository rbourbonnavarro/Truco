package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Truco.GanadorVuelta;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private List<GanadorVuelta> ganadoresVueltas;
    private Equipo equipoGanador;
    private int puntosRonda;

    public Ronda() {

        this.ganadoresVueltas = new ArrayList<>();

        this.puntosRonda = 0;

    }

    public void setGanadorVuelta(GanadorVuelta ganadorVuelta) {

        this.ganadoresVueltas.add(ganadorVuelta);

    }

    public boolean finalRonda() {

        if(this.ganadoresVueltas.size() == 2) {

            if(this.ganadoresVueltas.get(0).getEquipoGanador() == this.ganadoresVueltas.get(1).getEquipoGanador()) {

                this.equipoGanador = this.ganadoresVueltas.get(0).getEquipoGanador();

                return true;

            }

            return false;

        }

        if(this.ganadoresVueltas.size() == 3) {

            this.equipoGanador = this.ganadoresVueltas.get(2).getEquipoGanador();

            return true;

        }

        return false;

    }

    public void sumarPuntosEquipoGanador() {

        this.equipoGanador.sumarPuntos(this.puntosRonda);

    }

    public void agregarPuntosRonda(int puntosRonda) {

        this.puntosRonda += puntosRonda;

    }


}
