package fiuba.algo3.truco.modelo.EnvidoYFlor;

public class EnvidoEnvidoCantado implements EstadoEnvido {

    @Override
    public int puntos() {

        return 4;

    }

    @Override
    public int noQuerido() {

        return 2;

    }

    @Override
    public boolean sePuedeCantarEnvido() {

        return false;

    }

    @Override
    public boolean sePuedeCantarEnvidoEnvido() {

        return false;

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
