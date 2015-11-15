package fiuba.algo3.truco.modelo.EnvidoYFlor;

public class EnvidoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 2;

    }

    @Override
    public int noQuerido() {

        return 1;

    }

    @Override
    public boolean sePuedeCantarEnvido() {

        return false;

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
