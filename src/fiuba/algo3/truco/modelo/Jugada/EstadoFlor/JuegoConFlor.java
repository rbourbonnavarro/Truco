package fiuba.algo3.truco.modelo.Jugada.EstadoFlor;

import fiuba.algo3.truco.modelo.Carta;
import fiuba.algo3.truco.modelo.Jugada.Envido.CalculadorTanto;
import fiuba.algo3.truco.modelo.Jugada.Envido.CantasteEnvidoCuandoTenesFlorException;
import fiuba.algo3.truco.modelo.Jugada.Envido.NoHayFlorException;

import java.util.List;

public class JuegoConFlor extends CalculadorTanto {

    @Override
    public int envido(List<Carta> cartas) throws CantasteEnvidoCuandoTenesFlorException {
        try{
            this.hayFlor(cartas);
        }
        catch (NoHayFlorException error) {
            return super.envido(cartas);
        }
        throw new CantasteEnvidoCuandoTenesFlorException();
    }
    public int flor(List<Carta> cartas) {

        this.hayFlor(cartas);
        int flor = 0;
        for(Carta carta: cartas)
            flor += carta.getTanto();
        return flor +20;

    }

    private void hayFlor(List<Carta> cartas) {

        if(!(cartas.get(0).getPalo().equals(cartas.get(1).getPalo()) &&
                cartas.get(2).getPalo().equals(cartas.get(1).getPalo())))
            throw new NoHayFlorException();
    }


}
