package fiuba.algo3.truco.modelo.Palo;

import fiuba.algo3.truco.modelo.Mano;

public interface Palo {

    void agregarA(Mano mano);

    boolean equals(Object object);

    String toString();

    int getTanto(int valor);
    int tantoEspada();
    int tantoOro();
    int tantoBasto();
    int tantoCopa();
}
