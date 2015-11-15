package fiuba.algo3.truco.modelo.Truco;

public class TrucoNoCantado implements EstadoTruco {

    @Override
    public int puntos() {

        return 1;

    }

    @Override
    public int noQuerido() {
        return 0;
    }

    @Override
    public boolean sePuedeCantarTruco() {

        return true;
    }

    @Override
    public boolean sePuedeCantarRetruco() {

        return false;

    }

    @Override
    public boolean sePuedeCantarValeCuatro() {

        return false;

    }


}
