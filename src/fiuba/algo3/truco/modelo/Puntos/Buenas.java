package fiuba.algo3.truco.modelo.Puntos;

public class Buenas implements Puntaje {

    private int puntos;

    public Buenas(int puntos) {

        this.puntos = puntos;

    }
    public Buenas() {
        this.puntos = 0;
    }

    @Override
    public int faltaEnvido() {

        return 15 - this.puntos;

    }


}
