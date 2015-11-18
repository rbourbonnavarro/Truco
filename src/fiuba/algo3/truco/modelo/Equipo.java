package fiuba.algo3.truco.modelo;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class Equipo {

    private String nombre;
    private List<Jugador> integrantes;
    private Puntaje puntaje;
    private int indiceJugador;

    public Equipo(String nombre, List<Jugador> jugadores) {
        if(jugadores.size() == 0)
            throw new EquipoSinIntegrantesException();
    	this.nombre = nombre;
    	
        this.integrantes = new ArrayList<>(jugadores);

        this.puntaje = new Puntaje();

        this.indiceJugador = 0;

    }

    public Jugador getJugadorActual() {

        return this.integrantes.get(this.indiceJugador % this.integrantes.size());

    }
    public void setPie(){
        this.integrantes.get((this.indiceJugador + 1) % this.integrantes.size()).setJugadorPie(true);
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

    public void sumarPuntos(int puntosRonda) {

        this.puntaje.sumar(puntosRonda);

    }

    public int getPuntos() {

        return this.puntaje.getPuntos();

    }

    public int calcularEnvido() {

        int envido = 0;

        for(Jugador jugador : this.integrantes) {

            envido = (jugador.envido() > envido) ? jugador.envido() : envido;

        }

        return envido;

    }

    public List<Jugador> getIntegrantes() {

        return this.integrantes;

    }


}
