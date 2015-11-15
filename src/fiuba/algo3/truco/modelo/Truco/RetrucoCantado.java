package fiuba.algo3.truco.modelo.Truco;

public class RetrucoCantado implements EstadoTruco {

    @Override
    public int puntos() {

        return 3;

    }

    @Override
    public int noQuerido() {

        return 2;

    }

    @Override
    public boolean sePuedeCantarTruco() {

        return false;

    }

    @Override
    public boolean sePuedeCantarRetruco() {

        return false;

    }

    @Override
    public boolean sePuedeCantarValeCuatro() {

        return true;

    }


}
