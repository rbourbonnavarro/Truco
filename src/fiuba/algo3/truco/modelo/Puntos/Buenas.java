package fiuba.algo3.truco.modelo.Puntos;

public class Buenas implements Puntaje {

    private int puntos;

    public Buenas(int puntos) {

        this.puntos = puntos;

    }

    @Override
    public int faltaEnvido() {

        return 30 - this.puntos;

    }


}
