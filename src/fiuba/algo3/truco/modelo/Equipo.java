package fiuba.algo3.truco.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private List<Jugador> integrantes;
    private int puntaje;
    private Jugador jugadorActual;

    public Equipo(String nombre, List<Jugador> jugadores) {

        this.integrantes = new ArrayList<Jugador>(jugadores);

        this.puntaje = 0;

    }

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }

    public int getCantidadIntegrantes() {

        return this.integrantes.size();

    }


}
