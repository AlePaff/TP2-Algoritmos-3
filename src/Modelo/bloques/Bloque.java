package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public interface Bloque {

    void ejecutar(Personaje personaje, Posicion posicion, Tablero tablero);

}
