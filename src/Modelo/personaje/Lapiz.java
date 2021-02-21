package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Lapiz {

    private EstrategiaLapiz estado;

    public Lapiz(){
        this.estado = new LapizArriba();
    }

    public void LapizAbajo(){
        this.estado = new LapizAbajo();
    }
    public void LapizArriba(){
        this.estado = new LapizArriba();
    }

    public void dibujar(Tablero tablero, Posicion posicion){
        this.estado.dibujar(tablero, posicion);
    }

}
