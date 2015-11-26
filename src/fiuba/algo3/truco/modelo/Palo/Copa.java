package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Carta;

public class Copa implements Palo {


    @Override
    public int getTanto(Carta carta) {

        return carta.tantoCopa();

    }

    @Override
    public int tantoOro(int valor) {

        return 0;

    }

    @Override
    public int tantoEspada(int valor) {

        return 0;

    }

    @Override
    public int tantoCopa(int valor) {

        return valor + 20;

    }

    @Override
    public int tantoBasto(int valor) {

        return 0;

    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName();

    }

    @Override
    public boolean equals(Object palo) {

        return palo != null && palo instanceof Copa;

    }

    @Override
    public int hashCode() {

        return 36;

    }


}
