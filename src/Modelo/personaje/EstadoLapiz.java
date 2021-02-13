package Modelo.personaje;

import Modelo.bloques.Bloque;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public interface EstadoLapiz {


    void hacerMovimiento(Personaje personaje, Bloque bloque, Posicion posicion, Tablero tablero);
}
