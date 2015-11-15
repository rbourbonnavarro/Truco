package fiuba.algo3.truco.modelo.Puntos;

public class Malas implements Puntaje {

    private int puntos;

    public Malas() {

        this.puntos = 0;

    }

    @Override
    public int faltaEnvido() {

        return 30;

    }


}
