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
    private int ordenMesa;
    private boolean inicializacionOrdenMesa;

    public Equipo(String nombre, List<Jugador> jugadores) {

        if(jugadores.size() == 0)
            throw new EquipoSinIntegrantesException();

    	this.nombre = nombre;
    	
        this.integrantes = new ArrayList<>(jugadores);

        this.puntaje = new Puntaje();

        this.indiceJugador = 0;

        this.inicializacionOrdenMesa = false;

    }

    public void setOrdenMesa(int ordenMesa) {

        this.ordenMesa = ordenMesa;

        this.indiceJugador = 0;

        if(this.inicializacionOrdenMesa && this.ordenMesa == 1) {

            this.reordenarJugadores();

        }

        for (Jugador jugador : this.integrantes) {

            jugador.setOrdenMesa(ordenMesa);

            ordenMesa += 2;

        }

        this.inicializacionOrdenMesa = true;

    }

    private void reordenarJugadores() {

        for(int i = 0; i < (this.integrantes.size() - 1); i++) {

            Jugador aux = this.integrantes.get(i);
            this.integrantes.set(i, this.integrantes.get(i+1));
            this.integrantes.set(i+1, aux);

        }

    }

    public Jugador getJugadorActual() {

        return this.integrantes.get(this.indiceJugador % this.integrantes.size());

    }
    public void setPie(){

        this.integrantes.get((this.indiceJugador) + (this.integrantes.size()) -1).setJugadorPie(true);

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

    public int getOrdenMesa() {

        return this.ordenMesa;

    }

    public boolean primeroEnRonda() {

        return this.ordenMesa == 0;

    }

    @Override
    public boolean equals (Object object) {

        if(object instanceof Equipo) {

            Equipo equipo = (Equipo) object;
            return this.getNombre().equals(equipo.getNombre());

        }

        return false;

    }


}
