package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Puntos.Malas;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private List<Jugador> integrantes;
    private Puntaje puntaje;
    private int indiceJugador;

    public Equipo(String nombre, List<Jugador> jugadores) {

        this.integrantes = new ArrayList<>(jugadores);

        this.puntaje = new Malas();

        this.indiceJugador = 0;

    }

    public Jugador getJugadorActual() {

        return this.integrantes.get(this.indiceJugador % this.integrantes.size());

    }

    public int getCantidadIntegrantes() {

        return this.integrantes.size();

    }

    public void terminarJugada() {

        //if(this.indiceJugador > 2) this.indiceJugador = 0;

        this.indiceJugador++;

    }

    public Puntaje getPuntaje() {

        return this.puntaje;

    }


}
