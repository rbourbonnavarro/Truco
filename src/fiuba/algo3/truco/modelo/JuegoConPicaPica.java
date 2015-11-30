package fiuba.algo3.truco.modelo;

public class JuegoConPicaPica implements EstadoPicaPica {

    MesaPicaPica mesaPicaPica;

    @Override
    public void picaPica(Equipo equipo1, Equipo equipo2, boolean seJuegaConFlor) {

        if(equipo1.getPuntos() >= 5 || equipo2.getPuntos() >= 5) {

            this.mesaPicaPica = new MesaPicaPica(equipo1, equipo2, seJuegaConFlor, true);

        }

    }


}
