package fiuba.algo3.truco.modelo.Puntos;

public class Buenas implements EstadoPuntaje {

    /*private int puntos;

    public Buenas(int puntos) {

        this.puntos = puntos;

    }*/

    @Override
    public int faltaEnvido(int puntos) {

        return 30 - puntos;

    }


}
