package fiuba.algo3.truco.modelo.Truco;

public class ValeCuatroCantado implements EstadoTruco {

    @Override
    public int puntos() {

        return 4;

    }

    @Override
    public int noQuerido() {

        return 3;

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

        return false;

    }


}
