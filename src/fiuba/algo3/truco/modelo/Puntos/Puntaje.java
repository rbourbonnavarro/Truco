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

        if(this.puntos >= 30) throw new JuegoTerminadoException();

    }

    public int faltaEnvido() {

        return this.estadoPuntaje.faltaEnvido(this.puntos);

    }

    public int getPuntos() {

        return this.puntos;

    }

    public EstadoPuntaje getEstadoPuntaje(){

        return this.estadoPuntaje;

    }

    public int flor(){

        return this.estadoPuntaje.flor(puntos);

    }


}
