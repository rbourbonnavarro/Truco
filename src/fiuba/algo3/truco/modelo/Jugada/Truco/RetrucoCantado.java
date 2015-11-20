package fiuba.algo3.truco.modelo.Jugada.Truco;

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
    public EstadoTruco truco() {

        throw new NoSePuedeCantarTrucoException();

    }

    @Override
    public EstadoTruco reTruco() {

        throw new NoSePuedeCantarRetrucoException();

    }

    @Override
    public EstadoTruco valeCuatro() {

        return new ValeCuatroCantado();

    }
    @Override
    public boolean equals (Object estado){
        return estado instanceof RetrucoCantado;
    }


}
