package fiuba.algo3.truco.vista;

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
import fiuba.algo3.truco.modelo.Jugadas.Truco.*;
import fiuba.algo3.truco.modelo.Jugador;
import fiuba.algo3.truco.modelo.Puntos.Puntaje;
import javafx.scene.control.Button;

import java.util.*;

public class DiccionarioEstadosJuego {

    private Dictionary<EstadoJuego, List<Button>> botonesADeshabilitar;
    private static final Equipo EQUIPO = new Equipo("EQUIPO", Collections.singletonList(new Jugador("jugador")));
    private static final EstadoJuego ESTADO_JUEGO = new NadaCantado();

    public DiccionarioEstadosJuego(List<Button> botones, List<Button> botonesTruco, List<Button> botonesTanto, List<Button> botonesQuiero) {

        Button botonTruco = botones.get(0);
        Button botonRetruco = botones.get(1);
        Button botonValeCuatro = botones.get(2);
        Button botonQuieroTruco = botones.get(3);
        Button botonNoQuieroTruco = botones.get(4);
        Button botonEnvido = botones.get(5);
        Button botonRealEnvido = botones.get(6);
        Button botonFaltaEnvido = botones.get(7);
        Button botonQuieroEnvido = botones.get(8);
        Button botonFlor = botones.get(9);
        Button botonContraFlorAlResto = botones.get(10);
        Button botonContraFlorAlPartido = botones.get(11);
        Button botonQuieroFlor = botones.get(12);
        Button botonNoQuieroTanto = botones.get(13);

        botonesADeshabilitar = new Hashtable<>();

        botonesADeshabilitar.put(new NadaCantado(), Arrays.asList(botonRetruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TrucoCantado(EQUIPO, true), Arrays.asList(botonTruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new TrucoQuerido(EQUIPO), Arrays.asList(botonTruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new RetrucoCantado(EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new RetrucoQuerido(EQUIPO, EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new ValeCuatroCantado(EQUIPO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroEnvido, botonQuieroFlor, botonNoQuieroTanto));
        botonesADeshabilitar.put(new ValeCuatroQuerido(EQUIPO), botones);
        botonesADeshabilitar.put(new EnvidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new EnvidoEnvidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new RealEnvidoCantado(ESTADO_JUEGO, 0), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new FaltaEnvidoCantado(ESTADO_JUEGO, new Puntaje()), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroFlor));
        botonesADeshabilitar.put(new FlorCantada(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new FlorFlorCantada(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new ContraFlorAlRestoCantada(ESTADO_JUEGO, new Puntaje(), 0), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));
        botonesADeshabilitar.put(new ContraFlorAlPartidoCantado(ESTADO_JUEGO), Arrays.asList(botonTruco, botonRetruco, botonValeCuatro, botonEnvido, botonRealEnvido, botonFaltaEnvido, botonFlor, botonContraFlorAlResto, botonContraFlorAlPartido, botonQuieroTruco, botonNoQuieroTruco, botonQuieroEnvido));

    }

    public List<Button> obtenerBotones(EstadoJuego estadoJuego) {

        return this.botonesADeshabilitar.get(estadoJuego);

    }


}
