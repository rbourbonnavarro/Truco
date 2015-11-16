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
    public int getTanto() {
        return this.valor;
    }
    public int getValor() {
        return valor;
    }

    public String toString() {

        return this.valor + this.palo.toString();

    }

    public int sumarParaEnvido(Carta carta) {
        return this.getTanto() + palo.getTanto(carta);
    }

    public int tantoOro() {
        return palo.tantoOro(this.getTanto());
    }

    public int tantoBasto() {
        return palo.tantoBasto(this.getTanto());
    }
    public int tantoEspada() {
        return palo.tantoEspada(this.getTanto());
    }
    public int tantoCopa() {
        return palo.tantoCopa(this.getTanto());
    }

    public boolean equals(Object objeto) {

        if(objeto instanceof Carta) {

            return this.valor == ((Carta) objeto).getValor() && this.palo.equals(((Carta) objeto).getPalo());

        }

        return false;

    }


}
