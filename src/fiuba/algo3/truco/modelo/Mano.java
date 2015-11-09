package fiuba.algo3.truco.modelo;

public class Mano {

    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private EstadoFlor estadoFlor;

    public Mano(Carta carta1, Carta carta2, Carta carta3, EstadoFlor estadoFlor) {

        this.carta1 = carta1;
        this.carta2 = carta2;
        this.carta3 = carta3;
        this.estadoFlor = estadoFlor;

    }

    public int flor() {

        return this.estadoFlor.flor(this.carta1, this.carta2, this.carta3);

    }

    public int envido() {

        return this.estadoFlor.envido(this.carta1, this.carta2, this.carta3);

    }


}
