package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Mano;

public interface Palo {


    boolean equals(Object object);

    String toString();

    int getTanto(Carta carta);

    int tantoOro(int valor);
    int tantoEspada(int valor);
    int tantoCopa(int valor);
    int tantoBasto(int valor);
}
