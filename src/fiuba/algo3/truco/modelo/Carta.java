package fiuba.algo3.truco.modelo;

import fiuba.algo3.truco.modelo.Palo.Palo;
import fiuba.algo3.truco.modelo.Jugadas.Truco.ValoresTruco;

public class Carta {

    private int valor;
    private Palo palo;
    private ValoresTruco valoresTruco;

    public Carta(int valor, Palo palo) {

        this.valor = valor;
        this.palo = palo;
        this.valoresTruco = new ValoresTruco();

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

    public int truco(Carta carta) {
        int posicionEstaCarta = this.valoresTruco.rankingCarta(this);
        int posicionCartaContraria = this.valoresTruco.rankingCarta(carta);

        if(posicionEstaCarta < posicionCartaContraria)
            return 1;
        else {

            if(posicionEstaCarta > posicionCartaContraria)
                return -1;
            else return 0;

        }

    }

    @Override
    public boolean equals(Object objeto) {

        Carta carta = (Carta) objeto;
        return this.valor == carta.getValor() && this.palo.equals(carta.palo);

   }


}
