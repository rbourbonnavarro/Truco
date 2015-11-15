package fiuba.algo3.truco.modelo.Puntos;

public class Puntaje {

    private int puntos;
    private EstadoPuntaje estadoPuntaje;

    public Puntaje() {

        this.puntos = 0;

        this.estadoPuntaje = new Malas();

    }

    public void sumar(int puntosRonda) {

        this.puntos += puntosRonda;

        if(this.puntos >= 15) {

            this.estadoPuntaje = new Buenas();

        }

    }

    public int faltaEnvido() {

        return this.estadoPuntaje.faltaEnvido(this.puntos);

    }


}
