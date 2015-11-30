package fiuba.algo3.truco.vista;

import com.sun.javafx.geom.AreaOp;
import fiuba.algo3.truco.modelo.Equipo;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.EnvidoEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.FaltaEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Envido.RealEnvidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.EstadoJuego;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlPartidoCantado;
import fiuba.algo3.truco.modelo.Jugadas.Flor.ContraFlorAlRestoCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.Flor.FlorFlorCantada;
import fiuba.algo3.truco.modelo.Jugadas.NadaCantado;
import fiuba.algo3.truco.modelo.Jugadas.TantoJugado;
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;
import fiuba.algo3.truco.modelo.Jugadas.TrucoCantadoTantoJugado;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import javafx.scene.control.Button;

import java.util.*;

public class DiccionarioEstadosJuego {

    private Dictionary<EstadoJuego, List<Button>> botonesADeshabilitar;
    private static final Dictionary<EstadoJuego, String> MENSAJE_ESTADO;
    private static final Equipo EQUIPO = new Equipo("EQUIPO", Collections.singletonList(new Jugador("jugador")));
    private static final EstadoJuego ESTADO_JUEGO = new NadaCantado();

    static {

        MENSAJE_ESTADO = new Hashtable<>(17);

        MENSAJE_ESTADO.put(new NadaCantado(), "Nada ha sido cantado");
        MENSAJE_ESTADO.put(new TantoJugado(EQUIPO), "Tanto ya jugado");
        MENSAJE_ESTADO.put(new TrucoCantadoTantoNoJugado(EQUIPO), "Truco cantado");
        MENSAJE_ESTADO.put(new TrucoCantadoTantoJugado(EQUIPO, EQUIPO), "Truco cantado");
        MENSAJE_ESTADO.put(new TrucoQuerido(EQUIPO), "Truco querido");
        MENSAJE_ESTADO.put(new RetrucoCantado(EQUIPO), "Retruco cantado");
        MENSAJE_ESTADO.put(new RetrucoQuerido(EQUIPO, EQUIPO), "Retruco querido");
        MENSAJE_ESTADO.put(new ValeCuatroCantado(EQUIPO), "Vale cuatro cantado");
        MENSAJE_ESTADO.put(new ValeCuatroQuerido(EQUIPO), "Vale cuatro querido");
        MENSAJE_ESTADO.put(new EnvidoCantado(ESTADO_JUEGO), "Envido cantado");
        MENSAJE_ESTADO.put(new EnvidoEnvidoCantado(ESTADO_JUEGO), "Envido envido cantado");
        MENSAJE_ESTADO.put(new RealEnvidoCantado(ESTADO_JUEGO, 0, false), "Real Envido cantado");
        MENSAJE_ESTADO.put(new FaltaEnvidoCantado(ESTADO_JUEGO, new Puntaje()), "Falta Envido cantado");
        MENSAJE_ESTADO.put(new FlorCantada(ESTADO_JUEGO), "Flor cantada");
        MENSAJE_ESTADO.put(new FlorFlorCantada(ESTADO_JUEGO), "Flor flor cantada");
        MENSAJE_ESTADO.put(new ContraFlorAlRestoCantada(ESTADO_JUEGO, new Puntaje(), 0), "Contra flor al resto cantada");
        MENSAJE_ESTADO.put(new ContraFlorAlPartidoCantado(ESTADO_JUEGO), "Contra flor al partido cantada");



    }

    public DiccionarioEstadosJuego(List<Button> botonesTruco, List<Button> botonesTanto, List<Button> botonesQuiero) {

        Button botonTruco = botonesTruco.get(0);
        Button botonRetruco = botonesTruco.get(1);
        Button botonValeCuatro = botonesTruco.get(2);
        Button botonEnvido = botonesTanto.get(0);
        Button botonRealEnvido = botonesTanto.get(1);
        Button botonFaltaEnvido = botonesTanto.get(2);
        Button botonFlor = botonesTanto.get(3);
        Button botonContraFlorAlResto = botonesTanto.get(4);
        Button botonContraFlorAlPartido = botonesTanto.get(5);
        Button botonQuieroTruco = botonesQuiero.get(0);
        Button botonNoQuieroTruco = botonesQuiero.get(1);
        Button botonQuieroEnvido = botonesQuiero.get(2);
        Button botonQuieroFlor = botonesQuiero.get(3);
        Button botonNoQuieroTanto = botonesQuiero.get(4);

        botonesADeshabilitar = new Hashtable<>(17);

        botonesADeshabilitar.put(new NadaCantado(), Arrays.asList(botonRetruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TantoJugado(EQUIPO), Arrays.asList(botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TrucoCantadoTantoNoJugado(EQUIPO), Arrays.asList(botonTruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TrucoCantadoTantoJugado(EQUIPO, EQUIPO), Arrays.asList(botonTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TrucoQuerido(EQUIPO), Arrays.asList(botonTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new RetrucoCantado(EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new RetrucoQuerido(EQUIPO, EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new ValeCuatroCantado(EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new ValeCuatroQuerido(EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new EnvidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new EnvidoEnvidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new RealEnvidoCantado(ESTADO_JUEGO, 0, false), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new FaltaEnvidoCantado(ESTADO_JUEGO, new Puntaje()), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new FlorCantada(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new FlorFlorCantada(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new ContraFlorAlRestoCantada(ESTADO_JUEGO, new Puntaje(), 0), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new ContraFlorAlPartidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));

    }

    public List<Button> obtenerBotones(EstadoJuego estadoJuego) {

        return this.botonesADeshabilitar.get(estadoJuego);

    }

    public String obtenerMensajeEstado(EstadoJuego estadoJuego) {

        return MENSAJE_ESTADO.get(estadoJuego);

    }


}
