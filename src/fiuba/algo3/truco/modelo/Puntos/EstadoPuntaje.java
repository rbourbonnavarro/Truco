package fiuba.algo3.truco.modelo.Puntos;

public abstract class EstadoPuntaje {

    public abstract int faltaEnvido(int puntos);

    public int flor(int puntos) {

        return 30 - puntos;

    }

}
