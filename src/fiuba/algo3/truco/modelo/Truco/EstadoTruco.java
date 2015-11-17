package fiuba.algo3.truco.modelo.Truco;

public interface EstadoTruco {

    int puntos();

    int noQuerido();

    EstadoTruco truco();

    EstadoTruco reTruco();

    EstadoTruco valeCuatro();

}
