package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Palo.Palo;

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

    public String toString() {

        return this.valor + this.palo.toString();

    }

    public int sumarParaEnvido(Carta carta) {
        return this.envido() + palo.getTanto(carta);
    }

    public int tantoOro() {
        return palo.tantoOro(this.envido());
    }

    public int tantoBasto() {
        return palo.tantoOro(this.envido());
    }
    public int tantoEspada() {
        return palo.tantoEspada(this.envido());
    }
    public int tantoCopa() {
        return palo.tantoCopa(this.envido());
    }
}
