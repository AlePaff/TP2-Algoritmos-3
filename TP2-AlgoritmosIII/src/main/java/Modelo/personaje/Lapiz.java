package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Lapiz {

    private EstrategiaLapiz estrategia;

    public Lapiz(){
        this.estrategia = new LapizArriba();
    }

    public void setEstrategia(EstrategiaLapiz estrategia){
        this.estrategia = estrategia;
    }

    public void dibujar(Tablero tablero, Posicion posicion){
        this.estrategia.dibujar(tablero, posicion);
    }

}
