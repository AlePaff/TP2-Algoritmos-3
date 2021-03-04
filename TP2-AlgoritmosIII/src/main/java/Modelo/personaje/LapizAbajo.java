package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class LapizAbajo implements EstrategiaLapiz {
    public void dibujar(Tablero tablero, Posicion posicion) {
        tablero.dibujar(posicion);
    }
}


