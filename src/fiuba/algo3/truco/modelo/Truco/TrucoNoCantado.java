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
    public EstadoTruco truco() {

        return new TrucoCantado();
    }

    @Override
    public EstadoTruco reTruco() {
        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoTruco valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }


}
