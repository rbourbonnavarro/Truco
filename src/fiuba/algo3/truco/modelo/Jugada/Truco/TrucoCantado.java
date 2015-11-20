package fiuba.algo3.truco.modelo.Jugada.Truco;

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
    public EstadoTruco truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoTruco reTruco() {

        return new RetrucoCantado();

    }

    @Override
    public EstadoTruco valeCuatro() {

        throw new NoSePuedeCantarValeCuatroException();

    }
    @Override
    public boolean equals (Object estado){
        return estado instanceof TrucoCantado;
    }

}
