package fiuba.algo3.truco.modelo.Puntos;

public class Malas extends EstadoPuntaje {

    @Override
    public int faltaEnvido(int puntos) {

        return 30;

    }

    @Override
    public boolean equals(Object puntaje) {

        return puntaje instanceof Malas;

    }


}
