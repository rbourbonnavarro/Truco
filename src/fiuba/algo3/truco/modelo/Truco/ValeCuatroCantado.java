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
    public EstadoTruco truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoTruco reTruco() {
        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoTruco valeCuatro() {
        throw new NoSePuedeCantarValeCuatroException();

    }

    @Override
    public boolean equals (Object estado){
        return estado instanceof ValeCuatroCantado;
    }
}
