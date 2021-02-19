package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public interface EstadoLapiz {
    void dibujar(Tablero tablero, Posicion posicion);
}
