package fiuba.algo3.truco.modelo;

public class Carta {

    private int valor;
    private Palo palo;

    public Carta(int valor, Palo palo) {

        this.valor = valor;
        this.palo = palo;

    }

    public Palo getPalo() {

        return this.palo;

    }

    public int envido() {

        return this.valor;

    }


    public int getValor() {
        return valor;
    }
}
