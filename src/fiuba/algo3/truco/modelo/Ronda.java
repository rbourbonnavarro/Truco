package fiuba.algo3.truco.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.truco.modelo.Jugada.Truco.GanadorVuelta;

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

    /*public boolean finalRonda() {

        if(obtenerEquipoGanador() != null)
            return true;

        return false;

    }*/

    private Equipo obtenerEquipoGanador() {

        if(this.equipoGanador != null) return this.equipoGanador;

        if(this.ganadoresVueltas.size() == 2) {

            if(this.ganadoresVueltas.get(0).getEquipoGanador() == this.ganadoresVueltas.get(1).getEquipoGanador()) {

                return this.ganadoresVueltas.get(0).getEquipoGanador();

            }

            return null;

        }

        if(this.ganadoresVueltas.size() == 3) {

            return this.ganadoresVueltas.get(2).getEquipoGanador();

        }

        return null;

    }

    private void sumarPuntosEquipoGanador() {

        try {

            this.equipoGanador = this.obtenerEquipoGanador();

            this.equipoGanador.sumarPuntos(this.puntosRonda);

        } catch(NullPointerException nullPointerException) {

            throw new LaRondaNoTerminoAunException();

        }

    }

    public void terminar() {

        this.sumarPuntosEquipoGanador();

        this.equipoGanador = null;

        this.ganadoresVueltas = new ArrayList<>();

    }

    public void agregarPuntosRonda(int puntosRonda) {

        this.puntosRonda += puntosRonda;

    }

    public Equipo getEquipoGanador() {

        return this.equipoGanador;

    }

    public void setEquipoGanador(Equipo equipoGanador) {

        this.equipoGanador = equipoGanador;

    }
    
    public boolean sePuedeCantarEnvido(){
    	
    	return this.ganadoresVueltas.size() > 0;  
    	
    }

}
