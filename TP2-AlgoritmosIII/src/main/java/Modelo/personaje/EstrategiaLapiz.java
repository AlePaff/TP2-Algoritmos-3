package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public interface EstrategiaLapiz {
    void dibujar(Tablero tablero, Posicion posicion);
}
