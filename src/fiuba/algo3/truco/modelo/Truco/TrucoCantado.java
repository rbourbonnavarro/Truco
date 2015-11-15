package fiuba.algo3.truco.modelo.Truco;

public class TrucoCantado implements EstadoTruco {

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public boolean sePuedeCantarTruco() {

        return false;

    }

    @Override
    public boolean sePuedeCantarRetruco() {

        return true;

    }

    @Override
    public boolean sePuedeCantarValeCuatro() {

        return false;

    }


}
