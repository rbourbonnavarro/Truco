package fiuba.algo3.truco.modelo;

public class GanadorVuelta {

    private Equipo equipoGanador;
    private Carta carta;

    public GanadorVuelta(Equipo equipoGanador, Carta carta) {

        this.equipoGanador = equipoGanador;
        this.carta = carta;

    }

    public Carta getCarta() {

        return carta;

    }


}
