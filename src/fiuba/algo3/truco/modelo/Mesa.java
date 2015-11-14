package fiuba.algo3.truco.modelo;

public class Mesa {

    private CalculadorTanto calculadorTanto;
    private ValoresTruco valoresTruco;

    public Mesa(CalculadorTanto calculadorTanto) {

        this.calculadorTanto = calculadorTanto;

        this.valoresTruco = new ValoresTruco();

    }


}
