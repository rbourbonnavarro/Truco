package fiuba.algo3.truco.modelo.Puntos;

public class Buenas extends EstadoPuntaje {

    /*private int puntos;

    public Buenas(int puntos) {

        this.puntos = puntos;

    }*/

    @Override
    public int faltaEnvido(int puntos) {

        return 30 - puntos;

    }

    @Override
    public boolean equals(Object puntaje) {

        return puntaje instanceof Buenas;

    }


}
