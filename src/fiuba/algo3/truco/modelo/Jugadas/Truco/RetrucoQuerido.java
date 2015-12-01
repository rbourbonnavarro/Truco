package fiuba.algo3.truco.modelo.Jugadas.Truco;

import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarFaltaEnvido;
import fiuba.algo3.truco.modelo.Jugadas.Envido.NoSePuedeCantarRealEnvido;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarContraFlorException;
import fiuba.algo3.truco.modelo.Jugadas.Flor.NoSePuedeCantarFlorException;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;

public class RetrucoQuerido implements EstadoJuego {

    private Equipo equipoIniciadorJugada;
    private Equipo equipoQueCantoUltimo;

    public RetrucoQuerido(Equipo equipoIniciadorJugada, Equipo equipoQueCantoUltimo) {

        this.equipoIniciadorJugada = equipoIniciadorJugada;
        this.equipoQueCantoUltimo = equipoQueCantoUltimo;

    }

    @Override
    public int puntos() {

        return 3;

    }

    @Override
    public int noQuerido() {

        throw new RetrucoYaFueQueridoException();

    }

    @Override
    public EstadoJuego truco(Equipo equipoIniciador) {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoJuego reTruco(Equipo equipoIniciador) {

        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoJuego valeCuatro(Equipo equipoIniciador) {

        if(this.equipoQueCantoUltimo.equals(equipoIniciador)) throw new EquipoQueCantoRetrucoNoPuedeCantarValeCuatroException();

        return new ValeCuatroCantado(equipoIniciador);

    }

    @Override
    public EstadoJuego envido(Equipo equipoIniciador) {

        throw new NoSePuedeCantarEnvido();

    }

    @Override
    public EstadoJuego realEnvido(Equipo equipoIniciador) {

        throw new NoSePuedeCantarRealEnvido();

    }

    @Override
    public EstadoJuego faltaEnvido(Equipo equipoIniciador, Puntaje puntos) {

        throw new NoSePuedeCantarFaltaEnvido();

    }

    @Override
    public EstadoJuego flor(Equipo equipoIniciador) {

        throw new NoSePuedeCantarFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlResto(Puntaje puntos) {

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoJuego contraFlorAlPartido() {

        throw new NoSePuedeCantarContraFlorException();

    }

    @Override
    public EstadoJuego terminarTanto() {

        return null;

    }

    @Override
    public EstadoJuego quiero() {

        throw new EstadoYaQueridoException();

    }

    @Override
    public void estadoValido() {


    }

    @Override
    public Equipo getEquipoIniciador() {

        return this.equipoIniciadorJugada;

    }

    @Override
    public boolean equals (Object estado){

        return estado instanceof RetrucoQuerido;

    }

    @Override
    public int hashCode() {

        return this.puntos();

    }


}
