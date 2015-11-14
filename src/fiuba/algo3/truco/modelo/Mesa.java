package fiuba.algo3.truco.modelo;

public class Mesa {

    private CalculadorTanto calculadorTanto;
    private ValoresTruco valoresTruco;
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipoActual;
    private Jugador jugadorActual;

    public Mesa(Equipo equipo1, Equipo equipo2, CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;

        this.valoresTruco = new ValoresTruco();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

    }

    public void comenzarJuego() {

        this.equipoActual = this.equipo1;
        this.jugadorActual = this.equipoActual.getJugadorActual();

    }

    public Jugador getJugadorActual() {

        return this.jugadorActual;

    }


}
