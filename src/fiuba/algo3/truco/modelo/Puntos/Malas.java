package fiuba.algo3.truco.modelo.Puntos;

public class Malas implements EstadoPuntaje {

    /*private int puntos;

    public Malas() {

        this.puntos = 0;

    }*/

    @Override
    public int faltaEnvido(int puntos) {

        return 30;

    }
    @Override
    public boolean equals(Object puntaje) {
        return puntaje instanceof Malas;
    }


}
