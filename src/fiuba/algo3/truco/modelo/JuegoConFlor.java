package fiuba.algo3.truco.modelo;

public class JuegoConFlor extends EstadoFlor {

    public int flor(Carta carta1, Carta carta2, Carta carta3) {

        if(!this.hayFlor(carta1, carta2, carta3)) throw new NoHayFlorException();

        int flor = carta1.envido() + carta2.envido() + carta3.envido();

        if(flor == 60) return 20;

        if(flor > 40) return flor - 20;

        if(flor > 20) return flor;

        return flor + 20;

    }

    private boolean hayFlor(Carta carta1, Carta carta2, Carta carta3) {

        return (carta1.getPalo().equals(carta2.getPalo()) &&
                carta2.getPalo().equals(carta3.getPalo()));

    }


}
