package fiuba.algo3.truco.modelo;

import java.util.ArrayList;
import java.util.Collection;
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

    public void setOrdenMesa(int ordenMesa) {

        for(Jugador jugador : this.integrantes) {

            jugador.setOrdenMesa(ordenMesa);

            ordenMesa += 2;

        }

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

    public Jugador jugadorEnvidoMasAlto() {

        int envido = 0;
        Jugador envidoMasAlto = this.integrantes.get(0);

        for(Jugador jugador : this.integrantes) {

            if(jugador.envido() > envido) envidoMasAlto = jugador;

            envido = Math.max(jugador.envido(), envido);

        }

        return envidoMasAlto;

    }

    public Jugador jugadorFlorMasAlta() {

        int flor = 0;
        Jugador florMasAlta = this.integrantes.get(0);

        for(Jugador jugador : this.integrantes) {

            if(jugador.calcularFlor() > flor) florMasAlta = jugador;

            flor = Math.max(jugador.envido(), flor);

        }

        return florMasAlta;

    }

    public List<Jugador> getIntegrantes() {

        return this.integrantes;

    }

    public String getNombre() {

        return this.nombre;

    }

    public void flor() {

        int noTienenFlor = 0;

        for(Jugador jugador : this.integrantes) {

            try {

                jugador.flor();

            } catch(JugadorNoTieneFlorException jugadorNoTieneFlorException) {

                noTienenFlor++;

            }

        }

        if(noTienenFlor == 3) {

            throw new JugadorNoTieneFlorException();

        }

    }

    public Collection<Carta> recuperarCartas() {
        List<Carta> cartas = new ArrayList<>();
        for (Jugador jugador : this.integrantes) {
            cartas.addAll(jugador.obtenerCartas());
        }
        return cartas;
    }


}
