package fiuba.algo3.truco.modelo.EnvidoYFlor;

public class EnvidoNoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 0;

    }

    @Override
    public int noQuerido() {

        return 0;

    }

    @Override
    public boolean sePuedeCantarEnvido() {

        return true;

    }

    @Override
    public boolean sePuedeCantarEnvidoEnvido() {

        return true;

    }

    @Override
    public boolean sePuedeCantarRealEnvido() {

        return true;

    }

    @Override
    public boolean sePuedeCantarFaltaEnvido() {

        return true;

    }


}
