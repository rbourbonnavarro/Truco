package fiuba.algo3.truco.modelo;

public class Mesa {

    private EstadoFlor estadoFlor;
    private ValoresTruco valoresTruco;

    public Mesa(EstadoFlor estadoFlor) {

        this.estadoFlor = estadoFlor;

        this.valoresTruco = new ValoresTruco();

    }


}
