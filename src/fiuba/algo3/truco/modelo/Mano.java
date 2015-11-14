package fiuba.algo3.truco.modelo;

public class Mano {

    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private int cantidadEspada;
    private int cantidadBasto;
    private int cantidadCopa;
    private int cantidadOro;
    private EstadoFlor estadoFlor;

    public Mano(Carta carta1, Carta carta2, Carta carta3, EstadoFlor estadoFlor) {

        this.carta1 = carta1;
        this.carta2 = carta2;
        this.carta3 = carta3;
        this.estadoFlor = estadoFlor;

    }

    public Mano() {
        estadoFlor = new JuegoSinFlor();
        cantidadEspada = 0;
        cantidadBasto = 0;
        cantidadOro = 0;
        cantidadCopa = 0;
    }

    public int flor() {

        return this.estadoFlor.flor(this.carta1, this.carta2, this.carta3);

    }

    public int envido() {

        return this.estadoFlor.envido(this.carta1, this.carta2, this.carta3);

    }


    public int getCantidadEspada() {
        return cantidadEspada;
    }

    public void incrementarEspada() {
        cantidadEspada++;
    }

    public void incrementarCopa() {
        cantidadCopa++;
    }

    public void incrementarOro() {
        cantidadOro++;
    }

    public void incrementarBasto() {
        cantidadBasto++;
    }

    public int getCantidadCopa() {
        return cantidadCopa;
    }
    public int getCantidadOro() {
        return cantidadOro;
    }
    public int getCantidadBasto() {
        return cantidadBasto;
    }
}
